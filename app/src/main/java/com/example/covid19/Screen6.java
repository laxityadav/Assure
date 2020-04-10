package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Screen6 extends AppCompatActivity {

    private Button btnNext6;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10, rb11, rb12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        initViews();

        btnNext6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1() && check2() && check3() && check4()) {
                    Utils utils = getIntent().getExtras().getParcelable("util");
                    Intent intent = new Intent(Screen6.this, Screen7.class);
                    intent.putExtra("util", utils);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Screen6.this, "please select all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        btnNext6 = findViewById(R.id.btnNext6);

        radioGroup1 = findViewById(R.id.rg61);
        radioGroup2 = findViewById(R.id.rg62);
        radioGroup3 = findViewById(R.id.rg63);
        radioGroup4 = findViewById(R.id.rg64);

        rb1 = findViewById(R.id.rb6_1);
        rb2 = findViewById(R.id.rb6_2);
        rb3 = findViewById(R.id.rb6_3);
        rb4 = findViewById(R.id.rb6_4);
        rb5 = findViewById(R.id.rb6_5);
        rb6 = findViewById(R.id.rb6_6);
        rb7 = findViewById(R.id.rb6_7);
        rb8 = findViewById(R.id.rb6_8);
        rb9 = findViewById(R.id.rb6_9);
        rb10 = findViewById(R.id.rb6_10);
        rb11 = findViewById(R.id.rb6_11);
        rb12 = findViewById(R.id.rb6_12);
    }

    private boolean check1() {
        if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
            return true;
        }
        else
            return false;
    }

    private boolean check2() {
        if(rb4.isChecked() || rb5.isChecked() || rb6.isChecked()) {
            return true;
        }
        else
            return false;
    }

    private boolean check3() {
        if(rb7.isChecked() || rb8.isChecked() || rb9.isChecked()) {
            return true;
        }
        else
            return false;
    }

    private boolean check4() {
        if(rb10.isChecked() || rb11.isChecked() || rb12.isChecked()) {
            return true;
        }
        else
            return false;
    }
}
