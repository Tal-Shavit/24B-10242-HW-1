package com.talshavit.mylibrary.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.talshavit.mylibrary.models.Category;
import com.talshavit.mylibrary.DataManagerBase;
import com.talshavit.mylibrary.GlobalResources;
import com.talshavit.mylibrary.helpers.GridViewAdapter;
import com.talshavit.mylibrary.R;

import java.util.ArrayList;

public class AddFragment extends Fragment {

    private ArrayList<Category> categories;

    public AddFragment() {
    }

    public AddFragment(DataManagerBase dataManagerBase) {
        this.categories = dataManagerBase.getCategories();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridView gridView = view.findViewById(R.id.gridView);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getContext(), categories);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = categories.get(i).getCategoryName();
                String imgStr = categories.get(i).getImage();
                GlobalResources.replaceFragment(requireActivity().getSupportFragmentManager(),new AddSpecificFragment(str, imgStr));
            }
        });
    }
}