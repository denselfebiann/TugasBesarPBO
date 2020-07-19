/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MelvinS
 */
public class Konsumsi {
    private int idKonsumsi;
    private String namaProduk;
    private String tipe;
    private int jumlah;
    private int hargaSatuan;

    public int getIdKonsumsi(){
        return idKonsumsi;
    }
    public void setIdKonsumsi(int idKonsumsi){
        this.idKonsumsi = idKonsumsi;
    }
    public String getNamaProduk(){
        return namaProduk;
    }
    public void setNamaProduk(String namaProduk){
        this.namaProduk = namaProduk;
    }
    public String getTipe(){
        return tipe;
    }
    public void setTipe(String tipe){
        this.tipe = tipe;
    }
    public int getJumlah(){
        return jumlah;
    }
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public int getHargaSatuan(){
        return hargaSatuan;
    }
    public void setHargaSatuan(int hargaSatuan){
        this.hargaSatuan = hargaSatuan;
    }
    
}
