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
        System.out.println(count + ": " + messages.getString("exit"));
        System.out.print("\n" + prompt + ": ");
        String input = in.nextLine().trim();
        int result = validateIntInput(input, menuOptions.length + 1, in, messages);
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

    public static void showMenuTitle(String menuTitle) {
        System.out.println("\n" + "xxx " + menuTitle + " xxx\n");
    }

    /**
     * A string is converted to an integer. If invalid, a message will display.
     *
     * @param input The string representing an integer
     * @param in a Scanner object
     * @param messages
     * @return The string converted to an integer, or 0 if invalid
     */

    public static int validateIntInput(String input, int highBound, Scanner in, ResourceBundle messages) {
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);
            if (intInput < 1 || intInput > highBound) {
                intInput = 0;
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showErrorMessage().accept(messages.getString("invalid-input"), in);

        }
        return intInput;
    }


    public static BiConsumer<String, Scanner> showErrorMessage(){
        return (message, in) ->{
            System.out.println(messages.getString("error") +  ": " + message);
            pressEnterToContinue(in, messages).accept(in);
        };

    }

    public static void pressEnterToContinue(Scanner in) {
        System.out.print("\n" + messages.getString("press-enter"));
        in.nextLine();
    }

    public static Consumer<Scanner> pressEnterToContinue(Scanner scanner, ResourceBundle messages){
        return in -> {
            System.out.print("\n" + messages.getString("press-enter"));
            in.nextLine();
        };
    }

    public static Consumer<String> showSectionTitle(){

        return (title) -> System.out.println("\n" + "*** " + title + " ***\n");
    }

    public static void showSectionTitle(String menuOption) {
    }

    public static int showMenuOptions(String menuTitle, String prompt, String[] menuOptions, Scanner in, ResourceBundle messages) {

        showMenuTitle(menuTitle);
        int count = 1;
        for (String menuOption : menuOptions) {
            System.out.println(count++ + ": " + menuOption);
        }
        System.out.println(count + ": " + messages.getString("exit"));
        System.out.print("\n" + prompt + ": ");
        String input = in.nextLine().trim();
        int result = validateIntInput(input, menuOptions.length + 1, in, messages);
        return result;
    }

    public static void showErrorMessage(String message, Scanner in, ResourceBundle messages) {
        System.out.println(messages.getString("error") + ": " + message);
        pressEnterToContinue(in, messages);
    }

}
