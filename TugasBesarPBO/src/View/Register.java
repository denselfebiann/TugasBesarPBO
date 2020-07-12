/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.registerMember;
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
 * @author MelvinS
 */
public class Register implements ActionListener{
    JLabel username, password, email, passwordRe, namaLengkap, telepon, kota, alamat, KTP, konfirmasi;
    JTextField textUsername, textEmail, textNamaLengkap, textTelepon, textKota, textAlamat, textKTP;
    JPasswordField textPassword, textPasswordRe;
    JButton submit, cancel, back;
    JFrame frame = new JFrame();
    public Register(){
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Register");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        username = new JLabel("Username");
        password = new JLabel("Password");
        passwordRe = new JLabel("Password Retype");
        username.setBounds(40, 20, 100, 50);
        password.setBounds(40, 40, 100, 50);
        passwordRe.setBounds(40, 60, 100, 50);
        
        email = new JLabel("Email");
        namaLengkap = new JLabel("Nama Lengkap");
        telepon = new JLabel("Nomor Telepon");
        kota = new JLabel("Kota");
        alamat = new JLabel("Alamat");
        KTP = new JLabel("Nomor KTP");
        email.setBounds(40, 80, 100, 50);
        namaLengkap.setBounds(40, 100, 100, 50);
        telepon.setBounds(40, 120, 100, 50);
        kota.setBounds(40, 140, 100, 50);
        alamat.setBounds(40, 160, 100, 50);
        KTP.setBounds(40, 180, 100, 50);
        
        
        textUsername = new JTextField();
        textUsername.setBounds(150, 40, 100, 20);
        textPassword = new JPasswordField();
        textPassword.setBounds(150, 60, 100, 20);
        textPasswordRe = new JPasswordField();
        textPasswordRe.setBounds(150, 80, 100, 20);
        textEmail = new JTextField();
        textEmail.setBounds(150, 100, 100, 20);
        textNamaLengkap = new JTextField();
        textNamaLengkap.setBounds(150, 120, 100, 20);
        textTelepon = new JTextField();
        textTelepon.setBounds(150, 140, 100, 20);
        textKota = new JTextField();
        textKota.setBounds(150, 160, 100, 20);
        textAlamat = new JTextField();
        textAlamat.setBounds(150, 180, 100, 20);
        textKTP = new JTextField();
        textKTP.setBounds(150, 200, 100, 20);
        
        
        
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        back = new JButton("Back");
        submit.setBounds(40, 240, 100, 20);
        cancel.setBounds(150, 240, 100, 20);
        back.setBounds(90, 270, 100, 20);
        submit.addActionListener(this);
        cancel.addActionListener(this);
        back.addActionListener(this);
        
        konfirmasi = new JLabel();
        
        konfirmasi.setBounds(100, 300, 100, 30);
        
        frame.add(konfirmasi);
        frame.add(submit);
        frame.add(cancel);
        frame.add(back);
        frame.add(textUsername);
        frame.add(textPassword);
        frame.add(textPasswordRe);
        frame.add(textEmail);
        frame.add(textNamaLengkap);
        frame.add(textTelepon);
        frame.add(textKota);
        frame.add(textAlamat);
        frame.add(textKTP);
        frame.add(username);
        frame.add(password);
        frame.add(passwordRe);
        frame.add(email);
        frame.add(namaLengkap);
        frame.add(telepon);
        frame.add(kota);
        frame.add(alamat);
        frame.add(KTP);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Register();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Submit":
                String username = textUsername.getText();
                String password = textPassword.getText();
                String passwordRe = textPasswordRe.getText();
                String email = textEmail.getText();
                String namaLengkap = textNamaLengkap.getText();
                String telepon = textTelepon.getText();
                String kota = textKota.getText();
                String alamat = textAlamat.getText();
                String KTP = textKTP.getText();
                
                registerMember register = new registerMember(username, password, passwordRe, email, namaLengkap, telepon, kota, alamat, KTP);
                break;
            case "Back":
                frame.setVisible(false);
                new Login();
                break;
            case "Cancel":
                System.exit(1);
                break;
        }
    }
}
