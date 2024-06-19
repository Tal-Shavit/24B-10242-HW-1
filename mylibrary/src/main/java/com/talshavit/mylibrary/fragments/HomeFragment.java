package com.talshavit.mylibrary.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talshavit.mylibrary.GlobalResources;
import com.talshavit.mylibrary.MainActivityBase;
import com.talshavit.mylibrary.R;
import com.talshavit.mylibrary.helpers.MyAdapter;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private AppCompatTextView textView;
    public AppCompatTextView txtForNoCount;


    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        initViews();
    }

    public void initViews() {
        txtVisibilityIfEmpty();
        updateTextView();
        updateTxtColor();
        myAdapter = new MyAdapter(getContext());
        initAdapter(recyclerView, myAdapter);
        deleteFromRecycler();
    }

    private void updateTextView() {
        textView.setText(getString(R.string.homeFragmentTitle) +"\n"+ GlobalResources.count+" "+getString(R.string.unit));
    }

    private void txtVisibilityIfEmpty() {
        if(GlobalResources.items.isEmpty())
            txtForNoCount.setVisibility(View.VISIBLE);
    }

    private void updateTxtColor() {
        if (GlobalResources.count < 0) {
            textView.setTextColor(getResources().getColor(R.color.red));
        }
    }

    private void deleteFromRecycler() {
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        textView = view.findViewById(R.id.textView);
        txtForNoCount = view.findViewById(R.id.txtForNoCount);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void initAdapter(RecyclerView recyclerView, RecyclerView.Adapter myAdapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            int position = viewHolder.getAdapterPosition();

            builder.setTitle("מחיקה");
            builder.setMessage("את/ה בטוח/ה שברצונך למחוק?");
            builder.setCancelable(false);
            builder.setPositiveButton("כן", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("lala", position+"");
                    int count = myAdapter.getCount(position);
                    GlobalResources.count += count;
                    GlobalResources.items.remove(position);
                    updateTextView();
                    myAdapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    myAdapter.notifyItemChanged(position);
                }
            });
            builder.show();
        }
    };
}