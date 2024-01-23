module com.example.threebody {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threebody to javafx.fxml;
    exports com.example.threebody;
}