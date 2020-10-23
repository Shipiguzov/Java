package com.ifmo.jjd.oop;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Mouse mouse = new Mouse("Mikey", 20);
        IHandler handler = IHandler.getInstance("json");
        handler.write(mouse);
        Mouse mouseFromFile = handler.read();
    }
}

class Mouse {
    private String name;
    private int speed;

    public Mouse(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class Handler{
    private String file;

    public Handler(String file) {
        this.file = file;
    }

    public void saveToFile(Mouse mouse) {
        if (file.equals("json")) {
            // реализация записи в json файл
        } else if (file.equals("bin")) {
            // реализация записи в bin файл
        }
        // необходимость работы с другими типами файлов приведет
        // к необходимости изменять код существующего класса,
        // что может привести к сбоям в программе
    }

    public Mouse getFromFile(){
        // аналогично методу saveToFile(Mouse mouse)
        return null;
    }

}

interface IHandler {
    void write(Mouse mouse);
    Mouse read();
    static IHandler getInstance(String ext){
        IHandler handler = null;
        switch (ext){
            case "json":
                handler = new JsonHandler("json");
                break;
            case "bin":
                handler = new BinHandler("bin");
                break;
        }
        return handler;
    }
}
class JsonHandler extends Handler implements IHandler{

    public JsonHandler(String file) {
        super(file);
    }

    @Override
    public void write(Mouse mouse) {
        System.out.println("Записали mouse в json файл");
    }

    @Override
    public Mouse read() {
        System.out.println("Получили mouse из json файла");
        return null;
    }
}

class BinHandler extends Handler implements IHandler {

    public BinHandler(String file) {
        super(file);
    }

    @Override
    public void write(Mouse mouse) {
        System.out.println("Записали mouse в bin файл");
    }

    @Override
    public Mouse read() {
        System.out.println("Получили mouse из bin файла");
        return null;
    }
}

// необходимость работы с другими типами файлов позволит
// добавить новый функционал (новый класс) в программу, не меняя код уже
// существующих классов