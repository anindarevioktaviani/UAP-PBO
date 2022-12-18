package uapbo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BarangInputController {
    BarangModel brg = new BarangModel();

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TextField flBar;

    @FXML
    private TextField flDiskon;

    @FXML
    private TextField flExpired;

    @FXML
    private TextField flHarga;

    @FXML
    private TextField flJumlah;

    @FXML
    private TextField flKategori;

    @FXML
    private TextField flNama;

    @FXML
    void kembali(ActionEvent event)throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("BarangOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event)throws IOException{
       Barang brg1 = new Barang(flBar.getText(),flNama.getText(),Double.parseDouble(flHarga.getText()),Integer.parseInt(flJumlah.getText()),Double.parseDouble(flDiskon.getText()),flExpired.getText(),flKategori.getText());
       brg.addBarang(brg1);
       FXMLLoader loader = new FXMLLoader(getClass().getResource("BarangOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

}