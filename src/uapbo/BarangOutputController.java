/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uapbo;


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
import static uapbo.DBHelper.getConnection;

public class BarangOutputController implements Initializable {
    BarangModel brg = new BarangModel();
    
    @FXML
    private TableView<Barang> TBbarang;

    @FXML
    private TableColumn<Barang, String> Tbar;

    @FXML
    private TableColumn<Barang, Double> Tdiskon;

    @FXML
    private TableColumn<Barang, String> Texpired;

    @FXML
    private TableColumn<Barang, Double> Tharga;

    @FXML
    private TableColumn<Barang, Integer> Tjumlah;

    @FXML
    private TableColumn<Barang, String> Tkategori;

    @FXML
    private TableColumn<Barang, String> Tnama;
    
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnKembali;
    
    @FXML
    private Button btnHapus;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showBarang();
    }  
    
    @FXML
    void kembali(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdukInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("BarangInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnAdd.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
    
    @FXML
    void delete(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("BarangDelete.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnAdd.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
   
    
    public ObservableList<Barang> getBarangList(){
       ObservableList<Barang> barangList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM barang;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Barang barang;
           while(rs.next()){
              barang = new Barang(rs.getString("barcode"),rs.getString("nama_produk"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getString("expired"),rs.getString("kategori"));
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
   }
   
    public void showBarang(){
       ObservableList<Barang> list = getBarangList();
       Tbar.setCellValueFactory(new PropertyValueFactory<Barang,String>("barcode"));
       Tnama.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
       Tharga.setCellValueFactory(new PropertyValueFactory<Barang,Double>("harga"));
       Tjumlah.setCellValueFactory(new PropertyValueFactory<Barang,Integer>("jumlah"));
       Tdiskon.setCellValueFactory(new PropertyValueFactory<Barang,Double>("diskon"));
       Texpired.setCellValueFactory(new PropertyValueFactory<Barang,String>("expired"));
       Tkategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("kategori"));
       
       TBbarang.setItems(list);
   }

}
     
    

