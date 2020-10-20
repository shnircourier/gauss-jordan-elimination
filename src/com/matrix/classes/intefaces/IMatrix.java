package com.matrix.classes.intefaces;

public interface IMatrix {

   public double getMatrixElement(int i, int j);

   public double[] getMatrixRow(int j);

   public double[] getMatrixColumn(int i);

   public double[][] getMatrix();

   public int getMatrixN();

   public int getMatrixM();

   public void changeMatrixElement(int i, int j, double value);

   public void changeMatrixRow(int i, double[] newRow);

}