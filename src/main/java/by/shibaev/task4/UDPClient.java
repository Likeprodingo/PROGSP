package by.shibaev.task4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public void runClient() {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buf = new byte[512];
            System.out.println("UDPClient: Started");
            byte[] verCmd = {'V', 'E', 'R', 'S'};
            DatagramPacket sendPacket = new DatagramPacket(verCmd, verCmd.length, InetAddress.getByName("127.0.0.1"), 8001);
            socket.send(sendPacket);
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
            socket.receive(recvPacket);
            String version = new String(recvPacket.getData()).trim();
            System.out.println("UDPClient: Server Version: " + version);
            byte[] quitCmd = {'Q', 'U', 'I', 'T'};
            sendPacket.setData(quitCmd);
            sendPacket.setLength(quitCmd.length);
            socket.send(sendPacket);
            System.out.println("UDPClient: Ended");
        } catch (IOException e) {
            //logger
        }
    }

    public static void main(String[] args) {//метод main
            UDPClient client = new UDPClient();
            client.runClient();
    }

}
