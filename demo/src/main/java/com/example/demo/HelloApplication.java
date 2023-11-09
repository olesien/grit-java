package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.shape.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World!");

        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        //ScrollPane scroll = new ScrollPane();
        BorderPane main = new BorderPane();
        main.setPadding(new Insets(5, 0, 5, 0));
        main.setStyle("-fx-background-color: ddd;");

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setPrefWrapLength(170); // preferred width allows for two columns

        for (int i = 1; i <= 7; i++) {
            StackPane stack = new StackPane();
            VBox dayBox = new VBox();
            dayBox.minHeight(500.0);
            dayBox.maxWidth(200);
            dayBox.setPadding(new Insets(10, 10, 10, 10));
            dayBox.setStyle("-fx-background-color: eee;");

            Rectangle r = new Rectangle();

            r.setX(0.0f);
            r.setY(0.0f);
            r.setWidth(200.0f);
            r.setHeight(500.0f);
            r.setFill(Color.web("EEEEEE"));

            VBox header = new VBox();
            header.setAlignment(Pos.BASELINE_CENTER);
            header.setPadding(new Insets(0, 0, 20, 0));
            //Start with title
            Text title = new Text();
            title.setText("Monday");
            title.setFont(Font.font("Segone UI", 30));

            Text subtitle = new Text();
            subtitle.setText("6th of November");
            subtitle.setFont(Font.font("Segone UI", 20));

            header.getChildren().addAll(title, subtitle);


            ListView<String> list = new ListView<String>();
            ObservableList<String> items = FXCollections.observableArrayList (
                    "Thing 1", "Thing 2", "Thing 3");
            list.setItems(items);

            TextField textField = new TextField();
            textField.setTooltip(new Tooltip("Enter info"));

            Button btn = new Button();

            btn.setText("Say 'Hello World' for id " + i);
            final int finalI = i;
            btn.setOnAction(event -> System.out.println("Hello World! " + finalI));

            //Add elements
            dayBox.getChildren().addAll(header, list, textField, btn);
            stack.getChildren().add(r);
            stack.getChildren().add(dayBox);
            flow.getChildren().add(stack);
        }
        flow.setAlignment(Pos.BASELINE_CENTER);
        main.setCenter(flow);

        //scroll.setContent(main);
        primaryStage.setScene(new Scene(main, 1500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}