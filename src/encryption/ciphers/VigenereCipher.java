package encryption.ciphers;
import java.util.ArrayList;
import encryption.*;

public class VigenereCipher extends EncryptionType {

    /**
     * The password used to encrypt and decrypt the text.
     */
    private String key;

    /**
     * The number of characters in the password.
     */
    private int keyLength;

    /**
     * Create Vigenere cipher with the given password.
     * Constructor that takes in a password and sets the key and key length
     *
     * @param password
     *        The password used to encrypt and decrypt the text.
     */
    public VigenereCipher(String password) {
        this.key = password;
        this.keyLength = password.length();
    }

    /**
     * Encryption based on Vigenere cipher.
     * Encrypts the given text using the Vigenere Cipher algorithm.
     * (Encrypt input string by adding the key values to each character)
     * Handle wraparound to/from the two ends of the character range and
     * handle key that is not the same length as the input string
     *
     * @param input
     *        the String text to encrypt
     * @return Encrypted string text based on Vigenere Cipher
     */
    @Override
    public String encrypt(String input) {

        ArrayList<Character> encrypted = new ArrayList<Character>();

        String encryptedText = new String();

        for(int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            char shiftedChar =(char)( shiftChar(c,(key.charAt(i % keyLength) - START_CHAR)));

            encrypted.add((char)shiftedChar);
            encryptedText = encryptedText + encrypted.get(i);

        }
        return encryptedText;
    }

    /**
     * Decryption based on Vigenere cipher
     * Decrypt the given text using the Vigenere Cipher algorithm.
     * (Decrypt input string by subtracting the key values from each character)
     * Handle wraparound to/from the two ends of the character range and
     * handle key that is not the same length as the input string
     *
     * @param input
     *        the String text to decrypt
     * @return Decrypt string text based on Vigenere Cipher
     */
    @Override
    public String decrypt(String input) {

        ArrayList<Character> decrypted = new ArrayList<Character>();

        String decryptedText = new String();

        for(int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            char shiftedChar =(char)( shiftChar(c,-(key.charAt(i % keyLength) )));

            decrypted.add((char)shiftedChar);

            decryptedText =decryptedText + decrypted.get(i);
        }

        return decryptedText;
    }

}
