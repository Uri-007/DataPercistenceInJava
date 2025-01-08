package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("-------------");
            System.out.println("App messages");
            System.out.println("1. Create message");
            System.out.println("2. List messages");
            System.out.println("3. Edit message");
            System.out.println("4. Delete message");
            System.out.println("5. Logout");

            //Read user option
            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessagesService.createMessage();
                    break;
                case 2:
                    MessagesService.listMessages();
                    break;
                case 3:
                    MessagesService.updateMessage();
                    break;
                case 4:
                    MessagesService.deleteMessage();
                    break;
                default:
                    break;
            }

        } while (option != 5);

    }
}