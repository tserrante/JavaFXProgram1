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
    Scene scene1, scene2;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        window = stage;

        Label label1 = new Label("Welcome to the first scene!");

        Button button1 = new Button("Go to scene 2");

        button1.setOnAction(e -> window.setScene(scene2));

        // layout 1 - children are laid out in a vertical column
        // vbox is a layout that stacks all object on top of eachother in a column
        // this particular vbox spaces them 20 pixels
        VBox layout1 = new VBox(20 );
        layout1. getChildren().addAll(label1, button1);

        scene1 = new Scene(layout1, 200, 200);

        Label label2 = new Label("Welcome to the second scene!");

        Button button2 = new Button("Go to scene 1");

        button2.setOnAction(e -> window.setScene(scene1));

        // Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("This is a title");
        window.show();
    }




}