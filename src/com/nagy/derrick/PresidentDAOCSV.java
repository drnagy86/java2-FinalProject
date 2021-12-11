package com.nagy.derrick;

import com.nagy.derrick.car.Car;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PresidentDAOCSV implements PresidentDAO{

    private static final String FILE_NAME = "presidents.csv";
    private static List<President> presidents;


    @Override
    public void readInData() throws DataException {
        try(Scanner in = new Scanner(new File(FILE_NAME))){

            presidents = new ArrayList<>();

            int presidentID;
            String firstName;
            String lastName;
            LocalDate birthday;
            int inaugurationAgeYears;
            int inaugurationAgeDays;


            int lineCount = 0;
            String line = "";
            String[] fields;


            while (in.hasNextLine()){
                lineCount++;
                line = in.nextLine();
                if(lineCount > 1){
                    fields = line.split(",");
                    try {
                        presidentID = Integer.parseInt(fields[0]);
                    }
                    catch (NumberFormatException ex){
                        throw new DataException(ex.getMessage() + " CSV line" + lineCount);
                    }
                    firstName = fields[1];
                    lastName = fields[2];
                    try {
                        birthday = LocalDate.parse(fields[3]);
                    }
                    catch (DateTimeParseException e){
                        throw new DataException(e.getMessage() + " CSV line" + lineCount);
                    }
                    try {
                        inaugurationAgeYears = Integer.parseInt(fields[4]);
                    }
                    catch (NumberFormatException ex){
                        throw new DataException(ex.getMessage() + " CSV line" + lineCount);
                    }
                    try {
                        inaugurationAgeDays = Integer.parseInt(fields[5]);
                    }
                    catch (NumberFormatException ex) {
                        throw new DataException(ex.getMessage() + " CSV line" + lineCount);
                    }
                    presidents.add(new President(firstName, lastName, birthday, inaugurationAgeYears, inaugurationAgeDays, presidentID));
                }
            }

        } catch(FileNotFoundException e){
            throw new DataException(e);
        }


    }

    private void saveToFile() throws DataException {
        try(PrintWriter writer = new PrintWriter(new File(FILE_NAME))){
            writer.println("nth,firstName,lastName,birthday,inaugurationAge-Years,inaugurationAge-Days");
            String line = "";

            for(President president : presidents){
                line = president.getPresidentID() + ","
                        + president.getFirstName() +","
                        + president.getLastName() +","
                        + president.getBirthday() +","
                + president.getInaugurationAgeYears() +","
                + president.getInaugurationAgeDays()
                ;
                writer.println(line);
            }
        }
        catch (FileNotFoundException ex){
            throw new DataException(ex.getMessage());
        }
    }

    @Override
    public void verifyPresidentList() throws DataException {
        if(presidents == null){
            readInData();
        }

    }

    @Override
    public void createPresidentRecord(President president) throws DataException {
        verifyPresidentList();
        presidents.add(president);
        saveToFile();
    }

    @Override
    public President getPresidentByPresidentID(int presidentID) throws DataException {

        return null;
    }

    @Override
    public List<President> getAllPresidents() throws DataException {
        presidents = null;
        verifyPresidentList();
        return presidents;
    }

    @Override
    public void updatePresident(President original, President updated) throws DataException {

    }

    @Override
    public void deletePresident(President president) throws DataException {

    }

    @Override
    public void deletePresident(int presidentID) throws DataException {

    }
}
