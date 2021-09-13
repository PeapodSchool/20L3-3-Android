package com.peapod.crowcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView crowsText;
    int crowsNum;
    private static final String KEY_COUNT = "crowsNum";
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crowsText = findViewById(R.id.crowsTextView);
        settings = getSharedPreferences(KEY_COUNT, Context.MODE_PRIVATE);
        if (savedInstanceState != null) {
            crowsNum = savedInstanceState.getInt(KEY_COUNT, 0);
            crowsText.setText("Насчтано " + crowsNum + " ворон");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(KEY_COUNT, crowsNum);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (settings.contains(KEY_COUNT)) {
            crowsNum = settings.getInt(KEY_COUNT, 0);
            crowsText.setText("Насчтано " + crowsNum + " ворон");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, crowsNum);
    }

    public void countCrows(View view) {
        crowsNum++;
        crowsText.setText("Насчтано " + crowsNum + " ворон");
    }
}