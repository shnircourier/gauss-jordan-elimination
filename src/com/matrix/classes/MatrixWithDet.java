package com.matrix.classes;

import com.matrix.classes.intefaces.IGetDet;

public class MatrixWithDet extends Matrix implements IGetDet {

   public MatrixWithDet(double[][] matrix) {
      super(matrix);
   }

   public double getDet() {
      for (int step = 0; step < this.getMatrixN() - 2; step++) {
         this.annualColumn(step);
      }
      double det = this.getMinorDet();
      for (int i = 0; i < this.getMatrixN() - 2; i++) {
         det *= this.matrix[i][i];
      }
      return det;
   }

   protected void annualColumn(int step) {
      for (int i = 0; i < this.getMatrixN(); i++) {
         if (step != i) {
            for (int j = this.getMatrixM() - 1; j >= 0; j--) {
               this.matrix[i][j] -= this.matrix[i][step] * this.matrix[step][j] / this.matrix[step][step];
            }
         }
      }
   }

   protected double getMinorDet(){
      return this.matrix[this.getMatrixN() - 2][this.getMatrixN() - 2]
            * this.matrix[this.getMatrixN() - 1][this.getMatrixN() - 1]
            - this.matrix[this.getMatrixN() - 2][this.getMatrixN() - 1]
                  * this.matrix[this.getMatrixN() - 1][this.getMatrixN() - 2];
   }
}
