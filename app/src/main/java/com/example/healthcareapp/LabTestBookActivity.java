package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
    Button btnBook;
    EditText edName,edAddress,edPin,edContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edName=findViewById(R.id.editTextBookName);
        edAddress=findViewById(R.id.editTextBookAddress);
        edPin=findViewById(R.id.editTextBookPin);
        edContact=findViewById(R.id.editTextBookContact);
        btnBook=findViewById(R.id.buttonBookApp);

        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();

                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edName.getText().toString(),edAddress.getText().toString(),edContact.getText().toString(),Integer.parseInt(edPin.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");
                db.removeCart(username,"lab");
                Toast.makeText(getApplicationContext(), "Your Booking is done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });
    }
}