package com.nagy.derrick;
import com.nagy.derrick.car.CarDAO;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface PresidentDataHandler {
    void handleTask(PresidentDAO dao, Scanner in, ResourceBundle messages);
}
