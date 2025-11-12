package com.cpp.homeWork6.chatServer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCases {
    @Test
    public void TestChatServerSimpleConversation() {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("User-1", chatServer);
        User user2 = new User("User-2", chatServer);
        User user3 = new User("User-3", chatServer);

        Assertions.assertNull(chatServer.getChatHistory(user1.getId()));
        Assertions.assertNull(chatServer.getChatHistory(user1.getId()));

        chatServer.registerUser(user1.getId());
        chatServer.registerUser(user2.getId());
        chatServer.registerUser(user3.getId());

        user1.sendMessage("Hello Dear!!", user2);
        user2.sendMessage("Hi, I am good. How are you??", user1);

        Assertions.assertEquals("Hello Dear!!", chatServer.getChatHistory(user1.getId()).getSentMessages().getFirst().getMessage());
        Assertions.assertEquals("Hi, I am good. How are you??", chatServer.getChatHistory(user2.getId()).getSentMessages().getFirst().getMessage());
    }

    @Test
    public void TestChatServerBlockUser() {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("User-1", chatServer);
        User user2 = new User("User-2", chatServer);

        chatServer.registerUser(user1.getId());
        chatServer.registerUser(user2.getId());

        user2.blockUser(user1.getId());

        user1.sendMessage("Hello Dear!!", user2);
        user2.sendMessage("Hi, I am good. How are you??", user1);

        Assertions.assertEquals(0, chatServer.getChatHistory(user2.getId()).getReceivedMessages().size());
        Assertions.assertEquals(1, chatServer.getChatHistory(user1.getId()).getReceivedMessages().size());
        Assertions.assertEquals(1, chatServer.getChatHistory(user1.getId()).getSentMessages().size());
    }
}
