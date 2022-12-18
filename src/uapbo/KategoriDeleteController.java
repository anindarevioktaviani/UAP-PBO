package uapbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KategoriDeleteController {
   KategoriModel ktg = new KategoriModel();
    
   @FXML
   private TextField flKategori;

   @FXML
   private Button btnHapus;
   
   @FXML
   private Button btnKembali;
   
   @FXML
   public void hapus (ActionEvent event) throws IOException{
       Kategori ktgo = new Kategori(flKategori.getText());
       ktg.deleteKategori(ktgo);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnHapus.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
   
   @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   } 
    
}
