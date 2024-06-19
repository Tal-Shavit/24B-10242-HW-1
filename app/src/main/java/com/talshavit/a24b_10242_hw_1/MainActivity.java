package com.talshavit.a24b_10242_hw_1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.talshavit.mylibrary.DataManagerBase;
import com.talshavit.mylibrary.MainActivityBase;

public class MainActivity extends MainActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManager();
        super.onCreate(savedInstanceState);

    }
}