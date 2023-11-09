module com.linus.linus {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.linus.linus to javafx.fxml;
    exports com.linus.linus;
}