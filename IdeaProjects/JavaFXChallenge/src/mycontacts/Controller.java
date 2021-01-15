package mycontacts;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import mycontacts.datamodel.Contact;
import mycontacts.datamodel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainWindow;

    @FXML
    private TableView<Contact> contactsTable;

    private ContactData data;

    public void initialize(){
        data = new ContactData();
        data.loadContacts();
        contactsTable.setItems(data.getContacts());

    }

    @FXML
    public void addItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newcontact.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Unable to load Dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get().equals(ButtonType.OK)){
            DialogController dialogController = fxmlLoader.getController();
            Contact newContact = dialogController.getNewContact();
            data.addContact(newContact);
            data.saveContacts();
        }
    }

    @FXML
    public void editItemDialog(){
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if(selectedContact == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a contact you want to edit");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newcontact.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Can't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        DialogController dialogController = fxmlLoader.getController();
        dialogController.editContact(selectedContact);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            dialogController.updateContact(selectedContact);
            data.saveContacts();
        }
    }

    @FXML
    public void deleteContact(){
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if (selectedContact == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a contact you want to delete");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)){
            data.deleteContact(selectedContact);
            data.saveContacts();
        }
    }




}
