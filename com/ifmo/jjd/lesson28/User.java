package com.ifmo.jjd.lesson28;

public class User {
    private Level level;
    private String login;

    public User(String login, Level level) {
        this.level = level;
        this.login = login;
    }

    // область видимости определяется согласно модификатору доступа
    // объект Account  не может существовать без объекта User
    public class Account {
        // класс не может содержать статические методы и свойства, кроме final
        // private static int count;
        private static final int MAX_BALANCE = 500;
        private float balance;

        public Account(int balance) {
            // вложенный класс имеет доступ ко всем полям и методам внешнего класса, в том числе и private
            // имяВнешнегоКласса.this.свойство/метод
            this.balance = balance + User.this.level.getCount();
        }

        public String getInfo(){
            return "Пользователь: " + User.this.login + "; " +
                    "Баланс: " + balance + ".";
        }

        // возвращает ссылку на User, которому он принадлежит
        public User getUser(){
            return User.this;
        }
    }

    public enum Level{
        HIGH(10), MEDIUM(5), LOW(0);

        private  int count;
        Level(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
}