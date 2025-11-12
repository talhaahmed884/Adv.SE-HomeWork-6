package com.cpp.homeWork6.chatServer;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {
    private final HashMap<String, ChatHistory> messages;
    private final HashMap<String, Message.MessageMemento> stateHistory;
    private final HashMap<String, ArrayList<String>> blockedList;

    public ChatServer() {
        messages = new HashMap<>();
        stateHistory = new HashMap<>();
        blockedList = new HashMap<>();
    }

    public void registerUser(String userID) {
        messages.put(userID, new ChatHistory());
        blockedList.put(userID, new ArrayList<>());
    }

    public void unregisterUser(String userID) {
        messages.remove(userID);
        stateHistory.remove(userID);
        blockedList.remove(userID);
    }

    public void sendMessage(Message message) {
        if (!messages.containsKey(message.getSender().getId())) {
            System.out.println("Sender is not registered with the Chat server.");
            return;
        }

        if (!messages.containsKey(message.getReceiver().getId())) {
            System.out.println("Receiver is not registered with the Chat server.");
            return;
        }

        if (blockedList.get(message.getReceiver().getId()).contains(message.getSender().getId())) {
            messages.get(message.getSender().getId()).addSentMessage(message);
            stateHistory.put(message.getSender().getId(), message.createMemento());
            return;
        }

        messages.get(message.getSender().getId()).addSentMessage(message);
        messages.get(message.getReceiver().getId()).addReceiveMessage(message);
        stateHistory.put(message.getSender().getId(), message.createMemento());
    }

    public void undoLastMessage(String userID) {
        Message.MessageMemento lastMessageMemento = stateHistory.get(userID);

        messages.get(userID).getSentMessages().removeLast();

        int index = 0;
        boolean foundMessage = false;
        for (Message message : messages.get(lastMessageMemento.getReceiverID()).getReceivedMessages()) {
            if (message.getMessageID().equals(lastMessageMemento.getMessageID())) {
                foundMessage = true;
                break;
            }
            index++;
        }

        if (foundMessage) {
            messages.get(lastMessageMemento.getReceiverID()).getReceivedMessages().remove(index);
        }

        if (messages.get(userID).getSentMessages().isEmpty()) {
            stateHistory.put(userID, null);
        } else {
            stateHistory.put(userID, messages.get(userID).getSentMessages().getLast().createMemento());
        }
    }

    public void viewInbox(String userID) {
        if (messages.get(userID) == null) {
            System.out.println("No messages for user: " + userID);
            return;
        }
        System.out.println(messages.get(userID).getReceivedMessages());
    }

    public void viewSentMessages(String userID) {
        if (messages.get(userID) == null) {
            System.out.println("No messages for user: " + userID);
            return;
        }
        System.out.println(messages.get(userID).getSentMessages());
    }

    public void blockUser(String userID, String targetUserID) {
        blockedList.get(userID).add(targetUserID);
    }

    public void unblockUser(String userID, String targetUserID) {
        blockedList.get(userID).remove(targetUserID);
    }
}
