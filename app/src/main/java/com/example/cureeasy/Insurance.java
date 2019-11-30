package com.example.cureeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
// Insurance Class to display list of insurance

public class Insurance extends AppCompatActivity {
RecyclerView recyclerView;
Toolbar instool;
    private int camera_permission=101;
ArrayList<InsuranceClass> insc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance2);
        instool=findViewById(R.id.ins_tool);
        instool.setTitle("Select Your Policy");
        instool.setTitleTextColor(Color.parseColor("#FFFFFF"));

        recyclerView=findViewById(R.id.insrec);
        insc=new ArrayList<>();
        insc.add(new InsuranceClass("AEGON Life Insurance Company","OK Plus DP Metro, 4th Floor, Plot No. 5-6, DP Colony, Nr Vivek Vihar Metro Station, Jaipur, Rajasthan 302019","1800-209-9090","aegonlife@gmail.com",R.drawable.aegon));
        insc.add(new InsuranceClass("Bajaj Allianz Life Insurance","tower p.no d, Office no -601A,6th floor,Ambition, 46B, Subhash Marg, C Scheme, Jaipur, Rajasthan 302001","1800 103 7272","bajajalianz@gmail.com",R.drawable.bajaj));
        insc.add(new InsuranceClass("Life Insurance Corporation","Life Insurance Corporation Jaipur, Rajasthan 302001","022 6827 6827","lic@gmail.com",R.drawable.lic));
        insc.add(new InsuranceClass("Max Bupa","Max Bupa Health Insurance Company Limited,\n" +
                "Unit No 601D, 6th Floor,\n" +
                "KJ City Tower, Ashok Marg,\n" +
                "Jaipur - 300201,\n" +
                "Phone: 0141-4627600","011 4609 6100","maxbupa@gmail.com",R.drawable.max));
        insc.add(new InsuranceClass("Bharti AXA General Insurance","Royal World, Flat No.508 to 510, 5th Floor, Sansar Chandra Road, Jalupura, Jaipur, Rajasthan 302001","1800-102-4444","bhartilife@gmail.com",R.drawable.bharti));
InsuranceAdapter adapter=new InsuranceAdapter(this,insc,Insurance.this);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==camera_permission&&grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            SharedPreferences preferences=getSharedPreferences("prev",MODE_PRIVATE);
            int no=preferences.getInt("no",0) ;
            String number = insc.get(no).phone;
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
        else
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    camera_permission);
        }
    }
}

class InsuranceClass
{
    String name;
    int image;
    String address;
    String phone;
    String email;

    public InsuranceClass(String n,String a,String p,String e,int i)
    {
        name=n;
        address=a;
        phone=p;
        email=e;
        image=i;
    }
}