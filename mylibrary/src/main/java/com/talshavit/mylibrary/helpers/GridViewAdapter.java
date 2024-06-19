package com.talshavit.mylibrary.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.talshavit.mylibrary.models.Category;
import com.talshavit.mylibrary.R;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<Category> {

    public GridViewAdapter(@NonNull Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HolderView holderView;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }

        Category model = getItem(position);
        holderView.textView.setText(model.getCategoryName());
        Glide.with(getContext()).load(model.getImage()).into(holderView.img_item);

        return convertView;
    }

    private static class HolderView {
        private final TextView textView;
        private final ShapeableImageView img_item;

        public HolderView(View view) {
            textView = view.findViewById(R.id.text_item);
            img_item = view.findViewById(R.id.img_item);
        }
    }
}
