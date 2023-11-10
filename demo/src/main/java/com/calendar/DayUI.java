package com.calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.time.DayOfWeek;
import java.util.List;

public class DayUI {
    StackPane stack;
    DayUI(CustomDate currentDate, CustomCalendar calendar) {
        stack = new StackPane();
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
        title.setText(currentDate.weekday);
        title.setFont(Font.font("Segone UI", 30));

        Text subtitle = new Text();
        subtitle.setText(currentDate.dayAndMonth);
        subtitle.setFont(Font.font("Segone UI", 20));

        header.getChildren().addAll(title, subtitle);


        ListView<String> list = new ListView<String>();
        List<String> events = calendar.getEventNamesByDate(currentDate.date);
        list.setItems( FXCollections.observableArrayList(events));

        TextField textField = new TextField();
        textField.setTooltip(new Tooltip("Enter info"));

        Button btn = new Button();

        btn.setText("Add Event");
        btn.setOnAction(event -> {
            calendar.addEvent(new Event(currentDate.date, textField.getText()));
            System.out.println(calendar.getEventNamesByDate(currentDate.date));
            textField.setText("");
            list.setItems( FXCollections.observableArrayList(calendar.getEventNamesByDate(currentDate.date)));
        });

        //Add elements
        dayBox.getChildren().addAll(header, list, textField, btn);
        stack.getChildren().add(r);
        stack.getChildren().add(dayBox);
    }
}
