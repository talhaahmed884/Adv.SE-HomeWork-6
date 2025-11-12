package com.cpp.homeWork6.chatServer;

import com.cpp.homeWork6.iterator.IterableByUser;
import com.cpp.homeWork6.iterator.SearchMessagesByUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ChatHistory implements IterableByUser {
    private final ArrayList<Message> sentMessages;
    private final ArrayList<Message> receivedMessages;

    public ChatHistory() {
        this.sentMessages = new ArrayList<>();
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

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        if (userToSearchWith == null) {
            return Collections.emptyIterator();
        }
        return new SearchMessagesByUser(this, userToSearchWith);
    }
}
