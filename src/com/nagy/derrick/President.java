package com.nagy.derrick;

import java.time.LocalDate;

public class President extends Person implements Comparable<President>{

    private int inaugurationAgeYears;
    private int inaugurationAgeDays;

    public static final int DEFAULT_INAUGURATION_AGE_YEARS = 40;
    public static final int DEFAULT_INAUGURATION_AGE_DAYS = 200;

    public static final int MIN_INAUGURATION_AGE_YEARS = 35;
    public static final int MAX_INAUGURATION_AGE_YEARS = 100;
    public static final int MIN_INAUGURATION_AGE_DAYS = 1;
    public static final int MAX_INAUGURATION_AGE_DAYS = 365;

    public static final String MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_YEARS = "Age must be between 35 and 100 years old.";
    public static final String MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_DAYS = "Days must be between 1 and 365.";

    public President() {
        super(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_BIRTHDAY);
        this.inaugurationAgeYears = DEFAULT_INAUGURATION_AGE_YEARS;
        this.inaugurationAgeDays =DEFAULT_INAUGURATION_AGE_DAYS;
    }

    public President(String firstName, String lastName, LocalDate birthday, int inaugurationAgeYears, int inaugurationAgeDays) {
        super(firstName, lastName, birthday);
        validateInaugurationAgeYears(inaugurationAgeYears);
        validateInaugurationAgeDays(inaugurationAgeDays);

        this.inaugurationAgeYears = inaugurationAgeYears;
        this.inaugurationAgeDays = inaugurationAgeDays;
    }

    public int getInaugurationAgeYears() {
        return inaugurationAgeYears;
    }

    public void setInaugurationAgeYears(int inaugurationAgeYears) {
        validateInaugurationAgeYears(inaugurationAgeYears);
        this.inaugurationAgeYears = inaugurationAgeYears;
    }

    public int getInaugurationAgeDays() {
        return inaugurationAgeDays;
    }

    public void setInaugurationAgeDays(int inaugurationAgeDays) {
        validateInaugurationAgeDays(inaugurationAgeDays);
        this.inaugurationAgeDays = inaugurationAgeDays;
    }

    public void validateInaugurationAgeYears(int years){
        if (years > MAX_INAUGURATION_AGE_YEARS || years < MIN_INAUGURATION_AGE_YEARS ) throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_YEARS);
    }

    public void validateInaugurationAgeDays(int days){
        if (days > MAX_INAUGURATION_AGE_DAYS || days < MIN_INAUGURATION_AGE_DAYS) throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_DAYS);
    }


    @Override
    public String toString() {
        return super.toString() +
                "President{" +
                "inaugurationAge_Years=" + inaugurationAgeYears +
                ", inaugurationAge_Days=" + inaugurationAgeDays +
                '}';
    }

    @Override
    public int compareTo(President other) {
        // orders first by "inaugurationAge_Years" in descending order,
        // second by "inaugurationAge_Days" in descending order,
        // and third by "lastName" is ascending order.

        int result = (this.inaugurationAgeYears - other.inaugurationAgeYears) * -1;

        if (result == 0){
            result = (this.inaugurationAgeDays - other.inaugurationAgeDays) * -1;

            if (result == 0){
                result = (this.getLastName().compareToIgnoreCase(other.getLastName()));
            }
        }
        return result;
    }
}
