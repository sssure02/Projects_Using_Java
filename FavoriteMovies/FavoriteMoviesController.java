
package proj3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;

public class FavoriteMoviesController implements Initializable {
        
    @FXML
    private ListView<String> listMovie = new ListView<String>();
    
    @FXML
    private TextField laddMovie = new TextField();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void OnAdd(ActionEvent event) {
        listMovie.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        String newMovie = laddMovie.getText();
        String newText = newMovie.trim().toLowerCase();
        ObservableList<String> currentList = listMovie.getItems();
        currentList.add(newText);
        listMovie.setItems(currentList);
        laddMovie.clear();
    }

    // To remove more than one item on the list, you can select multiple items using the shift button. 
    @FXML
    private void OnRemove(ActionEvent event) {
        ObservableList<Integer> selectedInd = listMovie.getSelectionModel().getSelectedIndices();
        if(selectedInd.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select an item to delete!");
            alert.showAndWait();
        } else if(selectedInd.size() >= 1){
            ObservableList<String> currentList = listMovie.getItems();
            SortedList<Integer> sorted_selectedInd = selectedInd.sorted();
            for(int i = selectedInd.size() - 1; i >= 0; i--){
               currentList.remove(selectedInd.get(i), selectedInd.get(i)+1); }
            listMovie.setItems(currentList);
            listMovie.getSelectionModel().clearSelection();
        } 
    }

    @FXML
    private void OnLoad(ActionEvent event) {
       listMovie.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Path productsPath = Paths.get("movies.txt");
        File productsFile = productsPath.toFile();
        ObservableList<String> names = listMovie.getItems();
        names.remove(0, names.size());
        try{
            BufferedReader in = new BufferedReader(new FileReader(productsFile));
            String name = in.readLine();
            while(name != null){
                names.add(name);
                name = in.readLine();
            }
            in.close();
        } catch(IOException ex) {
            System.out.println(ex);
        }
        listMovie.setItems(names);
    }

    @FXML
    private void OnSave(ActionEvent event) {
        Path productsPath = Paths.get("movies.txt");
        File productsFile = productsPath.toFile();
        ObservableList<String> names = listMovie.getItems();
        PrintWriter pw;
        if(Files.exists(productsPath)){
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(productsFile)))){
                for(String name : names){
                   out.println(name);
               }
                out.close();
            } catch(IOException e){
                System.out.println(e);
            }
        } else {
            try{
               pw = new PrintWriter("movies.txt");
               for(String name : names){
                   pw.println(name);
               }
               pw.close();
           }
           catch(FileNotFoundException ex) {
               System.out.println(ex);
           }
        
        }
    }
    
}
