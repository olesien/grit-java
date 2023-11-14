package com.calendar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        CustomCalendar calendar = new CustomCalendar();

        primaryStage.setTitle("Hello World!");
        UserInterface UI = new UserInterface(calendar);

        primaryStage.setScene(new Scene(UI.main, 1500, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}