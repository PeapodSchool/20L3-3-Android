package com.peapod.crowcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView crowsText;
    int crowsNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crowsText = findViewById(R.id.crowsTextView);
    }

    public void countCrows(View view) {
        crowsNum++;
        crowsText.setText("Насчтано " + crowsNum + " ворон");
    }
}