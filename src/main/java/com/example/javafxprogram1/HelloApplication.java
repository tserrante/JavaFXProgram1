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
        window.setTitle("Tom's Subs - Always Fresh");

        //checkboxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        button = new Button("Order Now!");
        button.setOnAction(e -> handleOptions(box1, box2));
        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2)
    {
        String message = "User Order: ";

        if(box1.isSelected())
            message += "Bacon, ";

        if (box2.isSelected())
            message += "Tuna";

        if(!box2.isSelected() && !box1.isSelected())
            message += "No options selected";

        System.out.println(message);
    }


}