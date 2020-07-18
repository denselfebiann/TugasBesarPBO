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
    JFrame frame = new JFrame();
    JLabel labelGerbong;
    JButton submit, nextGerbong, previousGerbong;
    DatabaseControl controller = new DatabaseControl();
    
    int maxKursi = 40;
    int banyakKursi;
    int currentGerbong = 1;
    int gerbong;
    
    JCheckBox[] kursi;
    JLabel[] kursiTerisi;
    boolean[] kursiKosong;
    Kereta kereta = KeretaManager.getInstance().getKereta();
    ArrayList<Boolean> k = controller.getKursi(PesananManager.getInstance().getPesanan().getScheduleID());
    
    public PemilihanKursi(Pesanan pesanan){
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pemilihan Kursi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = 50, y = 60, z = 0;
        gerbong = kereta.getGerbong();
        
        banyakKursi = kereta.getJumlahKursi();
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
        
        labelGerbong.setBounds(310, 10, 200, 35);
        nextGerbong.setBounds(500, 10, 200,  35);
        previousGerbong.setBounds(50, 10, 200, 35);
        submit.setBounds(330, 350, 100, 20);
        
        nextGerbong.addActionListener(this);
        previousGerbong.addActionListener(this);
        submit.addActionListener(this);
        
        labelGerbong.setFont(new Font(labelGerbong.getFont().getName(), labelGerbong.getFont().getStyle(), 28));

        for(int i = 0; i < (maxKursi * currentGerbong); i++){
            kursiKosong[i] = false;
            kursiKosong[10] = true;
            if(!kursiKosong[i]){
                kursi[i] = new JCheckBox();
                kursi[i].setBounds(x, y, 50, 50);
                System.out.println(i);
                frame.add(kursi[i]);
            }else{
                kursiTerisi[i] = new JLabel("X");
                kursiTerisi[i].setBounds(x+5, y, 50, 50);
                frame.add(kursiTerisi[i]);
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
                kursi[5].setEnabled(false);
                labelGerbong.setText("Gerbong " + currentGerbong);
                //for(int i = 0; i < maxKursi; i++){
                //    frame.remove(kursi[i]);
                //    kursiKosong[i+39] = false;
                //    kursi[i+39] = new JCheckBox();
                //    frame.add(kursi[i+39]);
                //}
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
                break;
        }
    }
}
