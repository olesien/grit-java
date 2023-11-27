package com.calendar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CustomCalendar calendar = new CustomCalendar();

        primaryStage.setTitle("Calendar");
        UserInterface UI = new UserInterface(calendar);

        primaryStage.setScene(new Scene(UI.scrollBody, 1500, 620));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}