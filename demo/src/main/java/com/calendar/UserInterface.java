package com.calendar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class UserInterface {

    public ScrollPane scrollBody;
    public BorderPane body;
    public HBox header;

    public FlowPane main;
    void renderDays(CustomCalendar calendar) {
        main.getChildren().clear();
        //Loop to get monday to sunday, where monday is 1.
        //Get day of week compares the current day number of the week, then adds or removes days based on that.
        //Eg, if i is 2, and we are on monday, we want to add 1 day to the date. If we are on wednesday and i is 1, we remove 2.
        for (int i = 1; i <= 7; i++) {
            DayUI dayui = new DayUI(calendar.getDayOfWeek(i), calendar);
            main.getChildren().add(dayui.stack);
        }
    }
    UserInterface(CustomCalendar calendar) {


        //Calendar Header
        Text calendarTitle = new Text("Calendar of " + String.valueOf(calendar.getYear()));
        calendarTitle.setFont(Font.font("Segone UI", 22));
        header = new HBox(calendarTitle);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10, 10, 10, 10));

        //Define the body layout (all)
        body = new BorderPane();

        scrollBody = new ScrollPane(body); //Make a scroll body around it so that if it's a small screen, we can scroll
        scrollBody.setFitToWidth(true);
        scrollBody.setStyle("-fx-background-color: ddd;");

        body.setPadding(new Insets(5, 0, 5, 0));
        body.setTop(header);

        //the actual calendar
        main = new FlowPane();
        main.setPadding(new Insets(5, 0, 5, 0));
        main.setVgap(10);
        main.setHgap(10);
        main.setPrefWrapLength(170); // preferred width allows for two columns

        renderDays(calendar);

        main.setAlignment(Pos.BASELINE_CENTER);
        body.setCenter(main);

        HBox nav = new HBox();
        nav.setPadding(new Insets(10, 0, 10, 0));
        nav.setAlignment(Pos.CENTER);

        Text currentWeek = new Text("V. " + String.valueOf(calendar.getWeekOfYear()));
        currentWeek.setWrappingWidth(60);
        currentWeek.setTextAlignment(TextAlignment.CENTER);

        Button prevWeekBtn = new Button("<");
        prevWeekBtn.setOnAction(e -> {
            currentWeek.setText("V. " + String.valueOf(calendar.prevWeek()));
            calendarTitle.setText("Calendar of " + String.valueOf(calendar.getYear()));
            renderDays(calendar); //Rerender
        });

        Button nextWeekBtn = new Button(">");
        nextWeekBtn.setOnAction(e -> {
            currentWeek.setText("V. " + String.valueOf(calendar.nextWeek()));
            calendarTitle.setText("Calendar of " + String.valueOf(calendar.getYear()));
            renderDays(calendar); //Rerender
        });
        nav.getChildren().addAll(prevWeekBtn, currentWeek, nextWeekBtn);

        body.setBottom(nav);

    }
}
