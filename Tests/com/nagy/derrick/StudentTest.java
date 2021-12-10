package com.nagy.derrick;

        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void getId() {

        String expected = "k0000000";
        assertEquals(student.getId(), expected);
    }

    @Test
    void setId() {
        //arrange
        final String expected = "k0000001";
        String actual = "";
        //act
        student.setId("k0000001");
        actual = student.getId();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    void testSetIdBad(){

        String badID = "k0000000000000";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setId(badID));

        String expected = "The ID must be exactly 8 characters";
        String actual = exception.getMessage();

        assertEquals(expected,actual);

    }

}