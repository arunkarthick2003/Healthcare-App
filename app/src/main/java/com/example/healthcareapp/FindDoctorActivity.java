package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView back=findViewById(R.id.cardFDBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });
        CardView familyPhysician=findViewById(R.id.cardFDFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                //with the help of intent we set the family physician as title for the next page
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }
        });
        CardView dietician=findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                //with the help of intent we set the family physician as title for the next page
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });
        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                //with the help of intent we set the family physician as title for the next page
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                //with the help of intent we set the family physician as title for the next page
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });
        CardView cardiologist=findViewById(R.id.cardFDCardiologist);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                //with the help of intent we set the family physician as title for the next page
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });
    }
}