/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.UserManager;
import Model.Orders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author dense
 */
public class MenuAdmin implements ActionListener{
    
    JButton cekPesanan = new JButton("Tampilkan Semua Pesanan");
//    JButton ubahSchedule = new JButton("Reschedule");
    JFrame frame = new JFrame("Menu Admin");
    
    DatabaseControl control = new DatabaseControl();
        
        String column[] = {"ID Order", "ID User","Departure", "Arrival","Tanggal","Nomor Kursi","Harga Tiket","Langganan","Total Harga"};
        
        ArrayList<Orders> listOrders = control.getAllPesanan();
        
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        
        
        
        JTable tabelOrder = new JTable(tableModel);
    
    public MenuAdmin(){
        
        
        
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        
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
        
        JTableHeader header = tabelOrder.getTableHeader();
        
        tabelOrder.setBounds(0, 20, 700, 290);
        
        header.setBounds(0, 0, 700, 20);
        
        
        cekPesanan.setBounds(20, 310, 200, 50);
        cekPesanan.addActionListener(this);
//        ubahSchedule.setBounds(120, 310, 200, 50);
//        ubahSchedule.addActionListener(this);
        
        
        
        frame.add(cekPesanan);
//        frame.add(ubahSchedule);
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        

        header.setVisible(false);
        tabelOrder.setVisible(false);
        
        frame.add(header);
        frame.add(tabelOrder);
        
        
        
        
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
        
        
        

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Tampilkan Semua Pesanan":
                JTableHeader header = tabelOrder.getTableHeader();
                header.setVisible(true);
                tabelOrder.setVisible(true);
                break;
//            case "Reschedule":
////                frame.setVisible(false);
//                break;
        }
    }

    
    public static void main(String[] args) {
        new MenuAdmin();
    }
}