/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.KeretaManager;
import Controller.PesananManager;
import Controller.cekLogin;
import Model.Kereta;
import Model.Pesanan;
import Model.ExtPesanan;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dense
 */
public class PemilihanKursi implements ActionListener{
    JFrame frame = new JFrame("Pemilihan Kursi");
    JLabel labelGerbong;
    JButton submit, back, nextGerbong, previousGerbong;
    DatabaseControl controller = new DatabaseControl();
    
    int maxKursi = 40;
    int banyakKursi;
    int currentGerbong = 1;
    int gerbong;
    int banyakPilih;
    int counterKosong = 0, counterIsi = 0;
    String dipilih = "";
    
    JCheckBox[] kursi;
    JLabel[] kursiTerisi;
    boolean[] kursiKosong;
    Kereta kereta = KeretaManager.getInstance().getKereta();
    ArrayList<Boolean> k = controller.getKursi(PesananManager.getInstance().getPesanan().getScheduleID());
    
    public PemilihanKursi(){
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pemilihan Kursi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = 50, y = 60, z = 0;
        gerbong = kereta.getGerbong();
        
        banyakKursi = k.size();
        kursi = new JCheckBox[banyakKursi];
        kursiTerisi = new JLabel[banyakKursi];
        kursiKosong = new boolean[banyakKursi];
        
        for(int i = 0; i < k.size(); i++){
            kursiKosong[i] = k.get(i);
        }
        KeretaManager.getInstance().getKereta().setKursiKosong(kursiKosong);
        labelGerbong = new JLabel("Gerbong " + currentGerbong);
        nextGerbong = new JButton("Next Gerbong");
        previousGerbong = new JButton("Previous Gerbong");
        submit = new JButton("Submit");
        back = new JButton("Back");
        
        labelGerbong.setBounds(310, 10, 200, 35);
        nextGerbong.setBounds(500, 10, 200,  35);
        previousGerbong.setBounds(50, 10, 200, 35);
        submit.setBounds(330, 350, 100, 20);
        back.setBounds(330, 400, 100, 20);
        nextGerbong.addActionListener(this);
        previousGerbong.addActionListener(this);
        submit.addActionListener(this);
        back.addActionListener(this);
        
        labelGerbong.setFont(new Font(labelGerbong.getFont().getName(), labelGerbong.getFont().getStyle(), 28));
        
        for(int i = 0; i < maxKursi; i++){
            if(!kursiKosong[i]){
                kursi[counterKosong] = new JCheckBox();
                kursi[counterKosong].setBounds(x, y, 50, 50);
                frame.add(kursi[counterKosong]);
                counterKosong++;
            }else{
                kursiTerisi[counterIsi] = new JLabel("X");
                kursiTerisi[counterIsi].setBounds(x+5, y, 50, 50);
                frame.add(kursiTerisi[counterIsi]);
                counterIsi++;
            }
            x += 70;
            if(x > 700){
                x = 50;
                y += 50;
                z++;
            }
            if(z == 2){
                y += 50;
                z = 0;
            }
        }
        
        frame.add(submit);
        frame.add(back);
        frame.add(nextGerbong);
        frame.add(previousGerbong);
        frame.add(labelGerbong);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Next Gerbong":
                currentGerbong++;
                if(currentGerbong > gerbong){
                    currentGerbong = 1;
                }
                labelGerbong.setText("Gerbong " + currentGerbong);
                break;
            case "Previous Gerbong":
                frame.add(labelGerbong);
                currentGerbong--;
                if(currentGerbong <= 0){
                    currentGerbong = gerbong;
                }
                labelGerbong.setText("Gerbong " + currentGerbong);
                break;
            case "Submit":
                for(int i = 0; i < counterKosong; i++){
                    if(kursi[i].isSelected()){
                        kursiKosong[i] = true;
                        dipilih += (i+1) + " ";
                        banyakPilih++;
                        controller.updateKursi(i+1, PesananManager.getInstance().getPesanan().getScheduleID());
                        System.out.println(dipilih);
                    }
                }
                Pesanan pesanan = PesananManager.getInstance().getPesanan();
                int harga = pesanan.getHargaTiket();
                harga = harga * banyakPilih;
                ExtPesanan a = (ExtPesanan)pesanan;
                a.setKursiDipilih(dipilih);
                a.setDetailKereta(kereta);
                a.setGerbong(Integer.toString(gerbong));
                a.setKursi(banyakPilih);
                a.setTotalHargaTiket(harga);
                PesananManager.getInstance().setPesanan(a);
                frame.setVisible(false);
                new MenuKonsumsi();
                break;
            case "Back":
                frame.setVisible(false);
                new MenuOrder();
                break;
        }
    }
}
