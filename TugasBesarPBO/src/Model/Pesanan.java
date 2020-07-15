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
    private String kursi;
    private int hargaTiket;
    private int totalHargaTiket;
    private int totalHarga;

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
    public String getKursi(){
        return kursi;
    }
    public void setKursi(String kursi){
        this.kursi = kursi;
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
