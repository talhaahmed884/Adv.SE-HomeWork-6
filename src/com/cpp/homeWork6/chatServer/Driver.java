package com.cpp.homeWork6.chatServer;

public class Driver {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("Mike Tom", chatServer);
        User user2 = new User("Van Hop", chatServer);
        User user3 = new User("Luke Banner", chatServer);

        chatServer.registerUser(user1.getId());
        chatServer.registerUser(user2.getId());
        chatServer.registerUser(user3.getId());

        user1.sendMessage("Hello Dear!!", user2);
        user2.receiveMessages();
        System.out.println();

        user2.sendMessage("Hi, I am good. How are you??", user1);
        user1.receiveMessages();
        System.out.println();

        user1.sendMessage("Hey, are you free??", user3);
        user3.receiveMessages();
        System.out.println();

        user1.viewSentMessages();
        System.out.println();

        user3.blockUser(user1.getId());

        user1.sendMessage("Hey, please respond when you have time!!", user3);
        user3.receiveMessages();
        System.out.println();

        user1.sendMessage("No response :((", user3);
        user3.receiveMessages();
        System.out.println();

        user1.viewSentMessages();
        System.out.println();

        user1.undoLastMessage();
        System.out.println();

        user1.viewSentMessages();
        System.out.println();

        user1.undoLastMessage();
        user1.undoLastMessage();
        user1.undoLastMessage();

        user1.viewSentMessages();
        System.out.println();

        user2.receiveMessages();
        System.out.println();

        user3.receiveMessages();
        System.out.println();

        user1.receiveMessages();
        System.out.println();

        user3.unblockUser(user1.getId());
        user1.sendMessage("Hey, please respond when you have time!!", user3);
        user3.receiveMessages();
        System.out.println();

        user3.sendMessage("I am good. I had blocked you before :))", user1);
        user1.receiveMessages();
        System.out.println();
    }
}