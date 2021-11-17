package com.nagy.derrick;

import java.time.LocalDate;

public class President extends Person implements Comparable<President>{

    private int inaugurationAge_Years;
    private int inaugurationAge_Days;


    public static final int DEFAULT_INAUGURATION_AGE_YEARS = 4;
    public static final int DEFAULT_INAUGURATION_AGE_DAYS = 1;

    public static final int MIN_INAUGURATION_AGE_YEARS = 35;
    public static final int MAX_INAUGURATION_AGE_YEARS = 100;
    public static final int MIN_INAUGURATION_AGE_DAYS = 1;
    public static final int MAX_INAUGURATION_AGE_DAYS = 365;

    public static final String ILLEGAL_ARGUEMENT_EXCEPTION_MESSAGE_IAUGURATION_AGE_YEARS = "Age must be between 35 and 100 years old.";
    public static final String ILLEGAL_ARGUEMENT_EXCEPTION_MESSAGE_IAUGURATION_AGE_DAYS = "Days must be between 1 and 365.";

    public President() {
        super(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_BIRTHDAY);
        this.inaugurationAge_Years = DEFAULT_INAUGURATION_AGE_YEARS;
        this.inaugurationAge_Days =DEFAULT_INAUGURATION_AGE_DAYS;
    }

    public President(String firstName, String lastName, LocalDate birthday, int inaugurationAge_Years, int inaugurationAge_Days) {
        super(firstName, lastName, birthday);
        this.inaugurationAge_Years = inaugurationAge_Years;
        this.inaugurationAge_Days = inaugurationAge_Days;
    }

    @Override
    public String toString() {
        return super.toString() +
                "President{" +
                "inaugurationAge_Years=" + inaugurationAge_Years +
                ", inaugurationAge_Days=" + inaugurationAge_Days +
                '}';
    }

    @Override
    public int compareTo(President other) {
        // orders first by "inaugurationAge_Years" in descending order,
        // second by "inaugurationAge_Days" in descending order,
        // and third by "lastName" is ascending order.

        int result = (this.inaugurationAge_Years - other.inaugurationAge_Years) * -1;

        if (result == 0){
            result = (this.inaugurationAge_Days - other.inaugurationAge_Days) * -1;

            if (result == 0){
                result = (this.getLastName().compareToIgnoreCase(other.getLastName()));
            }
        }



        return result;
    }
}
