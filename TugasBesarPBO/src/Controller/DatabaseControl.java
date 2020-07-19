/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import javax.swing.JOptionPane;

/**
 *
 * @author dense
 */
public class DatabaseControl {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<Users> getAllUser(){
        ArrayList<Users> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Users user = new Users();
                user.setIdUser(rs.getInt("userID"));
                user.setNamaLengkap(rs.getString("nama"));
                user.setAlamat(rs.getString("alamat"));
                user.setKota(rs.getString("kota"));
                user.setKTP(rs.getString("KTP"));
                user.setEmail(rs.getString("email"));
                user.setTelepon(rs.getString("telepon"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("Password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    
    public static Users getUser(String username) {
        conn.connect();
        String query = "SELECT * FROM user WHERE username='" + username + "'";
        Users user = new Users();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setIdUser(rs.getInt("userID"));
                user.setNamaLengkap(rs.getString("nama"));
                user.setAlamat(rs.getString("alamat"));
                user.setKota(rs.getString("kota"));
                user.setKTP(rs.getString("KTP"));
                user.setEmail(rs.getString("email"));
                user.setTelepon(rs.getString("telepon"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("Password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
    
    public static boolean insertNewUser(Users user) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getNamaLengkap());
            stmt.setString(5, user.getAlamat());
            stmt.setString(6, user.getKota());
            stmt.setString(7, user.getTelepon());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getKTP());
            stmt.setInt(10, user.getTipeUser());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean updateUser(Users user) {
        conn.connect();
        String query = "UPDATE User SET username='" + user.getUsername() + "', "
                + "password='" + user.getPassword() + "', "
                + "nama='" + user.getNamaLengkap() + "' "
                + "alamat='" + user.getAlamat() + "' "
                + "kota='" + user.getKota() + "' "
                + "telepon='" + user.getTelepon() + "' "
                + "email='" + user.getEmail() + "' "
                + "KTP='" + user.getKTP() + "' "
                + "tipeUser='" + user.getTipeUser() + "' "
                + " WHERE ID='" + user.getIdUser() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean deleteUser(String name) {
        conn.connect();

        String query = "DELETE FROM user WHERE nama='" + name + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean cekRegister(String KTP) {
        conn.connect();
        String query = "SELECT * FROM User WHERE KTP='" + KTP + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static ArrayList<Kereta> getAllKereta(){
        ArrayList<Kereta> allKereta = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM kereta";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Kereta kereta = new Kereta();
                kereta.setIdKereta(rs.getInt("keretaID"));
                kereta.setGerbong(rs.getInt("gerbong"));
                kereta.setJumlahKursi(rs.getInt("jumlahKursi"));
                kereta.setDeparture(rs.getString("departure"));
                ArrayList<KeretaJadwal> allJadwal = new ArrayList<>();
                allJadwal = getAllJadwal(rs.getString("departure"));
                kereta.setJadwal(allJadwal);
                allKereta.add(kereta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allKereta);
    }
    public static Kereta getKereta(int idKereta, String departure){
        Kereta kereta = new Kereta();
        conn.connect();
        String query = "SELECT * FROM kereta WHERE keretaID = " + idKereta + " and departure = '" + departure + "'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                kereta.setIdKereta(rs.getInt("keretaID"));
                kereta.setDeparture(rs.getString("departure"));
                kereta.setGerbong(rs.getInt("gerbong"));
                kereta.setJumlahKursi(rs.getInt("jumlahKursi"));
                ArrayList<KeretaJadwal> allJadwal = new ArrayList<>();
                allJadwal = getAllJadwal(rs.getString("departure"));
                kereta.setJadwal(allJadwal);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kereta;
    }
    public static boolean updateKursi(int nomorKursi, int scheduleID){
        conn.connect();

        String query = "UPDATE kursi SET status = 'true' WHERE nomorKursi = " + nomorKursi + " and scheduleID = " + scheduleID;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static ArrayList<Boolean> getKursi(int scheduleID){
        ArrayList<Boolean> kursi = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM kursi WHERE scheduleID = " + scheduleID;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String k = rs.getString("status");
                kursi.add(Boolean.parseBoolean(k));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kursi;
    }
    public static ArrayList<KeretaJadwal>getAllJadwal(String departure){
        ArrayList<KeretaJadwal> allJadwal = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jadwalruteharga WHERE departure = '" + departure + "'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                KeretaJadwal jadwal = new KeretaJadwal();
                jadwal.setHargaTiket(rs.getInt("HargaTiket"));
                jadwal.setScheduleID(rs.getInt("scheduleID"));
                jadwal.setKeretaID(rs.getInt("keretaID"));
                jadwal.setJamDepart(rs.getString("jamBerangkat"));
                jadwal.setJamArrive(rs.getString("jamSampai"));
                jadwal.setLokasiDepart(rs.getString("ruteAwal"));
                jadwal.setLokasiArrive(rs.getString("ruteAkhir"));
                jadwal.setDeparture(rs.getString("departure"));
                allJadwal.add(jadwal);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return allJadwal;
    }
    public static KeretaJadwal getJadwal(String ruteAwal, String ruteAkhir){
        conn.connect();
        KeretaJadwal jadwal = new KeretaJadwal();
        String query = "SELECT * FROM jadwalruteharga WHERE ruteAwal = '" + ruteAwal + "' and ruteAkhir = '" + ruteAkhir + "'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                jadwal.setHargaTiket(rs.getInt("HargaTiket"));
                jadwal.setScheduleID(rs.getInt("scheduleID"));
                jadwal.setKeretaID(rs.getInt("keretaID"));
                jadwal.setJamDepart(rs.getString("jamBerangkat"));
                jadwal.setJamArrive(rs.getString("JamSampai"));
                jadwal.setLokasiDepart(rs.getString("ruteAwal"));
                jadwal.setLokasiArrive(rs.getString("ruteAkhir"));
                jadwal.setDeparture(rs.getString("departure"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jadwal;
    }
    public static ArrayList<Konsumsi> getAllKonsumsi(){
        ArrayList<Konsumsi> allKonsumsi = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM konsumsi";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Konsumsi konsumsi = new Konsumsi();
                konsumsi.setIdKonsumsi(rs.getInt("produkID"));
                konsumsi.setNamaProduk(rs.getString("namaProduk"));
                konsumsi.setTipe(rs.getString("type"));
                konsumsi.setJumlah(rs.getInt("jumlah"));
                konsumsi.setHargaSatuan(rs.getInt("harga"));
                allKonsumsi.add(konsumsi);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return allKonsumsi;
    }
    public static int getOrderID(ExtPesanan a){
        conn.connect();
        int orderID = 0;
        String query = "SELECT orderID FROM pesanan ORDER BY orderID DESC LIMIT 1";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                orderID = rs.getInt("orderID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderID;
    }
    public static boolean insertNewPesanan(int userID, Pesanan pesanan){
        conn.connect();
        ExtPesanan a = (ExtPesanan)pesanan;
        String query = "INSERT INTO pesanan VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, userID);
            stmt.setInt(3, a.getScheduleID());
            stmt.setString(4, a.getDepartureDipilih());
            stmt.setString(5, a.getTanggal());
            stmt.setString(6, a.getKursiDipilih());
            stmt.setInt(7, a.getHargaTiket());
            stmt.setString(8, "");
            stmt.setInt(9, a.getTotalHargaTiket());
            stmt.setInt(10, a.getTotalHargaKonsumsi());
            stmt.setInt(11, a.getTotalHarga());
            stmt.executeUpdate();
            if(a.getKonsumsi()!=null){
                insertNewPesananKonsumsi(a);
            }
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean insertNewPesananKonsumsi(ExtPesanan a){
        conn.connect();
        ArrayList<Konsumsi> allKonsumsi = a.getKonsumsi();
        for(int i = 0; i < allKonsumsi.size(); i++){
            String query = "INSERT INTO pesananKonsumsi VALUES(?, ?, ?, ?, ?)";
            try{
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1, 0);
                stmt.setInt(2, getOrderID(a));
                stmt.setString(3, allKonsumsi.get(i).getNamaProduk());
                stmt.setInt(4, allKonsumsi.get(i).getHargaSatuan());
                stmt.setInt(5, allKonsumsi.get(i).getJumlah());
                stmt.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }
    public static ArrayList<Pembayaran> getAllPembayaran(){
        ArrayList<Pembayaran> allPembayaran = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pembayaran";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pembayaran pembayaran = new Pembayaran();
                pembayaran.setMetodePembayaran(rs.getString("metodePembayaran"));
                pembayaran.setCashback(rs.getInt("cashback"));
                pembayaran.setDiskon(rs.getInt("diskon"));
                allPembayaran.add(pembayaran);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return allPembayaran;
    }
    public ArrayList<Orders> getPesanan(int userID){
        conn.connect();
        ArrayList<Orders> listOrders = new ArrayList<>();
        String query = "SELECT * FROM pesanan WHERE userID='" + userID + "'";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Orders orders = new Orders();
                
                orders.setOrderID(rs.getString("orderID"));
                orders.setDeparture(rs.getString("departureDipilih"));
                orders.setTanggal(rs.getString("tanggal"));
                orders.setKursi(rs.getString("kursi"));
                orders.setHargaTiket(rs.getString("hargaTiket"));
                orders.setLangganan(rs.getString("langganan"));
                orders.setTotalHarga(rs.getString("totalHarga"));
                
                String scheduleID = rs.getString("scheduleID");
                
                query="SELECT * FROM jadwalRuteHarga WHERE scheduleID='" + scheduleID + "'";
                try{
                    stmt = conn.con.createStatement();
                    rs = stmt.executeQuery(query);
                    
                    while(rs.next()){
                        orders.setArrival(rs.getString("ruteAkhir"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
//                orders.setArrival(rs.getString("arrivalDipilih"));

                listOrders.add(orders);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listOrders;
    }
    public ArrayList<Orders> getAllPesanan(int userID){
        conn.connect();
        ArrayList<Orders> listOrders = new ArrayList<>();
        String query = "SELECT * FROM pesanan ";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Orders orders = new Orders();
                
                orders.setOrderID(rs.getString("orderID"));
                orders.setDeparture(rs.getString("departureDipilih"));
                orders.setTanggal(rs.getString("tanggal"));
                orders.setKursi(rs.getString("kursi"));
                orders.setHargaTiket(rs.getString("hargaTiket"));
                orders.setLangganan(rs.getString("langganan"));
                orders.setTotalHarga(rs.getString("totalHarga"));
                
                String scheduleID = rs.getString("scheduleID");
                
                query="SELECT * FROM jadwalRuteHarga WHERE scheduleID='" + scheduleID + "'";
                try{
                    stmt = conn.con.createStatement();
                    rs = stmt.executeQuery(query);
                    
                    while(rs.next()){
                        orders.setArrival(rs.getString("ruteAkhir"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                listOrders.add(orders);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listOrders;
    }
    
    public static boolean updateMemberPoint(int userID, int newPoint){
        conn.connect();
        String query = "UPDATE User SET pointLangganan='" + newPoint + "' "
                + " WHERE userID='" + userID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        
    }
    public static boolean updateMemberVoucher(int userID, int newVoucher){
        conn.connect();
        String query = "UPDATE User SET giftRide='" + newVoucher + "' "
                + " WHERE userID='" + userID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        
    }
}
