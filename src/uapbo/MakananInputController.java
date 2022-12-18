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

public class MakananInputController {
    MakananModel mkn = new MakananModel();
    
    @FXML
    private TextField flDayatahan;

    @FXML
    private TextField flDiskon;

    @FXML
    private TextField flHarga;

    @FXML
    private TextField flId;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flNama;


    @FXML
    private Button btnTambah;
    
    @FXML
    private Button btnKembali;
    
    @FXML
   public void tambah (ActionEvent event) throws IOException{
       Makanan mkn1 = new Makanan(Integer.parseInt(flId.getText()),flNama.getText(),Double.parseDouble(flHarga.getText()),Integer.parseInt(flJumlah.getText()), Double.parseDouble(flDiskon.getText()), Integer.parseInt(flDayatahan.getText()));
       mkn.addMakanan(mkn1);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("MakananOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
   
   @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("MakananOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   } 
    
}
