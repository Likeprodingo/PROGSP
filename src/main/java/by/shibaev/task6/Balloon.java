package by.shibaev.task6;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


import java.sql.Time;
import java.util.Random;

public class Balloon extends ImageView implements Runnable {

    public static int score = 0;
    private ImageView balloonView;
    private boolean isActive = true;
    private final Image balloon = new Image("images.jpg");
    private final Image boom = new Image("119774-1.jpg");
    private Random random = new Random();

    public Balloon() {
        setImage(balloon);
        setFitHeight(50);
        setFitWidth(50);
        int x = random.nextInt(30) * 9;
        setX(x);
        setY(650);
        setPath();
        setOnMouseClicked((e) -> {
            score++;
            setImage(boom);
        });

    }

    private void setPath() {
        int x = random.nextInt(30) * 9;
        int y = 520;
        Path path = new Path();
        path.getElements().add(new MoveTo(x, y));
        path.getElements().add(new LineTo(x, y - 800));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(9000));
        pathTransition.setPath(path);
        pathTransition.setNode(this);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void run() {
        while (isActive) {
            try {
                if (getY() < 0) {
                    setPath();
                }
                if (getImage() == boom){
                    setImage(balloon);
                    setPath();
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setImage(null);
    }
}

