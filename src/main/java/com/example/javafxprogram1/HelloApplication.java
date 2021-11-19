package com.example.javafxprogram1;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableObjectValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;


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
        // linear gradient stops
        Stop[] stops = new Stop[] { new Stop(0, Color.DODGERBLUE),
                new Stop(0.5, Color.LIGHTBLUE),
                new Stop(1.0, Color.LIGHTGREEN) };

        // vertical gradient (x is constant)
        // startX=0, startY=0, endX=0, endY=1
        LinearGradient verticalGradient = new LinearGradient(0, 0, 0, 1,
                true, CycleMethod.NO_CYCLE, stops);
        // horizontal gradient (y is constant)
        // startX=0, startY=0, endX=1, endY=0
        LinearGradient  horizontalGradient = new LinearGradient(0,0,1,0,
                true, CycleMethod.NO_CYCLE, stops);


        // create an ellipse with drop shadow and gradient
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);
        ellipse.setEffect(new DropShadow(30, 10, 10, Color.GRAY));
        ellipse.setFill(horizontalGradient);


        // create text 1 & 2
        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24));

        Text text2 = new Text();
        text2.setFont(new Font("Arial Bold", 18));

        Text text3 = new Text("Animation Status: ");
        text3.setFont(new Font("Arial Bold", 18));

        // reflection
        Reflection r = new Reflection();
        r.setFraction(0.8);
        r.setTopOffset(1.0);
        text.setEffect(r);
        text2.setEffect(r);

        // create stackpane node, vBox is the root
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text);
        VBox vBox = new VBox(stackPane, text2);
        vBox.setSpacing(100.0);
        VBox vBoxRoot = new VBox(vBox, text3);
        vBoxRoot.setSpacing(50.0);

        // RotationTransition for stackpane node
        RotateTransition rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR);

        // invalidation listener using lambda expression
        rotate.statusProperty().addListener(observable -> {
            text3.setText("Animation status: " + rotate.getStatus());
        });

        // Change Listener using lambda expression
        rotate.statusProperty().addListener((observableValue, oldValue, newValue) -> {
            text2.setText("Was " + oldValue + ", Now " + newValue);
        });



        // mouse click handler for rotation
        stackPane.setOnMouseClicked(mouseEvent -> {
            if(rotate.getStatus().equals(Animation.Status.RUNNING))
            {
                rotate.pause();
            }
            else
            {
                rotate.play();
            }
        });

        text2.rotateProperty().bind(stackPane.rotateProperty());
        text3.rotateProperty().bindBidirectional(text2.rotateProperty());





       Scene scene = new Scene(vBoxRoot, 350, 350, Color.LIGHTYELLOW);

        window = stage;

        window.setTitle("Practice");
        window.setScene(scene);
        window.show();



    }




}