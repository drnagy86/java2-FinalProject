package com.nagy.derrick.car;

import com.nagy.derrick.DataException;
import com.nagy.derrick.UIUtility;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShowAllCars implements CarDataHandler {
    @Override
    public void handleTask(CarDAO dao, Scanner in, ResourceBundle messages) {
        try {
            List<Car> cars = dao.getAllCars();
            if(cars != null) {
                System.out.println(messages.getString("license-plate")+
                        "\t" + messages.getString("make") +
                        "\t" +messages.getString("model") +"\t" + messages.getString("model-year"));
                for (Car car : cars) {
                    System.out.println(car.getLicensePlate() + "\t\t" + car.getMake() + "\t"
                            + car.getModel() + "\n" + car.getModelYear());
                }
                System.out.println("\n"+ messages.getString("show-all-cars-complete")+ ".");
            } else {
                System.out.println(messages.getString("there-are-no-cars-available"));
            }
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}
