/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.Garis;
import Controller.PesananManager;
import Controller.UserManager;
import Model.Konsumsi;
import Model.Member;
import Model.Pesanan;
import Model.ExtPesanan;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dense
 */
public class MenuKonsumsi implements ActionListener{
    JFrame frame = new JFrame("Menu Konsumsi");
    JLabel labelKonsumsi, labelMakanan, labelMinuman;
    JLabel[] namaMakanan, namaMinuman, hargaMakanan, hargaMinuman;
    JComboBox[] banyakMakanan, banyakMinuman;
    JButton submit, back;
    DatabaseControl controller = new DatabaseControl();
    ArrayList<Konsumsi> konsumsi = controller.getAllKonsumsi();
    int jumlahMakanan = 0, jumlahMinuman = 0;
    
    public MenuKonsumsi(){
        int pilih = JOptionPane.showConfirmDialog(null, "Wanna Buy some Food?");
        if(pilih == JOptionPane.YES_OPTION){
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            for(int i = 0; i < konsumsi.size(); i++){
                if(konsumsi.get(i).getTipe().equals("makanan")){
                    jumlahMakanan++;
                }else if(konsumsi.get(i).getTipe().equals("minuman")){
                    jumlahMinuman++;
                }
            }
            namaMakanan = new JLabel[jumlahMakanan];
            namaMinuman = new JLabel[jumlahMinuman];
            banyakMakanan = new JComboBox[jumlahMakanan];
            banyakMinuman = new JComboBox[jumlahMinuman];
            hargaMakanan = new JLabel[jumlahMakanan];
            hargaMinuman = new JLabel[jumlahMinuman];
            
            int x1 = 150, x2 = 320, x3 = 250, y1 = 80, y2 = 84, y3 = 80;
            int x4 = 150, x5 = 320, x6 = 250, y4 = 320, y5 = 324, y6 = 320;
            int counterMakanan = 0, counterMinuman = 0;
            for(int i = 0; i < konsumsi.size(); i++){
                if(konsumsi.get(i).getTipe().equals("makanan")){
                    namaMakanan[counterMakanan] = new JLabel(konsumsi.get(i).getNamaProduk());
                    hargaMakanan[counterMakanan] = new JLabel("Rp. " + konsumsi.get(i).getHargaSatuan());
                    banyakMakanan[counterMakanan] = new JComboBox();
                    for(int j = 0; j <= konsumsi.get(i).getJumlah(); j++){
                        banyakMakanan[counterMakanan].addItem(j);
                    }
                    namaMakanan[counterMakanan].setBounds(x1, y1, 150, 25);
                    hargaMakanan[counterMakanan].setBounds(x3, y3, 150,25);
                    banyakMakanan[counterMakanan].setBounds(x2, y2, 80, 20);
                    
                    frame.add(hargaMakanan[counterMakanan]);
                    frame.add(banyakMakanan[counterMakanan]);
                    frame.add(namaMakanan[counterMakanan]);
                    y1 += 40;
                    y2 += 40;
                    y3 += 40;
                    if(y1 > 250){
                        y1 = 80;
                        y2 = 84;
                        y3 = 80;
                        x1 += 260;
                        x2 += 260;
                        x3 += 260;
                    }
                    counterMakanan++;
                }else if(konsumsi.get(i).getTipe().equals("minuman")){
                    namaMinuman[counterMinuman] = new JLabel(konsumsi.get(i).getNamaProduk());
                    hargaMinuman[counterMinuman] = new JLabel("Rp. " + konsumsi.get(i).getHargaSatuan());
                    banyakMinuman[counterMinuman] = new JComboBox();
                    for(int j = 0; j <= konsumsi.get(i).getJumlah(); j++){
                        banyakMinuman[counterMinuman].addItem(j);
                    }
                    namaMinuman[counterMinuman].setBounds(x4, y4, 150, 25);
                    banyakMinuman[counterMinuman].setBounds(x5, y5, 80, 20);
                    hargaMinuman[counterMinuman].setBounds(x6, y6, 80, 20);
                    
                    frame.add(hargaMinuman[counterMinuman]);
                    frame.add(namaMinuman[counterMinuman]);
                    frame.add(banyakMinuman[counterMinuman]);
                    y4 += 40;
                    y5 += 40;
                    y6 += 40;
                    if(y4 > 550){
                        y4 = 320;
                        y5 = 324;
                        y6 = 320;
                        x4 += 260;
                        x5 += 260;
                        x6 += 260;
                    }
                    counterMinuman++;
                }
            }
            labelKonsumsi = new JLabel("Konsumsi");
            labelMakanan = new JLabel("Food");
            labelMinuman = new JLabel("Drink");
            
            labelKonsumsi.setBounds(300, 0, 200, 25);
            labelMakanan.setBounds(150, 40, 250, 25);
            labelMinuman.setBounds(150, 280, 250, 25);
            
            labelKonsumsi.setFont(new Font(labelKonsumsi.getFont().getName(), labelKonsumsi.getFont().getStyle(), 28));
            labelMakanan.setFont(new Font(labelMakanan.getFont().getName(), labelMakanan.getFont().getStyle(), 22));
            labelMinuman.setFont(new Font(labelMinuman.getFont().getName(), labelMinuman.getFont().getStyle(), 22));
            
            submit = new JButton("Submit");
            submit.setBounds(650, 480, 100, 25);
            submit.addActionListener(this);
            back = new JButton("Back");
            back.setBounds(650, 520, 100, 25);
            back.addActionListener(this);
            Garis garis = new Garis();
            
            frame.add(submit);
            frame.add(back);
            frame.add(labelKonsumsi);
            frame.add(labelMakanan);
            frame.add(labelMinuman);
            frame.add(garis);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }else{
            Pesanan pesanan = PesananManager.getInstance().getPesanan();
            ExtPesanan a = (ExtPesanan)pesanan;
            a.setTotalHargaKonsumsi(0);
            a.setTotalHarga(a.getTotalHargaTiket());
            PesananManager.getInstance().setPesanan(a);
            new MenuPembayaran();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Submit":
                ArrayList<Konsumsi> allKonsumsi = new ArrayList<>();
                for(int i = 0; i < jumlahMakanan; i++){
                    Konsumsi konsumsi = new Konsumsi();
                    if(banyakMakanan[i].getSelectedIndex() != 0){
                        String h = hargaMakanan[i].getText().substring(4, hargaMakanan[i].getText().length());
                        int harga = Integer.parseInt(h);
                        konsumsi.setNamaProduk(namaMakanan[i].getText());
                        konsumsi.setTipe("makanan");
                        konsumsi.setJumlah(Integer.parseInt(banyakMakanan[i].getSelectedItem().toString()));
                        konsumsi.setHargaSatuan(harga);
                        allKonsumsi.add(konsumsi);
                    }
                }
                Pesanan pesanan = PesananManager.getInstance().getPesanan();
                ExtPesanan a = (ExtPesanan)pesanan;
                a.setKonsumsi(allKonsumsi);
                
                int total = 0;
                for(int i = 0; i < allKonsumsi.size(); i++){
                    total += (allKonsumsi.get(i).getHargaSatuan() * allKonsumsi.get(i).getJumlah());
                }
                a.setTotalHargaKonsumsi(total);
                total += a.getTotalHargaTiket();
                a.setTotalHarga(total);
                PesananManager.getInstance().setPesanan(a);
                frame.setVisible(false);
                new MenuPembayaran();
                break;
            case "Back":
                frame.setVisible(false);
                new MenuOrder();
                break;
        }
    }


}
