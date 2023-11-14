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
    public FlowPane flow;
    void renderDays(CustomCalendar calendar) {
        flow.getChildren().clear();
        for (int i = 1; i <= 7; i++) {
            DayUI dayui = new DayUI(calendar.getDayOfWeek(i), calendar);
            flow.getChildren().add(dayui.stack);
        }
    }
    UserInterface(CustomCalendar calendar) {
        main = new BorderPane();
        main.setPadding(new Insets(5, 0, 5, 0));
        main.setStyle("-fx-background-color: ddd;");

        flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setPrefWrapLength(170); // preferred width allows for two columns

        renderDays(calendar);

        flow.setAlignment(Pos.BASELINE_CENTER);
        main.setCenter(flow);

        HBox nav = new HBox();
        nav.setAlignment(Pos.CENTER);

        Text currentWeek = new Text("V. " + String.valueOf(calendar.getWeekOfYear()));
        currentWeek.setWrappingWidth(60);
        currentWeek.setTextAlignment(TextAlignment.CENTER);

        Button prevWeekBtn = new Button("<");
        prevWeekBtn.setOnAction(e -> {
            currentWeek.setText("V. " + String.valueOf(calendar.prevWeek()));
            renderDays(calendar); //Rerender
        });

        Button nextWeekBtn = new Button(">");
        nextWeekBtn.setOnAction(e -> {
            currentWeek.setText("V. " + String.valueOf(calendar.nextWeek()));
            renderDays(calendar); //Rerender
        });
        nav.getChildren().addAll(prevWeekBtn, currentWeek, nextWeekBtn);

        main.setBottom(nav);

    }
}
