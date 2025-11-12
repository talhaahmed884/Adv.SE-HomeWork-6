package com.cpp.homeWork6.chatServer;

import java.util.UUID;

public class User {
    private final String name;
    private final String id;
    private final ChatServer chatServer;

    public User(String name, ChatServer chatServer) {
        this.name = name;
        id = UUID.randomUUID().toString();
        this.chatServer = chatServer;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User Details:\nName: " + name + ", id: " + id;
    }

    public void sendMessage(String message, User receiver) {
        chatServer.sendMessage(new Message(message, this, receiver));
    }

    public void receiveMessages() {
        System.out.println("Inbox for User: " + name + " and ID: " + id);
        chatServer.viewInbox(this.id);
    }

    public void undoLastMessage() {
        chatServer.undoLastMessage(this.id);
    }

    public void viewSentMessages() {
        System.out.println("Sent history for User: " + name + " and ID: " + id);
        chatServer.viewSentMessages(this.id);
    }

    public void blockUser(String userID) {
        chatServer.blockUser(id, userID);
    }

    public void unblockUser(String userID) {
        chatServer.unblockUser(id, userID);
    }
}
