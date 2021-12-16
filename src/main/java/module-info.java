module com.example.knightsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Interface to javafx.fxml;
    exports Interface;
}