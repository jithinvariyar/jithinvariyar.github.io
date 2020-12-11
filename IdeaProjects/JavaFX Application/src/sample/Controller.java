package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private WebView webView;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button button4;

    public void initialize(){
        button4.setEffect(new BoxBlur());
        label.setEffect(new Reflection());
    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleY(1.0);
        label.setScaleX(1.0);
    }

    @FXML
    public void handleFileClick(){

        FileChooser chooser = new FileChooser();
        chooser.setTitle("File Chooser");
        chooser.setInitialFileName("untitled");
        chooser.setInitialDirectory(new File("/home/jithin/Downloads"));
        FileChooser.ExtensionFilter pdfFile = new FileChooser.ExtensionFilter("PDF","*.pdf");

        chooser.setSelectedExtensionFilter(pdfFile);
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                pdfFile,
                new FileChooser.ExtensionFilter("Image files","*.jpg","*.png","*.gif"),
                new FileChooser.ExtensionFilter("All files","*.*")
        );


        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        if(file != null){
            System.out.println(file.getPath());
        }else {
            System.out.println("Chooser was cancelled");
        }
        List<File> files = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if(files == null){
            System.out.println("Chooser was cancelled");
        }else{
            for(int i = 0 ; i < files.size() ; i++){
                System.out.println(files.get(i).getPath());
            }
        }


    }

    @FXML
    public void handleLinkClick(){
//        try {
//            System.out.println(Desktop.isDesktopSupported());
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
//        } catch (IOException e){
//            e.printStackTrace();
//        } catch (URISyntaxException e){
//            e.printStackTrace();
//        }

        WebEngine engine = webView.getEngine();
        engine.load("http://javafx.com");

    }

    @FXML
    public void handleDirectoryClick(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Directory");
        chooser.setInitialDirectory(new File("/home/jithin/Documents/IdeaProjects/JavaFX Application/out/production"));
        File file = chooser.showDialog(gridPane.getScene().getWindow());
        if(file != null){
            System.out.println(file.getPath());
        }else {
            System.out.println("Chooser was cancelled.");
        }
    }











}
