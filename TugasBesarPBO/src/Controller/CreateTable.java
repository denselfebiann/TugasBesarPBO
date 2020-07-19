/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dense
 */
public class CreateTable{
    static DatabaseHandler conn = new DatabaseHandler();
    public static Statement stm;
    
    public CreateTable(){
        conn.connect();
        String sql = "";
        try{
            stm = (Statement) conn.con.createStatement();
            
            sql = "CREATE TABLE User (" +
"                   userID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   username VARCHAR(100) NOT NULL," +
"                   password VARCHAR(100) NOT NULL," +
"                   nama VARCHAR(255) NOT NULL," +
"                   alamat VARCHAR(255) NOT NULL," +
"                   kota VARCHAR(100) NOT NULL," +
"                   telepon VARCHAR(100) NOT NULL," +
"                   email VARCHAR(255) NOT NULL," +
"                   KTP VARCHAR(255) NOT NULL," +
"                   tipeUser INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE kereta(" + 
"                   id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   keretaID INT NOT NULL," +
"                   gerbong INT NOT NULL," + 
"                   jumlahKursi INT NOT NULL" + 
"                   departure VARCHAR(100) NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE jadwalRuteHarga(" +
"                   scheduleID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   keretaID INT NOT NULL," +
"                   departure VARCHAR(100) NOT NULL," +
"                   ruteAwal VARCHAR(100) NOT NULL," +
"                   ruteAkhir VARCHAR(100) NOT NULL," +
"                   jamBerangkat VARCHAR(100) NOT ULL," +
"                   jamSampai VARCHAR(100) NOT NULL," +
"                   HargaTiket INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE langganan(" +
"                   langgananID INT NOT NULL," +
"                   jumlahHari INT NOT NULL," +
"                   hargaLangganan INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE pembayaran(" +
"                   id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   metodePembayaran VARCHAR(100) NOT NULL," +
"                   diskon DOUBLE NOT NULL," +
"                   cashback INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE konsumsi(" +
"                   produkID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   namaProduk VARCHAR(100) NOT NULL," +
"                   type VARCHAR(100) NOT NULL," +
"                   jumlah INT NOT NULL," +
"                   harga INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE kursi(" +
"                   id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   nomorKursi INT NOT NULL," +
"                   scheduleID INT NOT NULL," +
"                   status VARCHAR(100) NOT NULL" +
"                 )";
            stm.execute(sql);
            sql = "CREATE TABLE pesanan(" +
"                   orderID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," + 
"                   userID INT NOT NULL," + 
"                   scheduleID INT NOT NULL," + 
"                   departureDipilih VARCHAR(100) NOT NULL," + 
"                   tanggal VARCHAR(100) NOT NULL," + 
"                   kursi VARCHAR(100) NOT NULL," + 
"                   hargaTiket INT NOT NULL," + 
"                   langganan VARCHAR(100) NOT NULL," +
"                   totalHargaTiket INT NOT NULL," +
"                   totalHargaKonsumsi INT NOT NULL," + 
"                   totalHarga INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE pesananKonsumsi(" +
"                   id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   orderID INT NOT NULL," +
"                   konsumsi VARCHAR(100) NOT NULL," +
"                   hargaKonsumsi INT NOT NULL," +
"                   jumlahKonsumsi INT NOT NULL" +
"                )";
            stm.execute(sql);
            stm.close();
            conn.disconnect();
        }catch (Exception e){
            System.err.println("Connection Failure" + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new CreateTable();
    }
}
