package com.talshavit.dietapp;

import com.talshavit.mylibrary.models.Category;
import com.talshavit.mylibrary.DataManagerBase;

import java.util.ArrayList;

public class DataManager extends DataManagerBase {
    @Override
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/3480/3480768.png").setCategoryName("ארוחת בוקר"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/3274/3274083.png").setCategoryName("ארוחת צהריים"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/8033/8033081.png").setCategoryName("ארוחת ערב"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/1625/1625099.png").setCategoryName("ארוחת ביניים"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/2553/2553692.png").setCategoryName("נשנושים"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/3170/3170733.png").setCategoryName("אחר"));

        return categories;
    }
}
