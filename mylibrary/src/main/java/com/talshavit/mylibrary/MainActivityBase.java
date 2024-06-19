package com.talshavit.mylibrary;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.talshavit.mylibrary.fragments.AddFragment;
import com.talshavit.mylibrary.fragments.ChartFragment;
import com.talshavit.mylibrary.fragments.HomeFragment;

public class MainActivityBase extends AppCompatActivity {

    protected DataManagerBase dataManagerBase;
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private AddFragment addFragment;
    private ChartFragment chartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_base);

        findViews();
        initViews();
    }

    private void initViews() {

        if (GlobalResources.items.isEmpty()) {
            GlobalResources.replaceFragment(getSupportFragmentManager(), addFragment);
            openDialog(getString(R.string.titleDialog));
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    GlobalResources.replaceFragment(getSupportFragmentManager(), homeFragment);
                    return true;
                }
                if (item.getItemId() == R.id.add) {
                    GlobalResources.replaceFragment(getSupportFragmentManager(), addFragment);
                    return true;
                }
                if (item.getItemId() == R.id.chart) {
                    GlobalResources.replaceFragment(getSupportFragmentManager(), chartFragment);
                    return true;
                }
                if (item.getItemId() == R.id.chnageCount) {
                    openDialog("שנה את המגבלה");
                    return true;
                }
                return false;
            }
        });
    }

    private void openDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_change_count, null);
        builder.setView(dialogView);

        EditText editText = dialogView.findViewById(R.id.editText);

        builder.setTitle(title)
                .setPositiveButton("אישור", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        GlobalResources.count = Integer.parseInt(editText.getText().toString());
                        calcCount();
                        if (title.equals(getString(R.string.titleDialog))) {
                            GlobalResources.replaceFragment(getSupportFragmentManager(), addFragment);
                        } else {
                            GlobalResources.replaceFragment(getSupportFragmentManager(), new HomeFragment());
                            selectHomeFragment();
                        }
                    }
                })
                .setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }

    private void calcCount() {
        for(int i=0; i<GlobalResources.items.size(); i++){
            GlobalResources.count -= Integer.parseInt(GlobalResources.items.get(i).getCount());
        }
    }

    private void findViews() {
        homeFragment = new HomeFragment();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        addFragment = new AddFragment(dataManagerBase);
        chartFragment = new ChartFragment();
    }

    public void selectHomeFragment() {
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}