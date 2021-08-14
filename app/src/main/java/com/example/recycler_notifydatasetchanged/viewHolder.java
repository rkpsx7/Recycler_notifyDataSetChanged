package com.example.recycler_notifydatasetchanged;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {

    TextView mTvName, mTvAge, mTvAddress;
    ImageView mIvEdit;
    clickListener clickListener;

    public viewHolder(@NonNull View itemView, clickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mIvEdit = itemView.findViewById(R.id.ivEdit);
    }

    public void setData(Model model) {
        mTvName.setText(model.getName());
        mTvAge.setText(model.getAge() + "");
        mTvAddress.setText(model.getAddress());
        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(model, getAdapterPosition());
            }
        });
    }
}
