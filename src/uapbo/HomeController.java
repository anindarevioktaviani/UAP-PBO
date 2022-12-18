/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uapbo;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author baash
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnData;

    @FXML
    private Button btnKategori;

    @FXML
    private Button btnProduk;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void DataPenjualanInput(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKategori.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    public void kategoriInput(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("KategoriOutput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKategori.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    public void produkInput(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdukInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnProduk.getScene().getWindow();
       stage.setScene(new Scene(root));
    }   
    
}
