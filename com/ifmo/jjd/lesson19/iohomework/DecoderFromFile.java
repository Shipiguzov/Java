package com.ifmo.jjd.lesson19.iohomework;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoderFromFile extends FilterInputStream {
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected DecoderFromFile(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int count = super.read(b);
        byte[] key = KeyForCoding.KEY.toString().getBytes();
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte)(b[i] ^ key[i % key.length]);
        }
        return count;
    }
}
