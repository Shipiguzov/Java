package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Properties;

public class SimpleServer {

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException ioException) {
            System.out.println("IOException");
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
    }

    private Connection connection;
    private int count = 0;

    public void start() throws IOException, ClassNotFoundException {
        Properties properties = null;
        properties = Connection.getPropertiesForConnection();
        try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty("port")))) { // ожидание клиента
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept(); // принятие клиента
                connection = new Connection(socket);
                SimpleMessage message = connection.readMessage();
                LocalTime time = LocalTime.now();
                System.out.println(time);
                count++;
                System.out.println(message);
                String commandMessage = this.processingOfMessage(message, time);
                if (Objects.isNull(commandMessage))
                    connection.sendMessage(SimpleMessage.getMessage("server", "recived"));
                else connection.sendMessage(SimpleMessage.getMessage("server", commandMessage));
            }
        }
    }

    public String processingOfMessage(SimpleMessage message, LocalTime time) {
        String command = message.getText().substring(1);
        if (ServerCommand.HELP.toString().equalsIgnoreCase(command))
            return "/command: /" + ServerCommand.HELP.toString().toLowerCase() + ". Aviable commands: " + helpCommand();
        if (ServerCommand.COUNT.toString().equalsIgnoreCase(command))
            return "/command: /" + ServerCommand.COUNT.toString().toLowerCase() + " Number of connections " + getCount();
        if (ServerCommand.PING.toString().equalsIgnoreCase(command))
            return "/command: /" + ServerCommand.PING.toString().toLowerCase() + " Current ping: " + pingCommand(message, time) + " microseconds";
        return null;
    }

    public String helpCommand() {
        StringBuilder outputMessage = new StringBuilder();
        for (ServerCommand value : ServerCommand.values()) {
            outputMessage.append("/").append(value.toString().toLowerCase()).append(", ");
        }
        return outputMessage.toString();
    }

    public int getCount() {
        return count;
    }

    public long pingCommand(SimpleMessage message, LocalTime time) {
        return ChronoUnit.MICROS.between(time, message.getDateTime().toLocalTime());
    }
} // ip 127.0.0.1 : 8090
