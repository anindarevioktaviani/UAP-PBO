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


public class MakananOutputController implements Initializable {

    @FXML
    private TableColumn<Makanan, Integer> MdayaTahan;

    @FXML
    private TableColumn<Makanan, Double> Mdiskon;

    @FXML
    private TableColumn<Makanan, Double> Mharga;

    @FXML
    private TableColumn<Makanan, Integer> Mid;

    @FXML
    private TableColumn<Makanan, Integer> Mjumlah;

    @FXML
    private TableColumn<Makanan, String> Mnama;

    @FXML
    private TableView<Makanan> TBmakanan;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showMakanan();
    }  

    @FXML
    void hapus(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("MakananDelete.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnHapus.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void kembali(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnKembali.getScene().getWindow();
       stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("MakananInput.fxml"));
       Parent root = (Parent) loader.load();
       Stage stage = (Stage) btnTambah.getScene().getWindow();
       stage.setScene(new Scene(root));
    }
    
    public ObservableList<Makanan> getMakananList(){
       ObservableList<Makanan> makananList = FXCollections.observableArrayList();
       Connection CONN = getConnection();
       String query ="SELECT * FROM makanan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           Makanan makanan;
           while(rs.next()){
               makanan = new Makanan(rs.getInt("id"),rs.getString("nama_produk"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getInt("daya_tahan"));
               makananList.add(makanan);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return makananList;
   }
    
   public void showMakanan(){
       ObservableList<Makanan> list = getMakananList();
       Mid.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("id"));
       Mnama.setCellValueFactory(new PropertyValueFactory<Makanan,String>("nama_produk"));
       Mharga.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("harga"));
       Mjumlah.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("jumlah"));
       Mdiskon.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("diskon"));
       MdayaTahan.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("daya_tahan"));
       
       TBmakanan.setItems(list);
   }
}
