package by.shibaev.task6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class GameController extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static int clickCount = 0;
    private List<Balloon> balloons = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Button button = new Button("Start");
        button.setOnMouseClicked((e) -> {
            if (button.getText().equals("Start")) {
                button.setText("Stop");
                for (int i = 0; i < 5; i++) {
                    Balloon balloon = new Balloon();
                    Thread thread = new Thread(balloon);
                    balloons.add(balloon);
                    thread.start();
                    pane.getChildren().addAll(balloon);
                }
            } else {
                button.setText("Start");
                for (Balloon balloon : balloons) {
                    balloon.setActive(false);
                }
            }
        });
        button.setLayoutX(250);
        button.setLayoutY(10);
        Label clicks = new Label("clicked: ");
        clicks.setLayoutX(50);
        clicks.setLayoutY(10);
        Label score = new Label("score: ");
        score.setLayoutX(150);
        score.setLayoutY(10);
        pane.getChildren().addAll(score, clicks, button);
        pane.setOnMouseClicked((e) -> {
            score.setText(String.valueOf("score: " + Balloon.score));
            clicks.setText(String.valueOf("clicked: " + (++clickCount - Balloon.score)));
        });
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(pane);
        Scene scene = new Scene(stackPane, 300, 500);
        stage.setTitle("Click to Flip!");
        stage.setScene(scene);
        stage.show();
        for (int i = 0; i < 5; i++) {
            Balloon balloon = new Balloon();
            Thread thread = new Thread(balloon);
            balloons.add(balloon);
            thread.start();
            balloon.setActive(false);
            pane.getChildren().addAll(balloon);
        }
    }
}

