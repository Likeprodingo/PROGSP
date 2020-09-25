package by.shibaev.task5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Window extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createPage(stage),250,250);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.show();
    }

    private VBox createPage(Stage stage){
        Label startCity =  new Label();
        Label endCity = new Label();

        ObservableList<String> values = FXCollections.observableArrayList("Moscow", "Minsk", "Kiev", "Riga","Warsaw");
        ListView<String> fromCities = new ListView<String>(values);
        MultipleSelectionModel<String> selectionModel = fromCities.getSelectionModel();

        selectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){
                startCity.setText("From: " + newValue);
            }
        });

        ListView<String> toCities = new ListView<String>(values);
        selectionModel = toCities.getSelectionModel();

        selectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){
                endCity.setText("to: " + newValue);
            }
        });
        var button = new Button();
        button.setText("Get Ticket");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VBox secondaryLayout = new VBox(10, startCity, endCity);
                Scene secondScene = new Scene(secondaryLayout, 230, 100);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Ticket");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(stage.getX() + 200);
                newWindow.setY(stage.getY() + 100);

                newWindow.show();
            }
        });
        return new VBox(10.0,fromCities, endCity,button);
    }
}
