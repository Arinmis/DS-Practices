import java.util.Arrays;

/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.20 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Give examples of values for a and b in the pseudorandom generator given on
 *  page 113 of this chapter such that the result is not very random looking, for
 *  n = 1000.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since 20.11.2020
 *
 * */


public class Main{
    public static void main(String[] args) {
        //pseudorandom number generators formula:
        // next = (a ∗ cur + b) % n;
        // if a % b == 0 it will produce sequancial numbers

        // example for a = 4096 and b = 2048
        System.out.println(Arrays.toString(randArray(2,25 ,25, 1000,  30)));
        System.out.println("After '675, 500, 125, 750, 375, 0' this sequence it repeats itself  every 8 digit");
   
    }

    public static int[] randArray(int cur, int a, int b,int n, int length) {
        /* return given number of random number according to PSNG's varaiables
        * and given length*/
        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
            //PRNG formula: next = (a ∗ cur + b) % n;
            arr[i] = a * (cur + b) % n;
            cur = arr[i];
        }
        return arr;
    }
}
