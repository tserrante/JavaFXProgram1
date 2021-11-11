package com.example.javafxprogram1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    Stage window;
    Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        window = stage;
        window.setTitle("Main Window");

        button = new Button("Click me");
        button.setOnAction(e -> AlertBox.display("Alert Box", "this is the new window"));
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

         Scene scene = new Scene(layout, 300, 250);
         window.setScene(scene);
         window.show();
    }




}