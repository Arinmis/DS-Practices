import java.util.Arrays;

/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.22 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Write a method, shuffle(A), that rearranges the elements of array A so that every
 *  possible ordering is equally likely. You may rely on the nextInt(n) method of
 *  the java.util.Random class, which returns a random number between 0 and n − 1
 *  inclusive.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 19.11.2020
 *
 * */


public class Main{
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //shuffleArray(arr);
        //System.out.println(Arrays.toString(arr));
    }
    public static void shuffleArray(int[] arr) {
        int shuffleCount = arr.length;
        int index, temp;

        for(int i=0; i<shuffleCount; i++) {
            /* this method will select arrays
               element randomly starting from index 0,
               to n - 1*/
            index =  i + (int)(Math.random() * (shuffleCount - i));

            //We can choose existing index to this index
            if( index == i)
                continue;

            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

    }
}
