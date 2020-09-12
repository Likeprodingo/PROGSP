package by.shibaev.task4.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    private final static int DEFAULT_PORT = 8001;
    private final String QUIT_CMD = "QUIT";
    private final String UNKNOWN_CMD = "UNKNOWN COMMAND";
    private final String TASK = "TASK";

    public void runServer() {
        try (DatagramSocket socket = new DatagramSocket(DEFAULT_PORT)) {
            byte[] buf = new byte[512];
            //logger System.out.println("UDPServer: Started on " + socket.getLocalAddress() + ":"
            //        + socket.getLocalPort());
            while (true) {
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                socket.receive(recvPacket);
                String cmd = new String(recvPacket.getData()).trim();
                //logger command
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(), recvPacket.getPort());                                                                 // дейтаграммы для отсылки данных
                int n = 0;
                switch (cmd) {
                    case TASK:
                        socket.receive(recvPacket);
                        cmd = new String(recvPacket.getData()).trim();
                        String result = processTask(cmd);
                        buf = result.getBytes();
                        n = buf.length;
                        break;
                    case QUIT_CMD:
                        break;
                    default:
                        n = UNKNOWN_CMD.length();
                        System.arraycopy(UNKNOWN_CMD.getBytes(), 0, buf, 0, n);
                }
                sendPacket.setData(buf);
                sendPacket.setLength(n);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            //logger
        }
        //logger stop
    }

    private String processTask(String cmd) {
        String result = "wrong input";
        int x;
        try {
            x = Integer.parseInt(cmd);
            result = String.valueOf(2 * x * Math.pow((1 + Math.pow(x, 2)), 2)
                    / (x + Math.pow(Math.abs(1 + Math.pow(x, 5)), 1 / 3.))
                    * (Math.pow(x, 1 / 2.) / (2 * x + 10)));
        } catch (NumberFormatException e) {
            //logger
        }
        return result;
    }

    public static void main(String[] args) {
        new UDPServer().runServer();
    }
}
