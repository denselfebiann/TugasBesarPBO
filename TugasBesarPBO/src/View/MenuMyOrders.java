/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.UserManager;
import Model.Orders;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author MelvinS
 */
public class MenuMyOrders implements ActionListener{
    JFrame frame = new JFrame("Menu MyOrders");
    JLabel[] listPesanan = new JLabel[3];
    JButton back;
    
    public MenuMyOrders(int IDUser){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        
//        int IDUser = 7;  //Hapus Untuk ambil ke DB
        DatabaseControl control = new DatabaseControl();
        
        String column[] = {"ID Order","Departure", "Arrival","Tanggal","Nomor Kursi","Harga Tiket","Langganan","Total Harga"};
        
        ArrayList<Orders> listOrders = control.getPesanan(IDUser);
        
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        
        for(int i = 0; i<listOrders.size(); i++){
            String orderID = listOrders.get(i).getOrderID();
            String departure = listOrders.get(i).getDeparture();
            String arrival = listOrders.get(i).getArrival();
            String tanggal = listOrders.get(i).getTanggal();
            String kursi = listOrders.get(i).getKursi();
            String hargaTiket = listOrders.get(i).getHargaTiket();
            String langganan = listOrders.get(i).getLangganan();
            String totalHarga = listOrders.get(i).getTotalHarga();
            
            String[] data_coba = {orderID, departure, arrival, tanggal, kursi, hargaTiket, langganan, totalHarga};
            tableModel.addRow(data_coba);

        }
        
        
        
        JTable tabelOrder = new JTable(tableModel);
        
        tabelOrder.setBounds(0, 20, 700, 290);
        JTableHeader header = tabelOrder.getTableHeader();
        header.setBounds(0, 0, 700, 20);
        

        frame.add(header);
        frame.add(tabelOrder);

        JButton back = new JButton("Back");
        back.setBounds(20, 320, 100, 20);
        back.addActionListener(this);
        
        frame.add(back);
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuMyOrders(UserManager.getInstance().getUser().getIdUser());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        new MenuMember();
    }
}