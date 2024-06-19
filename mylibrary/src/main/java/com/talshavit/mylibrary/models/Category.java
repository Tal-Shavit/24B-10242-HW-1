package com.talshavit.mylibrary.models;

public class Category {
    private String categoryName;
    private String image;

    public Category() {
    }

    public Category(String categoryName, String image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Category setImage(String image) {
        this.image = image;
        return this;
    }
}
