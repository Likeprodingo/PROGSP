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
        try (DatagramSocket socket = new DatagramSocket()) {
            sendMessage(TASK.length(), TASK.getBytes(), socket);
            String number = "5";
            sendMessage(number.length(), number.getBytes(), socket);
            String result = readMessage(socket);
            System.out.println(result);
        } catch (IOException e) {
            //logger
        }
        //logger ended
    }

    private void sendMessage(int length, byte[] data, DatagramSocket socket) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(data, length, InetAddress.getByName("127.0.0.1"), 8001);
        socket.send(sendPacket);
    }

    private String readMessage(DatagramSocket socket) throws IOException {
        byte[] buf = new byte[512];
        String data = "";
        DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
        socket.receive(recvPacket);
        data = new String(recvPacket.getData()).trim();
        return data;
    }

    public static void main(String[] args) {//метод main
        new UDPClient().runClient();
    }
}
