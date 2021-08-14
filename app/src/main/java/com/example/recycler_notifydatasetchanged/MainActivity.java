package com.example.recycler_notifydatasetchanged;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements clickListener {

    private ArrayList<Model> dataList = new ArrayList<>();
    private CardView mEditCardView;
    private RecyclerView recyclerView;
    private EditText mEtName, mEtAge, mEtAddress;
    private Button mBtnSave;
    private Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        buildData();
        setRecyclerView();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mEditCardView = findViewById(R.id.edit_details_layout);
        mEtName = findViewById(R.id.etName);
        mEtAge = findViewById(R.id.etAge);
        mEtAddress = findViewById(R.id.etAddress);
        mBtnSave = findViewById(R.id.btn_Done);

    }

    private void setRecyclerView() {
        adapter = new Adapter(dataList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildData() {
        for (int i = 0; i < 50; i++) {
            Model model = new Model("Sai Krishna", "Bangalore", i + 1);
            dataList.add(model);
        }
    }

    @Override
    public void onClick(Model model, int position) {
        mEditCardView.setVisibility(View.VISIBLE);
        mEtName.setText(model.getName());
        mEtAge.setText(model.getAge() + "");
        mEtAddress.setText(model.getAddress());


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model1 = new Model(mEtName.getText().toString(), mEtAddress.getText().toString(),
                        Integer.parseInt(mEtAge.getText().toString()));
                dataList.set(position, model1);
                adapter.notifyDataSetChanged();
                mEditCardView.setVisibility(View.GONE);
            }
        });
    }
}