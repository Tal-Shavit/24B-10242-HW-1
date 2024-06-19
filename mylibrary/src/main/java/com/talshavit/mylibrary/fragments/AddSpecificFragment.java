package com.talshavit.mylibrary.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.talshavit.mylibrary.GlobalResources;
import com.talshavit.mylibrary.models.Item;
import com.talshavit.mylibrary.MainActivityBase;
import com.talshavit.mylibrary.R;

import java.util.Calendar;

public class AddSpecificFragment extends Fragment {

    protected EditText editTxtFirstFrame, editTxtSecFrame, editTxtThirdFrame, editTxtDate;
    private String str, strCount, strDescription, imgStr, date;
    private MaterialButton calcButton;


    public AddSpecificFragment() {
    }

    public AddSpecificFragment(String str, String imgStr) {
        this.str = str;
        this.imgStr = imgStr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_specific, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        initViews();
    }

    private void initViews() {
        editTxtFirstFrame.setText(str);
        onEditTxtDate();
        onCalcButton();
    }

    private void onCalcButton() {
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strCount = editTxtSecFrame.getText().toString().trim();
                strDescription = editTxtThirdFrame.getText().toString().trim();
                boolean isValid = true;
                if (str.equals("אחר")) {
                    str = editTxtFirstFrame.getText().toString().trim();
                    if (str.equals("אחר")) {
                        editTxtFirstFrame.setError("חייב למלא קטגוריה");
                        isValid = false;
                    } else {
                        editTxtFirstFrame.setText(str);
                    }
                }
                if (strCount.isEmpty()) {
                    editTxtSecFrame.setError("חייב למלא כמות");
                    isValid = false;
                }
                if (strDescription.isEmpty()) {
                    editTxtThirdFrame.setError("חייב למלא תיאור");
                }
                if (isValid) {
                    Item item = new Item(str, strCount, strDescription, imgStr, date);
                    GlobalResources.items.add(item);
                    calcCount();
                    GlobalResources.replaceFragment(requireActivity().getSupportFragmentManager(), new HomeFragment());
                    ((MainActivityBase) requireActivity()).selectHomeFragment();
                }
            }
        });
    }

    private void calcCount() {
        int count = Integer.parseInt(strCount);
        GlobalResources.count -= count;
        if (GlobalResources.count < 0) {
            Toast.makeText(getContext(), getString(R.string.toast), Toast.LENGTH_LONG).show();
        }
    }


    private void onEditTxtDate() {
        editTxtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    initDateDialog();
                }
            }
        });
    }

    private void initDateDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        editTxtDate.setText(date); // Update EditText with selected date
                    }
                }, year, month, dayOfMonth);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        long minDate = calendar.getTimeInMillis();
        datePickerDialog.getDatePicker().setMinDate(minDate);

        datePickerDialog.show();
    }

    private void findViews(View view) {
        editTxtFirstFrame = view.findViewById(R.id.editTxtFirstFrame);
        editTxtSecFrame = view.findViewById(R.id.editTxtSecFrame);
        editTxtThirdFrame = view.findViewById(R.id.editTxtThirdFrame);
        editTxtDate = view.findViewById(R.id.editTxtDate);
        calcButton = view.findViewById(R.id.calcButton);
    }
}