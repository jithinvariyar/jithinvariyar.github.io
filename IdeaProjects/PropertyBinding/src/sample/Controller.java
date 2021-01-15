package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class Controller {
    public void initialize(){
        number = new Number();
        i = 0;
        pi.progressProperty().bind(number.myNumProperty());
        pb.progressProperty().bind(number.myNumProperty());
    }

    Number number;
    int i;
    @FXML
    private Label label;

    @FXML
    private ProgressBar pb;

    @FXML
    private ProgressIndicator pi;

    @FXML
    public void handlePlusClicked(){
        i = i + 1;
        number.setMyNum(i);
    }

    @FXML
    public void handleMinusClicked(){
        i = i - 1;
        number.setMyNum(i);
    }
}
