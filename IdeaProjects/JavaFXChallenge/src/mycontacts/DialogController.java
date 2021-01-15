package mycontacts;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mycontacts.datamodel.Contact;
import org.w3c.dom.Text;

public class DialogController {
    @FXML
    private TextField fNameField;

    @FXML
    private TextField lNameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField notesField;

    public Contact getNewContact(){
        String fName = fNameField.getText().isEmpty() ? "null" : fNameField.getText();
        String lName = lNameField.getText().isEmpty() ? "null" : lNameField.getText();
        String phoneNumber = phoneField.getText().isEmpty() ? "null" : phoneField.getText();
        String notes = notesField.getText().isEmpty() ? "null" : notesField.getText();
        Contact newContact = new Contact(fName,lName,phoneNumber,notes);
        return newContact;
    }

    public void editContact(Contact contact){
        fNameField.setText(contact.getFirstName());
        lNameField.setText(contact.getLastName());
        phoneField.setText(contact.getPhoneNumber());
        notesField.setText(contact.getNotes());
    }

    public void updateContact(Contact contact){
        if(fNameField.getText().isEmpty())
            fNameField.setText("null");
        if(lNameField.getText().isEmpty())
            lNameField.setText("null");
        if(phoneField.getText().isEmpty())
            phoneField.setText("null");
        if(notesField.getText().isEmpty())
            notesField.setText("null");
        contact.setFirstName(fNameField.getText());
        contact.setLastName(lNameField.getText());
        contact.setPhoneNumber(phoneField.getText());
        contact.setNotes(notesField.getText());
    }

}
