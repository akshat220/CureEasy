package com.example.cureeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AuthActivity extends AppCompatActivity {

    Button doctor, patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //h
        setContentView(R.layout.activity_auth);
    }

    public void doc(View v) {
        startActivity(new Intent(this, DoctorHome.class));
    }

    public void pat(View v) {
        startActivity(new Intent(this, PatientHome.class));
    }
}
