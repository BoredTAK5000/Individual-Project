module com.example.individual_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.individual_project to javafx.fxml;
    exports com.example.individual_project;
}