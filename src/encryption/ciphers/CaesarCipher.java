package encryption.ciphers;
import encryption.*;
import java.util.ArrayList;

public class CaesarCipher extends EncryptionType {

    /**
     * The amount of shift between encrypted and decrypted characters.
     * This determines the number of positions to shift the letters of the ASCII characters.
     */
    private int key;

    /**
     * Create Caesar cipher with the given shift
     *
     * @param shift the number of positions to shift the letters of the ASCII characters for the cipher
     */
    public CaesarCipher(int shift) {
        this.key = shift;
    }


    /**
     * Encryption based on Caesar cipher.
     * Encrypts the given text using the Caesar Cipher algorithm.
     * Handle wraparound to/from the two ends of the character range.
     *
     * @param input the String text to encrypt
     * @return Encrypted string text based on Caesar cipher
     */
    @Override
    public String encrypt(String input) {

        ArrayList<Character> encrypted = new ArrayList<Character>();

        String encryptedText = new String();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            char shiftedChar = shiftChar(c,key);
            encrypted.add(shiftedChar);
            encryptedText = encryptedText + encrypted.get(i);}
        return encryptedText;
    }



    /**
     * Decryption based on Caesar cipher.
     * Decrypts the given text using the Caesar Cipher algorithm.
     * Handle wraparound to/from the two ends of the character range.
     *
     * @param input the text to decrypt
     * @return Decrypted text based on Caesar cipher
     */
    @Override
    public String decrypt(String input) {

        ArrayList<Character> decrypted = new ArrayList<Character>();
        String decryptedText = new String();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char shiftedChar = shiftChar(c,-key);
            decrypted.add((char)shiftedChar);
            decryptedText = decryptedText + decrypted.get(i);
        }
        return decryptedText;
    }
}