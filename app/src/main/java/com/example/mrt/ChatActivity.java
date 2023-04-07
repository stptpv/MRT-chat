package com.example.mrt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ChatAdapter mAdapter;
    private ChatDataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        RecyclerView recyclerView = findViewById(R.id.chatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ChatAdapter((List<ChatMessage>) mDataManager);
        recyclerView.setAdapter(mAdapter);

        mDataManager = new ChatDataManager(mAdapter);
        mDataManager.loadInitialMessages();

        EditText messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(view -> {
            String message = messageEditText.getText().toString().trim();
            if (!message.isEmpty()) {
                mDataManager.addMessage("User", message);
                messageEditText.setText("");
            }
        });
    }
}
