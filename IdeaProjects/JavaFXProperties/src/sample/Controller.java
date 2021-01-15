package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Label myLabel;

    @FXML
    private Button button;

    int i = 1;


    public void initialize(){

        button.onMouseClickedProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                myLabel.setText(Integer.toString(i));
                i++;
            }
        });
    }

    @FXML
    public void handleButtonClick(){
        button.setText("Increment");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Button clicked");
            }
        });
    }
}
