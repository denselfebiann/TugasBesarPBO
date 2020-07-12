/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        String query = "UPDATE user SET username='" + user.getUsername() + "', "
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
}
