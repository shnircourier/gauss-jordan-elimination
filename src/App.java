import com.matrix.classes.*;


public class App {
    public static void main(String[] args) throws Exception {
        //det = 0.016
        double[][] MATRIX_ARRAY = {
            {0.47, 1, 0.67, -0.32},
            {1, 0.17, -0.25, 0.54},
            {0.55, 0.43, 0.36, 1},
            {-0.11, 0.35, 1, -0.74}
        };
        //double[] equalsArray = {0.29, 0.32, -0.10};
        // Matrix matrix = new Matrix(MATRIX_ARRAY);
        // JourdanGaussMethod roots = new JourdanGaussMethod(matrix);
        // double[][] arr = roots.getInverseMatrix();
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         System.out.println(i + " " + j + ": " + arr[i][j]);
        //     }
        // }
        MatrixWithDet mat = new MatrixWithDet(MATRIX_ARRAY);
        System.out.println(mat.getDet());
        

    }
}
