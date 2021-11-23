package com.nagy.derrick.car;

import java.util.ArrayList;

public enum Size {
    // Marc had the description be short and let the string method fill in the pieces
    EXTRA_SMALL("extra small", 6),
    SMALL("small", 8),
    MEDIUM("medium", 10),
    LARGE("large", 12),
    EXTRA_LARGE("extra large", 14),
    TERMINATOR("terminator", 20),;

    private String sizeDescription;
    private int diameter;

    Size(String sizeDescription, int diameter) {
        this.sizeDescription = sizeDescription;
        this.diameter = diameter;
    }

    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {

//        ArrayList<char> vowels = new ArrayList<char>('a', 'e', 'i','o','u');
        char[] vowels ={'a','e','i','o','u'};
        String indefArticle = "";
        for (char vowel: vowels ) {
            if(sizeDescription.charAt(0) == vowel) {
                indefArticle = "an";
                break;
            }else {
                indefArticle = "a";
            }
        }


        return "The diameter of " + indefArticle + " " + sizeDescription +" pizza is "+ diameter + " inches";
    }
}
