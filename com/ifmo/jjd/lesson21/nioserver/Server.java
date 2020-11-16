package com.ifmo.jjd.lesson21.nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        // запускаем один поток для обработки всех соединений
        new Thread(new NioThread()).start();
    }

    // Если сервер написан при помощи nio, то параллельных потоков не будет, будут асинхронные потоки (асинхронная работа с клиентами)
    //       в одном потоке
    // client1 | client2 | client3

    // 1. на каждое подключение создаётся канал
    // 2. каждый канал регестрируется селектором
    // 3. любое событие обрабатывается селектором (следит за каналами)
    // 4. селектор реагирует согласно инструкции на событие в канале

    private class NioThread extends Worker{
        private static final int BUF_SIZE = 1024;

        private ByteBuffer byteBuffer;
        private ServerSocketChannel serverChannel;
        private Selector selector;

        @Override
        protected void init() throws IOException {
            // Создание буфера
            byteBuffer = ByteBuffer.allocate(BUF_SIZE);
            // создание объекта селектор
            selector = Selector.open();
            // открытие канала сервера
            serverChannel = ServerSocketChannel.open();
            // начало ожидания входящих подключений на порту 8090
            serverChannel.bind(new InetSocketAddress(8090));
            // перевод канала в неблокирующий режим
            serverChannel.configureBlocking(false);
            // регистрация канала в селекторе (селектор подписан на канал) (селектор наблюдает на события в этом канале)
            // для serverChannel - OP_ACCEPT
            serverChannel.register(selector, serverChannel.validOps());
            // ServerSocketChannel ждет подключений, новый клиент - событие OP_ACCEPT в канале.
            // Когда оно наступает, селектор переключает внимание на данный канал и сервер принимает клиента.
        }

        @Override
        protected void loop() throws IOException {
            // селектор ожидает событий во всех каналах, на которые подписан
            selector.select();

            // 1. ServerSocketChannel -> OP_ACCEPT - запрос клиента на создание подключения
            // 2. SocketChannel - создание канала между клинтом-сервером после запроса клиента
            //      SocketChannel:
            //          OP_CONNECT (текущий клиент подключился),
            //          OP_READ (в канал пришли данные)(надо прочитать из канала)
            //          OP_WRITE (в канал пришли данные от сервера, которые необходимо "записать" (передать) в канал, чтобы передать их клиенту

            // получает все ключи на события в канале, к которому подписан селектор (собирает все события (что за событие и в каком канале оно произошло))
            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();

            // перебирает все ключи в цикле и обрабатывает их в цикле
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                if (key.isAcceptable()){ // событие от клиента
                    // создание нового подключения клиент - сервер
                    SocketChannel channel = serverChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Client connected " + channel.getRemoteAddress());

                } else if (key.isReadable()) { // событие от клиента
                    System.out.println("читаем входящие данные...");
                    readData((SocketChannel)key.channel());
                } else if (key.isValid() && key.isWritable()){ // событие от сервера
                    System.out.println("запись данных в канал...");
                    writeData((SocketChannel)key.channel(), key);
                }
                iterator.remove();
            }

        }

        @Override
        protected void stop() throws IOException {
            serverChannel.close();
            selector.close();
        }

        private void readData(SocketChannel channel){
            byteBuffer.clear();

            try {
                int read = channel.read(byteBuffer);
                if(read != -1) {
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), StandardCharsets.UTF_8));
                } else {
                    System.out.println("client disconnected " + channel.getRemoteAddress());
                    channel.close();
                }

                byteBuffer.flip();

                Set<SelectionKey> keys = selector.keys();
                for (SelectionKey key: keys){
                    // может происходить
                    // Канал: [возможные события (channel().validOps()), события в канале в момент времени key.interestOps()]
                    if ((key.channel().validOps() & SelectionKey.OP_WRITE) > 0){
                        key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                    }
                }

            } catch (IOException e) {
                System.out.println("client disconnected ");
                byteBuffer.clear();
                try {
                    channel.close();
                } catch (IOException e1) {
//                    e1.printStackTrace();
                }
            }
        }

        private void writeData(SocketChannel channel, SelectionKey key) throws IOException {
            channel.write(byteBuffer);
            byteBuffer.rewind();
            key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
        }
    }
}