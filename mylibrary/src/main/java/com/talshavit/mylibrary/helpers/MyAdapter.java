package com.talshavit.mylibrary.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.talshavit.mylibrary.GlobalResources;
import com.talshavit.mylibrary.models.Item;
import com.talshavit.mylibrary.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Item> items;
    private Context context;

    public MyAdapter() {
        this.items = GlobalResources.items;
    }

    public MyAdapter(Context context) {
        this.items = GlobalResources.items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.categoryName.setText(items.get(position).getCatrgoryName());
        holder.count.setText(items.get(position).getCount() + " " + context.getResources().getString(R.string.unit));
        holder.description.setText(items.get(position).getDescription());
        Glide.with(context).load(items.get(position).getImgStr()).into(holder.imgItem);
        holder.date.setText(items.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public int getCount(int pos) {
        return Integer.parseInt(items.get(pos).getCount());
    }
}
