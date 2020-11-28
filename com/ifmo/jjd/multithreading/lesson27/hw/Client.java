package com.ifmo.jjd.multithreading.lesson27.hw;

import com.ifmo.jjd.lesson20.socketio.SimpleMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;

public class Client {

    private String ip;
    private int port;
    private BufferedReader scanner;

    public static void main(String[] args) {
        Properties connectionProperties = Connection.getConnectionPropertiesFromFile();
        try {
            new Client(connectionProperties.getProperty("ip"),
                    Integer.parseInt(connectionProperties.getProperty("port"))).start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws Exception {
        System.out.println("Enter login:");
        String name = scanner.readLine();
        for (int i = 0; i < 1000; i++) {
            sendAndPrintMessage(SimpleMessage.getMessage(name, Integer.toString(i)));
        }
        while (true) {
            System.out.println("Enter message:");
            String message = scanner.readLine();
            if (message.length() == 0) continue;
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    public void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            if (fromServer.getText().startsWith("/")) {
                System.out.println(fromServer.getText().substring(1));
            } else System.out.println("от сервера: " + fromServer);
        }
    }
}
