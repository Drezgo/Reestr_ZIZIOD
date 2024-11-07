module com.individualproject_v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.individualproject_v2 to javafx.fxml;
    exports com.individualproject_v2;
}