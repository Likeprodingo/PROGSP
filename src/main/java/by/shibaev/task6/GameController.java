package by.shibaev.task6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameController extends Application {

    private final static String BALlOON_PATH =  "119774-1.jpg";
    private final static String BOOM_PATH = "images.jpg";

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Balloon balloon = new Balloon(150,500,1,BALlOON_PATH,BOOM_PATH);
        Thread thread = new Thread(balloon);
        thread.start();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(balloon);
        Scene scene = new Scene(stackPane, 300, 500);
        stage.setTitle("Click to Flip!");
        stage.setScene(scene);
        stage.show();
    }
}
