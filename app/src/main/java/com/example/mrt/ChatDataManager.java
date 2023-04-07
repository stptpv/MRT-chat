package com.example.mrt;

import android.icu.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatDataManager {
    private List<ChatMessage> mMessages;
    private ChatAdapter mAdapter;

    public ChatDataManager(ChatAdapter adapter) {
        mMessages = new ArrayList<>();
        mAdapter = adapter;
    }

    public void loadInitialMessages() {
        // загрузка начальных сообщений из локальной базы данных или сервера
        // и добавление их в список mMessages
        // затем вызов метода mAdapter.notifyDataSetChanged() для обновления RecyclerView
    }

    public void addMessage(String name, String message) {
        ChatMessage newMessage = new ChatMessage(name, message, getTimestamp());
        mMessages.add(newMessage);
        mAdapter.addMessage(newMessage);
        // сохранение нового сообщения в локальной базе данных или отправка на сервер
    }

    private String getTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}

