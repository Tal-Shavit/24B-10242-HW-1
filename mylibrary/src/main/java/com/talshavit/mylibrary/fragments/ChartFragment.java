package com.talshavit.mylibrary.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.talshavit.mylibrary.GlobalResources;
import com.talshavit.mylibrary.R;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {

    public ChartFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        initView(view);
    }

    private void initView(View view) {
        List<PieEntry> pieEntries = new ArrayList<>();
        List<String> category = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        pieEntries.add(new PieEntry(GlobalResources.count, getString(R.string.onChart))); // Display total count

        for (int i = 0; i < GlobalResources.items.size(); i++) {
            category.add(GlobalResources.items.get(i).getCatrgoryName());
            count.add(Integer.parseInt(GlobalResources.items.get(i).getCount()));
        }

        for (int i = 0; i < GlobalResources.items.size(); i++) {
            pieEntries.add(new PieEntry(count.get(i), category.get(i)));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) view.findViewById(R.id.chart);
        chart.setData(data);
        chart.invalidate();
    }

    private void findViews(View view) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }
}