package com.ifmo.jjd.lesson12.homework1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class ExceptionClass extends Exception{

    public static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException {
        switch (status) {
            case FILE_NOT_FOUND:
                throw new FileNotFoundException("File not found");
            case JAR_ERROR:
                throw new JarException();
            case ACCESS_DENIED:
                throw new AccessDeniedException(null);
        }
    }
}
