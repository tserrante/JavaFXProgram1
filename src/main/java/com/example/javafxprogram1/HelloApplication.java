package com.example.javafxprogram1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;


import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application  {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        window = primaryStage;
        window.setTitle("ChoiceBox Demo");
        button = new Button("Click Me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // get items returns ObservableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().add("Grapes");
        choiceBox.getItems().addAll("Oranges", "Blueberries", "Cherries", "Tomato");
        choiceBox.setValue("Apple");

        //listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue) );


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}