package com.linus.linus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    Stage window;
    Scene scene1, scene2;
    Button button;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        window = stage;

        Label label1 = new Label("Welcome to the first secene!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children are laid out in a vertical column;
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        //btn 2
        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));


        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        stage.setScene(scene1);
        window.setTitle("Wow a title");
        stage.show();
        /*stage.setTitle("Hello!");
        button = new Button();
        button.setText("CLICK ME NOWWW");

        button.setOnAction(e -> System.out.println("hey"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();*/
    }


}