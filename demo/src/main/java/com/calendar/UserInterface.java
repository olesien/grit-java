package com.calendar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class UserInterface {
    public BorderPane main;
    UserInterface(CustomCalendar calendar) {
        main = new BorderPane();
        main.setPadding(new Insets(5, 0, 5, 0));
        main.setStyle("-fx-background-color: ddd;");

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setPrefWrapLength(170); // preferred width allows for two columns

        for (int i = 1; i <= 7; i++) {
            DayUI dayui = new DayUI(calendar.getDayOfWeek(i), calendar);
            flow.getChildren().add(dayui.stack);
        }
        flow.setAlignment(Pos.BASELINE_CENTER);
        main.setCenter(flow);

        HBox nav = new HBox();
        nav.setAlignment(Pos.CENTER);
        Button prevWeekBtn = new Button("<");

        Text currentWeek = new Text("V. " + String.valueOf(calendar.getWeekOfYear()));
        currentWeek.setWrappingWidth(60);
        currentWeek.setTextAlignment(TextAlignment.CENTER);

        Button nextWeekBtn = new Button(">");
        nav.getChildren().addAll(prevWeekBtn, currentWeek, nextWeekBtn);




        main.setBottom(nav);

    }
}
