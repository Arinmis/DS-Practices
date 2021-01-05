/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.17 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Let A be an array of size n ≥ 2 containing integers from 1 to n − 1 inclusive, one
 *  of which is repeated. Describe an algorithm for finding the integer in A that is
 *  repeated.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 19.11.2020
 *
 * */

public class Main{
    public static void main(String[]args) {
        //int[] arr = {1, 2, 3, 4, 5, 3, 6, 7};
        //System.out.println(findRpead(arr));
    }

    public static int findRpead(int[] arr) {

        for(int i=0; i<arr.length - 1; i++) {
            for(int j= i + 1; j<arr.length; j++) {
                if(arr[i] == arr[j])
                    return arr[i];
            }
        }
        // if nothing found return -1
        return -1;
    }
}
