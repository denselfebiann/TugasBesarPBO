/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RunningText;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author dense
 */
public class MenuMember implements ActionListener{
    private JButton order, langganan, myOrder;
    private RunningText welcome;
    private JLabel gambar;
    JFrame frame = new JFrame("Menu Member"); //hapus aja kalo ga perlu
    public MenuMember(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        String kata = "WELCOME DENSEL FEBIAN";
        welcome = new RunningText(kata);
        
        gambar = new JLabel("");
        gambar.setIcon(new ImageIcon("image/kereta.jpg"));
        gambar.setBounds(200, 50, 250, 250);
        
        order = new JButton("Order Ticket");
        order.setBounds(10, 50, 150, 50);
        order.addActionListener(this);
        
        langganan = new JButton("Langganan");
        langganan.setBounds(10, 150, 150, 50);
        langganan.addActionListener(this);
        
        myOrder = new JButton("My Orders");
        myOrder.setBounds(10, 250, 150, 50);
        myOrder.addActionListener(this);
        
        frame.add(order);
        frame.add(langganan);
        frame.add(myOrder);
        frame.add(gambar);
        frame.add(welcome);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(welcome).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Order Ticket":
                frame.setVisible(false);
                MenuOrder order = new MenuOrder();
                break;
            case "Langganan":
                break;
            case "My Orders":
                frame.setVisible(true);
                new MenuMyOrders();
                break;
        }
    }
}
