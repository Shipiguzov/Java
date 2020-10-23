package src.com.ifmo.jjd.lesson12.exceptions;

// Если необходимо создать собственный класс исключения времени выполнения, то класс должен наследоваться от
// RuntimeException
// Если необходимо создать собственный класс исключения времени компиляции, то класс должен наследоваться от
// Exception
public class ChatException extends Exception {

    public ChatException(String message) {
        super(message);
    }

    public ChatException(String message, Throwable cause) {
        super(message, cause);
    }

    // можем переопределить методы родителя

    @Override
    public String getMessage() {
        return super.getMessage() + " Будьте внимательны";
    }
}
