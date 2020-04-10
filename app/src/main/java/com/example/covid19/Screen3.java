package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Screen3 extends AppCompatActivity {

    private Button btnNext3;
    private EditText edtTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        btnNext3 = findViewById(R.id.btnNext3);
        edtTemperature = findViewById(R.id.edtTemperature);

        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = "";
                temp = edtTemperature.getText().toString().trim();
                int tempCount=0;
                if(!temp.equals("")) {
                    try {
                        tempCount = Integer.parseInt(temp);
                        Utils utils = getIntent().getExtras().getParcelable("util");
                        utils.setTemperature(tempCount);

                        Intent intent = new Intent(Screen3.this, Screen4.class);
                        intent.putExtra("util", utils);
                        startActivity(intent);
                    }catch (NumberFormatException e){
                        Toast.makeText(Screen3.this, "please enter a number", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Screen3.this, "please fill the field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
