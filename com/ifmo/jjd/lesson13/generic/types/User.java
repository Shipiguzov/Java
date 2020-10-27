package com.ifmo.jjd.lesson13.generic.types;

// в <> указываем, что класс будет использовать generic тип
// Вместо T может быть любая буква или их сочитание
public class User<T> {
    // тип данных поля будет задан в момент создания объекта
    // тип T ничем не ограничен и будет скомпилирован в Object, поэтому
    // внутри класса полю id будут доступны только методы Object
    private T id;

    private String login;
    private String pwd;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
