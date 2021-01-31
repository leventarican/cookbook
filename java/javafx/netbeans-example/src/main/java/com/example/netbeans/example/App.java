package com.example.netbeans.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    void fxParameters() {
        System.out.println("# FX parameters");
        getParameters().getRaw().forEach(System.out::println);
        getParameters().getNamed().forEach((k, v) -> System.out.println(k + " = " + v));
        getParameters().getUnnamed().forEach(System.out::println);
    }

    Circle aCircle() {
        Circle circle = new Circle();
        circle.setCenterX(200);
        circle.setCenterY(200);
        circle.setRadius(50);
        circle.setStroke(Color.valueOf("#aaaabb"));
        circle.setStrokeWidth(5);
        circle.setFill(Color.TRANSPARENT);
        return circle;
    }

    Rectangle aRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(200);
        rectangle.setY(200);
        rectangle.setWidth(100);
        rectangle.setHeight(150);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.valueOf("#00ff00"));
        return rectangle;
    }

    Label aLabel() {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        return label;
    }

    @Override
    public void start(Stage stage) {

        fxParameters();
        var label = aLabel();
        
        var pane = new Pane();
        
        pane.getChildren().add(aRectangle());
        pane.getChildren().add(aCircle());

        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.setTitle("javafx dev with netbeans");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
