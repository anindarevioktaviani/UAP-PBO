/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uapbo;

import java.util.ArrayList;

public class Penjualan extends Produk implements ProductCounter{
    private ArrayList<Produk> listProduk = new ArrayList<>();
    private int jumlahProduk;
    private int stok;
    
    public Penjualan(){}
    
    public Penjualan(String nama_produk){
        super(nama_produk);
    }
    
    public Penjualan(int jumlahProduk, int stok){
    this.jumlahProduk = jumlahProduk;
    this.stok = stok;
    }

    public Penjualan(String nama_produk,int jumlahProduk, int stok ,double harga) {
        super(nama_produk, harga);
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
    }
    
    public ArrayList<Produk> getProduk(){
        return listProduk;
    }

    @Override
    public int hitungJumlahProduk(){
        return jumlahProduk;
    }

    @Override
    public int hitungHargaProduk(){
        return 0;
    }
    
    
    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int JumlahProduk) {
        this.jumlahProduk = JumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
