/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Pesanan;
import Model.Konsumsi;
import Model.Kereta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MelvinS
 */
public class extPesanan extends Pesanan{
    private Kereta detailKereta;
    private String gerbong;
    private String kursiDipilih;
    private ArrayList<Konsumsi> konsumsi;

    public extPesanan() {
    }

    public extPesanan(Kereta detailKereta, String gerbong, String kursiDipilih, ArrayList<Konsumsi> konsumsi, int orderID, Date tanggal) {
        this.detailKereta = detailKereta;
        this.gerbong = gerbong;
        this.kursiDipilih = kursiDipilih;
        this.konsumsi = konsumsi;
        super.setOrderID(orderID);
        super.setTanggal(tanggal);
    }

    public Kereta getDetailKereta() {
        return detailKereta;
    }

    public void setDetailKereta(Kereta detailKereta) {
        this.detailKereta = detailKereta;
    }

    public String getGerbong() {
        return gerbong;
    }

    public void setGerbong(String gerbong) {
        this.gerbong = gerbong;
    }

    public String getKursiDipilih() {
        return kursiDipilih;
    }

    public void setKursiDipilih(String kursiDipilih) {
        this.kursiDipilih = kursiDipilih;
    }

    public ArrayList<Konsumsi> getKonsumsi() {
        return konsumsi;
    }

    public void setKonsumsi(ArrayList<Konsumsi> konsumsi) {
        this.konsumsi = konsumsi;
    }
    
    
    
}
