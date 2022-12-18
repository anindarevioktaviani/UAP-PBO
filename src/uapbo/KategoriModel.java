/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uapbo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategoriModel {
    private final Connection CONN;
    
    public KategoriModel(){
        this.CONN = DBHelper.getConnection();
    }
    
    public void deleteKategori(Kategori ktg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE kategori = '"+ ktg.getNama_kategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(delete)>0){
            System.out.println("Data Berhasil Dihapus");
           }else{
               System.out.println("Data Gagal dihapus");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal dihapus");
        }  
    }
}
