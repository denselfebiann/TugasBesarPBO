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
public class Member extends Users{
    private ArrayList<Pesanan> pesanan;
    
    public ArrayList<Pesanan> getPesanan(){
        return pesanan;
    }
    public void setPesanan(ArrayList<Pesanan> pesanan){
        this.pesanan = pesanan;
    }
}
