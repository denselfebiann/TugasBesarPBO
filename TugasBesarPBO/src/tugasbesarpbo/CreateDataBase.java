/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesarpbo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dense
 */
public class CreateDataBase implements mySQL{
    public static Connection con;
    public static Statement stm;
    
    public CreateDataBase(){
        String sql = "";
        try{
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            stm = (Statement) con.createStatement();
            
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
"                   keretaID INT NOT NULL," + 
"                   jamBerangkat VARCHAR(100) NOT NULL," + 
"                   gerbong VARCHAR(100) NOT NULL," + 
"                   jumlahKursi INT NOT NULL" + 
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE jadwalRuteHarga(" +
"                   keretaID INT NOT NULL," +
"                   scheduleID INT NOT NULL," +
"                   ruteAwal VARCHAR(100) NOT NULL," +
"                   ruteAkhir VARCHAR(100) NOT NULL," +
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
"                   metodePembayaran VARCHAR(100) NOT NULL," +
"                   diskon DOUBLE NOT NULL," +
"                   cashback INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE konsumsi(" +
"                   produkID INT NOT NULL," +
"                   namaProduk VARCHAR(100) NOT NULL," +
"                   harga INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE pesanan(" +
"                   orderID INT NOT NULL," + 
"                   userID INT NOT NULL," + 
"                   scheduleID INT NOT NULL," + 
"                   departureDipilih VARCHAR(100) NOT NULL," + 
"                   tanggal VARCHAR(100) NOT NULL," + 
"                   kursi VARCHAR(100) NOT NULL," + 
"                   hargaTiket INT NOT NULL," + 
"                   langganan VARCHAR(100) NOT NULL," + 
"                   konsumsi VARCHAR(100) NOT NULL," + 
"                   hargaKonsumsi INT NOT NULL," + 
"                   jumlahKonsumsi INT NOT NULL," + 
"                   totalHargaTiket INT NOT NULL," +
"                   totalHargaKonsumsi INT NOT NULL," + 
"                   totalHarga INT NOT NULL" +
"                 )";
            stm.execute(sql);
            
            stm.close();
            con.close();
        }catch (Exception e){
            System.err.println("Connection Failure" + e.getMessage());
        }
    }
}
