public class CaesarCipher {

    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int rotation) { //initializing encoders and decoders
        for(int k=0; k<26; k++){
            encoder[k] =  (char) ('A'+ (k + rotation) % 26);
            decoder[k] =  (char) ('A'+ (k - rotation + 26) % 26);
        }
    }

    protected CaesarCipher() {} //default constructor for subclasses

    public String encrypt(String message) {
        return transform(message, encoder);
    }


    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    private String transform(String original, char[] code){
        char[] msg = original.toCharArray();
        for(int k=0; k<msg.length; k++) {
            if(Character.isLowerCase(msg[k])) { // check char case to use correct coder
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        }
        return new String(msg);
    }

    // testing
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        String message ="THE EAGLE IS IN PLAY; MEET AT JOE’S";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }

}
