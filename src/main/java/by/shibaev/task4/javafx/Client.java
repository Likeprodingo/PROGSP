package by.shibaev.task4.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.*;
import java.net.Socket;

public class Client extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane flowPane;
        flowPane = createPage();
        Scene scene = new Scene(flowPane, 250, 250);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.show();
    }

    public FlowPane createPage() {

        Label x = new Label("X: ");
        Label y = new Label("Y: ");
        Label x1 = new Label("X: ");
        Label y1 = new Label("Y: ");
        Label x2 = new Label("X: ");
        Label y2 = new Label("Y: ");
        Label x3 = new Label("X: ");
        Label y3 = new Label("Y: ");
        TextField x4Field = new TextField();
        TextField y4Field = new TextField();
        TextField x1Field = new TextField();
        TextField y1Field = new TextField();
        TextField x2Field = new TextField();
        TextField y2Field = new TextField();
        TextField x3Field = new TextField();
        TextField y3Field = new TextField();
        x1Field.setPrefColumnCount(11);
        y1Field.setPrefColumnCount(11);
        x2Field.setPrefColumnCount(11);
        y2Field.setPrefColumnCount(11);
        y3Field.setPrefColumnCount(11);
        x3Field.setPrefColumnCount(11);
        y4Field.setPrefColumnCount(11);
        x4Field.setPrefColumnCount(11);
        Label xCheck = new Label("Check x: ");
        Label yCheck = new Label("Check y: ");
        TextField xCheckField = new TextField();
        TextField yCheckField = new TextField();
        Button btn = new Button("Check");
        Label result = new Label();
        btn.setOnAction(event -> {
            result.setText("Output: " + sendMessage(x1Field.getText(), y1Field.getText(),
                    x2Field.getText(), y2Field.getText(),
                    x3Field.getText(), y3Field.getText(),
                    x4Field.getText(), y4Field.getText(),
                    xCheckField.getText(), yCheckField.getText()));
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,
                x, x1Field, y, y1Field,
                x1, x2Field, y1, y2Field,
                x2, x3Field, y2, y3Field,
                x3, x4Field, y3, y4Field,
                xCheck, xCheckField, yCheck, yCheckField,
                result, btn);
        return root;
    }

    public String sendMessage(String x1, String y1, String x2, String y2, String x3, String y3, String x4, String y4, String x, String y) {
        String result;
        try (Socket clientSocket = new Socket("127.0.0.1", 2525);
             ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream())) {
            outputStream.writeObject(x1);
            outputStream.writeObject(y1);
            outputStream.writeObject(x2);
            outputStream.writeObject(y2);
            outputStream.writeObject(x3);
            outputStream.writeObject(y3);
            outputStream.writeObject(x4);
            outputStream.writeObject(y4);
            outputStream.writeObject(x);
            outputStream.writeObject(y);
            result = (String) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            result = "wrong connection";
        } finally {
            System.out.println("close");
        }
        return result;
    }
}
