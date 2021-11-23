package com.nagy.derrick;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PresidentTest {

    President president;

    @BeforeEach
    void setUp() {
        president = new President();
    }

    @Test
    void getFirstName() {
        assertEquals(president.getFirstName(),President.DEFAULT_FIRST_NAME);
    }

    @Test
    void getLastName(){
        assertEquals(president.getLastName(), President.DEFAULT_LAST_NAME);
    }

    @Test
    void getBirthday(){
        assertEquals(president.getBirthday(), President.DEFAULT_BIRTHDAY);
    }

    @Test
    void getInaugurationYears(){
        assertEquals(president.getInaugurationAgeYears(), President.DEFAULT_INAUGURATION_AGE_YEARS);
    }

    @Test
    void getInaugurationDays(){
        assertEquals(president.getInaugurationAgeDays(), President.DEFAULT_INAUGURATION_AGE_DAYS);
    }

    @Test
    void getPresidentID(){
        assertEquals(president.getPresidentID(), President.DEFAULT_PRESIDENT_ID);
    }

    @Test
    void testToString(){
        String expected = "Person" +
                "{firstName='" +
                President.DEFAULT_FIRST_NAME +
                "', lastName='" +
                President.DEFAULT_LAST_NAME +
                "', birthday=" +
                President.DEFAULT_BIRTHDAY +
                "} President{inaugurationAgeYears=" +
                President.DEFAULT_INAUGURATION_AGE_YEARS +
                ", inaugurationAgeDays=" +
                President.DEFAULT_INAUGURATION_AGE_DAYS +
                ", presidentID=" +
                President.DEFAULT_PRESIDENT_ID +
                "}"
                ;
        assertEquals(expected, president.toString());
    }

    @Test
    void setFirstName(){
        //arrange
        final String expected = "Marc";
        String acutal = "";
        //act
        president.setFirstName(expected);
        acutal = president.getFirstName();
        //assert
        assertEquals(expected, acutal);
    }

    @Test
    void setFirstNameNull(){
        String newFirstName = null;

        Exception exception = assertThrows(NullPointerException.class, () -> president.setFirstName(newFirstName));

        String expected = President.MSG_NULL_POINTER_EXCEPTION;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void setLastName(){
        //arrange
        final String expected = "Washington";
        String acutal = "";
        //act
        president.setLastName(expected);
        acutal = president.getLastName();
        //assert
        assertEquals(expected, acutal);
    }

    @Test
    void setLastNameNull(){
        String newLastName = null;

        Exception exception = assertThrows(NullPointerException.class, () -> president.setLastName(newLastName));

        String expected = President.MSG_NULL_POINTER_EXCEPTION;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void setBirthday(){
        //arrange
        final LocalDate expected = LocalDate.now().minusYears(50);
        LocalDate actual;
        //act
        president.setBirthday(expected);
        actual = president.getBirthday();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    void setBirthdayEarliestThrowsDateTimeException(){
        LocalDate newBirthday = LocalDate.ofYearDay(1400,365);

        Exception exception = assertThrows(DateTimeException.class, () -> president.setBirthday(newBirthday));

        String expected = President.MSG_DATE_TIME_EXCEPTION;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void setBirthdayFutureThrowsDateTimeException(){
        LocalDate newBirthday = LocalDate.now().plusDays(1);

        Exception exception = assertThrows(DateTimeException.class, () -> president.setBirthday(newBirthday));

        String expected = President.MSG_DATE_TIME_EXCEPTION;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }



    @Test
    void setInaugurationAgeYears(){
        //arrange
        final int expected = 35;
        int actual;
        //act
        president.setInaugurationAgeYears(expected);
        actual = president.getInaugurationAgeYears();
        //assert
        assertEquals(expected, actual);
    }


    @Test
    void setInaugurationAgeYearsTooLow(){
        int newInaugurationAgeYears = 34;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> president.setInaugurationAgeYears(newInaugurationAgeYears));

        String expected = President.MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_YEARS;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }
    @Test
    void setInaugurationAgeYearsTooHigh(){
        int newInaugurationAgeYears = 101;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> president.setInaugurationAgeYears(newInaugurationAgeYears));

        String expected = President.MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_YEARS;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void setInaugurationAgeDays(){
        //arrange
        final int expected = 2;
        int acutal;
        //act
        president.setInaugurationAgeDays(expected);
        acutal = president.getInaugurationAgeDays();
        //assert
        assertEquals(expected, acutal);
    }

    @Test
    void setInaugurationAgeDaysTooLow(){
        int newInaugurationAgeDays = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> president.setInaugurationAgeDays(newInaugurationAgeDays));

        String expected = President.MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_DAYS;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void setInaugurationAgeDaysTooHigh(){
        int newInaugurationAgeDays = 366;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> president.setInaugurationAgeDays(newInaugurationAgeDays));

        String expected = President.MSG_ILLEGAL_ARGUMENT_EXCEPTION_INAUGURATION_AGE_DAYS;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void setPresidentID(){
        //arrange
        final int expected = 2;
        int acutal;
        //act
        president.setPresidentID(expected);
        acutal = president.getPresidentID();
        //assert
        assertEquals(expected, acutal);
    }

    @Test
    void setPresidentIDTooLow(){
        int newPresidentID = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> president.setPresidentID(newPresidentID));

        String expected = President.MSG_ILLEGAL_ARGUMENT_EXCEPTION_PRESIDENT_ID;
        String actual = exception.getMessage();

        assertEquals(expected,actual);
    }

    @Test
    void compareInaugurationAgeYearsAfterOtherDescendingSort(){
        President otherPres = new President();

        otherPres.setInaugurationAgeYears(41);

        int result = president.compareTo(otherPres);

        assertTrue(result > 0);

    }

    @Test
    void compareInaugurationAgeYearsBeforeOtherDescendingSort(){
        President otherPres = new President();

        otherPres.setInaugurationAgeYears(39);

        int result = president.compareTo(otherPres);

        assertTrue(result < 0);

    }

    @Test
    void compareInaugurationAgeYearsSameAsOther(){
        President otherPres = new President();

        otherPres.setInaugurationAgeYears(40);

        int result = president.compareTo(otherPres);

        assertTrue(result == 0);

    }

    @Test
    void compareInaugurationAgeDaysAfterOtherDescendingSort(){
        President otherPres = new President();

        otherPres.setInaugurationAgeDays(201);

        int result = president.compareTo(otherPres);

        assertTrue(result > 0);

    }

    @Test
    void compareInaugurationAgeDaysBeforeOtherDescendingSort(){
        President otherPres = new President();

        otherPres.setInaugurationAgeDays(199);

        int result = president.compareTo(otherPres);

        assertTrue(result < 0);

    }

    @Test
    void compareInaugurationAgeDaysSameAsOther(){
        President otherPres = new President();

        otherPres.setInaugurationAgeDays(200);

        int result = president.compareTo(otherPres);

        assertTrue(result == 0);
    }

    @Test
    void compareLastNameBeforeOther(){
        President otherPres = new President();
        otherPres.setLastName("e");

        int result = president.compareTo(otherPres);
        assertTrue(result < 0);
    }


    @Test
    void compareLastNameAfterOther(){
        President otherPres = new President();
        otherPres.setLastName("c");

        int result = president.compareTo(otherPres);
        assertTrue(result > 0);
    }


}