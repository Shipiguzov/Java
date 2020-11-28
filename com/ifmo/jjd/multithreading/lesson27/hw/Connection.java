package com.ifmo.jjd.multithreading.lesson27.hw;

import com.ifmo.jjd.lesson20.socketio.SimpleMessage;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Connection implements AutoCloseable {

    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    public static Properties getConnectionPropertiesFromFile() {
        Properties properties = new Properties();
        try (InputStream inputStream = Connection.class.getClassLoader().getResourceAsStream("sources/ClientServer.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    public void close() throws Exception {
        this.input.close();
        this.output.close();
        this.socket.close();
    }
}
