package com.example.cureeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class DoctorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_doctor);
    }

    public void addActivity(View v){
        startActivity(new Intent(DoctorHome.this, AddPatient.class));
    }

    public void MyPatients(View v){
        startActivity(new Intent(DoctorHome.this, MyPatients.class));
    }
}
