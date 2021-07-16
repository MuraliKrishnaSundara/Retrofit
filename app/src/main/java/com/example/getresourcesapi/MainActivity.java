package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserId;
    private Button mBtnCallApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, APICallActivity.class);
                intent.putExtra("userId", mEtUserId.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        mEtUserId = findViewById(R.id.etUserId);
        mBtnCallApi = findViewById(R.id.btnCallApi);
    }
}