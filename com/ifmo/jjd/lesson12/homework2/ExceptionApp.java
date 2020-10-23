package com.ifmo.jjd.lesson12.homework2;

import java.util.Objects;

public class ExceptionApp {
    public static void main(String[] args) {
        ExceptionClass exceptionVar = new ExceptionClass();
        int[] arrayInteger = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int result;
        int indexException = 0;
        Object str = "text";
        int i;
        try {
            exceptionVar.error();
        } catch (Exception e) {
            exceptionVar.saveException(e);
        }
        try {
            result = arrayInteger[1] / arrayInteger[0];
        } catch (Exception e) {
            exceptionVar.saveException(e);
        }
        try {
            result = arrayInteger[10];
        } catch (Exception e){
            exceptionVar.saveException(e);
        }
        try {
            if (arrayInteger[0] == 0) throw new IllegalArgumentException("arrayInteger[0] > 0");
        } catch (Exception e) {
            exceptionVar.saveException(e);
        }
        try {
            Integer var = (Integer) str;
        } catch (Exception e) {
            exceptionVar.saveException(e);
        }

        exceptionVar.printException();
    }
}
