package com.talshavit.a24b_10242_hw_1;

import com.talshavit.mylibrary.models.Category;
import com.talshavit.mylibrary.DataManagerBase;

import java.util.ArrayList;

public class DataManager extends DataManagerBase {

    @Override
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/2357/2357127.png").setCategoryName("ביגוד"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/10508/10508396.png").setCategoryName("אוכל לבית"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/6966/6966307.png").setCategoryName("מסעדות ואוכל בחוץ"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/4807/4807765.png").setCategoryName("פנאי ובילויים"));
        categories.add(new Category().setImage("https://cdn-icons-png.flaticon.com/512/16273/16273692.png").setCategoryName("אחר"));

        return categories;
    }
}
