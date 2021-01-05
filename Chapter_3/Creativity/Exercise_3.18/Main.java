/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.18 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Let B be an array of size n ≥ 6 containing integers from 1 to n − 5 inclusive, five
 *  of which are repeated. Describe an algorithm for finding the five integers in B
 *  that are repeated.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 19.11.2020
 *
 * */

public class Main{
    public static void main(String[]args) {
        int[] arr = {2, 2, 1, 4, 2, 1, 2, 7, 2};
        System.out.println(findRpead(arr));
    }

    public static int findRpead(int[] arr) {

        for(int i=0; i<arr.length - 1; i++) {
            int count = 1;
            for(int j= i + 1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                    if(count == 5)
                     return arr[i];
                }
            }
        }
        // if nothing found return -1
        return -1;
    }

}
