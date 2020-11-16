package com.ifmo.jjd.lesson19.iohomework;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CoderToFile extends FilterOutputStream {
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public CoderToFile(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] key = KeyForCoding.KEY.toString().getBytes();
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte)(b[i] ^ key[i % key.length]);
        }
        super.write(b);
    }
}
