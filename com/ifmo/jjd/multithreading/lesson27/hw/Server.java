package com.ifmo.jjd.multithreading.lesson27.hw;

import com.ifmo.jjd.lesson20.socketio.ServerCommand;
import com.ifmo.jjd.lesson20.socketio.SimpleMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

    private Connection connection;
    private int count = 0;
    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public int getCount() {
        return count;
    }

    public void start() {
        Properties properties = Connection.getConnectionPropertiesFromFile();
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty("port")))) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                SimpleMessage message = connection.readMessage();
                LocalTime time = LocalTime.now();
                System.out.println(time);
                count++;
                System.out.println(message);
                Future<String> commandMessage = executorService.submit(new ProceccingMessage(message, count, time));
                if (Objects.isNull(commandMessage.get()))
                    connection.sendMessage(SimpleMessage.getMessage("server", "recived"));
                else connection.sendMessage(SimpleMessage.getMessage("server", commandMessage.get()));
            }
        } catch (IOException | ClassNotFoundException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /*private String processingMessage (SimpleMessage message, LocalTime time) {
        String command = message.getText().substring(1);
        if (ServerCommand.HELP.toString().equals(command))
            return "/command: " + ServerCommand.HELP.toString().toLowerCase() + ". Aviable command: " + helpCommand();
        if (ServerCommand.COUNT.toString().equals(command))
            return "/command: /" + ServerCommand.COUNT.toString().toLowerCase() + " Number of connections " + getCount();
        if (ServerCommand.PING.toString().equalsIgnoreCase(command))
            return "/command: /" + ServerCommand.PING.toString().toLowerCase() + " Current ping: " + pingCommand(message, time) + " microseconds";
        return null;
    }*/

    /*private String helpCommand() {
        StringBuilder outputMessage = new StringBuilder();
        for (ServerCommand value : ServerCommand.values()) {
            outputMessage.append("/").append(value.toString().toLowerCase()).append(", ");
        }
        return outputMessage.toString();
    }*/

    /*private long pingCommand(SimpleMessage message, LocalTime time) {
        return ChronoUnit.MICROS.between(time, message.getDateTime().toLocalTime());
    }*/
}
