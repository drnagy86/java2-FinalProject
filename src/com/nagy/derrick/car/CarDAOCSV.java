package com.nagy.derrick.car;

import com.nagy.derrick.DataException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAOCSV implements CarDAO {
    private static final String FILE_NAME = "cars.csv";
    private static List<Car> cars;

    @Override
    public void readInData() throws DataException {

        try(Scanner in = new Scanner(new File(FILE_NAME))){
            cars = new ArrayList<>();
            int lineCount = 0;

            String line;
            String[] fields;
            String licensePlate;
            String make;
            String model;
            int modelYear;

            line = in.nextLine();
            while (in.hasNext()){

            }

        }
        catch(FileNotFoundException e){
            throw new DataException(e);
        }

    }

    private void saveToFile() throws DataException {

    }

    @Override
    public void verifyCarList() throws DataException {
        if(null == cars){
            readInData();
        }
    }

    @Override
    public void createCarRecord(Car car) throws DataException {
        verifyCarList();
        cars.add(car);
        saveToFile();
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) throws DataException {
        Car car = null;

        return car;
    }

    @Override
    public List<Car> getAllCars() throws DataException {
        List<Car> cars = null;

        return cars;
    }

    @Override
    public void updateCar(Car original, Car updated) throws DataException {

    }

    @Override
    public void deleteCar(Car car) throws DataException {

    }

    @Override
    public void deleteCar(String licensePlate) throws DataException {

    }

}
