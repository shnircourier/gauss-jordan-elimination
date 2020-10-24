package com.matrix.classes;

import com.matrix.classes.intefaces.*;

public class JourdanGaussMethod implements IGetRoots {

   protected Matrix matrix;
   protected double[] equalsArray;

   public JourdanGaussMethod(Matrix matrix, double[] equalsArray) {
      this.matrix = matrix;
      this.equalsArray = equalsArray;
   }

   public JourdanGaussMethod(Matrix matrix) {
      this.matrix = matrix;
   }

   public double[] getRoots() {
      if (this.equalsArray == null)
         return new double[0];
      else {
         double[][] newMatrix = new double[this.matrix.getMatrixN()][this.matrix.getMatrixM() + 1];
         this.matrix.setMatrix(this.addNewColoumn(newMatrix, this.equalsArray));
         this.calculate();
         return this.matrix.getMatrixColumn(this.matrix.getMatrixM() - 1);
      }
   }

   public double[][] getInverseMatrix() {
      double[][] eTypeMatrix = this.getEtypeMatrix(this.matrix.getMatrixN());
      this.matrix.setMatrix(this.compileArrays(this.matrix.getMatrix(), eTypeMatrix));
      this.calculate();
      double[][] inverseMatrix = new double[this.matrix.getMatrixN()][this.matrix.getMatrixN()];
      for (int i = 0; i < inverseMatrix.length; i++) {
         for (int j = inverseMatrix[0].length; j < this.matrix.getMatrixM(); j++) {
            inverseMatrix[i][j - inverseMatrix[0].length] = this.matrix.getMatrixElement(i, j);
         }
      }
      return inverseMatrix;
   }

   protected double[][] compileArrays(double[][] firstArray, double[][] secondArray) {
      double[][] newArray = new double[firstArray.length][firstArray[0].length + secondArray[0].length];
      for (int i = 0; i < newArray.length; i++) {
         for (int j = 0; j < newArray[0].length; j++) {
            if (j >= firstArray[0].length)
               newArray[i][j] = secondArray[i][j - firstArray[0].length];
            else
               newArray[i][j] = firstArray[i][j];
         }
      }
      return newArray;
   }

   protected double[][] getEtypeMatrix(int order) {
      double[][] eTypeMatrix = new double[order][order];
      for (int i = 0; i < eTypeMatrix.length; i++) {
         for (int j = 0; j < eTypeMatrix.length; j++) {
            if (i == j)
               eTypeMatrix[i][j] = 1;
            else
               eTypeMatrix[i][j] = 0;
         }
      }
      return eTypeMatrix;
   }

   protected double[][] addNewColoumn(double[][] emptyArray, double[] equalsArray) {
      for (int i = 0; i < emptyArray.length; i++) {
         for (int j = 0; j < emptyArray[0].length; j++) {
            if (emptyArray[0].length - 1 == j)
               emptyArray[i][j] = equalsArray[i];
            else
               emptyArray[i][j] = this.matrix.getMatrixElement(i, j);
         }
      }
      return emptyArray;
   }

   protected void calculate() {
      for (int step = 0; step < this.matrix.getMatrixN(); step++) {
         for (int i = 0; i < this.matrix.getMatrixN(); i++) {
            if (step == i) {
               for (int j = this.matrix.getMatrixM() - 1; j >= 0; j--) {
                  this.matrix.changeMatrixElement(i, j,
                        this.matrix.getMatrixElement(i, j) / this.matrix.getMatrixElement(step, step));
               }
            } else {
               for (int j = this.matrix.getMatrixM() - 1; j >= 0; j--) {
                  this.matrix.changeMatrixElement(i, j, this.squareFunction(step, i, j));
               }
            }
         }
      }
   }

   protected double squareFunction(int step, int i, int j) {
      return this.matrix.getMatrixElement(i, j)
            - (this.matrix.getMatrixElement(i, step) * this.matrix.getMatrixElement(step, j))
                  / this.matrix.getMatrixElement(step, step);
   }

}
