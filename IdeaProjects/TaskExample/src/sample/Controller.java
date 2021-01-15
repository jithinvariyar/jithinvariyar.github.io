package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.security.Provider;

public class Controller {
    @FXML
    private ListView<String> listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label label;

    private Service<ObservableList<String>> service;
    public void initialize(){
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//                Thread.sleep(1000);
//                String[] items = {"Jithin",
//                                  "Jishnu",
//                                  "Raji",
//                                  "Ammini"};
//                ObservableList<String> members = FXCollections.observableArrayList();
//                for(int i = 0 ; i < items.length ; i++){
//                    members.add(items[i]);
//                    updateProgress(i+1,4);
//                    updateMessage("Fetched " + items[i] + " from database");
//                    Thread.sleep(1000);
//                }
//                updateMessage("Completed");
//                return members;
//            }
//        };
        service = new FamilyService();
        progressBar.progressProperty().bind(service.progressProperty());
        progressBar.visibleProperty().bind(service.runningProperty());
        listView.itemsProperty().bind(service.valueProperty());
        label.textProperty().bind(service.messageProperty());
    }
    @FXML
    public void handleButtonClick(){
        if(service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        } else if(service.getState() == Service.State.READY){
            service.start();
        }
    }
}
