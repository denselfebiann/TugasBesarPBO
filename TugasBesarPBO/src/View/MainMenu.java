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
public class MainMenu implements ActionListener{
    private JButton login, register;
    JFrame frame = new JFrame();
    public MainMenu(){
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        login = new JButton("Login");
        login.setBounds(70, 80, 150, 50);
        login.addActionListener(this);
        register = new JButton("Register");
        register.setBounds(70, 150, 150, 50);
        register.addActionListener(this);
        

        frame.add(login);
        frame.add(register);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Login":
                frame.setVisible(false);
                Login login = new Login();
                break;
            case "Register":
                frame.setVisible(false);
                Register register = new Register();
                break;
        }
    }
}
