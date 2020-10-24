package com.matrix.classes;
import com.matrix.classes.intefaces.IMatrix;

public class Matrix implements IMatrix {

   protected double[][] matrix;

   public Matrix(double[][] matrix) {
      this.matrix = matrix;
   }

   public double getMatrixElement(int i, int j) {
      return this.matrix[i][j];
   }

   public double[] getMatrixRow(int j) {
      return this.matrix[j];
   }

   public double[] getMatrixColumn(int i) {
      double[] column = new double[this.matrix.length];
      for (int j = 0; j < this.matrix.length; j++) {
         column[j] = this.matrix[j][i];
      }
      return column;
   }

   public double[][] getMatrix() {
      return this.matrix;
   }

   public int getMatrixN(){
      return this.getMatrixColumn(0).length;
   }

   public int getMatrixM(){
      return this.getMatrixRow(0).length;
   }

   public void changeMatrixElement(int i, int j, double value){
      this.matrix[i][j] = value;
   }

   public void changeMatrixRow(int i, double[] newRow){
      this.matrix[i] = newRow;
   }

   public void setMatrix(double[][] matrix){
      this.matrix = matrix;
   }

}

