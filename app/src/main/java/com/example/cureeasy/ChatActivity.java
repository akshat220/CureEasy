package com.example.cureeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class ChatActivity extends AppCompatActivity {
RecyclerView chatrecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatrecycler=findViewById(R.id.chat_recycler_view);
        ChatAdapter adapter=new ChatAdapter(this);
       LinearLayoutManager ll = new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        chatrecycler.setLayoutManager(ll);
       chatrecycler.setAdapter(adapter);
    }
}
