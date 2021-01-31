package com.github.leventarican.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Levent
 */
public class LoginExample extends Application {

    private Label label;
    
    @Override
    public void init() throws Exception {
        var javaVersion = System.getProperty("java.version");
        var javafxVersion = System.getProperty("javafx.version");
        label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        var gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(16, 16, 16, 16));
        gridPane.setVgap(5);
        gridPane.setHgap(5);      
        gridPane.setAlignment(Pos.CENTER);
        
        var tvUser = new Text("user");
        var tvPassword = new Text("password");
        var teUser = new TextField();
        var tePassword = new PasswordField();
        var btLogin = new Button("login");
        var btClear = new Button("clear");
        
        btLogin.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");
        btLogin.setOnAction((e) -> {
            System.out.println("action name: " + ((ActionEvent) e).getEventType().getName());
            System.out.println("open a new window");
            var start = new Stage();
            start.show();
        });
        
        gridPane.add(tvUser, 0, 0);
        gridPane.add(teUser, 1, 0);
        gridPane.add(tvPassword, 0, 1);  
        gridPane.add(tePassword, 1, 1);
        gridPane.add(btLogin, 0, 2);
        gridPane.add(btClear, 1, 2);
        
        var scene = new Scene(gridPane);
        stage.setTitle("JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
