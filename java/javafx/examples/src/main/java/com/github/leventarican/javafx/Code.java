package com.github.leventarican.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Memory
 * 
 * @author levent
 */
public class Code extends Application {

    TilePane root;
    double time;

    @Override
    public void init() throws Exception {
        root = new TilePane();
        root.setMaxWidth(400.0);

    }

    Rectangle rect() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.valueOf("#6d9c79"));

        rectangle.setOnMouseClicked(event -> {
            System.out.println("#");
            time = 0.0;
            rectangle.setFill(Color.valueOf("#1fb4ff"));
        });

        return rectangle;
    }

    void uiComponents() {
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setHgap(30);
        root.setVgap(30);

        root.getChildren().add(rect());
        root.getChildren().add(rect());
        root.getChildren().add(rect());

        root.getChildren().add(rect());
        root.getChildren().add(rect());
        root.getChildren().add(rect());
    }

    void mainLoop() {
        AnimationTimer loop = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                time += 0.05;
                if (time > 5.0) {
                    root.getChildren().forEach((r) -> {
                        ((Rectangle) r).setFill(Color.valueOf("#6d9c79"));
                    });
                }
            }
        };
        loop.start();
    }

    @Override
    public void start(Stage stage) throws Exception {

        uiComponents();
        mainLoop();

        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
