package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Customer customer = new Customer();
        customer.setName("Jithin");
        System.out.println(customer.nameProperty().getValue());
        System.out.println(customer.nameProperty().getName());
        System.out.println(customer.nameProperty().getBean());
        Circle circle = new Circle();
        System.out.println(circle.radiusProperty().getBean());
        System.out.println(circle.radiusProperty().getName());
        System.out.println(circle.radiusProperty().getValue());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
