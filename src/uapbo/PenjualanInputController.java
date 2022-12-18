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

public class PenjualanInputController implements Initializable {
   PenjualanModel pj =new PenjualanModel();
     @FXML
    private TextField flHarga;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flNama;

    @FXML
    private TextField flStok;

    @FXML
    private Button btnKembali;


    @FXML
    private Button btnTambah;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   public void kembali (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
   }

    @FXML
   public void tambah (ActionEvent event) throws IOException{
       Penjualan p1 = new Penjualan(flNama.getText(),Integer.parseInt(flJumlah.getText()),Integer.parseInt(flStok.getText()),Double.parseDouble(flHarga.getText()));
       pj.addPenjualan(p1);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah.getScene().getWindow();
       stage.setScene(new Scene(root));
   }
    
}
