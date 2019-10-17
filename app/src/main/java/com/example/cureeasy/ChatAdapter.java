package com.example.cureeasy;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder>
{
    Context context;

    public ChatAdapter(Context c) {
        super();
        context=c;

    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.chat_msg_layout,parent,false);
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ChatHolder extends RecyclerView.ViewHolder
{
    TextView sender,reciever;
    ImageView profile;
    public ChatHolder(@NonNull View itemView) {
        super(itemView);
        sender=itemView.findViewById(R.id.chat_sender);
        reciever=itemView.findViewById(R.id.chat_sender);
        profile=itemView.findViewById(R.id.chat_profile_img);

    }
}
}
