package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen8 extends AppCompatActivity {

    private Button btnNext8;
    private TextView txtName81, txtName82;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen8);

        btnNext8 = findViewById(R.id.btnNext8);
        txtName81 = findViewById(R.id.txtName81);
        txtName82 = findViewById(R.id.txtName82);

        Utils utils = getIntent().getExtras().getParcelable("util");
        if(utils.isCorona()) {
            txtName81.setVisibility(View.GONE);
            txtName82.setVisibility(View.VISIBLE);
        }
        else {
            txtName81.setVisibility(View.VISIBLE);
            txtName82.setVisibility(View.GONE);
        }

        btnNext8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screen8.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Screen8.this, MainActivity.class);
        startActivity(intent);
    }
}
