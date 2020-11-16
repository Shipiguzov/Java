package com.ifmo.jjd.lesson21;

import java.nio.ByteBuffer;


public class NIOBuffer {
    public static void main(String[] args) {

        // пакет nio (new io / non-blocking io) предназначен для работы с вводом и выводом
        // * неблокирующий
        // * асинхронный
        // * буфер-ориентированный

        // nio включает:
        // Path (аналог класса File), Files (набор статических методов работы с файлами)
        // набор классов Channel, набор Buffer, селекторы

        // Channel (аналог InputStream и Outputstream) : программа буфер ==канал== файл
        // Данные идут по Channel
        // можно использовать как для записи, так и для чтения
        // События в канале могут происходить асинхронно
        // Channel всегда читают в буфер и записывают в буфер
        // FileChannel - для чтения и записи в файл (для работы с файлами)
        // SocketChannel - клиентский сокет, используется для подключения к серверу и передачи данных по TCP-протоколу
        // DatagramChannel - клиентский сокет, используется для подключения к серверу и передачи данных по UDP-протоколу (пакеты могут теряться)
        // ServerSocketChannel - используется на сервере. Ждёт клиентских подключений. Воссоздает клиентский сокет

        // Буферы:
        // Хранилище, в которую записывается инфа
        // ByteBuffer (самый удобный для передачи данных)
        // CharBuffer
        // DoubleBuffer / FloatBuffer
        // ShortBuffer / IntBuffer / LongBuffer

        // Свойства буферов:
        // capacity - ёмкость (задаётся при создании и не меняется)
        // position - текущая позиция в буфере (изначальна равна 0)
        // limit - указатель, до какого значения можно писать / с какого значения читать данные (изначально равен capacity). Чтение/запись - от position к limit
        // при чтении из буфера limit перемещаем к position для чтения только заполненных ячеек буфера, а позицию перемещаем на 0 и читаем дл limit
        // при записи из буфера limit перемещаем к capacity.
        // remaining

        // assert используется только при разработке, чтобы они работали, их нужно включить: где запускать программу - Edit configuration -> VM Options: - ea
        // проверяют условие, при false - выкидывает эксепшн

        // buffer.position() - возвращает позицию
        // buffer.capacity() - возвращает ёмкость
        // buffer.limit() - возвращает лимит
        ByteBuffer buffer = ByteBuffer.allocate(16);
        System.out.println(buffer.position());// возвращает позицию
        System.out.println(buffer.capacity());// возвращает ёмкость
        System.out.println(buffer.limit());// возвращает лимит
        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16; // разница между position и limit

        // put - запись в буфер
        // Увеличивает позицию на 4.
        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 8.
        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        // Подготовка буфера для чтения
        // Устанавливает лимит на место позиции, сбрасывает позицию в 0 (для чтения из буфера)
        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        // Увеличивает позицию на 8.
        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        // Сбрасывает позицию в 0 (limit остается на прежнем месте - для повторного чтения)
        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        assert anInt == buffer.getInt();
        // Увеличивает позицию на 8.
        assert aDouble == buffer.getDouble();

        // Сбрасывает позицию в 0, ставит лимит, равный емкости буфера (для записи в буфер)
        // не очищает данные буфера
        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.position(2); // устанавливает позицию на значение 2 (для установки позиции вручную)

        // копирует все непрочитанные данные в начало буфера, позиция - на конце непрочитанных данных
        // установит limit равный емкости буфера
        // Буфер готов для дозаписи после непрочитанных данных
        // buffer.compact()
    }
}