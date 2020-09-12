package by.shibaev.task4.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class TCPServer {

    private final static int DEFAULT_PORT = 2525;
    private final static String QUIT_CMD = "QUIT";
    private final static String GET_CMD = "GET";
    private final static String ADD_CMD = "ADD";
    private final static String EDIT_CMD = "EDIT";
    private final String UNKNOWN_CMD = "UNKNOWN COMMAND";

    public static void main(String[] arg) {
        Schedule schedule = Schedule.getInstance();
        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
             Socket clientAccepted = serverSocket.accept();
             ObjectInputStream inputStream = new ObjectInputStream(clientAccepted.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(clientAccepted.getOutputStream())) {
            //logger start
            String clientMessageRecieved;
            String input;
            do {
                clientMessageRecieved = (String) inputStream.readObject();
                //logger
                switch (clientMessageRecieved) {
                    case GET_CMD:
                        clientMessageRecieved = schedule.toString();
                        break;
                    case ADD_CMD:
                        input = (String) inputStream.readObject();
                        schedule.add(new Subject(clientMessageRecieved));
                        clientMessageRecieved = "DONE";
                        break;
                    case EDIT_CMD:
                        input = (String) inputStream.readObject();
                        clientMessageRecieved = (String) inputStream.readObject();
                        for (Subject s : schedule.getSchedule()) {
                            if (s.getName().equals(input)){
                                s.setName(clientMessageRecieved);
                            }
                        }
                        clientMessageRecieved = "DONE";
                        break;
                }
                outputStream.writeObject(clientMessageRecieved);
            } while (!clientMessageRecieved.equals(QUIT_CMD));
        } catch (Exception e) {
            //logger
        }
        //logger
    }
}
