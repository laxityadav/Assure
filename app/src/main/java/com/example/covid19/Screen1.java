package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Screen1 extends AppCompatActivity {

    private EditText edtName, edtAddress, edtPhone, edtEmail;
    private Button btnNext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        initViews();

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "", phone = "", email = "", address = "";
                name = edtName.getText().toString().trim();
                phone = edtPhone.getText().toString().trim();
                email = edtEmail.getText().toString().trim();
                address = edtAddress.getText().toString().trim();

                if(name.equals("") || phone.equals("") || email.equals("") || address.equals("")) {
                    Toast.makeText(Screen1.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(checkEmail(email) && checkPhone(phone)) {
                        Utils utils = getIntent().getExtras().getParcelable("util");
                        utils.setName(name);
                        utils.setPhoneNo(phone);
                        utils.setAddress(address);
                        utils.setEmailId(email);

                        Intent intent = new Intent(Screen1.this, Screen2.class);
                        intent.putExtra("util", utils);
                        startActivity(intent);
                    }
                    else if(!checkEmail(email))
                        Toast.makeText(Screen1.this, "please enter valid email id", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Screen1.this, "please enter valid phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean checkPhone(String phone) {
        if(phone.length() != 10) {
            return false;
        }
        else {
            for(int i=0;i<10;i++) {
                char ch = phone.charAt(i);
                if(ch >= '0' && ch <= '9'){

                }
                else
                    return false;
            }
            return true;
        }
    }

    private boolean checkEmail(String email) {
        String gmail = "@gmail.com", yahoo = "@yahoo.com";
        int i=0;
        for(i=0;i<email.length();i++) {
            if(email.charAt(i) == '@')
                break;
        }
        if(i<email.length() && email.charAt(i) == '@') {
            String temp = email.substring(i, email.length());
            if(temp.equals(gmail) || temp.equals(yahoo))
                return true;
            else
                return false;
        }
         return false;
    }

    private void initViews() {
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);

        btnNext1 = findViewById(R.id.btnNext1);
    }
}












