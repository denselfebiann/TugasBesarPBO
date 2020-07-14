/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MelvinS
 */
public class LoginController {
    
    private DatabaseControl controller = new DatabaseControl();
    
    public boolean cekLogin(String username, String password){
        boolean cek = false;
        ArrayList<Users> user = controller.getAllUser();
        for(int i = 0; (i < user.size()) && (!cek); i++){
            if((username.equals(user.get(i).getUsername())) && (CommonController.stringToMD5(password).equals(user.get(i).getPassword()))){
                cek = true;
            }
        }
        return cek;
    }
    
    public boolean cekAdmin(String username){
        Users user = controller.getUser(username);
        boolean cek = false;
        if(user.getTipeUser() == 1){
            cek = true;
        }else if(user.getTipeUser() == 0){
            cek = false;
        }
        return cek;
    }
    
    
    public void registerMember(String username, String password, String passwordRe, String email, String namaLengkap, String telepon, String kota, String alamat, String KTP){
        
        if(password.equals(passwordRe)){
            if(DatabaseControl.cekRegister(KTP)){
                Users user = new Users();
                user.setUsername(username);
                user.setPassword(CommonController.stringToMD5(password));
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
