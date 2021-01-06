/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.36 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Write a Java program for a matrix class that can add and multiply arbitrary two-
 *  dimensional arrays of integers.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since  06.01.2021
 *
 * */
public class Matrix {
    public static void main(String[] args) {

        // adding two matrices
        int[][] X = {{1, 2, 3}, {4, 5, 6}};
        int[][] Y = {{1, 2, 3}, {4, 5, 6}};;
        System.out.println("Addition result:");
        printMatrix(addMatrix(X, Y));


        // multiplying two matrices
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] B = {{10, 11}, {20, 21}, {30, 31}};
        System.out.println("\nMultiplication result");
        printMatrix(multiplyMatrix(A, B));

    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b) {
        if(a[0].length != b.length)
            throw new IllegalStateException("invalid matrices given");

        int[][] result = new int[a.length][b[0].length];

        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result.length; j++) {
                int element = 0;
                for(int k=0; k<a[0].length; k++) {
                    element += a[i][k] * b[k][j];
                }
                result[i][j] =  element;
            }
        }
        return result;

    }

    private static int[][] addMatrix(int[][] a, int[][] b) {
        if(a.length != b.length && a[0].length != b[0].length)
            throw new IllegalStateException("invalid matrices given");

        int[][] result = new int[a.length][a[0].length];
        for (int i=0; i<a.length; i++ ) {
            for( int j=0; j<a[0].length; j++) {
                result[i][j] =  a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}