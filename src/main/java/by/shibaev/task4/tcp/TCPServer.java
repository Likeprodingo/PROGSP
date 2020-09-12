package by.shibaev.task4.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private final static int DEFAULT_PORT = 2525;
    private final static String QUIT_CMD = "QUIT";
    private final String UNKNOWN_CMD = "UNKNOWN COMMAND";

    public static void main(String[] arg) {
        //объявление байтового потока ввода
        //объявление байтового потока вывода
        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
             Socket clientAccepted = serverSocket.accept();
             ObjectInputStream inputStream = new ObjectInputStream(clientAccepted.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(clientAccepted.getOutputStream())) {
            //logger start
            String clientMessageRecieved;
            do {
                clientMessageRecieved = (String) inputStream.readObject();
                //logger
                //task
                outputStream.writeObject(clientMessageRecieved);
            } while (!clientMessageRecieved.equals(QUIT_CMD));
        } catch (Exception e) {
            //logger
        }
        //logger
    }
}
