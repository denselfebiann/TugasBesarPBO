/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.Garis;
import Controller.KeretaManager;
import Controller.PesananManager;
import Controller.UserManager;
import Model.Kereta;
import Model.KeretaJadwal;
import Model.Pesanan;
import Model.ExtPesanan;
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
public class MenuOrder{
    JLabel labelRute, judul, note, labelTanggal, labelJam, labelDeparture;
    JComboBox rute, tanggal, jam, departure;
    JButton submit, back;
    JFrame frame = new JFrame("Menu Order");
    DatabaseControl controller = new DatabaseControl();
    ArrayList<Kereta> Allkereta = controller.getAllKereta();

    String[] isiRute;
    String[][] isiTanggal;
    String[] isiJam;
    String[] isiDeparture;
    Kereta kereta = null;
    public MenuOrder(){
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        isiJam = new String[1];
        isiTanggal = new String[2][30];
        boolean ketemu = false, sama = false;
        int banyakDeparture = 0;
        for(int i = 0; i < Allkereta.size(); i++){
            sama = false;
            for(int j = 0; (j < i) && (!sama); j++){
                if(!(Allkereta.get(j).getDeparture().equals(Allkereta.get(i).getDeparture()))){
                    sama = false;
                }else{
                    sama = true;
                }
                if(!sama){
                    banyakDeparture++;
                }
            }
        }
        isiDeparture = new String[banyakDeparture];
        isiDeparture[0] = Allkereta.get(0).getDeparture();
        for(int i = 0; i < Allkereta.size(); i++){
            for(int j = 0; j < i; j++){
                if(isiDeparture[j].equals(Allkereta.get(i).getDeparture())){
                    ketemu = true;
                }
            }
            if(!ketemu){
                isiDeparture[i] = Allkereta.get(i).getDeparture();
            }
        }
        Date berikut = new Date();
        SimpleDateFormat dn = new SimpleDateFormat("dd-MM-yyyy");
        String date = dn.format(berikut);
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
                isiTanggal[0][counter1] = temp;
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
                isiTanggal[1][counter2] = temp;
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
        
        judul = new JLabel("Menu Order");
        labelDeparture = new JLabel("Departure");
        labelRute = new JLabel("Rute");
        labelTanggal = new JLabel("Tanggal");
        labelJam = new JLabel("Jadwal Keberangkatan");
        
        judul.setBounds(300, 0, 200, 25);
        labelDeparture.setBounds(150, 40, 250, 25);
        labelRute.setBounds(150, 80, 250, 25);
        labelTanggal.setBounds(150, 120, 250, 25);
        labelJam.setBounds(150, 160, 250, 25);
        
        judul.setFont(new Font(judul.getFont().getName(), judul.getFont().getStyle(), 28));
        labelDeparture.setFont(new Font(labelDeparture.getFont().getName(), labelDeparture.getFont().getStyle(), 22));
        labelRute.setFont(new Font(labelRute.getFont().getName(), labelRute.getFont().getStyle(), 22));
        labelTanggal.setFont(new Font(labelTanggal.getFont().getName(), labelTanggal.getFont().getStyle(), 22));
        labelJam.setFont(new Font(labelJam.getFont().getName(), labelJam.getFont().getStyle(), 22));
        
        departure = new JComboBox(isiDeparture);
        rute = new JComboBox();
        tanggal = new JComboBox();
        jam = new JComboBox();
        
        departure.setBounds(400, 40, 180, 25);
        rute.setBounds(400, 80, 180, 25);
        tanggal.setBounds(400, 120, 180, 25);
        jam.setBounds(400, 160, 180, 25);
        
        departure.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                rute.removeAllItems();
                for(int i = 0; i < Allkereta.size(); i++){
                    if(departure.getSelectedItem().equals(Allkereta.get(i).getDeparture())){
                        kereta = Allkereta.get(i);
                        for(int j = 0; j < kereta.getJadwal().size(); j++){
                            if(kereta.getIdKereta() == kereta.getJadwal().get(j).getKeretaID()){
                                rute.addItem(kereta.getJadwal().get(j).getLokasiDepart() + "-" + kereta.getJadwal().get(j).getLokasiArrive());
                            }
                        }
                    }
                }
            }
            
        });
        rute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jam.removeAllItems();
                tanggal.removeAllItems();
        
                try{
                    Object rut = rute.getSelectedItem();
                    String str = rut.toString();
                    if(rute.getSelectedIndex() % 2 == 0){
                        for(int i = 0; i < 15; i++){
                            tanggal.addItem(isiTanggal[0][i]);
                        }
                    }else{
                        for(int i = 0; i < 15; i++){
                           tanggal.addItem(isiTanggal[1][i]);
                        }
                    }
        
                    KeretaJadwal jadwal = new KeretaJadwal();
        
                    for(int i = 0; i < str.length(); i++){
                        String s = str.substring(i, i+1);
                        if(s.equals("-")){
                            String cek1 = str.substring(0, i);
                            String cek2 = str.substring(i+1, str.length());
                            jadwal = controller.getJadwal(cek1, cek2);
                            kereta = controller.getKereta(jadwal.getKeretaID(), jadwal.getDeparture());
                            KeretaManager.getInstance().setKereta(kereta);
                            String j = jadwal.getJamDepart() + "-" + jadwal.getJamArrive();
                            jam.addItem(j);
                        }
                    }
                }catch(Exception a){
                }
            }
        });
        submit = new JButton("Submit");
        submit.setBounds(150, 200, 430, 25);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                switch(e.getActionCommand()){
                    case "Submit":
                        Pesanan pesanan = new ExtPesanan();
                        pesanan.setDepartureDipilih(departure.getSelectedItem().toString());
                        for(int i = 0; i < rute.getSelectedItem().toString().length(); i++){
                            String rut = rute.getSelectedItem().toString();
                            String s = rut.substring(i, i+1);
                            if(s.equals("-")){
                                String cek1 = rut.substring(0, i);
                                String cek2 = rut.substring(i+1, rut.length());
                                KeretaJadwal jadwal = controller.getJadwal(cek1, cek2);
                                pesanan.setScheduleID(jadwal.getScheduleID());
                                pesanan.setHargaTiket(jadwal.getHargaTiket());
                                pesanan.setTanggal(tanggal.getSelectedItem().toString());
                            }
                        }
                        frame.setVisible(false);
                        PesananManager.getInstance().setPesanan(pesanan);
                        new PemilihanKursi();
                        break;
                }       
            }
        });
        back = new JButton("Back");
        back.setBounds(250, 250, 230, 25);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(e.getActionCommand()){
                    case "Back":
                        new MenuMember();
                        break;
                }
            }
        });
        Garis garis = new Garis();

        frame.add(judul);
        frame.add(labelDeparture);
        frame.add(labelRute);
        frame.add(labelTanggal);
        frame.add(labelJam);
        frame.add(departure);
        frame.add(rute);
        frame.add(tanggal);
        frame.add(jam);
        frame.add(submit);
        frame.add(back);
        frame.add(garis);
        //frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
