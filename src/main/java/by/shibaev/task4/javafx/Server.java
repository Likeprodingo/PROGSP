package by.shibaev.task4.javafx;

import by.shibaev.task4.tcp.Schedule;
import by.shibaev.task4.tcp.Subject;

import javax.print.attribute.standard.NumberUp;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {

    private final static int DEFAULT_PORT = 2525;
    private final static String WRONG_INPUT = "Wrong Input";

    public static void main(String[] arg) {
        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
             Socket clientAccepted = serverSocket.accept();
             ObjectInputStream inputStream = new ObjectInputStream(clientAccepted.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(clientAccepted.getOutputStream())) {
            String x;
            String y;
            String result = "";
            Point[] points = new Point[4];
            Point point = null;
            for (int i = 0; i < 4; i++) {
                try {
                    x = (String) inputStream.readObject();
                    y = (String) inputStream.readObject();
                } catch (EOFException e) {
                    i--;
                    continue;
                }
                try {
                    points[i] = new Point(x, y);
                    System.out.println(points[i]);
                } catch (NumberFormatException e) {
                    result = WRONG_INPUT;
                }
            }
            x = (String) inputStream.readObject();
            y = (String) inputStream.readObject();
            try {
                point = new Point(x, y);
                System.out.println(point);
            } catch (NumberFormatException e) {
                result = WRONG_INPUT;
            }
            if (result.equals("")) {
                result = String.valueOf(task(point, points));
            }
            System.out.println(result);
            outputStream.writeObject(result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean task(Point point, Point[] points) {
        int maxH = points[0].getY();
        int minH = points[0].getY();
        int maxW = points[0].getX();
        int minW = points[0].getX();
        for (int i = 1; i < points.length; i++) {
            System.out.println(points[i]);
            if (points[i].getY() > maxH) {
                maxH = points[i].getY();
            }
            if (points[i].getY() < minH) {
                minH = points[i].getY();
            }
            if (points[i].getX() > maxW) {
                maxW = points[i].getX();
            }
            if (points[i].getX() < minW) {
                minW = points[i].getX();
            }
        }
        System.out.println("maxW " + maxW);
        System.out.println("maxH " + maxH);
        System.out.println("minH " + minH);
        System.out.println("minW " + minW);
        return point.getX() <= maxW && point.getX() >= minW && points[0].getY() <= maxH && points[0].getY() >= minH;
    }
}
