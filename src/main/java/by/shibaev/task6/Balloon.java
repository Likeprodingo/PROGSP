package by.shibaev.task6;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


import java.sql.Time;

public class Balloon extends Pane implements Runnable {
    private int x;
    private int y;
    private int speed;
    private static int score = 0;
    private final BooleanProperty booleanProperty = new SimpleBooleanProperty();
    private ImageView balloonView;
    private ImageView boomView;
    private boolean isActive = true;

    public Balloon(int x, int y, int speed, String balloonImg, String boomImg) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        setWidth(50);
        setHeight(50);
        booleanProperty.setValue(true);
        Image balloon = new Image(balloonImg);
        balloonView = new ImageView(balloon);
        balloonView.setX(0);
        balloonView.setY(0);
        balloonView.setFitHeight(50);
        balloonView.setFitWidth(50);
        getChildren().add(balloonView);

        Image boom = new Image(boomImg);
        boomView = new ImageView(boom);
        boomView.setX(x);
        boomView.setY(y);
        boomView.setFitHeight(50);
        boomView.setFitWidth(50);
        getChildren().add(boomView);

        balloonView.visibleProperty().bind(booleanProperty.not());
        boomView.visibleProperty().bind(booleanProperty);

        setOnMouseEntered((e) -> {
            score++;
            booleanProperty.setValue(!booleanProperty.getValue());
            getChildren().remove(balloonView);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            getChildren().remove(boomView);
            isActive = false;
        });
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        while (isActive) {
            y -= speed;
            boomView.yProperty().setValue(y);
            balloonView.yProperty().setValue(y);
            System.out.println(y);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
