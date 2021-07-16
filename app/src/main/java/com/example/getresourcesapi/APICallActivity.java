package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APICallActivity extends AppCompatActivity {

    private TextView mTvName;
    private TextView mTvYear;
    private TextView mTvPantoneValue;
    private LinearLayout mLlBackground;
    private String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicall);
        Intent intent = getIntent();
        mUserId = intent.getStringExtra("userId");
        initViews();
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvName);
        mTvYear = findViewById(R.id.tvYear);
        mTvPantoneValue = findViewById(R.id.tvPantoneValue);
        mLlBackground = findViewById(R.id.LinearLayout);

        ApiService apiService = Network.getInstance().create(ApiService.class);
        int userId = Integer.parseInt(mUserId);
        apiService.getUser(userId).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model = response.body();
                String name = model.getData().getName();
                String year = model.getData().getYear() + "";
                String pantoneValue = model.getData().getPantoneValue();
                mTvName.setText(name);
                mTvYear.setText(year);
                mTvPantoneValue.setText(pantoneValue);
                mLlBackground.setBackgroundColor(Color.parseColor(model.getData().getColor()));
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}