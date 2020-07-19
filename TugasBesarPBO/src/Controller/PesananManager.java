/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pesanan;

/**
 *
 * @author dense
 */
public class PesananManager {
    static PesananManager instance;
    private Pesanan pesanan;

    public static PesananManager getInstance() {
        if (instance == null) {
            instance = new PesananManager();
        }
        return instance;
    }
    
    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }
}
