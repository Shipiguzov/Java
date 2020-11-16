package com.ifmo.jjd.lesson20.socketio;

// AutoCloseable + close() позволит создавать объекты в try-with-sources блоке

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Connection implements AutoCloseable{

    // объект типа Socket позволит клиенту установить соединение с сервером
    // объект типа Socket позволит серверу принять клиента
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage (SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    @Override
    // будет вызван автоматически после завершения try-блока если объект Connection был создан в () try-блока
    public void close() throws Exception {
        this.input.close();
        this.output.close();
        this.socket.close();
    }

    public static Properties getPropertiesForConnection() {
        Properties properties = new Properties();
        try (InputStream input = Connection.class.getClassLoader().getResourceAsStream("ClientServer.properties")) {
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties;
    }
}

