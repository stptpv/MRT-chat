package com.example.mrt;

public class ChatMessage {
    private String mName;
    private String mMessage;
    private String mTimestamp;

    public ChatMessage(String name, String message, String timestamp) {
        mName = name;
        mMessage = message;
        mTimestamp = timestamp;
    }

    public String getName() {
        return mName;
    }

    public String getMessage() {
        return mMessage;
    }

    public String getTimestamp() {
        return mTimestamp;
    }
}

