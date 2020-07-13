/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author MelvinS
 */
public class MenuMyOrders implements ActionListener{
    JFrame frame = new JFrame("Menu MyOrders");
    JLabel[] listPesanan = new JLabel[3];
    JButton back;
    
    public MenuMyOrders(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        //ambil data dari db
        
        int height = 20;
        
        
        listPesanan[0] = new JLabel("orderID111 | departureDipilih | tanggal | kursiDipilih | hargaTiket | langganan | konsumsi | totalHarga");
        listPesanan[1] = new JLabel("orderID222 | departureDipilih | tanggal | kursiDipilih | hargaTiket | langganan | konsumsi | totalHarga");
        listPesanan[2] = new JLabel("orderID333 | departureDipilih | tanggal | kursiDipilih | hargaTiket | langganan | konsumsi | totalHarga");
        for(int i = 0; i<listPesanan.length;i++){
            listPesanan[i].setBounds(10, height, 600, 20);
            frame.add(listPesanan[i]);
            height += 20;
        }
        JButton back = new JButton("Back");
        back.setBounds(20, 300, 100, 20);
        back.addActionListener(this);
        
        frame.add(back);
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuMyOrders();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
