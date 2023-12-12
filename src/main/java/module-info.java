module programmingtechnology.observer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens programmingtechnology.observer.controllers to javafx.controls, javafx.graphics, javafx.fxml;
    opens programmingtechnology.observer to javafx.fxml;
    exports programmingtechnology.observer;
}