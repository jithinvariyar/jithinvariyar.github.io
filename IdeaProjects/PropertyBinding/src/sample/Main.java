package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Label label = new Label("Hai");
        TextField text = new TextField("Hello");
        label.textProperty().bindBidirectional(text.textProperty());
        text.setText("Updated");
        System.out.println(text.getText() + "\n" + label.getText());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
