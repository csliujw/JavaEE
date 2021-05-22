package io.nio.chat;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    private Selector selector;
    private ServerSocketChannel channel;
    private final static int PORT = 9999;

    // 初始化连接信息
    public Server() {
        try {
            selector = Selector.open();
            channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(PORT));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        // 监听
        server.listen();
    }

    // 监听事件
    private void listen() {
        try {
            while (selector.select() > 0) {
                System.out.println("=========start listen=========");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey event = iterator.next();
                    if (event.isAcceptable()) {
                        // 客户端接入请求 连接事件
                        SocketChannel accept = channel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ);
                    } else if (event.isReadable()) {
                        // 读取数据请求 读取事件的请求
                        readData(event);
                    }
                }
                iterator.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readData(SelectionKey event) {
        // Java 7 try catch resource
        try {
            SocketChannel channel = (SocketChannel) event.channel();
            channel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len;
            while ((len = channel.read(buffer)) > 0) {
                buffer.flip();
                String msg = new String(buffer.array(), 0, len);
                sendToAll(msg);
                System.out.println("msg: " + msg);
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 把消息发送给除了自己外的所有人
    private void sendToAll(String msg) {
        try {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey event = iterator.next();
                if (event.isReadable()) {
                    SocketChannel channel = (SocketChannel) event.channel();
                    channel.configureBlocking(false);
                    byte[] bytes = msg.getBytes();
                    ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
                    allocate.put(bytes);
                    channel.write(allocate);
                }
            }
            iterator.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
