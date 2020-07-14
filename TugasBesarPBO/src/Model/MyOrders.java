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
public class MyOrders {
    private String orderID, departure, arrival, tanggal, kursi, hargaTiket, langganan, konsumsi, totalHarga;

    public MyOrders() {
    }

    public MyOrders(String orderID, String departure, String arrival, String tanggal, String kursi, String hargaTiket, String langganan, String konsumsi, String totalHarga) {
        this.orderID = orderID;
        this.departure = departure;
        this.arrival = arrival;
        this.tanggal = tanggal;
        this.kursi = kursi;
        this.hargaTiket = hargaTiket;
        this.langganan = langganan;
        this.konsumsi = konsumsi;
        this.totalHarga = totalHarga;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKursi() {
        return kursi;
    }

    public void setKursi(String kursi) {
        this.kursi = kursi;
    }

    public String getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(String hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    public String getLangganan() {
        return langganan;
    }

    public void setLangganan(String langganan) {
        this.langganan = langganan;
    }

    public String getKonsumsi() {
        return konsumsi;
    }

    public void setKonsumsi(String konsumsi) {
        this.konsumsi = konsumsi;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }


}
