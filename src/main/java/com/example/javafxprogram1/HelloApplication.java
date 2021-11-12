package com.example.javafxprogram1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    //Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        // create an ellipse
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        // create text
        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text);

        Scene scene = new Scene(stackPane, 350, 230, Color.LIGHTYELLOW);

        window = stage;

        window.setTitle("Shapes and Text");
        window.setScene(scene);
        window.show();



    }




}