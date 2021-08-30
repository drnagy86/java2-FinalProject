package com.nagy.derrick;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Book[] bookshelf = new Book[5];
        bookshelf[0] = new Book(
                "Python",
                "Marc Hauschildt",
                false,
                1000
        );
        bookshelf[1] = new Book(
                "Java",
                "Marc Hauschildt",
                false,
                750
        );
        bookshelf[2] = new Book(
                "Java",
                "Ada Lovelace",
                false,
                500
        );
        bookshelf[3] = new Book();
        bookshelf[4] = new ChildrensBook("Java for Kids", "Grace Hopper", true, 20, "Some Guy");

        Arrays.sort(bookshelf);
        System.out.println("There are " + Book.getBookCount() + " books on the bookshelf.");
        for (Book book : bookshelf){
            System.out.println(book);
        }

    }
}
