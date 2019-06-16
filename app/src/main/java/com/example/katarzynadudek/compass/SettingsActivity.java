package com.example.katarzynadudek.compass;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    SwitchCompat switch_1;
    boolean stateSwitch1;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences=getSharedPreferences("PREFS",0);
        stateSwitch1=preferences.getBoolean("switch1",false);

        switch_1=(SwitchCompat) findViewById(R.id.switch_1);

        switch_1.setChecked(stateSwitch1);

        switch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch1=!stateSwitch1;
                switch_1.setChecked(stateSwitch1);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putBoolean("switch1",stateSwitch1);
                editor.apply();
            }
        });
    }
}
