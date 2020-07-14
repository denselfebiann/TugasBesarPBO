/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.Garis;
import Controller.UserManager;
import Model.Kereta;
import Model.KeretaJadwal;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    DatabaseControl controller = new DatabaseControl();
    ArrayList<Kereta> kereta = controller.getKereta();

    String[] r;
    String[][] d;
    String[] t;
    public MenuOrder(){
        int size = 0;
        Date berikut = new Date();
        for(int i = 0; i < kereta.size(); i++){
            size += kereta.get(i).getJadwal().size();
        }
        r = new String[size];
        t = new String[1];
        d = new String[2][30];
        SimpleDateFormat dn = new SimpleDateFormat("dd-MM-yy");
        String date = dn.format(berikut);
        System.out.println(date);
        int hari = Integer.parseInt(date.substring(0, 2));
        int bulan = Integer.parseInt(date.substring(3, 5));
        int tahun = Integer.parseInt(date.substring(6, 8));
        int counter1 = 0, counter2 = 0;
        for(int j = 1; j <= 30; j++){
            String temp = "";
            if(j % 2 == 0){
                if(hari < 10){
                    temp = "0" + Integer.toString(hari);
                }else{
                    temp = Integer.toString(hari);
                }
                if(bulan < 10){
                    temp += "-0" + Integer.toString(bulan);
                }else{
                    temp += "-" + Integer.toString(bulan);
                }
                temp += "-" + Integer.toString(tahun);
                d[0][counter1] = temp;
                counter1++;
            }else{
                if(hari < 10){
                    temp = "0" + Integer.toString(hari);
                }else{
                    temp = Integer.toString(hari);
                }
                if(bulan < 10){
                    temp += "-0" + Integer.toString(bulan);
                }else{
                    temp += "-" + Integer.toString(bulan);
                }
                temp += "-" + Integer.toString(tahun);
                d[1][counter2] = temp;
                counter2++;
            }
            hari++;
            if(hari == 30){
                bulan++;
                hari = 1;
            }
            if(bulan == 12){
                tahun++;
                bulan = 1;
            }
        }
        
        
        for(int i = 0; i < kereta.size(); i++){
            Kereta train = kereta.get(i);
            for(int j = 0; j < train.getJadwal().size(); j++){
                r[j] = (train.getJadwal().get(j).getLokasiDepart() + "-" + train.getJadwal().get(j).getLokasiArrive());
            }
        }
        frame.setSize(500, 400);
        //1 GERBONG SENDIRI"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        tanggal = new JComboBox();
        tanggal.setBounds(210, 80, 150, 20);
        jam = new JComboBox();
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
        Object rut = rute.getSelectedItem();
        String str = rut.toString();
        KeretaJadwal jadwal = new KeretaJadwal();
        jam.removeAllItems();
        tanggal.removeAllItems();
        for(int i = 0; i < str.length(); i++){
            String s = str.substring(i, i+1);
            if(s.equals("-")){
                String cek1 = str.substring(0, i);
                String cek2 = str.substring(i+1, str.length());
                jadwal = controller.getJadwal(cek1, cek2);
                String j = jadwal.getJamDepart() + "-" + jadwal.getJamArrive();
                jam.addItem(j);
            }
        }
        if(rute.getSelectedIndex() % 2 == 0){
            for(int i = 0; i < 15; i++){
                tanggal.addItem(d[0][i]);
            }
        }else{
            for(int i = 0; i < 15; i++){
                tanggal.addItem(d[1][i]);
            }
        }
        switch(e.getActionCommand()){
            case "Submit":
                
                frame.setVisible(false);
                new PemilihanKursi();
                break;
        }
    }
}
