package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Screen5 extends AppCompatActivity {

    private Button btnNext5, btnTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2;
    private TextView txtTimer;
    private EditText edtBreathing;

    private CountDownTimer countDownTimer;
    private static final long COUNTDOWN_IN_MILLIS = 10000;
    private long timeLeft;
    private boolean isOver = false;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);

        btnNext5 = findViewById(R.id.btnNext5);
        btnTimer = findViewById(R.id.btnTimer);
        radioGroup = findViewById(R.id.rg5);
        rb1 = findViewById(R.id.rb51);
        rb2 = findViewById(R.id.rb52);
        txtTimer = findViewById(R.id.txtTimer);
        edtBreathing = findViewById(R.id.edtBreathing);
        utils = getIntent().getExtras().getParcelable("util");

        timeLeft = COUNTDOWN_IN_MILLIS;

        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCountDown();
                btnTimer.setVisibility(View.GONE);
            }
        });

        btnNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1() && isOver) {
                    Intent intent = new Intent(Screen5.this, Screen6.class);
                    intent.putExtra("util", utils);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Screen5.this, "please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean check1() {
        String Rate = edtBreathing.getText().toString().trim();
        int rate=0;
        if((rb1.isChecked() || rb2.isChecked()) && !Rate.equals("")) {
            try {
                rate = Integer.parseInt(Rate);
                if(rb1.isChecked()) {
                    utils.setShortBreath(true);
                }
                utils.setBreathingRate(rate);
                return true;
            }catch (NumberFormatException e){
                return false;
            }
        }
        else
            return false;
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeft = 0;
                isOver = true;
                updateCountDownText();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        txtTimer.setText(timeFormatted);
    }
}
