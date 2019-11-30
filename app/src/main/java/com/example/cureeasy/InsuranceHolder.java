package com.example.cureeasy;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


// insurance holder

public class InsuranceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
TextView txtcomp,txtloc;
ImageView imgview,call;
Context c;
    private int camera_permission=101;
    Activity a;
Button buttonapply;
ArrayList<InsuranceClass> ins;
    public InsuranceHolder(@NonNull View itemView, ArrayList<InsuranceClass> i,Context cn,Activity ac) {
        super(itemView);
        ins=i;
        c=cn;
        a=ac;
        txtcomp=itemView.findViewById(R.id.txtcompany);
        txtloc=itemView.findViewById(R.id.txtlocation);
        imgview=itemView.findViewById(R.id.imageView);
        call=itemView.findViewById(R.id.call);
        buttonapply=itemView.findViewById(R.id.btnapply);
        buttonapply.setOnClickListener(this);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.call) {
            if (ContextCompat.checkSelfPermission(c, Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                String number = ins.get(getAdapterPosition()).phone;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                c.startActivity(intent);

            }
            else
            {   SharedPreferences pref=c.getSharedPreferences("prev",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putInt("no",getAdapterPosition());
                askPermission();
            }



        }
        else
        {
            SharedPreferences pref=c.getSharedPreferences("prev",Context.MODE_PRIVATE);
            String uname=pref.getString("username",null);
            String email=pref.getString("email",null);
            String uid=pref.getString("userid",null);
            String link="https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="+uid;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ins.get(getAdapterPosition()).email});
            intent.putExtra(Intent.EXTRA_SUBJECT, "REGARDING INSURANCE CLAIM");
            intent.putExtra(Intent.EXTRA_TEXT, "NAME : "+uname+"\n"+"EMAIL : "+email+"\n\n\n"+"ATTACHED LINK CONTAIN MY QR CODE\n\n\n\n"+link+"\n\n\n"+
                    "KINDLY VERIFY MY PRESCRIPTIONS AND POLICY NO...");

            c.startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }
    public void askPermission()
    {
        if (ContextCompat.checkSelfPermission(c, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(a,
                    new String[]{Manifest.permission.CALL_PHONE},
                    camera_permission);


        }
    }

}
