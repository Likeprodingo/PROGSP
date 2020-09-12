package by.shibaev.task4.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    private final static String TASK = "TASK";
    private final static String QUIT = "QUIT";

    public void runClient() {
        //logger started
        sendMessage(TASK.length(), TASK.getBytes());
        sendMessage(new Integer(5).byteValue());
        String result = readMessage();
        sendMessage(QUIT.length(), QUIT.getBytes());

        //logger ended
    }

    private boolean sendMessage(int length, byte[] data) {
        boolean result = false;
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket sendPacket = new DatagramPacket(data, length, InetAddress.getByName("127.0.0.1"), 8001);
            socket.send(sendPacket);
            result = true;
        } catch (IOException e) {
            //logger
        }
        return result;
    }

    private boolean sendMessage(byte data) {
        boolean result = false;
        byte[] request = new byte[1];
        request[0] = data;
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket sendPacket = new DatagramPacket(request, 1, InetAddress.getByName("127.0.0.1"), 8001);
            socket.send(sendPacket);
            result = true;
        } catch (IOException e) {
            //logger
        }
        return result;
    }

    private String readMessage() {
        byte[] buf = new byte[512];
        String data = "";
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
            socket.receive(recvPacket);
            data = new String(recvPacket.getData()).trim();
        } catch (IOException e) {
            //logger;
        }
        return data;
    }

    public static void main(String[] args) {//метод main
        new UDPClient().runClient();
    }
}
