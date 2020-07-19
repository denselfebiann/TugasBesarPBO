/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Pembayaran;
import java.util.Date;

/**
 *
 * @author MelvinS
 */
public class Pesanan {
    private int orderID;
    private int scheduleID;
    private String departureDipilih;
    private String tanggal;
    private int banyakKursiDipilih;
    private int hargaTiket;
    private int totalHargaTiket;
    private int totalHarga;
    
    public Pesanan(){
    }
    public Pesanan(int orderID, int scheduleID, String departureDipilih, String tanggal, int banyakKursiDipilih, int hargaTiket, int totalHargaTiket, int totalHarga) {
        this.orderID = orderID;
        this.scheduleID = scheduleID;
        this.departureDipilih = departureDipilih;
        this.tanggal = tanggal;
        this.banyakKursiDipilih = banyakKursiDipilih;
        this.hargaTiket = hargaTiket;
        this.totalHargaTiket = totalHargaTiket;
        this.totalHarga = totalHarga;
    }
    
    public int getOrderID(){
        return orderID;
    }
    public void setOrderID(int orderID){
        this.orderID = orderID;
    }
    public int getScheduleID(){
        return scheduleID;
    }
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }
    public String getDepartureDipilih(){
        return departureDipilih;
    }
    public void setDepartureDipilih(String departureDipilih){
        this.departureDipilih = departureDipilih;
    }
    public String getTanggal(){
        return tanggal;
    }
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public int getKursi(){
        return banyakKursiDipilih;
    }
    public void setKursi(int banyakKursiDipilih){
        this.banyakKursiDipilih = banyakKursiDipilih;
    }
    public int getHargaTiket(){
        return hargaTiket;
    }
    public void setHargaTiket(int hargaTiket){
        this.hargaTiket = hargaTiket;
    }
    public int getTotalHargaTiket(){
        return totalHargaTiket;
    }
    public void setTotalHargaTiket(int totalHargaTiket){
        this.totalHargaTiket = totalHargaTiket;
    }
    public int getTotalHarga(){
        return totalHarga;
    }
    public void setTotalHarga(int totalHarga){
        this.totalHarga = totalHarga;
    }
    
}
