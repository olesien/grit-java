package org.linus.firebase_javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    Firebase firebase = new Firebase("https://java-test-de4c6-default-rtdb.europe-west1.firebasedatabase.app/notes.json");

    @FXML
    private TextField note;

    public HelloController() throws MalformedURLException {
    }

    @FXML
    protected void onSaveClick() {
        System.out.println("Hi");

        System.out.println(note.getText());

        try {
            firebase.setNote(note.getText());
        } catch (IOException err) {
            System.out.println(err);
        }
    }


    void getData() {
       note.setText(firebase.getNote());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Run on start
        getData();
    }
}