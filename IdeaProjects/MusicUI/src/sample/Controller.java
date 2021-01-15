package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import sample.model.Album;
import sample.model.Artist;
import sample.model.DataSource;
import sample.model.Song;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView artistTable;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button listArtists;
    @FXML
    private Button showAlbums;
    @FXML
    private Button showSongs;
    @FXML
    private Button updateArtist;

    @FXML
    public void listArtists(){
        listArtists.setEffect(new Bloom());
        showAlbums.setEffect(null);
        updateArtist.setEffect(null);
        showSongs.setEffect(null);
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        progressBar.progressProperty().bind(task.progressProperty());

        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));
        new Thread(task).start();
    }

    public void listSongsOfAlbum(){
        listArtists.setEffect(null);
        updateArtist.setEffect(null);
        showAlbums.setEffect(null);
        showSongs.setEffect(new Bloom());
        Object albumObject = artistTable.getSelectionModel().getSelectedItem();
        Task<ObservableList<Song>> task = new Task<>() {
            @Override
            protected ObservableList<Song> call() throws Exception {
                Album album = (Album)albumObject;
                int id = album.getId();
                List<Song> songs = DataSource.getInstance().querySongByAlbum(id);
                return FXCollections.observableArrayList(songs);
            }
        };

        artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void handleShowAlbumsOfArtist(){
        listArtists.setEffect(null);
        showAlbums.setEffect(new Bloom());
        updateArtist.setEffect(null);
        showSongs.setEffect(null);
        Object artistObject = artistTable.getSelectionModel().getSelectedItem();  //The selected item should be accessed here because it runs in previous thread if we go into task method below it is an another thread. so we have to access it before leaving this thread
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                Artist artist = (Artist)artistObject;
                int id = artist.getId();
                List<Album> albums = DataSource.getInstance().queryAlbumsForArtistId(id);
                return FXCollections.observableArrayList(albums);
            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void handleDialogButton(){
        listArtists.setEffect(null);
        showAlbums.setEffect(null);
        updateArtist.setEffect(new Bloom());
        showSongs.setEffect(null);
        Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if(artist == null){
            return;
        }
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Update Artist Name");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("dialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        DialogController controller = fxmlLoader.getController();
        controller.initialising(artist);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            controller.process(artist);
            listArtists();
        }
    }

}

class GetAllArtistsTask extends Task<ObservableList<Artist>>{
    @Override
    public ObservableList<Artist> call() {
        return FXCollections.observableArrayList(DataSource.getInstance().queryArtists(DataSource.ORDER_BY_ASC));
    }
}