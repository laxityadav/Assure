package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Screen4 extends AppCompatActivity {

    private Button btnNext4;
    private RadioGroup radioGroup1;
    private RadioButton rb1, rb2;
    private EditText edtCough, edtCoughDays;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        initViews();
        utils = getIntent().getExtras().getParcelable("util");

        btnNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1()) {
                    Intent intent = new Intent(Screen4.this, Screen5.class);
                    intent.putExtra("util", utils);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Screen4.this, "please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean check1() {
        String cough = "";
        String coughDays = "";
        int coughCount=0;
        cough = edtCough.getText().toString().trim();
        coughDays = edtCoughDays.getText().toString().trim();
        if(rb1.isChecked() || rb2.isChecked()) {
            if(rb1.isChecked()) {
                if(!cough.equals("") && !coughDays.equals("")) {
                    try {
                        coughCount = Integer.parseInt(coughDays);
                        utils.setCoughDays(coughCount);
                        utils.setCough(true);
                        utils.setTypeCough(cough.toLowerCase());
                        return true;
                    }catch (NumberFormatException e){
                        return false;
                    }
                }
                else
                    return false;
            }
            else {
                return true;
            }
        }
        else
            return false;
    }

    private void initViews() {
        btnNext4 = findViewById(R.id.btnNext4);

        radioGroup1 = findViewById(R.id.rg41);
        rb1 = findViewById(R.id.rb4_1);
        rb2 = findViewById(R.id.rb4_2);

        edtCough = findViewById(R.id.edtCough);
        edtCoughDays = findViewById(R.id.edtCoughDays);
    }
}
