package com.cpp.homeWork6.chatServer;

import java.util.Date;
import java.util.UUID;

public class Message {
    private final String message;
    private final User sender;
    private final User receiver;
    private final Date timeStamp;
    private final String messageID;

    public Message(String message, User sender, User receiver) {
        this.messageID = UUID.randomUUID().toString();
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.timeStamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessageID() {
        return messageID;
    }

    @Override
    public String toString() {
        return "Message Details:\nSender name: " + this.sender.getName() + " and ID: " + this.sender.getId() + "\nMessage: " +
                this.message + "\nTimeStamp: " + this.timeStamp + "\nReceiver name: " + this.receiver.getName() + " and ID: " +
                this.receiver.getId();
    }

    public MessageMemento createMemento() {
        return new MessageMemento(this.messageID, this.message, this.sender.getId(), this.receiver.getId(), this.timeStamp);
    }

    public static class MessageMemento {
        private final String messageID;
        private final String message;
        private final String senderID;
        private final String receiverID;
        private final Date timeStamp;

        public MessageMemento(String messageID, String message, String senderID, String receiverID, Date timeStamp) {
            this.messageID = messageID;
            this.message = message;
            this.senderID = senderID;
            this.receiverID = receiverID;
            this.timeStamp = timeStamp;
        }

        public MessageMemento getState() {
            return this;
        }

        public String getMessageID() {
            return messageID;
        }

        public String getReceiverID() {
            return receiverID;
        }
    }
}
