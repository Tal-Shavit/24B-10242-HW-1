package com.talshavit.mylibrary.models;

import java.util.Date;

public class Item {

    private String catrgoryName, count, description, imgStr;
    private String date;

    public Item() {
    }

    public Item(String catrgoryName, String count, String description, String imgStr, String date) {
        this.catrgoryName = catrgoryName;
        this.count = count;
        this.description = description;
        this.imgStr = imgStr;
        this.date = date;
    }

    public String getCatrgoryName() {
        return catrgoryName;
    }

    public Item setCatrgoryName(String catrgoryName) {
        this.catrgoryName = catrgoryName;
        return this;
    }

    public String getCount() {
        return count;
    }

    public Item setCount(String count) {
        this.count = count;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Item setDate(String date) {
        this.date = date;
        return this;
    }

    public String getImgStr() {
        return imgStr;
    }

    public Item setImgStr(String imgStr) {
        this.imgStr = imgStr;
        return this;
    }
}
