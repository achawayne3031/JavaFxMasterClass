module com.javafxmasterclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafxmasterclass to javafx.fxml;
    exports com.javafxmasterclass;
}