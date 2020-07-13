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
    private String idKereta;
    private String gerbong;
    private int jumlahKursi;
    private boolean[] kursiKosong;
    private ArrayList<KeretaJadwal> jadwal;

    public String getIdKereta() {
        return idKereta;
    }

    public void setIdKereta(String idKereta) {
        this.idKereta = idKereta;
    }

    public String getGerbong() {
        return gerbong;
    }

    public void setGerbong(String gerbong) {
        this.gerbong = gerbong;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public boolean[] getKursiKosong() {
        return kursiKosong;
    }

    public void setKursiKosong(boolean[] kursiKosong) {
        this.kursiKosong = kursiKosong;
    }

    public ArrayList<KeretaJadwal> getJadwal() {
        return jadwal;
    }

    public void setJadwal(ArrayList<KeretaJadwal> jadwal) {
        this.jadwal = jadwal;
    }
    
    
}
