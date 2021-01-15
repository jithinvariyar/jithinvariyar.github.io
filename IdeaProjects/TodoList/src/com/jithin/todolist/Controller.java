package com.jithin.todolist;

import com.jithin.todolist.datamodel.TodoData;
import com.jithin.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private ToggleButton filterToggleButton;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadLineLabel;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;

    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> showToday;

    private Predicate<TodoItem> showAll;

    public void initialize(){
//        TodoItem item1 = new TodoItem("Mail birthday card","Buy a 23rd birthday card for Sruthy", LocalDate.of(2020, Month.JUNE,3));
//        TodoItem item2 = new TodoItem("Study SQL","Study the newly purchased course in udemy", LocalDate.of(2020, Month.JUNE,5));
//        TodoItem item3 = new TodoItem("Refund status","Check the refund status of returned item in Club Factory application", LocalDate.of(2020, Month.JUNE,10));
//        TodoItem item4 = new TodoItem("Dentist","Accompany vallyamma to the dentist at Thavanur", LocalDate.of(2020, Month.JUNE,11));
//        TodoItem item5 = new TodoItem("Jam","Buy Jam for the bread and butter", LocalDate.of(2020, Month.JUNE,5));
//
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//        TodoData.getInstance().setTodoItems(todoItems);

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        MenuItem editTodoItem = new MenuItem("Edit");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        editTodoItem.setOnAction(actionEvent -> {TodoItem item = todoListView.getSelectionModel().getSelectedItem();
            editItem(item);});
        deleteMenuItem.setOnAction(actionEvent -> {TodoItem item = todoListView.getSelectionModel().getSelectedItem();
            deleteItem(item);});
        listContextMenu.getItems().addAll(deleteMenuItem,separator,editTodoItem);
        todoListView.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
            if(newValue != null){
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                itemDetailsTextArea.setText(item.getDetails());
                itemDetailsTextArea.setFont(new Font(16));
                DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                deadLineLabel.setText(df.format(item.getDeadLine()));
            }
        });

        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(),todoItem -> true);
        showToday = todoItem -> todoItem.getDeadLine().equals(LocalDate.now());
//        showToday = new Predicate<TodoItem>() {
//            @Override
//            public boolean test(TodoItem item) {
//                return item.getDeadLine().equals(LocalDate.now());
//            }
//        };

        showAll = todoItem -> true;
//        showAll = new Predicate<TodoItem>() {
//            @Override
//            public boolean test(TodoItem item) {
//                return true;
//            }
//        };


        SortedList<TodoItem> sortedList = new SortedList<>(filteredList,(todoItem1,todoItem2) -> todoItem1.getDeadLine().compareTo(todoItem2.getDeadLine()));
//        SortedList<TodoItem> sortedList = new SortedList<>(filteredList, new Comparator<TodoItem>() {
//            @Override
//            public int compare(TodoItem o1, TodoItem o2) {
//                return o1.getDeadLine().compareTo(o2.getDeadLine());
//            }
//        });
//        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>(){
                    @Override
                    protected void updateItem(TodoItem item, boolean b) {
                        super.updateItem(item, b);
                        if(b){
                            setText(null);
                        }
                        else {
                            setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    setEffect(new Glow());
                                }
                            });

                            setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    setEffect(null);
                                }
                            });
                            setFont(Font.font("Chilanka", FontWeight.BOLD, 20));
                            setText(item.getShortDescription());
                            if(item.getDeadLine().isBefore(LocalDate.now().plusDays(1))){
                                setTextFill(Color.RED);
                            }
                            else if(item.getDeadLine().equals(LocalDate.now().plusDays(1))){
                                setTextFill(Color.BROWN);
                            }
                            else {
                                setTextFill(Color.WHITE);
                            }
                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if(isNowEmpty){
                                cell.setContextMenu(null);
                            }
                            else {
                                cell.setContextMenu(listContextMenu);
                            }
                        });
                return cell;
            }
        });
    }

    @FXML
    public void handleFilterButton(){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(filterToggleButton.isSelected()){
            filteredList.setPredicate(showToday);
            if(filteredList.isEmpty()){
                itemDetailsTextArea.clear();
                deadLineLabel.setText(null);
            }
            else{
                if(filteredList.contains(selectedItem)) {
                    todoListView.getSelectionModel().select(selectedItem);
                } else {
                    todoListView.getSelectionModel().selectFirst();
                }
            }



        } else {
            filteredList.setPredicate(showAll);
            todoListView.getSelectionModel().selectFirst();
        }
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
//        dialog.setHeaderText("This is header text of Dialog");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
            System.out.println("OK pressed.");
        }
        else {
            System.out.println("Cancel pressed.");
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        if(item != null){
            if(keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(item);
            }
        }
    }

    @FXML
    public void closeApplication(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to exit the application?");
        alert.setTitle("Confirm Exit");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Platform.exit();
        }
    }
    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadLineLabel.setText(item.getDeadLine().toString());
        // System.out.println("The selected item is " +item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadLine().toString());
//        System.out.println(sb.substring(0,5));
//        itemDetailsTextArea.setText(sb.toString());
    }

    public void deleteItem(TodoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete Item: " + item.getShortDescription());
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            TodoData.getInstance().deleteTodoItem(item);
        }
        if (todoListView.getItems().isEmpty()){
            itemDetailsTextArea.clear();
            deadLineLabel.setText("");
        }
    }

    public void editItem(TodoItem item){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit Todo Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        DialogController controller = fxmlLoader.getController();
        controller.initial(item);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            TodoItem newItem = controller.editItem(item);
            todoListView.getSelectionModel().select(newItem);
        }
    }

}

