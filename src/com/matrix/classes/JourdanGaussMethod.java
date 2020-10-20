package com.matrix.classes;

import com.matrix.classes.intefaces.*;

public class JourdanGaussMethod implements IGetRoots {

   protected Matrix matrix;

   public JourdanGaussMethod(Matrix matrix) {
      this.matrix = matrix;
   }

   public double[] getRoots(){
      this.calculate();
      return this.matrix.getMatrixColumn(this.matrix.getMatrixM() - 1);
   }

   protected void calculate(){
      for (int step = 0; step < this.matrix.getMatrixN(); step++) {
         for (int i = 0; i < this.matrix.getMatrixN(); i++) {
            if(step == i){
               for (int j = this.matrix.getMatrixM() - 1; j >= 0; j--) {
                  this.matrix.changeMatrixElement(i, j, this.matrix.getMatrixElement(i, j) / this.matrix.getMatrixElement(step, step));
               }
            }
            else{
               for (int j = this.matrix.getMatrixM() - 1; j >= 0 ; j--) {
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
