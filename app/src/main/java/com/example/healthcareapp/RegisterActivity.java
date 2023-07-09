package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edCPassword;
    Button btn;
    TextView textViewLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername=findViewById(R.id.editTextRegisterUsername);
        edEmail=findViewById(R.id.editTextRegisterEmail);
        edPassword=findViewById(R.id.editTextRegisterPassword);
        edCPassword=findViewById(R.id.editTextRegisterCPassword);
        btn=findViewById(R.id.buttonRegister);
        textViewLogin=findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();
                String cpassword=edCPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(uname.length()==0 || email.length()==0 || password.length()==0 || cpassword.length()==0){
                    Toast.makeText(RegisterActivity.this, "Please enter all details!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(cpassword)==0){
                        if(isValid(password)){
                            db.register(uname,email,password);
                            Toast.makeText(RegisterActivity.this, "Record insertion successful!!! Login", Toast.LENGTH_SHORT).show();
                            //redirect to login page
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Password must contain atleast 8 character, with letters and should contain symbol", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password and Confirm password didn't match!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String password){
        int f1=0,f2=0,f3=0;
        if(password.length()<8){
            return false;
        }
        else{
            for(int p=0;p<password.length();p++){
                char c=password.charAt(p);
                if(Character.isLetter(c)){
                    f1=1;
                }
                if(Character.isDigit(c)){
                    f2=1;
                }
                //checks if the password has special characters
                if(c>=33 && c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
        }
        return false;
    }
}