package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Artist {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;

    public Artist() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

//    public SimpleStringProperty nameProperty() {
//        return name;
//    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
