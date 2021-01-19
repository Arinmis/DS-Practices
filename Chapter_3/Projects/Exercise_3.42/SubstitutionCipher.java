import java.util.HashSet;

public class SubstitutionCipher {
    protected char[] code = new char[26];

    public SubstitutionCipher(String encoderStr) { //initializing encoders and decoders
        if(!isValid(encoderStr))
            throw new InvalidEncoderException(encoderStr);
        code = encoderStr.toCharArray();
    }

    protected SubstitutionCipher() {}

    public String encrypt(String message) {
        char[] msg = message.toCharArray();
        for(int k=0; k<msg.length; k++) {
            if(Character.isUpperCase(msg[k])){
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        }
        return new String(msg);
    }

    public String decrypt(String secret) {
        char[] msg = secret.toCharArray();
        String codeStr = new String(this.code);
        for(int k=0; k<msg.length; k++) {
            if(Character.isUpperCase(msg[k])) {
                int j = codeStr.indexOf(msg[k]); //find index of char
                msg[k] = (char) ('A' + j); // and replace with corresponding char
            }
        }
        return new String(msg);
    }

    /* check given char include all uppercase Latin chars */
    private boolean isValid(String encoderStr) {
        if(encoderStr.length() != 26)
            return false;

        HashSet<Character> alphabet = new HashSet<>();
        for(int i=0; i<encoderStr.length(); i++) {
            char chr = encoderStr.charAt(i);
            if(Character.isUpperCase(chr)) // check for uppercase
                alphabet.add(chr);
            else
                return false;
        }
        return alphabet.size() == 26;
    }

    public static void main(String[] args) {
        String encoder = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        SubstitutionCipher cipher = new SubstitutionCipher(encoder);
        String message ="HELLO WORLD";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }
}

class InvalidEncoderException extends RuntimeException{
    public InvalidEncoderException(String message) {
        super(message);
    }
}
