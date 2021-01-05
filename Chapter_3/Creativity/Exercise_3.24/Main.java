import java.util.Arrays;

/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.23 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Write a Java method that takes two three-dimensional integer arrays and adds
 *  them componentwise.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 20.11.2020
 *
 * */


public class Main{
    public static void main(String[] args) {

        /*
        int[][][] arr1 = {{{1, 1}, {1, 1}}, {{1, 1}, {1, 1}}};
        int[][][] arr2 =  {{{2, 2}, {2, 2}}, {{2, 2}, {2, 2}}};
            
        //sum of temp's each element should be 3
        int[][][] temp = adds(arr1, arr2);
        
        for(int i=0; i< temp.length; i++) {
            for(int j=0; j<temp[0].length; j++) {
                for(int k=0; k<temp[0][0].length;k++) {
                    System.out.print(temp[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        
         */

    }

    //I assumed that 3-dimentional arrays have same dimention length
    public static int[][][] adds(int[][][] arr1, int[][][] arr2) {
        int[][][] temp = new int[arr1.length][arr1[0].length][arr1[0][0].length];

        for(int i=0; i< arr1.length; i++) {
            for(int j=0; j<arr1[0].length; j++) {
                for(int k=0; k<arr1[0][0].length;k++) {
                    temp[i][j][k] = arr1[i][j][k] + arr2[i][j][k];
                }
            }
        }

        return temp;
    }
}
