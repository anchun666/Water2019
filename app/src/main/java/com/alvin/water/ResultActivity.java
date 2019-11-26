package com.alvin.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.internal.NavigationMenu;

import java.util.jar.Attributes;

public class ResultActivity extends AppCompatActivity {


    private static final double DEFAULTVALUE = 0;
    private TextView feeText;
    private static final String TAG = ResultActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        double fee = getIntent().getDoubleExtra(getString(R.string.extra_fee), DEFAULTVALUE);
        Log.d(TAG, fee + " ");
        feeText = findViewById(R.id.fee);
        int n = (int) (fee + 0.5d);
        feeText.setText(n + " ");


    }
}
