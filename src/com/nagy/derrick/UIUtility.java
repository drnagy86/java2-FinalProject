package com.nagy.derrick;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class UIUtility {
    private static Language language = new Language();
    private static ResourceBundle messages = language.getMessages();


    /**
     * Displays a menu and the prompt, returning the String entered by the user.
     *
     * @param menuTitle the title of the menu
     * @param prompt the prompt for input
     * @param menuOptions the list of menu options to display
     * @param in a Scanner object
     * @return the user's response
     */
    public static int showMenuOptions(String menuTitle, String prompt, String[] menuOptions, Scanner in) {
        showMenuTitle().accept(menuTitle);
        int count = 1;
        for (String menuOption : menuOptions) {
            System.out.println(count++ + ": " + menuOption);
        }
        System.out.println(count + ": Exit");
        System.out.print("\n" + prompt + ": ");
        String input = in.nextLine().trim();
        int result = validateIntInput(input, menuOptions.length + 1, in);
        return result;
    }

    /**
     * Displays a properly formatted menu title.
     *
     *
     */
    public static Consumer<String> showMenuTitle() {

        return m -> System.out.println("\n" + "xxx " + m + " xxx\n");
    }

    /**
     * A string is converted to an integer. If invalid, a message will display.
     *
     * @param input The string representing an integer
     * @param in a Scanner object
     * @return The string converted to an integer, or 0 if invalid
     */

    public static int validateIntInput(String input, int highBound, Scanner in) {
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);
            if (intInput < 1 || intInput > highBound) {
                intInput = 0;
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showErrorMessage().accept("Invalid input", in);

        }
        return intInput;
    }


    public static BiConsumer<String, Scanner> showErrorMessage(){
        return (message, in) ->{
            System.out.println("ERROR: " + message);
            pressEnterToContinue().accept(in);
        };

    }

//    public static void pressEnterToContinue(Scanner in) {
//        System.out.print("\nPress Enter to continue... ");
//        in.nextLine();
//    }

    public static Consumer<Scanner> pressEnterToContinue(){
        return in -> {
            System.out.println("\nPress Enter to continue... ");
            in.nextLine();
        };
    }

    public static Consumer<String> showSectionTitle(){

        return (title) -> System.out.println("\n" + "*** " + title + " ***\n");
    }
}
