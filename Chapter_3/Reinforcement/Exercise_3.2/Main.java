/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.2 Exercise
 *
 *  -----------------------------------------------------------------
 *  Write a Java method that repeatedly selects and removes a random
 *  entry from an array until the array holds no more entries.
 *  -----------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 19.11.2020
 *
 * */

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args)   {
        //uncomment and run
        //int[] arr = {1, 2, 3, 4, 5};
        //removeRad(arr);
    }
    public static void removeRad(int[] arr) {
        /* mothod will print which index removed and updated array */
        Random rand = new Random();

        for(int i=0; i<arr.length; i++) {
            int targetIdx= rand.nextInt(arr.length - i ) ;
            for(int j=targetIdx; j<arr.length - i - 1; j++ )
                    arr[j] = arr[j + 1];

            arr[arr.length - i - 1] = 0;
            System.out.println("Deleted Index: " + targetIdx +
                    "\nUpdated array :" + Arrays.toString(arr));
        }
    }
}

