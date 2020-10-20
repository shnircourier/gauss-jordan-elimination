import com.matrix.classes.*;


public class App {
    public static void main(String[] args) throws Exception {
        
        double[][] MATRIX_ARRAY = {
            {0.71, 0.10, 0.12, 0.29},
            {0.10, 0.34, -0.04, 0.32},
            {0.12, -0.04, 0.10, -0.10}
        };
        Matrix matrix = new Matrix(MATRIX_ARRAY);
        JourdanGaussMethod roots = new JourdanGaussMethod(matrix);

        for (int i = 0; i < MATRIX_ARRAY.length; i++) {
            System.out.println(roots.getRoots()[i]);
        }
    }
}
