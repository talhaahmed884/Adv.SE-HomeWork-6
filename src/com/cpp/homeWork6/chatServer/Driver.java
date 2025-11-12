package com.cpp.homeWork6.chatServer;

import java.util.Iterator;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("User-1", chatServer);
        User user2 = new User("User-2", chatServer);
        User user3 = new User("User-3", chatServer);

        chatServer.registerUser(user1.getId());
        chatServer.registerUser(user2.getId());
        chatServer.registerUser(user3.getId());

        user1.sendMessage("Hello Dear!!", user2);
        user2.receiveMessages();
        System.out.println();

        user2.sendMessage("Hi, I am good. How are you??", user1);
        user1.receiveMessages();
        System.out.println();

        user2.sendMessage("Hi user3, I am user2", user3);
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

        user1.sendMessage("Hello once again!!", user2);
        Thread.sleep(100);
        user2.sendMessage("HI", user1);
        Thread.sleep(100);
        user1.sendMessage("Done with SE work??", user2);
        Thread.sleep(100);
        user2.sendMessage("Almost done!!", user1);
        Thread.sleep(100);
        user2.sendMessage("How about you??", user1);
        Thread.sleep(100);
        user1.sendMessage("Me too", user2);
        Thread.sleep(100);
        user2.sendMessage("I hope we both receive full points", user1);
        Thread.sleep(100);
        user1.sendMessage("Very hopeful", user2);

        System.out.println("Displaying communication between User 1 and User 2");
        Iterator<Message> userIterator = user1.iterator(user2);
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next());
            System.out.println();
        }
    }
}