package com.nagy.derrick.car;

import com.nagy.derrick.DataException;
import com.nagy.derrick.Helpers;
import com.nagy.derrick.Language;
import com.nagy.derrick.UIUtility;

import java.util.ResourceBundle;
import java.util.Scanner;

public class AddCar implements CarDataHandler {
    private static Language language = new Language();
    private static ResourceBundle messages = language.getMessages();

    @Override
    public void handleTask(CarDAO dao, Scanner in, ResourceBundle messages) {
        Car car = new Car();
        boolean needed = true;

        while(needed) {
            try {
                car.setLicensePlate(Helpers.getUserString("Enter the license plate", in));
                needed = false;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        car.setMake(Helpers.getUserString("Enter the make", in));
        car.setModel(Helpers.getUserString("Enter the model", in));
        String prompt = "Enter the model year";
        int modelYear;
        needed = true;
        while(needed){
            try{
                car.setModelYear(Helpers.getUserInt(prompt, in, messages));
                needed = false;
            } catch(IllegalArgumentException e){
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }

        try{
            dao.createCarRecord(car);
            System.out.println("\nAdded: " + car);
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
//
    }
}