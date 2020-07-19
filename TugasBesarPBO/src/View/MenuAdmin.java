/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RunningText;
import Controller.UserManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dense
 */
public class MenuAdmin {
    
    JButton cekPesanan, ubahSchedule;
    JFrame frame = new JFrame("Menu Admin");
    public MenuAdmin(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        cekPesanan = new JButton("Semua Pesanan");
        cekPesanan.setBounds(30, 20, 200, 50);
        ubahSchedule = new JButton("Change Schedule");
        ubahSchedule.setBounds(250, 20, 200, 50);
        
        
        
        frame.add(cekPesanan);
        frame.add(ubahSchedule);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MenuAdmin();
    }
}
