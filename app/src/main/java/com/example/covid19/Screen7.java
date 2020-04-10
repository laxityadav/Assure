package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen7 extends AppCompatActivity {

    private Button btnNext7;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);

        btnNext7 = findViewById(R.id.btnNext7);
        utils = getIntent().getExtras().getParcelable("util");

        btnNext7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result();
                Intent intent = new Intent(Screen7.this, Screen8.class);
                intent.putExtra("util", utils);
                startActivity(intent);
            }
        });
    }

    private void result() {
        if(utils.isFever() && utils.isCough() && utils.isShortBreath()) {
            if(utils.getTemperature() > 101 && utils.getFeverDays() > 3) {
                if(utils.getCoughDays() > 3 && utils.getTypeCough().equals("dry") && utils.getBreathingRate() > 30) {
                    utils.setCorona(true);
                }
                else
                    utils.setCorona(false);
            }
            else
                utils.setCorona(false);
        }
        else {
            utils.setCorona(false);
        }
    }
}
