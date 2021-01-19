/**
 *
 *  Data Structures and Algorithm with Java - Chapter 3.39 Exercise
 *
 *  --------------------------------------------------------------------------------
 *  Write a program that can perform the Caesar cipher for English messages that
 *  include both upper and lowercase characters.
 *  --------------------------------------------------------------------------------
 *
 *  @author Mustafa Arinmis
 *  @since  19.01.2021
 *
 * */

public class CaesarCipher {
    // decoder and encoder for lower case
    protected char[] lowerCaseEncoder =new char[26];
    protected char[] lowerCaseDecoder =new char[26];
    //decoder and encoder for upper case
    protected char[] upperCaseEncoder =new char[26];
    protected char[] upperCaseDecoder =new char[26];

    public CaesarCipher(int rotation) { //initializing encoders and decoders
        for(int k=0; k<26; k++){
            lowerCaseEncoder[k] =  (char) ('a'+ (k + rotation) % 26);
            lowerCaseDecoder[k] =  (char) ('a'+ (k - rotation + 26) % 26);

            upperCaseEncoder[k] =  (char) ('A'+ (k + rotation) % 26);
            upperCaseDecoder[k] =  (char) ('A'+ (k - rotation + 26) % 26);
        }
    }

    public String encrypt(String message) {
        return transform(message, lowerCaseEncoder, upperCaseEncoder);
    }


    public String decrypt(String secret) {
        return transform(secret, lowerCaseDecoder, upperCaseDecoder);
    }

    private String transform(String original, char[] lowerCode, char[] upperCode){
        char[] msg = original.toCharArray();
        for(int k=0; k<msg.length; k++) {
            if(Character.isLowerCase(msg[k])) { // check char case to use correct coder
                int j = msg[k] - 'a';
                msg[k] = lowerCode[j];
            }
            else if(Character.isUpperCase(msg[k])){
                int j = msg[k] - 'A';
                msg[k] = upperCode[j];
            }
        }
        return new String(msg);
    }

    // testing
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        String message ="The Eagle Is In Play; Meet At Joe's.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }

}
