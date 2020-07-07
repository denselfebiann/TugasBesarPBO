/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Garis;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dense
 */
public class MenuOrder extends JPanel{
    JLabel labelRute, judul, note;
    JComboBox rute;
    public MenuOrder(){
        
        String r[] = {"Bandung-Jakarta", "Jakarta-Bogor", "Bogor-Surabaya", "Surabaya-Bandung"};
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        
        judul = new JLabel("Menu Order");
        judul.setBounds(170, 0, 200, 20);
        judul.setFont(new Font(judul.getFont().getName(), judul.getFont().getStyle(), 22));
        labelRute = new JLabel("Rute");
        labelRute.setBounds(20, 40, 100, 20);
        labelRute.setFont(new Font(labelRute.getFont().getName(), labelRute.getFont().getStyle(), 15));
        
        rute = new JComboBox(r);
        rute.setBounds(130, 40, 150, 20);
        
        Garis garis = new Garis();

        frame.add(judul);
        frame.add(labelRute);
        frame.add(rute);
        frame.add(garis);
        //frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void paint(Graphics g){
        
    }
}
