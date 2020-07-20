/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Convert;
import Controller.DatabaseControl;
import Controller.UserManager;
import View.MenuLogin;
import View.MenuRegister;
import java.util.ArrayList;

/**
 *
 * @author MelvinS
 */
public class Users {
    private int idUser;
    private String namaLengkap;
    private String alamat;
    private String email;
    private String telepon;
    private String username;
    private String password;
    private String kota;
    private String KTP;
    private int tipeUser;
    private int pointLangganan = 0;
    private int giftRide = 1;

    public int getGiftRide() {
        return giftRide;
    }

    public void setGiftRide(int giftRide) {
        this.giftRide = giftRide;
    }

    public int getPointLangganan() {
        return pointLangganan;
    }
    public void setPointLangganan(int pointLangganan) {
        this.pointLangganan = pointLangganan;
    }
    public String getKota(){
        return kota;
    }
    public void setKota(String kota){
        this.kota = kota;
    }
    public String getKTP(){
        return KTP;
    }
    public void setKTP(String KTP){
        this.KTP = KTP;
    }
    public int getTipeUser(){
        return tipeUser;
    }
    public void setTipeUser(int tipeUser){
        this.tipeUser = tipeUser;
    }
    public int getIdUser(){
        return idUser;
    }
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
    public String getNamaLengkap(){
        return namaLengkap;
    }
    public void setNamaLengkap(String namaLengkap){
        this.namaLengkap = namaLengkap;
    }
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTelepon(){
        return telepon;
    }
    public void setTelepon(String telepon){
        this.telepon = telepon;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public void register(){
        new MenuRegister();
    }
    public void login(){
        new MenuLogin();
    }
    public boolean cekLogin(String username, String password){
        DatabaseControl controller = new DatabaseControl();
        Users user = controller.getUser(username);
        String passwordConvert = Convert.stringToMD5(password);
        if((user.getUsername().equals(username)) && (passwordConvert.equals(user.getPassword()))){
            UserManager.getInstance().setUser(user);
            return true;
        }else{
            return false;
        }
    }
    public void logout(){
        
    }
    public boolean cekAdmin(){
        DatabaseControl controller = new DatabaseControl();
        Users user = controller.getUser(username);
        boolean cek = false;
        if(user.getTipeUser() == 1){
            cek = true;
        }else if(user.getTipeUser() == 0){
            cek = false;
        }
        return cek;
    }
    
    public void updatePointDatabase(){
        DatabaseControl controller = new DatabaseControl();
        Users user = controller.getUser(username);
        controller.updateMemberPoint(user.idUser, user.pointLangganan);
        controller.updateMemberPoint(user.idUser, user.giftRide);
    }
    public void updateVoucherDatabase(){
        
    }
}