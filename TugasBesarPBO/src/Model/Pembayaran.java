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
public class Pembayaran {
    private String metodePembayaran;
    private int diskon;
    private int cashback;

    public String getMetodePembayaran(){
        return metodePembayaran;
    }
    public void setMetodePembayaran(String metodePembayaran){
        this.metodePembayaran = metodePembayaran;
    }
    public int getDiskon(){
        return diskon;
    }
    public void setDiskon(int diskon){
        this.diskon = diskon;
    }
    public int getCashback(){
        return cashback;
    }
    public void setCashback(int cashback){
        this.cashback = cashback;
    }
    
}
