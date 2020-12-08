package com.ifmo.jjd.exam2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class Connection implements AutoCloseable {

    private String accountName;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public Connection(Socket socket, String accountName) throws IOException {
        this.accountName = accountName;
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (Objects.isNull(accountName) || accountName.length() < 3)
            throw new IllegalArgumentException("Wrong account name");
        this.accountName = accountName;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void sendMessage(Message message) throws IOException {
        message.setTime();
        output.writeObject(message);
        output.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) input.readObject();
    }

    public boolean isMessageIncome() throws IOException {
        int ip = input.available();
        if (this.input.available() != 0) return true;
        return false;
    }

    @Override
    public void close() throws Exception {
        this.input.close();
        this.output.close();
        this.socket.close();
    }
}
