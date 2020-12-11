module JavaFXChallenge {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.xml;
    opens mycontacts;
    opens mycontacts.datamodel;
}