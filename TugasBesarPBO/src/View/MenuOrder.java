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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dense
 */
public class MenuOrder implements ActionListener{
    JLabel labelRute, judul, note, labelTanggal, labelJam;
    JComboBox rute, tanggal, jam;
    JButton submit;
    JFrame frame = new JFrame();
    String[] r = {"Bandung-Jakarta", "Jakarta-Bogor", "Bogor-Surabaya", "Surabaya-Bandung"};
    String[][] t = {
        {"13-7-2020", "14-7-2020", "15-7-2020", "17-7-2020"},
        {"13-7-2020", "14-7-2020", "13-7-2020", "13-7-2020"},
        {"14-7-2020", "15-7-2020", "14-7-2020", "16-7-2020"},
        {"12-7-2020", "13-7-2020", "14-7-2020", "15-7-2020"}
    };
    String[][] j = {
        {"07.00-09.00", "10.00-13.00", "14.00-17.00", "18.00-21.00"},
        {"05.00-09.00", "10.00-12.00", "13.00-18.00", "19.00-23.00"},
        {"06.00-09.00", "10.00-14.00", "15.00-19.00", "20.00-24.00"},
        {"04.00-09.00", "10.00-14.00", "15.00-20.00", "21.00-23.00"}
    };
    public MenuOrder(){
        frame.setSize(500, 400);
        
        judul = new JLabel("Menu Order");
        judul.setBounds(170, 0, 200, 20);
        judul.setFont(new Font(judul.getFont().getName(), judul.getFont().getStyle(), 22));
        labelRute = new JLabel("Rute");
        labelRute.setBounds(20, 40, 180, 20);
        labelRute.setFont(new Font(labelRute.getFont().getName(), labelRute.getFont().getStyle(), 15));
        labelTanggal = new JLabel("Tanggal");
        labelTanggal.setBounds(20, 80, 180, 20);
        labelTanggal.setFont(new Font(labelTanggal.getFont().getName(), labelTanggal.getFont().getStyle(), 15));
        labelJam = new JLabel("Jadwal Keberangkatan");
        labelJam.setBounds(20, 120, 180, 20);
        labelJam.setFont(new Font(labelJam.getFont().getName(), labelJam.getFont().getStyle(), 15));
        
        rute = new JComboBox(r);
        rute.setBounds(210, 40, 150, 20);
        rute.addActionListener(this);
        tanggal = new JComboBox(t[0]);
        tanggal.setBounds(210, 80, 150, 20);
        jam = new JComboBox(j[0]);
        jam.setBounds(210, 120, 150, 20);
        submit = new JButton("Submit");
        submit.setBounds(150, 150, 150, 20);
        submit.addActionListener(this);
        Garis garis = new Garis();

        frame.add(judul);
        frame.add(labelRute);
        frame.add(labelTanggal);
        frame.add(labelJam);
        frame.add(rute);
        frame.add(tanggal);
        frame.add(jam);
        frame.add(submit);
        frame.add(garis);
        //frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int rut = rute.getSelectedIndex();
        
        tanggal.removeAllItems();
        for(int i = 0; i < t[rut].length; i++){
            tanggal.addItem(t[rut][i]);
        }
        
        switch(e.getActionCommand()){
            case "Submit":
                break;
        }
    }
}
