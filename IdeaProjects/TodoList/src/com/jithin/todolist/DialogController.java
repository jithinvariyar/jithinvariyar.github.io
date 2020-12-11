package com.jithin.todolist;

import com.jithin.todolist.datamodel.TodoData;
import com.jithin.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadLinePicker;


    public TodoItem processResults(){
        String shortDescription = (shortDescriptionField.getText().trim().isEmpty()) ?  "Nothing has entered here" : shortDescriptionField.getText().trim();
        String details = (detailsArea.getText().trim().isEmpty()) ? "Nothing has entered here" : detailsArea.getText().trim();
        LocalDate deadLineValue = (deadLinePicker.getValue() == null) ? LocalDate.now() : deadLinePicker.getValue();
        TodoItem newItem = new TodoItem(shortDescription,details,deadLineValue);
        TodoData.getInstance().addTodoItems(newItem);
        return newItem;
    }

    public void initial(TodoItem item){
        shortDescriptionField.setText(item.getShortDescription());
        detailsArea.setText(item.getDetails());
        deadLinePicker.setValue(item.getDeadLine());
    }

    public TodoItem editItem(TodoItem item){
        TodoData.getInstance().getTodoItems().remove(item);
        return processResults();
    }
}
