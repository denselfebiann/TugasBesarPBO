/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import javax.swing.JOptionPane;

/**
 *
 * @author MelvinS
 */
public class registerMember {
    private DatabaseControl controller = new DatabaseControl();
    
    public registerMember(String username, String password, String passwordRe, String email, String namaLengkap, String telepon, String kota, String alamat, String KTP){
        
        if(password.equals(passwordRe)){
            if(DatabaseControl.cekRegister(KTP)){
                Users user = new Users();
                user.setUsername(username);
                user.setPassword(Convert.stringToMD5(password));
                user.setEmail(email);
                user.setNamaLengkap(namaLengkap);
                user.setTelepon(telepon);
                user.setKota(kota);
                user.setAlamat(alamat);
                user.setKTP(KTP);

                DatabaseControl.insertNewUser(user);
            }else{
                JOptionPane.showMessageDialog(null, "Nomor KTP sudah terdaftar!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Password tidak sama!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
}
