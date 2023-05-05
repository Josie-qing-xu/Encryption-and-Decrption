package encryption;

public interface EncryptionType {
    public static final int START_CHAR = 32;

    public static final int END_CHAR = 122;

    public static final int RANGE = END_CHAR - START_CHAR + 1;

    /**
     * get the result of shifting the character by the offset.
     * handle any wrap around required from going below start character or above end character.
     * @param c
     * 			the input character from user
     * @param offset
     * 			the shift(char) number from user input
     * @return return to character that is the result of shifting the character by the offset.
     */
    public char shiftChar(char c, int offset) {
        int shiftedChar = c + offset;
        if (shiftedChar >= START_CHAR && shiftedChar <= END_CHAR ) {
            shiftedChar = c + offset;
        } else if (shiftedChar > END_CHAR) {
            shiftedChar = shiftedChar - RANGE; // shiftedChar = shiftedChar - END_CHAR+ START_CHAR - 1
        } else if (shiftedChar >0 && shiftedChar < START_CHAR){
            shiftedChar = shiftedChar + START_CHAR ;
        } else if(shiftedChar == 0){
            shiftedChar = START_CHAR;
        } else { // if shiftedChar < 0, use is it
            shiftedChar = END_CHAR + shiftedChar + 1;
        }
        return (char)shiftedChar;
    }

    /**
     * Get the encryption method.
     * Handle all invalid user input and only return when a valid EncryptionType has been selected.
     *
     * @return An instance of an EncryptionType object (either a CaesarCipher or VigenereCipher)
     */
    public static EncryptionType getMethod() {
        System.out.println("Encryption method");
        System.out.println("     1 - Caesar");
        System.out.println("     2 - Vigenere");

        boolean con = true;
        int option = 0;
        while(con) {

            option = ScannerUtils.getInt("Select action: ", 1, 2);

            if (option !=1 && option !=2) {
                System.out.println("     1 - Caesar\n"
                        + "     2 - Vigenere"
                );
            } else {

                con =false;
            }
        }

        if (option == 1) {
            int shift = 0;
            boolean opCon = true;
            while(opCon) {

                shift = ScannerUtils.getInt("Shift value: ", 1, 90);

                if(shift != 0) {
                    opCon = false;
                }
            }
            return new CaesarCipher(shift);

        } else {
            String password = ScannerUtils.getString("Password: ");
            return new VigenereCipher(password);
        }
    }

    /**
     * Encrypted version of the given string
     * @param input
     *        the input from user that needs to be encrypted
     *
     * @return Encrypted string text for print
     */
    public abstract String encrypt(String input);


}
