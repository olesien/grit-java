package com.calendar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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

        //HBox nav = new HBox();
        Pagination pagination = new Pagination();
        pagination.setPageCount(21);
        pagination.setCurrentPageIndex(3);
        pagination.setMaxPageIndicatorCount(1);

        /*pagination.setPageFactory((pageIndex) -> {

            Label label1 = new Label("Content for page with index: " + pageIndex);
            label1.setFont(new Font("Arial", 24));

            Label label2 = new Label("Main content of the page ...");

            return new VBox(label1, label2);
        });*/

        VBox nav = new VBox(pagination);

        main.setBottom(nav);

    }
}
