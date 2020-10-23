package com.ifmo.jjd.lesson12.homework1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class ExceptionHW1App {
    public static void main(String[] args) {
        try {
            ExceptionClass.throwException(Status.FILE_NOT_FOUND);
        } catch (JarException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + " NOT GOOD");
        } catch (AccessDeniedException e) {
            e.getMessage();

        }
        try {
            ExceptionClass.throwException(Status.ACCESS_DENIED);
        } catch (JarException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            e.getMessage();
            try {
                ExceptionClass.throwException(Status.JAR_ERROR);
            } catch (JarException jarException) {
                jarException.getStackTrace();
            } catch (FileNotFoundException ignored) {
            } catch (AccessDeniedException ignored) {
            }
        }
    }
}
