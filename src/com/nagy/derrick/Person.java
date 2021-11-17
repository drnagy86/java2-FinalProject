package com.nagy.derrick;

import java.time.LocalDate;

public class Person {
//
//    A String instance variable for "firstName" and "lastName".
//    A LocalDate instance variable for "birthday".
//    static minimum/maximum variables for "birthday" (See validate info below).
//    a regular constructor.
//    getter and setter methods.
//    validate methods:
//    firstName, lastName, and birthday cannot be null.
//    birthday cannot be before January 1, 1700 and not after the current day.

    private String firstName;
    private String lastName;
    private LocalDate birthday;


    public static final LocalDate DEFAULT_BIRTHDAY = LocalDate.now().minusYears(40);
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";

    public static final LocalDate EARLIEST_BIRTHDAY = LocalDate.ofYearDay(1500,1);
    public static final LocalDate LATEST_BIRTHDAY = LocalDate.now();

    public static final String NULL_POINTER_EXCEPTION_MESSAGE = "This field can't be empty.";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "Not a date between 1700 and now.";

    public Person() {
        firstName = DEFAULT_FIRST_NAME;
        lastName = DEFAULT_LAST_NAME;
        birthday = DEFAULT_BIRTHDAY;
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        validateStringNotNull(firstName,lastName);
        validateDateRange1700toNow(birthday);

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        validateStringNotNull(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        validateStringNotNull(lastName);
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        validateDateRange1700toNow(birthday);
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public void validateStringNotNull(String ... stringToTest ){

        for (String s : stringToTest) {
            if (s == null){
                throw new NullPointerException(NULL_POINTER_EXCEPTION_MESSAGE);
            }
        }
    }

    public void validateDateRange1700toNow(LocalDate dateToTest){
        if (dateToTest.isBefore(EARLIEST_BIRTHDAY) || dateToTest.isAfter(LATEST_BIRTHDAY)){
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }




}
