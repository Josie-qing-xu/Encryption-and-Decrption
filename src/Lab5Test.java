import java.util.ArrayList;
import encryption.*;

public class Lab5Test {

    /**
     * This is the application main method.
     * @param args
     *        the param of main method
     **/

    public static void main(String[] args) {
        System.out.println("Encryption tester");

        //Creates a new ArrayList object to hold encrypted text.
        ArrayList<String> encryptedText = new ArrayList<>();

        //Creates a boolean variable to control the while loop.
        boolean con = true;
        //Loop that displays a menu of options and performs the selected action.
        while (con) {

            //Calls the getMenuItem method to display the menu and get the user's selection.
            int selection = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

            //Switch statement that performs the appropriate action based on the user's selection.
            switch (selection) {

                //Case 1: Encrypt text
                case 1:
                    //Prompts the user to enter text to be encrypted.
                    String text = ScannerUtils.getString("Please enter text to be encrypted:");

                    //Calls the getMethod method to get the encryption method.
                    EncryptionType method = EncryptionType.getMethod();

                    //Encrypts the user's text using the selected method and adds it to the ArrayList.
                    String encrypted = method.encrypt(text);
                    encryptedText.add(encrypted);

                    //Prints the encrypted value and its number in the list to the console.
                    System.out.printf("Encrypted value #%d is: %s%n\n", encryptedText.size(), encrypted);
                    break;

                //Case 2: Decrypt text
                case 2:
                    //Checks if the ArrayList is empty.
                    if (encryptedText.isEmpty()) {
                        System.out.println("\nNothing to decrypt");
                        break;
                    }

                    //Loop that prompts the user to enter the number of the message they want to decrypt.
                    boolean a = true;
                    int messageNumber =0;
                    while(a) {
                        messageNumber = ScannerUtils.getInt("Message number you want to decrypt:", 1, encryptedText.size());
                        if(messageNumber >= 1 && messageNumber <= encryptedText.size()) {
                            a = false;
                        }
                    }

                    //Calls the getMethod method to get the decryption method.
                    method = EncryptionType.getMethod();

                    //Gets the encrypted message to be decrypted from the ArrayList.
                    String messageToDecrypt = encryptedText.get(messageNumber - 1);

                    //Decrypts the message using the selected method and prints it to the console.
                    String decrypted = method.decrypt(messageToDecrypt);
                    System.out.printf("Decrypted value #%d is: %s%n\n", messageNumber, decrypted);
                    break;

                //Case 3: Display encrypted list
                case 3:

                    //Checks if the ArrayList is empty.
                    if (encryptedText.isEmpty()) {
                        System.out.println("\nNothing to display");
                        break;
                    }
                    System.out.println("------------");

                    //Loop that prints each encrypted message and its number in the list to the console.
                    for(int i = 0; i <encryptedText.size();i++ ) {
                        System.out.printf("#%d: %s%n",i+1,encryptedText.get(i));
                    }
                    System.out.println("------------\n");
                    break;

                //Case 4: Exit
                case 4:
                    //Sets the boolean con variable to false to exit the while loop.
                    con = false;
                    break;

            }
        }
        //Prints a message to the console to indicate the end of the program
        System.out.println("Good bye");

    }
}