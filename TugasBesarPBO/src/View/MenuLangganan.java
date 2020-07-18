/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserManager;
import Model.Users;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MelvinS
 */
public class MenuLangganan {
    JFrame frame = new JFrame("Menu Langganan"); //hapus aja kalo ga perlu
    public MenuLangganan(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        Users user = UserManager.getInstance().getUser();
        
        JLabel nameLabel = new JLabel("Nama: " + user.getNamaLengkap());
        nameLabel.setBounds(20, 20, 200, 20);
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        emailLabel.setBounds(20, 40, 200, 20);
        JLabel pointsLabel = new JLabel("Points Available: " + Integer.toString(user.getPointLangganan()));
        pointsLabel.setBounds(20, 60, 200, 20);
        
        JButton exchangeButton = new JButton("Exchange");
        exchangeButton.setBounds(20, 300, 100, 20);
        
        
        frame.add(exchangeButton);
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
}
