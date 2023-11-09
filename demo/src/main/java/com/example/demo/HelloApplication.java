package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World!");

        //StackPane root = new StackPane();
        //root.getChildren().add(btn);

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        for (int i = 0; i < 8; i++) {
            Button btn = new Button();
            btn.setText("Say 'Hello World' for id " + i);
            final int finalI = i;
            btn.setOnAction(event -> System.out.println("Hello World! " + finalI));
            flow.getChildren().add(btn);
        }

        primaryStage.setScene(new Scene(flow, 1500, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}