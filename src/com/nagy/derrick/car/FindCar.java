package com.nagy.derrick.car;

import com.nagy.derrick.DataException;
import com.nagy.derrick.Helpers;
import com.nagy.derrick.UIUtility;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FindCar implements CarDataHandler{
    @Override
    public void handleTask(CarDAO dao, Scanner in, ResourceBundle messages) {
        try {
            List<Car> cars = dao.getAllCars();
            if(cars != null) {
                String licensePlate = Helpers.getUserString.apply(messages.getString("enter-license-plate"), in);
                System.out.println("\n"+ messages.getString("searching-for-license-plate") +" " + licensePlate + "...");
                Car car = dao.getCarByLicensePlate(licensePlate);
                if (car == null) {
                    System.out.println(messages.getString("no-car-found-with-license-plate") + ": " + licensePlate);
                } else {
                    System.out.println(messages.getString("retrieved") + " : " + car);
                }
                System.out.println("\n" + messages.getString("find-a-car-complete"));
            } else {
                System.out.println(messages.getString("there-are-no-cars-available"));
            }
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}
