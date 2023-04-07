package com.example.mrt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private final List<ChatMessage> mMessages;

    public ChatAdapter(List<ChatMessage> messages) {
        mMessages = messages != null ? messages : new ArrayList<>();
    }


    public void addMessage(ChatMessage message) {
        mMessages.add(message);
        notifyItemInserted(mMessages.size() - 1);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChatMessage message = mMessages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNameTextView;
        private final TextView mMessageTextView;
        private final TextView mTimestampTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.text_email);
            mMessageTextView = itemView.findViewById(R.id.message_user);
            mTimestampTextView = itemView.findViewById(R.id.message_time);
        }

        public void bind(ChatMessage message) {
            mNameTextView.setText(message.getName());
            mMessageTextView.setText(message.getMessage());
            mTimestampTextView.setText(message.getTimestamp());
        }
    }
}

