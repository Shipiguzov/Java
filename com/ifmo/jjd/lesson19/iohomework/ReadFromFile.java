package com.ifmo.jjd.lesson19.iohomework;

import com.ifmo.jjd.lesson9.playlist.Singer;

import java.io.*;

public class ReadFromFile extends FilterInputStream {
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected ReadFromFile(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int count = super.read(b);
        String key = KeyValue.KEY.toString();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i] + " " + key.getBytes()[i % key.length()]);
            b[i] = (byte)(b[i] ^ key.getBytes()[i % key.length()]);
            System.out.println(b[i]);
        }
        return count;
    }
}
