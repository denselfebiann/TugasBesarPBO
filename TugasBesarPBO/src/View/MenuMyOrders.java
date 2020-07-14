/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Model.MyOrders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public MenuMyOrders(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        //ambil data dari db
        int IDUser = 0;
        DatabaseControl control = new DatabaseControl();
        
        String column[] = {"ID Order","Departure","Arrival","Tanggal","Nomor Kursi","Harga Tiket","Langganan","Konsumsi","Total Harga"};
        String data[][] = {{"01","Bandung","Yogyakarta","10/07/2020","A3","50000","Langganan_2","Konsumsi_1","60000"},
                            {"02","Yogyakarta","Tangerang","14/07/2020","J1","100000","Langganan_3","Konsumsi_3","120000"},
                            {"05","Tangerang","Bandung","16/07/2020","C3","50000","Langganan_1","Konsumsi_1","60000"},
                            };
        
        control.getPesanan(IDUser);
        
        ArrayList<MyOrders> listOrders = new ArrayList<>();
        for(int i = 0; i<data.length; i++){
            MyOrders order_cobain = new MyOrders();
            order_cobain.setOrderID(data[i][0]);
            order_cobain.setDeparture(data[i][1]);
            order_cobain.setArrival(data[i][2]);
            order_cobain.setTanggal(data[i][3]);
            order_cobain.setKursi(data[i][4]);
            order_cobain.setHargaTiket(data[i][5]);
            order_cobain.setLangganan(data[i][6]);
            order_cobain.setKonsumsi(data[i][7]);
            order_cobain.setTotalHarga(data[i][8]);
            listOrders.add(order_cobain);
            
            
        }
        
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(tableModel);
        
        for(int i = 0; i<listOrders.size(); i++){
            String orderID = listOrders.get(i).getOrderID();
            String departure = listOrders.get(i).getDeparture();
            String arrival = listOrders.get(i).getArrival();
            String tanggal = listOrders.get(i).getTanggal();
            String kursi = listOrders.get(i).getKursi();
            String hargaTiket = listOrders.get(i).getHargaTiket();
            String langganan = listOrders.get(i).getLangganan();
            String konsumsi = listOrders.get(i).getKonsumsi();
            String totalHarga = listOrders.get(i).getTotalHarga();
            
            String[] data_coba = {orderID, departure, arrival, tanggal, kursi, hargaTiket, langganan, konsumsi, totalHarga};
            tableModel.addRow(data_coba);

        }
        
        
        
        JTable tabelOrder = new JTable(tableModel);
        
        tabelOrder.setBounds(0, 20, 700, 290);
        JTableHeader header = tabelOrder.getTableHeader();
        header.setBounds(0, 0, 700, 20);
        

        frame.add(header);
        frame.add(tabelOrder);

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
