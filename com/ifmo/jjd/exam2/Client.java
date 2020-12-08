package com.ifmo.jjd.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {

    private String accountName = "default";
    private final String IP = "127.0.0.1";
    private final int PORT = 8090;
    private Connection connection;

    private Client() {

    }

    public static void main(String[] args) {
        new Client().start();
    }

    private void start() {
        Service.println("Client started");
        setAccountName();
        try (Connection connection = new Connection(new Socket(IP, PORT))) {
            this.connection = connection;
            Thread receiveThread = new Thread(new ReceiveMessageFromServer());
            receiveThread.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter a message or type EXIT to quit: ");
                String text = "";
                try {
                    text = input.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (connection) {
                    try {
                        if ("exit".equalsIgnoreCase(text)) {
                            Client.this.connection.sendMessage(new Message(accountName, false));
                            receiveThread.interrupt();
                            break;
                        } else Client.this.connection.sendMessage(new Message(accountName, text));
                        System.out.println("Message sent");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAccountName() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter account name: ");
        try {
            accountName = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReceiveMessageFromServer implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            while (true) {
                try {
                    System.out.println(Client.this.connection.readMessage());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
