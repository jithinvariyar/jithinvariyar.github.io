package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FamilyService extends Service<ObservableList<String>>{
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                String[] items = {
                        "Jithin",
                        "Jishnu",
                        "Raji",
                        "Ammini"};
                ObservableList<String> members = FXCollections.observableArrayList();
                for (int i = 0; i < items.length; i++) {
                    members.add(items[i]);
                    updateProgress(i + 1, 4);
                    updateMessage("Fetched " + items[i] + " from database");
                    Thread.sleep(1000);
                }
                updateMessage("Completed");
                return members;
            }
        };
    }
}
