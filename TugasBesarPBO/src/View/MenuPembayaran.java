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
import Model.ExtPesanan;
import Model.Pembayaran;
import Model.Pesanan;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dense
 */
public class MenuPembayaran implements ActionListener{
    JFrame frame = new JFrame("Menu Pembayaran");
    JLabel labelGaris, labelJudul, labelMetode;
    JLabel[] labelTotalHarga = new JLabel[2], labelHarga = new JLabel[2], labelHargaTiket = new JLabel[2], labelDiskon = new JLabel[2];
    JLabel[] namaKonsumsi, hargaSatuanKonsumsi, hargaTotalKonsumsi;
    JComboBox metode;
    JButton submit;
    String[] method;
    int banyakMetode, banyakKonsumsi;
    ArrayList<Pembayaran> allPembayaran = new ArrayList<>();
    DatabaseControl controller = new DatabaseControl();
    public MenuPembayaran(){
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        allPembayaran = controller.getAllPembayaran();
        for(int i = 0; i < allPembayaran.size(); i++){
            banyakMetode++;
        }
        method = new String[banyakMetode];
        for(int i = 0; i < allPembayaran.size(); i++){
            method[i] = allPembayaran.get(i).getMetodePembayaran();
        }
        Pesanan pesanan = PesananManager.getInstance().getPesanan();
        ExtPesanan a = (ExtPesanan)pesanan;
        
        labelHargaTiket[0] = new JLabel("Harga Tiket: Rp. " + PesananManager.getInstance().getPesanan().getHargaTiket() + " x " + PesananManager.getInstance().getPesanan().getKursi() + " = ");
        labelHargaTiket[0].setBounds(100, 100, 400, 25);
        labelHargaTiket[0].setFont(new Font(labelHargaTiket[0].getFont().getName(), labelHargaTiket[0].getFont().getStyle(), 18));
        labelHargaTiket[1] = new JLabel("Rp. " + PesananManager.getInstance().getPesanan().getTotalHargaTiket());
        labelHargaTiket[1].setBounds(400, 100, 180, 25);
        labelHargaTiket[1].setFont(new Font(labelHargaTiket[1].getFont().getName(), labelHargaTiket[1].getFont().getStyle(), 18));
        
        labelHarga[0] = new JLabel("Harga: ");
        labelHarga[0].setFont(new Font(labelHarga[0].getFont().getName(), labelHarga[0].getFont().getStyle(), 18));
        labelHarga[1] = new JLabel("Rp. " + PesananManager.getInstance().getPesanan().getTotalHarga());
        labelHarga[1].setFont(new Font(labelHarga[1].getFont().getName(), labelHarga[1].getFont().getStyle(), 18));
        
        labelDiskon[0] = new JLabel("Diskon: " + allPembayaran.get(0).getDiskon() + "% =>");
        labelDiskon[0].setFont(new Font(labelDiskon[0].getFont().getName(), labelDiskon[0].getFont().getStyle(), 18));
        labelDiskon[1] = new JLabel("Rp. " + (PesananManager.getInstance().getPesanan().getTotalHargaTiket() * (allPembayaran.get(0).getDiskon() / 100)));
        labelDiskon[1].setFont(new Font(labelDiskon[1].getFont().getName(), labelDiskon[1].getFont().getStyle(), 18));
        
        labelTotalHarga[0] = new JLabel("Total Harga: ");
        labelTotalHarga[0].setFont(new Font(labelTotalHarga[0].getFont().getName(), labelTotalHarga[0].getFont().getStyle(), 18));
        labelTotalHarga[1] = new JLabel("Rp. " + (PesananManager.getInstance().getPesanan().getTotalHarga()-(PesananManager.getInstance().getPesanan().getTotalHargaTiket() * (allPembayaran.get(0).getDiskon() / 100))));
        labelTotalHarga[1].setFont(new Font(labelTotalHarga[1].getFont().getName(), labelTotalHarga[1].getFont().getStyle(), 18));
        
        labelGaris = new JLabel("----------------------------------------------------------------------------------------------------");
        labelGaris.setFont(new Font(labelGaris.getFont().getName(), labelGaris.getFont().getStyle(), 18));
        submit = new JButton("Submit");
        submit.addActionListener(this);
        
        labelJudul = new JLabel("Pembayaran");
        labelJudul.setBounds(300, 0, 200, 25);
        labelJudul.setFont(new Font(labelJudul.getFont().getName(), labelJudul.getFont().getStyle(), 28));
        
        labelMetode = new JLabel("Pilih Metode Pembayaran");
        labelMetode.setBounds(100, 40, 300, 25);
        labelMetode.setFont(new Font(labelMetode.getFont().getName(), labelMetode.getFont().getStyle(), 22));
        
        metode = new JComboBox(method);
        metode.setBounds(400, 40, 180, 25);
        metode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < allPembayaran.size(); i++){
                    if(allPembayaran.get(i).getMetodePembayaran().equals(metode.getSelectedItem())){
                        labelDiskon[0].setText("Diskon: " + allPembayaran.get(i).getDiskon() + "% =>");
                        float diskon = PesananManager.getInstance().getPesanan().getTotalHarga() * (Float.valueOf(allPembayaran.get(i).getDiskon()) / 100);
                        labelDiskon[1].setText("Rp. " + (int)diskon);
                        labelTotalHarga[1].setText("Rp. " + (PesananManager.getInstance().getPesanan().getTotalHarga() - (int)diskon));
                    }
                }
            }
        });
        
        if(a.getKonsumsi() != null){
            for(int i = 0; i < a.getKonsumsi().size(); i++){
                banyakKonsumsi++;
            }
            namaKonsumsi = new JLabel[banyakKonsumsi];
            hargaSatuanKonsumsi = new JLabel[banyakKonsumsi];
            hargaTotalKonsumsi = new JLabel[banyakKonsumsi];
            int x1 = 100, x2 = 250, x3 = 400, y = 140;
            for(int i = 0; i < banyakKonsumsi; i++){
                namaKonsumsi[i] = new JLabel(a.getKonsumsi().get(i).getNamaProduk());
                hargaSatuanKonsumsi[i] = new JLabel("Rp. " + Integer.toString(a.getKonsumsi().get(i).getHargaSatuan()) + " x " + Integer.toString(a.getKonsumsi().get(i).getJumlah()));
                hargaTotalKonsumsi[i] = new JLabel("Rp. " + Integer.toString(a.getKonsumsi().get(i).getHargaSatuan() * a.getKonsumsi().get(i).getJumlah()));
                namaKonsumsi[i].setBounds(x1, y, 300, 25);
                hargaSatuanKonsumsi[i].setBounds(x2, y, 300, 25);
                hargaTotalKonsumsi[i].setBounds(x3, y, 300, 25);
                namaKonsumsi[i].setFont(new Font(namaKonsumsi[i].getFont().getName(), namaKonsumsi[i].getFont().getStyle(), 18));
                hargaSatuanKonsumsi[i].setFont(new Font(hargaSatuanKonsumsi[i].getFont().getName(), hargaSatuanKonsumsi[i].getFont().getStyle(), 18));
                hargaTotalKonsumsi[i].setFont(new Font(hargaTotalKonsumsi[i].getFont().getName(), hargaTotalKonsumsi[i].getFont().getStyle(), 18));
                y += 40;
                frame.add(namaKonsumsi[i]);
                frame.add(hargaSatuanKonsumsi[i]);
                frame.add(hargaTotalKonsumsi[i]);
            }
            labelHarga[0].setBounds(100, y, 180, 25);
            labelHarga[1].setBounds(400, y, 180, 25);
            labelDiskon[0].setBounds(100, y+60, 300, 25);
            labelDiskon[1].setBounds(400, y+60, 180, 25);
            labelTotalHarga[0].setBounds(100, y+120, 180, 25);
            labelTotalHarga[1].setBounds(400, y+120, 180, 25);
            labelGaris.setBounds(100, y+80, 650, 25);
            submit.setBounds(100, y+180, 600, 25);
        }else{
            banyakKonsumsi = 0;
            labelHarga[0].setBounds(100, 140, 180, 25);
            labelHarga[1].setBounds(400, 140, 180, 25);
            labelDiskon[0].setBounds(100, 200, 300, 25);
            labelDiskon[1].setBounds(400, 200, 180, 25);
            labelTotalHarga[0].setBounds(100, 260, 180, 25);
            labelTotalHarga[1].setBounds(400, 260, 180, 25);
            labelGaris.setBounds(100, 220, 650, 25);
            submit.setBounds(100, 320, 600, 25);
        }
        
        Garis garis = new Garis();
        
        frame.add(labelJudul);
        frame.add(labelMetode);
        frame.add(submit);
        for(int i = 0; i < 2; i++){
            frame.add(labelHarga[i]);
            frame.add(labelHargaTiket[i]);
            frame.add(labelDiskon[i]);
            frame.add(labelTotalHarga[i]);
        }
        frame.add(labelGaris);
        frame.add(metode);
        frame.add(garis);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Submit":
                ExtPesanan a = (ExtPesanan)PesananManager.getInstance().getPesanan();
                int temp;
                String t = labelHarga[1].getText().substring(4, labelHarga[1].getText().length());
                temp = Integer.valueOf(t);
                a.setTotalHargaTiket(temp);
                t = labelTotalHarga[1].getText().substring(4, labelTotalHarga[1].getText().length());
                temp = Integer.valueOf(t);
                a.setTotalHarga(temp);
                if(controller.insertNewPesanan(UserManager.getInstance().getUser().getIdUser(), a)){
                    JOptionPane.showMessageDialog(null, "Pesanan Berhasil!!");
                    new MenuMember();
                }
                break;
        }
    }
}
