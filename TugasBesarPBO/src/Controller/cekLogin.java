/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import java.util.ArrayList;

/**
 *
 * @author dense
 */
public class cekLogin {
    private DatabaseControl controller = new DatabaseControl();
    public boolean cekLogin(String username, String password){
        boolean cek = false;
        ArrayList<Users> user = controller.getAllUser();
        for(int i = 0; (i < user.size()) && (!cek); i++){
            if((username.equals(user.get(i).getUsername())) && (Convert.stringToMD5(password).equals(user.get(i).getPassword()))){
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
}
