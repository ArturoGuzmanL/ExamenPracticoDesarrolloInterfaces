module com.example.examenpracticointerfaces {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examenpracticointerfaces to javafx.fxml;
    exports com.example.examenpracticointerfaces;
}