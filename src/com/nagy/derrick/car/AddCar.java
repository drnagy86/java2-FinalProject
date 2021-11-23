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
    public void handleTask(CarDAO dao, Scanner in) {
        Car car = new Car();
        car.setLicensePlate(Helpers.getUserString("Enter the license plate", in));
        car.setMake(Helpers.getUserString("Enter the make", in));
        car.setModel(Helpers.getUserString("Enter the model", in));
        String prompt = "Enter the model year";
        int modelYear;
        boolean needed = true;
        while(needed){
            try{
                car.setModelYear(Helpers.getUserIntInRange(prompt, Car.MINIMUM_MODEL_YEAR, Car.MAXIMUM_MODEL_YEAR, in));
                needed = false;
            } catch(IllegalArgumentException e){
                UIUtility.showErrorMessage().accept(e.getMessage(), in);
            }
        }

        try{
            dao.createCarRecord(car);
            System.out.println("Added " + car);
        } catch (DataException e) {
            UIUtility.showErrorMessage().accept(e.getMessage(), in);
        }
        UIUtility.pressEnterToContinue().accept(in);
    }
}