package com.ifmo.jjd.exam2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Server {

    private CopyOnWriteArrayList<Connection> accountList;
    private LinkedBlockingQueue<Message> messages;

    public static void main(String[] args) {
        new Server().start();
    }

    private Server() {
        accountList = new CopyOnWriteArrayList<>();
        messages = new LinkedBlockingQueue<>();
    }

    private void start() {
        Thread.currentThread().setName("GettingMessageThread");
        System.out.println("Server started");
        new Thread(new SendMessageToClientList()).start();
        Properties properties = Service.getPropertiesFromFile("Server.properties");
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty("port")))) {
            System.out.println("Server wait for clients");
            while (true) {
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);
                connection.setAccountName("default");
                new Thread(new ClientThread(connection)).start();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private class SendMessageToClientList implements Runnable {

        @Override
        public void run() {
            while (true) {
                Message message;
                try {
                    message = Server.this.messages.take();
                    for (Connection connection : Server.this.accountList) {
                        if (!connection.getAccountName().equalsIgnoreCase(message.getSender())) {
                            connection.sendMessage(message);
                            System.out.println("Message sent to " + connection.getAccountName());
                        }
                    }
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

//    private class ProcessingMessage implements Runnable {
//
//        private Message message;
//        private Connection connection;
//
//        private ProcessingMessage(Connection connection, Message message) {
//            this.connection = connection;
//            this.message = message;
//        }
//
//        @Override
//        public void run() {
//            if (message.isConnected()) {
//                if ("default".equalsIgnoreCase(connection.getAccountName())) {
//                    connection.setAccountName(message.getSender());
//                }
//                synchronized (Server.this.messages) {
//                    try {
//                        Server.this.messages.put(message);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Service.println(message.toString() + " added to message list. Account " +
//                        connection.getAccountName() + " added to account list");
//                System.out.println(Server.this.messages.size());
//            } else {
//                Server.this.accountList.remove(connection);
//                Service.println("Account " + connection.getAccountName() + " disconnected");
//            }
//        }
//    }

//    private class WaitClientThread implements Runnable {
//
//        @Override
//        public void run() {
//            Thread.currentThread().setName("WaitClientThread");
//            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//                Service.println("Server wait for clients");
//                while (true) {
//                    Socket socket = serverSocket.accept();
//                    Connection connection = new Connection(socket);
//                    connection.setAccountName("default");
//                    new Thread(new ClientThread(connection)).start();
//                }
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//    }

    private class ClientThread implements Runnable {

        Connection connection;

        private ClientThread(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            Server.this.accountList.addIfAbsent(connection);
            while (true) {
                try {
                    Message message = connection.readMessage();
                    if (message.isConnected()) {
                        if ("default".equalsIgnoreCase(connection.getAccountName())) {
                            connection.setAccountName(message.getSender());
                        }
                        try {
                            Server.this.messages.put(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(message + " added to message list. Account " +
                                connection.getAccountName() + " added to account list");
                    } else {
                        Server.this.accountList.remove(connection);
                        System.out.println("Account " + connection.getAccountName() + " disconnected");
                    }
                } catch (IOException ioException) {
                    //ioException.printStackTrace();
                    System.out.println("Client " + connection.getAccountName() + " disconnected");
                    accountList.remove(connection);
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}