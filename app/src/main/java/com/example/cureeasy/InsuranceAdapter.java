package com.example.cureeasy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// insurance adpater
public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceHolder> {
Context c;
Activity a;
ArrayList<InsuranceClass> insurance;
    public InsuranceAdapter(Context context,ArrayList<InsuranceClass>i,Activity ac) {
        super();
        c=context;
        insurance=i;
        a=ac;

    }

    @NonNull
    @Override
    public InsuranceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.activity_insurance,parent,false);
        return new InsuranceHolder(v, insurance,c,a);
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceHolder holder, int position) {
    holder.imgview.setImageResource(insurance.get(position).image);
    holder.txtloc.setText(insurance.get(position).address);
    holder.txtcomp.setText(insurance.get(position).name);

    }

    @Override
    public int getItemCount() {
        return insurance.size();
    }
}
