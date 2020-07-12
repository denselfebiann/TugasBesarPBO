/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;

/**
 *
 * @author MelvinS
 */
public class MenuMyOrders {
    JFrame frame = new JFrame("Menu MyOrders");
    JLabel[] listPesanan = new JLabel[1];
    
    public MenuMyOrders(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        //ambil data dari db
        
        listPesanan[0] = new JLabel("orderID | departureDipilih | tanggal | kursiDipilih | hargaTiket | langganan | konsumsi | totalHarga");
        listPesanan[0].setBounds(20, 20, 500, 20);
        
//        for(int i = 0; i<listPesanan.length;i++){
//            //print data
//        }
        
        frame.add(listPesanan[0]);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuMyOrders();
    }
}
