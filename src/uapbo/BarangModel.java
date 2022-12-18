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

public class BarangModel { 
    private final Connection CONN;
    
    public BarangModel(){
        this.CONN = DBHelper.getConnection();
    }
    public void addBarang(Barang brg){
        String insert = "INSERT INTO barang VALUES ('"+brg.getBarcode()+"','"+brg.getNama_produk()+
                                                    "','"+brg.getHarga()+"','"+brg.getJumlah()+
                                                    "','"+brg.getDiskon()+"','"+brg.getExpired()+"','"+brg.getKategori()+"');";
        try {
           if( CONN.createStatement().executeUpdate(insert)>0){
            System.out.println("Data Berhasil Dimasukkan");
           }else{
               System.out.println("Data yang dimasukkan sudah ada");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
    }
    
     public void updateBarang(Barang brg,Produk prd,Kategori ktg){//untuk memperbarui data pada query
        String update = "UPDATE barang SET barcode = '"+ brg.getBarcode() +"', nama_produk = '"+prd.getNama_produk()+
                                         "', harga = '"+prd.getHarga()+"', jumlah = '"+prd.getHarga()+
                                         "', diskon = '"+prd.getDiskon()+"', expired = '"+ brg.getExpired() +"', kategori = '"+ktg.getNama_kategori()+
                                         "' WHERE barcode = '"+brg.getBarcode()+"';";
        try {
           if( CONN.createStatement().executeUpdate(update)>0){
            System.out.println("Data Berhasil Diperbarui");
           }else{
               System.out.println("Data yang dimasukkan tidak berubah");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal Dimasukkan");
        }
     }
     
     public void deleteProduk(Barang brg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE barcode = '"+ brg.getBarcode()+"';";
        
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
     
    public void selectProduk(Kategori ktg){
        String select = "SELECT FROM barang WHERE barcode = '"+ ktg.getNama_kategori()+"';";
        
         try {
           if( CONN.createStatement().executeUpdate(select)>0){
            System.out.println("Data Berhasil Ditampilkan");
           }else{
               System.out.println("Data Gagal ditampilkan");
           }     
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Gagal ditampilkan");
        } 
    }     
    
    public void deleteKategori(Barang brg){//menghapus data didalam query
        String delete = "DELETE FROM barang WHERE kategori = '"+ brg.getKategori()+"';";
        
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
