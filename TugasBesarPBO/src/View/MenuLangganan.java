/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserManager;
import Model.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MelvinS
 */
public class MenuLangganan implements ActionListener{
    JFrame frame = new JFrame("Menu Langganan"); //hapus aja kalo ga perlu
    Users user = UserManager.getInstance().getUser();
    int availablePoint = user.getPointLangganan();
    int availableFreeRide = user.getGiftRide();
    public MenuLangganan(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
                
        
        
        JLabel nameLabel = new JLabel("Nama: " + user.getNamaLengkap());
        nameLabel.setBounds(20, 20, 200, 20);
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        emailLabel.setBounds(20, 40, 200, 20);
        JLabel pointsLabel = new JLabel("Points Available: " + Integer.toString(user.getPointLangganan()));
        pointsLabel.setBounds(20, 60, 200, 20);
        JLabel voucherLabel = new JLabel("Vouchers Available: " + Integer.toString(user.getGiftRide()));
        voucherLabel.setBounds(20, 80, 200, 20);
        
        JButton exchangeButton = new JButton("Exchange");
        exchangeButton.setBounds(20, 300, 100, 20);
        exchangeButton.addActionListener(this);
        JButton backButton = new JButton("Back");
        backButton.setBounds(20, 320, 100, 20);
        backButton.addActionListener(this);
        
        
        frame.add(voucherLabel);
        frame.add(exchangeButton);
        frame.add(backButton);
        frame.add(nameLabel);
        frame.add(emailLabel);
        frame.add(pointsLabel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuLangganan();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        
        switch(e.getActionCommand()){
            case "Back":
                frame.setVisible(false);
                new MenuMember();
                break;
            case "Exchange":
//                frame.setVisible(false);
                
                if(availablePoint >= 1000){
                    user.setPointLangganan(availablePoint - 1000);
                    user.setGiftRide(availableFreeRide+1);
                    JOptionPane.showMessageDialog(null, "Exchanged succesfully!");
                    user.updatePointDatabase();
                    user.updateVoucherDatabase();
                }else{
                    JOptionPane.showMessageDialog(null, "Point tidak cukup! \n Point anda: " + availablePoint + "/1000");
                }
                
                
                break;
        }
    }
}