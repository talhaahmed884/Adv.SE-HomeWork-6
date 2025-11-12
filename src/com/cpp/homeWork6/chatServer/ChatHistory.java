package com.cpp.homeWork6.chatServer;

import java.util.ArrayList;

public class ChatHistory {
    private final ArrayList<Message> sentMessages;
    private final ArrayList<Message> receivedMessages;

    public ChatHistory() {
        this.sentMessages = new ArrayList<Message>();
        this.receivedMessages = new ArrayList<>();
    }

    public void addSentMessage(Message message) {
        this.sentMessages.add(message);
    }

    public Message getLastSentMessage() {
        return this.sentMessages.getLast();
    }

    public void addReceiveMessage(Message message) {
        this.receivedMessages.add(message);
    }

    public Message getLastReceiveMessage() {
        return this.receivedMessages.getLast();
    }

    public ArrayList<Message> getSentMessages() {
        return this.sentMessages;
    }

    public ArrayList<Message> getReceivedMessages() {
        return this.receivedMessages;
    }
}
