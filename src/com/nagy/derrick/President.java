package com.nagy.derrick;

import java.time.LocalDate;

public class President extends Person implements Comparable<President>{

    private int inaugurationAgeYears;
    private int inaugurationAgeDays;
    private int presidentID;

    public static final int DEFAULT_INAUGURATION_AGE_YEARS = 40;
    public static final int DEFAULT_INAUGURATION_AGE_DAYS = 200;
    public static final int DEFAULT_PRESIDENT_ID = 99;

    public static final int MIN_INAUGURATION_AGE_YEARS = 35;
    public static final int MAX_INAUGURATION_AGE_YEARS = 100;
    public static final int MIN_INAUGURATION_AGE_DAYS = 1;
    public static final int MAX_INAUGURATION_AGE_DAYS = 365;
    public static final int MIN_PRESIDENT_ORDINAL = 1;
    public static final int MAX_PRESIDENT_ORDINAL = Integer.MAX_VALUE;


    public static final String MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_YEARS = "Age must be between 35 and 100 years old.";
    public static final String MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_DAYS = "Days must be between 1 and 365.";
    public static final String MSG_ILLEGAL_ARGUMENT_EXCEPTION_PRESIDENT_ID = "Ordinal must be greater than zero.";

    public President() {
        super(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_BIRTHDAY);
        this.inaugurationAgeYears = DEFAULT_INAUGURATION_AGE_YEARS;
        this.inaugurationAgeDays =DEFAULT_INAUGURATION_AGE_DAYS;
        this.presidentID = DEFAULT_PRESIDENT_ID;
    }

    public President(String firstName, String lastName, LocalDate birthday, int inaugurationAgeYears, int inaugurationAgeDays, int presidentID) {
        super(firstName, lastName, birthday);
        validateInaugurationAgeYears(inaugurationAgeYears);
        validateInaugurationAgeDays(inaugurationAgeDays);
        validatePresidentID(presidentID);

        this.inaugurationAgeYears = inaugurationAgeYears;
        this.inaugurationAgeDays = inaugurationAgeDays;
        this.presidentID = presidentID;
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


    public int getPresidentID() {
        return presidentID;
    }

    public void setPresidentID(int presidentID) {
        validatePresidentID(presidentID);
        this.presidentID = presidentID;
    }

    public void validateInaugurationAgeYears(int years){
        if (years > MAX_INAUGURATION_AGE_YEARS || years < MIN_INAUGURATION_AGE_YEARS ) throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_YEARS);
    }

    public void validateInaugurationAgeDays(int days){
        if (days > MAX_INAUGURATION_AGE_DAYS || days < MIN_INAUGURATION_AGE_DAYS) throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_DAYS);
    }

    public void validatePresidentID(int ordinal){
        if (ordinal < MIN_PRESIDENT_ORDINAL) throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT_EXCEPTION_PRESIDENT_ID);
    }

    @Override
    public String toString() {
        return super.toString() +
                " President{" +
                "inaugurationAgeYears=" + inaugurationAgeYears +
                ", inaugurationAgeDays=" + inaugurationAgeDays +
                ", presidentID=" + presidentID +
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
