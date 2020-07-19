/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserManager;
import Controller.cekLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dense
 */
public class MenuLogin implements ActionListener{
    JLabel username, password, konfirmasi;
    JTextField textUsername;
    JPasswordField textPassword;
    JButton submit, cancel, register;
    JFrame frame = new JFrame("Menu Login");
    public MenuLogin(){
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        username = new JLabel("Username");
        password = new JLabel("Password");
        username.setBounds(40, 90, 100, 50);
        password.setBounds(40, 140, 100, 50);
        
        textUsername = new JTextField();
        textUsername.setBounds(103, 106, 100, 20);
        textPassword = new JPasswordField();
        textPassword.setBounds(103, 156, 100, 20);
        
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        register = new JButton("Register");
        submit.setBounds(40, 180, 100, 20);
        cancel.setBounds(150, 180, 100, 20);
        register.setBounds(100, 210, 100, 20);
        submit.addActionListener(this);
        cancel.addActionListener(this);
        register.addActionListener(this);
        
        konfirmasi = new JLabel();
        
        konfirmasi.setBounds(100, 300, 100, 30);
        
        frame.add(konfirmasi);
        frame.add(submit);
        frame.add(cancel);
        frame.add(register);
        frame.add(textUsername);
        frame.add(textPassword);
        frame.add(username);
        frame.add(password);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Submit":
                String user = textUsername.getText();
                String pass = new String(textPassword.getPassword());
                if(UserManager.getInstance().getUser().cekLogin(user, pass)){
                    if(UserManager.getInstance().getUser().cekAdmin()){
                        new MenuAdmin();
                    }else{
                        new MenuMember();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Username/Password Salah!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Register":
                frame.setVisible(false);
                new MenuRegister();
                break;
            case "Cancel":
                System.exit(1);
                break;
        }
    }
}
