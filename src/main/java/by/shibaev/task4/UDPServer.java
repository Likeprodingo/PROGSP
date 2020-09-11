package by.shibaev.task4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public final static int DEFAULT_PORT = 8001;
    public final String VERSION_CMD = "VERS";
    public final String QUIT_CMD = "QUIT";//определение
    public final byte[] VERSION = {'V', '2', '.', '0'};
    public final byte[] UNKNOWN_CMD = {'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ',
            'c', 'o', 'm', 'm', 'a', 'n', 'd'};

    public void runServer() throws IOException {
        try (DatagramSocket socket = new DatagramSocket(DEFAULT_PORT)) {
            boolean stopFlag = false;
            byte[] buf = new byte[512];
            System.out.println("UDPServer: Started on " + socket.getLocalAddress() + ":"
                    + socket.getLocalPort());
            while (!stopFlag) {
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                socket.receive(recvPacket);
                String cmd = new String(recvPacket.getData()).trim();
                System.out.println("UDPServer: Command: " + cmd);
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(), recvPacket.getPort());                                                                 // дейтаграммы для отсылки данных
                int n = 0;//количество байт в ответе
                if (cmd.equals(VERSION_CMD)) {
                    n = VERSION.length;
                    System.arraycopy(VERSION, 0, buf, 0, n);
                } else if (cmd.equals(QUIT_CMD)) {
                    stopFlag = true;
                    continue;
                } else {
                    n = UNKNOWN_CMD.length;
                    System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
                }
                sendPacket.setData(buf);
                sendPacket.setLength(n);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            //logger
        }
        System.out.println("UDPServer: Stopped");
    }

}

    public static void main(String[] args) {//метод main
        try {
            UDPServer udpSvr = new UDPServer();//создание объекта udpSvr
            udpSvr.runServer();//вызов метода объекта runServer
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
