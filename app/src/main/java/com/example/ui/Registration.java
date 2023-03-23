package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText edUsername, edPassword,edEmail,edConfirm;
    ImageView btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edUsername = findViewById(R.id.editTextRegName);
        edEmail = findViewById(R.id.editTextRegEmail);
        edConfirm = findViewById(R.id.editTextConfRegPassword);
        edPassword = findViewById(R.id.editTextRegPassword);
        btn = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView3);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this,MainActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"SAYFR",null,1);


                if(username.length()==0 || password.length()==0 || email.length()==0 || confirm.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all details", Toast.LENGTH_SHORT ).show();
                }else {
                    if (password.compareTo(confirm) == 0) {
                        //if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext() ,"Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent (Registration.this, MainActivity.class));

                        //}else {

                        //Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letters, digits and special symbol", Toast.LENGTH_SHORT).show();}

                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
            }

    public static boolean isValid(String passwordhere){
        int f1=0,f2=0;
        if (passwordhere.length() < 8){
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f2 = 1;
                }
            }

            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            /*for (int s= 0 ; s<passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if(c>=33&&c<=46 || c==64){
                    f3=1;
                }
            }*/
            if (f1 == 1 && f2 == 1)
                return true;
            return false;
        }
        }
    }