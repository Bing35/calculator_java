module it.app {
    requires javafx.controls;
    requires javafx.fxml;
    opens it.app to javafx.fxml;
    exports it.app;
}