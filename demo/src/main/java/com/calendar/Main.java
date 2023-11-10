package com.calendar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        CustomCalendar calendar = new CustomCalendar();

        //weekday.getDayOfWeek(5);

        primaryStage.setTitle("Hello World!");
        UserInterface UI = new UserInterface(calendar);

        //scroll.setContent(main);
        primaryStage.setScene(new Scene(UI.main, 1500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}