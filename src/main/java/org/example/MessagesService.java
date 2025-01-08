package org.example;

import java.util.Scanner;

public class MessagesService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String message = sc.nextLine();

        System.out.println("Your name");
        String name = sc.nextLine();

        Messages register = new Messages();
        register.setMessage(message);
        register.setAuthor_message(name);
        MessagesDAO.createDbMessage(register);
    }

    public static void listMessages() {
        MessagesDAO.readMessages();
    }

    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indicates the id of the message to delete");
        int id_message = sc.nextInt();
        MessagesDAO.deleteMessagesDb(id_message);
    }

    public static void updateMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your new message");
        String message = sc.nextLine();

        System.out.println("Indicates the id of the message to edit");
        int id_message = sc.nextInt();

        Messages update = new Messages();
        update.setId_message(id_message);
        update.setMessage(message);
        MessagesDAO.updateMessage(update);

    }

}
