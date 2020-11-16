package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Properties properties = null;
        properties = Connection.getPropertiesForConnection();
        try {
            new Client(properties.getProperty("ip"), Integer.valueOf(properties.getProperty("port"))).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String ip;
    private int port;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        String name = scanner.nextLine();
        String message;
        while (true) {
            System.out.println("Введите сообщение");
            message = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            if (fromServer.getText().startsWith("/")) {
                System.out.println(fromServer.getText().substring(1));
            } else {
                System.out.println("от сервера: " + fromServer);
            }
        }
    }
}
