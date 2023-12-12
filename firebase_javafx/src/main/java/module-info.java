module org.linus.firebase_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens org.linus.firebase_javafx to javafx.fxml;
    exports org.linus.firebase_javafx;
}