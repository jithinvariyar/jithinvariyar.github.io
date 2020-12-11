package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.model.Artist;
import sample.model.DataSource;

public class DialogController {
   @FXML
    private TextField currentNameField;

   @FXML
   private TextField newNameField;

   public void initialising(Artist artist){
       currentNameField.setText(artist.getName());
   }

   public void process(Artist artist){
       String name = newNameField.getText();
       DataSource.getInstance().updateArtistName(artist.getId(),name);
   }
}
