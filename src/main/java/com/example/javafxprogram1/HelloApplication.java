package com.example.javafxprogram1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


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
        window.setOnCloseRequest(e ->
        {
            // the user wants to close, we will consume the event to stop
            // automatic closing
            e.consume();
            closeProgram();
        });

        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();

    }

    private void closeProgram()
    {
        Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");

        if(answer)
        {
            System.out.println("Proper close");
            window.close();

        }

    }


}