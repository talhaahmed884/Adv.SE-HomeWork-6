package com.cpp.homeWork6.iterator;

import com.cpp.homeWork6.chatServer.ChatHistory;
import com.cpp.homeWork6.chatServer.Message;
import com.cpp.homeWork6.chatServer.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class SearchMessagesByUser implements Iterator<Message> {
    private final ArrayList<Message> messagesByUser;
    private int index;

    public SearchMessagesByUser(ChatHistory history, User userToSearchWith) {
        messagesByUser = new ArrayList<>();

        for (Message message : history.getSentMessages()) {
            if (message.getReceiver().getId().equals(userToSearchWith.getId()))
                messagesByUser.add(message);
        }

        for (Message message : history.getReceivedMessages()) {
            if (message.getSender().getId().equals(userToSearchWith.getId()))
                messagesByUser.add(message);
        }

        messagesByUser.sort(Comparator.comparing(Message::getTimeStamp));
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return messagesByUser.size() > index;
    }

    @Override
    public Message next() {
        return messagesByUser.get(index++);
    }
}
