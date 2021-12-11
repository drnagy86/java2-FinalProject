package com.nagy.derrick;

import com.nagy.derrick.car.Car;
import com.nagy.derrick.car.CarDAO;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FindPresident implements PresidentDataHandler {

    @Override
    public void handleTask(PresidentDAO dao, Scanner in, ResourceBundle messages) {
        try {
            List<President> presidents = dao.getAllPresidents();


            if (presidents != null){
                int presidentID = Helpers.getUserIntInRange(messages.getString("enter-president-id"), President.MIN_PRESIDENT_ORDINAL, President.MAX_PRESIDENT_ORDINAL, in, messages);
                System.out.println("\n" + messages.getString("search-for-president") + " " + presidentID + "...");
                President president = dao.getPresidentByPresidentID(presidentID);
                if (president == null){
                    System.out.println(messages.getString("no-president-found-with-that-ordinal"));

                } else {
                    System.out.println(messages.getString("retrieved") + " : " + president);
                }
                System.out.println("\n" + messages.getString("find-a-president-complete"));

            } else {
                System.out.println(messages.getString("no-presidents-available"));
            }
        }
        catch (DataException e){
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}

