package com.example.recycler_notifydatasetchanged;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<viewHolder> {
    private ArrayList<Model> dataList = new ArrayList<>();
    clickListener clickListener;

    public Adapter(ArrayList<Model> dataList,clickListener clickListener) {
        this.dataList = dataList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new viewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
