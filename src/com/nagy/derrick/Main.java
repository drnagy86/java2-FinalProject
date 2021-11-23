package com.nagy.derrick;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Language language = new Language();
        language.setLocale(Language.Option.US);
        ResourceBundle messages = language.getMessages();

//        CarDAO dao = CarDAOFactory.getCarDAO();
        PresidentDAO dao = PresidentDAOFactory.getPresidentDAO();
        Scanner scanner = new Scanner(System.in);
        String menuTitle = "Main Menu";
        String prompt = "Select an option";
        String[] menuOptions = {
                //messages.getString("add-president"),
                "Add a president",
                "Find a president",
                "Show all presidents",
                "Update a president",
                "Delete a president",
                "Change language",
                "Change data source"
        };
        int choice = 0;
        while (true) {
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle().accept(menuOptions[Integer.valueOf(choice) - 1]);
            switch (choice) {
                case 1:
                    //new AddCar().handleTask(dao,scanner);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
            }
            UIUtility.pressEnterToContinue().accept(scanner);
        }
        System.out.println("\nProgram complete. Goodbye.\n");
        scanner.close();
    }
}
