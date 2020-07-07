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
        
    }
    public void login(){
        
    }
    public boolean cekLogin(String username, String password){
        
        return true;
    }
    public void logout(){
        
    }
    public boolean cekAdmin(){
        
        return true;
    }
}
