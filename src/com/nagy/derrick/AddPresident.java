package com.nagy.derrick;

import com.nagy.derrick.DataException;
import com.nagy.derrick.Helpers;
import com.nagy.derrick.Language;
import com.nagy.derrick.UIUtility;

import java.util.ResourceBundle;
import java.util.Scanner;

public class AddPresident implements PresidentDataHandler {
    private static Language language = new Language();
    private static ResourceBundle messages = language.getMessages();

    @Override
    public void handleTask(PresidentDAO dao, Scanner in, ResourceBundle messages) {
        President president = new President();
        boolean needed = true;

        while (needed) {
            try {
                president.setFirstName(Helpers.getUserString.apply(messages.getString("enter-first-name"), in));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        needed = true;
        while (needed) {
            try {
                president.setLastName(Helpers.getUserString.apply(messages.getString("enter-last-name"), in));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        needed = true;
        while (needed) {
            try {
                president.setBirthday(Helpers.getUserLocalDate.apply(messages.getString("enter-birthday"), in));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        needed = true;
        while (needed) {
            try {
                president.setPresidentID(Helpers.getUserIntInRange(messages.getString("enter-president-id"), President.MIN_PRESIDENT_ORDINAL, President.MAX_PRESIDENT_ORDINAL, in, messages));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }

            needed = true;
            while (needed) {
                try {
                    president.setInaugurationAgeYears(Helpers.getUserIntInRange(messages.getString("enter-inauguration_age_years"), President.MIN_INAUGURATION_AGE_YEARS, President.MAX_INAUGURATION_AGE_YEARS, in, messages));
                    needed = false;
                } catch (IllegalArgumentException e) {
                    UIUtility.showErrorMessage(e.getMessage(), in, messages);
                }

                needed = true;
                while (needed) {
                    try {
                        president.setInaugurationAgeDays(Helpers.getUserIntInRange(messages.getString("enter-inauguration_age_days"), President.MIN_INAUGURATION_AGE_DAYS, President.MAX_INAUGURATION_AGE_DAYS, in, messages));
                        needed = false;
                    } catch (IllegalArgumentException e) {
                        UIUtility.showErrorMessage(e.getMessage(), in, messages);
                    }
                }


                try {
                    dao.createPresidentRecord(president);
                    System.out.println("\n" + messages.getString("added") + ": " + president.toString());
                } catch (DataException e) {
                    UIUtility.showErrorMessage(e.getMessage(), in, messages);
                }
            }
        }
    }
}