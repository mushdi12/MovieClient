package client.brain;


import client.basic.Messages;
import dto.classes.Client;
import dto.transmision.Reception;
import dto.transmision.Shipment;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import static frontend.StartApplication.startApplication;
import static java.lang.System.out;


public class ClientCode {
    public static Client this_client;
    public static SocketChannel channel;

    public static void main(String[] args) throws IOException {
        try {
            channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("localhost", 8090));
            channel.configureBlocking(true);
            out.println("Connected to server success..");
            startApplication();

        } catch (IOException ex) {
            out.println("Connected to server was failed..");

        }

    }


    public static Messages printer(SocketChannel channel) throws IOException, ClassNotFoundException {
        ByteBuffer readBuffer = ByteBuffer.allocate(16384);
        while (channel.isOpen()) {
            readBuffer.clear();
            int bytesRead = channel.read(readBuffer);
            if (bytesRead == -1) {
                out.println("Сервер закрыл соединение.");
                channel.close();
                System.exit(0);
            } else if (bytesRead > 0) {
                readBuffer.flip();
                byte[] byteArray1 = new byte[bytesRead];
                readBuffer.get(byteArray1);
                ByteArrayInputStream bais1 = new ByteArrayInputStream(byteArray1);
                try (ObjectInputStream ois1 = new ObjectInputStream(bais1)) {
                    Reception message = (Reception) ois1.readObject();
                    if (message.getMode() == 2) {
                        return new Messages(message.getLinkedList(),0);
                    } else {

                        return new Messages(message.getMessage(),0);

                    }
                } catch (EOFException e) {
                    return new Messages("Ошибка",0);
                }
            }

        }
        return new Messages("Ошибка",0);
    }

    public static void send(SocketChannel channel, Shipment ship) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(ship);
        byte[] byteArray = baos.toByteArray();
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }
    }


}
