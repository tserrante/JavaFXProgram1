package com.example.javafxprogram1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        window.setTitle("Title of Window");

        // form
        TextField nameInput = new TextField();
        button = new Button("Click me");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput, button);

        scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField nameInput, String text)
    {
        try
        {

            int age = Integer.parseInt(text);
            System.out.println("User is: " + age);
            return true;

        }
        catch (NumberFormatException e)
        {
            System.out.println("Error: " + text + " is not a valid number");
            return false;
        }
    }


}