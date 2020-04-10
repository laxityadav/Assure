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

public class Screen2 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton rb1, rb2;
    private Button btnNext2;
    private EditText edtFeverDays;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        initViews();
        utils = getIntent().getExtras().getParcelable("util");
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feverDays = "";
                feverDays = edtFeverDays.getText().toString().trim();
                int days=0;

                if(rb1.isChecked() || rb2.isChecked()) {
                    if(rb1.isChecked()) {
                        if(!feverDays.equals("")) {
                            try {
                                days = Integer.parseInt(feverDays);
                                int id = radioGroup.getCheckedRadioButtonId();
                                RadioButton radio = findViewById(id);
                                if(radio.getText().equals("Yes")) {
                                    utils.setFever(true);
                                    utils.setFeverDays(days);
                                }

                                Intent intent = new Intent(Screen2.this, Screen3.class);
                                intent.putExtra("util", utils);
                                startActivity(intent);
                            }catch (NumberFormatException e){
                                Toast.makeText(Screen2.this, "please enter a number", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(Screen2.this, "please fill no. of days", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(Screen2.this, Screen3.class);
                        intent.putExtra("util", utils);
                        startActivity(intent);
                    }
                }
                else
                    Toast.makeText(Screen2.this, "please select a field", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initViews() {
        radioGroup = findViewById(R.id.rg);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        btnNext2 = findViewById(R.id.btnNext2);
        edtFeverDays = findViewById(R.id.edtFeverDays);
    }
}
