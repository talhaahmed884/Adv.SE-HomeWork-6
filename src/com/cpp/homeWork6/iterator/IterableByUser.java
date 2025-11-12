package com.cpp.homeWork6.iterator;

import com.cpp.homeWork6.chatServer.Message;
import com.cpp.homeWork6.chatServer.User;

import java.util.Iterator;

public interface IterableByUser {
    Iterator<Message> iterator(User userToSearchWith);
}

