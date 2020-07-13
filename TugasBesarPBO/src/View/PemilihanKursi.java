/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.cekLogin;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JLabel judul;
    JButton submit, cancel, register;
    
    JFrame frame = new JFrame();
    
    int banyakKursi = 40;
    JCheckBox[] kursi = new JCheckBox[banyakKursi];
    JLabel[] kursiTerisi = new JLabel[banyakKursi];
    boolean[] kursiKosong = {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, };
    public PemilihanKursi(){
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pemilihan Kursi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Silahkan Pilih Kursi");
        judul.setFont(new Font(judul.getFont().getName(), judul.getFont().getStyle(), 18));
        judul.setBounds(60, 10, 200, 50);

        frame.add(judul);
        
        int x = 50, y = 60, z = 0;
        for(int i = 0; i < banyakKursi; i++){
            if(!kursiKosong[i]){
                kursi[i] = new JCheckBox();
                kursi[i].setBounds(x, y, 15, 15);
                frame.add(kursi[i]);
            }else{
                kursiTerisi[i] = new JLabel("X");
                kursiTerisi[i].setBounds(x+5, y, 15, 15);
                frame.add(kursiTerisi[i]);
            }
            x += 20;
            if(x > 230){
                x = 50;
                y += 20;
                z++;
            }
            if(z == 2){
                y += 20;
                z = 0;
            }
        }
        
        
        submit = new JButton("Submit");
        submit.setBounds(85, 180, 100, 20);
        submit.addActionListener(this);
        
        frame.add(submit);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Submit":
                break;
        }
    }
}
