package com.nagy.derrick;

import java.time.LocalDate;
import java.util.Locale;

public class Student extends Person implements Comparable<Student>{

    private String id;

    public Student(){
        super();

        this.id = "k0000000";
    }

    public Student(String firstName, String lastName, LocalDate birthday, String id) {
        super(firstName, lastName, birthday);
        validateID(id.toLowerCase());
        this.id = id.toLowerCase();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validateID(id.toLowerCase());
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Student{" +
                "id='" + id + '\'' +
                '}';
    }

    public void validateID(String id){
        if (id == "") throw new IllegalArgumentException("The ID can not be blank");
        if(id.length() != 8) throw new IllegalArgumentException("The ID must be exactly 8 characters");
        if (id.charAt(0) != 'k') throw new IllegalArgumentException("The ID must start with \"k\"");
    }

    @Override
    public int compareTo(Student other) {
        return this.getId().compareToIgnoreCase(other.getId());
    }
}
