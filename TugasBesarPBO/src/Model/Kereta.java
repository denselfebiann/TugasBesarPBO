/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author MelvinS
 */
public class Kereta {
    private int idKereta;
    private String departure;
    private int gerbong;
    private int jumlahKursi;
    private boolean[] kursiKosong;
    private ArrayList<KeretaJadwal> jadwal;

    public int getIdKereta(){
        return idKereta;
    }
    public void setIdKereta(int idKereta){
        this.idKereta = idKereta;
    }
    public int getGerbong(){
        return gerbong;
    }
    public void setGerbong(int gerbong){
        this.gerbong = gerbong;
    }
    public int getJumlahKursi(){
        return jumlahKursi;
    }
    public void setJumlahKursi(int jumlahKursi){
        this.jumlahKursi = jumlahKursi;
    }
    public boolean[] getKursiKosong(){
        return kursiKosong;
    }
    public void setKursiKosong(boolean[] kursiKosong){
        this.kursiKosong = kursiKosong;
    }
    public ArrayList<KeretaJadwal> getJadwal(){
        return jadwal;
    }
    public void setJadwal(ArrayList<KeretaJadwal> jadwal){
        this.jadwal = jadwal;
    }
    public String getDeparture(){
        return departure;
    }
    public void setDeparture(String departure){
        this.departure = departure;
    }
    
}
