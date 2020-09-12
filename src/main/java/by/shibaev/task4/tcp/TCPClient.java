package by.shibaev.task4.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {

    private final static int DEFAULT_PORT = 2525;
    private final static String QUIT_CMD = "QUIT";

    public static void main(String[] arg) {
        String clientMessage;
        try (Socket clientSocket = new Socket("127.0.0.1", 2525);
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
             ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream())) {
            do {
                System.out.println("Enter any string to send to server \n\t('QUIT' − programme terminate)");
                clientMessage = stdin.readLine();
                outputStream.writeObject(clientMessage);
                //logger
            } while (!clientMessage.equals(QUIT_CMD));
        } catch (Exception e) {
            //logger
        }
    }
}

