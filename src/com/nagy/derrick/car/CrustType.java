package com.nagy.derrick.car;

public enum CrustType {
    //Create an Enum for CrustType.
    //
    //Original (270 calories per slice)
    // , Stuffed (330 calories per slice),
    // Thin (200 calories per slice),
    // Gluten-Free (150 calories per slice)
    ORIGINAL(270, "Original"),
    STUFFED(330,"Stuffed"),
    THIN(200, "Thin"),
    GLUTEN_FREE(150, "Gluten Free");

    private int calories;
    private String description;

    CrustType(int calories, String description) {
        this.calories = calories;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return description + "(" + calories+" calories per slice)";
    }
}
