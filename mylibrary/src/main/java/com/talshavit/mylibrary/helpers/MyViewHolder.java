package com.talshavit.mylibrary.helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.talshavit.mylibrary.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView count, description, categoryName, date;
    public ShapeableImageView imgItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View view) {
        count = view.findViewById(R.id.count);
        description = view.findViewById(R.id.description);
        categoryName = view.findViewById(R.id.categoryName);
        imgItem = view.findViewById(R.id.imgItem);
        date = view.findViewById(R.id.date);
    }
}
