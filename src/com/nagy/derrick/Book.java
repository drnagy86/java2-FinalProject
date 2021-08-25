package com.nagy.derrick;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private boolean read;
    private int numPages;

    private int bookId;
    private static int count = 0;


    public Book() {

        bookId = ++count;
        this.title = "Unknown";
        this.author = "Unknown";
        this.read = false;
        setNumPages(0);
    }

    public Book(String title, String author, boolean read, int numPages) {
        // calls the default
        this();
        this.title = title;
        this.author = author;
        this.read = read;
        setNumPages(numPages);
    }

    public static int getBookCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        if (numPages >= 0) {
            this.numPages = numPages;
        } else {
            this.numPages = 0;
        }
    }

    @Override
    public String toString() {
        String result = "Book Id: " + bookId;
        result += "\n\tTitle: " + title;
        result += "\n\tAuthor: " + author;
        result += "\n\tRead: " + read;
        result += "\n\tPages: " + numPages;
        return result;
    }

    @Override
    public int compareTo(Book other) {
        if (this.author.compareTo(other.author) == 0) {
            return this.title.compareTo(other.title);
        }
        return this.author.compareTo(other.author);
    }
}
