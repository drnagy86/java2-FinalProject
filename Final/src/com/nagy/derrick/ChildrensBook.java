package com.nagy.derrick;

public class ChildrensBook extends Book{

    private String illustrator;


    public ChildrensBook() {
        // always needs to be first
        super();
        this.illustrator = "Unknown";
    }

    public ChildrensBook(String title, String author, boolean read, int numPages, String illustrator) {
        super(title, author, read, numPages);
        this.illustrator = illustrator;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tIllustractor: " + illustrator;
    }
}
