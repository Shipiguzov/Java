package src.com.ifmo.jjd.lesson12.exceptions;

import java.io.IOException;

public class Message {
    private String text;

    public Message(String text) throws ChatException {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws ChatException {
        if (text == null || text.trim().length() < 3) throw new ChatException("text.length < 3");
        this.text = text;
    }
}
