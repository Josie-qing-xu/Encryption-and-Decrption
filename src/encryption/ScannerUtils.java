package encryption;
import java.util.Scanner;

public class ScannerUtils {

    /*
     * The one Scanner shared by all input methods
     */
    private static Scanner input = new Scanner(System.in);

    /**
     * Displays the menu options and return the user's option number. Handle all invalid user input and only return
     * when a valid selection has been made.
     *
     * @param options The options to display in the menu.
     * @return An integer representing the user's option number.
     */
    public static int getMenuItem(String... options) {
        int selection = 0;

        // Loop through the options and print them
        for (int i = 0; i < options.length; i++) {
            System.out.printf("  %d - %s%n", i + 1, options[i]);
        }

        // Ask user to select an action
        System.out.print("Select action:");

        // Check if user input is an integer
        if (input.hasNextInt()) {
            // Store user input in selection variable and consume the newline
            selection = input.nextInt();
            input.nextLine();

            // Check if the selection is in the valid range
            if (selection >= 1 && selection <= options.length) {
                return selection;
            } else {
                // Print error message if the selection is not in the valid range
                System.out.println("\nPlease select a number in the range");
            }
        } else {
            // Print error message if the input is not an integer and consume the invalid input
            System.out.println("\nPlease enter an integer");
            input.nextLine();
        }

        // Return integer selection
        return selection;
    }

    /**
     * Get a string from the user
     *
     * @param prompt The message to be displayed to the user
     * @return The user's input as a string
     */
    public static String getString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * Get an integer from the user.
     *
     * @param prompt The message to be displayed to the user
     * @param min    The minimum value allowed for the user's input
     * @param max    The maximum value allowed for the user's input
     * @return The user's input as an integer
     */
    public static int getInt(String prompt, int min, int max) {
        int selection = 0;
        System.out.print(prompt);

        // Check if user input is an integer
        if (input.hasNextInt()) {
            selection = input.nextInt();
            input.nextLine(); // consume newline

            // Check if the selection is in the valid range
            if (selection >= min && selection <= max) {
                return selection;
            } else {
                // Print error message if the selection is not in the valid range
                System.out.printf("\nPlease select a number in the range\n");

                // Set selection to 0, the default value
                return selection = 0;
            }
        } else {

            // Print error message if the input is not an integer and consume the invalid input
            System.out.println("\nPlease enter an integer");
            input.nextLine(); // consume invalid input
        }
        // Return selection
        return selection;

    }
}
