import java.util.Arrays;

/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.42 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Design a RandomCipher class as a subclass of the SubstitutionCipher from Exercise
 *  P-3.40, so that each instance of the class relies on a random permutation of
 *  letters for its mapping.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since  19.01.2021
 *
 * */


public class RandomCipher extends SubstitutionCipher {

    public RandomCipher() {
        createRandomEncoder();
    }

    private void createRandomEncoder() {
        for(int i=0; i<super.code.length; i++) //initialize all chars in order
            super.code[i] = (char)('A' + i);

        shuffle(code); //shuffle chars to get random encoder
    }

    /* shuffle given char array */
    private void shuffle(char[] code) {
        for(int i=0; i<code.length; i++) {
            int index = (int)(Math.random() * 26);
            char temp = code[i];
            code[i] = code[index];
            code[index] = temp;
        }
    }

    // testing random cipher
    public static void main(String[] args) {
        RandomCipher cipher = new RandomCipher();
        System.out.println("Encoder: " + Arrays.toString(cipher.code));
        String message = "HELLO DEAR WORLD";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }
}
