package com.nagy.derrick;

import com.nagy.derrick.DataException;
import com.nagy.derrick.UIUtility;
import com.nagy.derrick.car.Car;
import com.nagy.derrick.car.CarDAO;
import com.nagy.derrick.car.CarDataHandler;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShowAllPresidents implements PresidentDataHandler {
    @Override
    public void handleTask(PresidentDAO dao, Scanner in, ResourceBundle messages) {
        try {

            List<President> presidents = dao.getAllPresidents();
            if(presidents != null) {
                System.out.println(messages.getString("first-name")+ "\t"
                        + messages.getString("last-name") + "\t"
                        + messages.getString("birthday") +"\t"
                        + messages.getString("presidential-ordinal") +"\t"
                        + messages.getString("presidential-inauguration-years") +"\t"
                        + messages.getString("presidential-inauguration-days")

                );
                for (President president: presidents) {
                    System.out.println(president.getFirstName() + "\t" +
                            president.getLastName() + "\t" +
                            president.getBirthday() + "\t" +
                            president.getPresidentID() + "\t" +
                            president.getInaugurationAgeYears() + "\t" +
                            president.getInaugurationAgeDays()
                            );
                }
                System.out.println("\n"+ messages.getString("show-all-presidents-complete")+ ".");
            } else {
                System.out.println(messages.getString("no-presidents-available"));
            }
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}
