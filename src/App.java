import com.matrix.classes.*;


public class App {
    public static void main(String[] args) throws Exception {
        
        double[][] MATRIX_ARRAY = {
            {0.71, 0.10, 0.12},
            {0.10, 0.34, -0.04},
            {0.12, -0.04, 0.10}
        };
        //double[] equalsArray = {0.29, 0.32, -0.10};
        Matrix matrix = new Matrix(MATRIX_ARRAY);
        JourdanGaussMethod roots = new JourdanGaussMethod(matrix);
        double[][] arr = roots.getInverseMatrix();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(i + " " + j + ": " + arr[i][j]);
            }
        }
    }
}
