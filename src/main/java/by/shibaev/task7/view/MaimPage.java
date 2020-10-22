package by.shibaev.task7.view;

import by.shibaev.task7.model.entity.Film;
import by.shibaev.task7.model.exception.ServiceException;
import by.shibaev.task7.model.service.FilmLibraryService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class MaimPage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label outPut = new Label();

        Label name = new Label("Name: ");
        Label producer = new Label("Producer: ");
        Label year = new Label("Year: ");

        TextField nameField = new TextField();
        nameField.setPrefColumnCount(11);
        nameField.setMaxWidth(200);

        TextField producerField = new TextField();
        producerField.setPrefColumnCount(11);
        producerField.setMaxWidth(200);

        TextField yearField = new TextField();
        yearField.setPrefColumnCount(11);
        yearField.setMaxWidth(50);

        Button add = new Button("Add");
        add.setOnMouseClicked((e) -> {
            FilmLibraryService service = FilmLibraryService.INSTANCE;
            try {
                service.add(nameField.getText(),producerField.getText(),yearField.getText());
                outPut.setText("");
            } catch (ServiceException ex) {
                outPut.setText(ex.toString());
            }
        });

        Button selectAll = new Button("Select All");
        selectAll.setOnMouseClicked(e ->{
            FilmLibraryService service = FilmLibraryService.INSTANCE;
            String result;
            try {
                result = service.selectAll().toString();
            } catch (ServiceException ex) {
                result = ex.toString();
            }
            outPut.setText(result);
        });

        Button selectByName = new Button("Select");
        TextField nameInput = new TextField("name");

        selectByName.setOnMouseClicked(e ->{
            FilmLibraryService service = FilmLibraryService.INSTANCE;
            String result;
            try {
                result = service.selectByName(nameInput.getText()).toString();
            } catch (ServiceException ex) {
                result = ex.toString();
            }
            outPut.setText(result);
        });

        Button selectByAuthor = new Button("Select");
        TextField authorInput = new TextField("author");

        selectByAuthor.setOnMouseClicked(e ->{
            FilmLibraryService service = FilmLibraryService.INSTANCE;
            String result;
            try {
                result = service.selectByProducer(authorInput.getText()).toString();
            } catch (ServiceException ex) {
                result = ex.toString();
            }
            outPut.setText(result);
        });

        VBox box = new VBox(name,nameField,producer,producerField,year,yearField,add,selectAll,nameInput,selectByName,authorInput,selectByAuthor,outPut);
        box.setSpacing(3);
        Scene scene = new Scene(box, 600, 500);
        stage.setTitle("Click to Flip!");
        stage.setScene(scene);
        stage.show();
    }
}
