package com.nagy.derrick.car;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface CarDataHandler {
    void handleTask(CarDAO dao, Scanner in, ResourceBundle messages);
}
