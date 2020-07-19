/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sun.applet.Main;
//import sun.util.logging.PlatformLogger;

/**
 *
 * @author dense
 */
public class Convert {
    //Common Controller // UTIL
    public static String stringToMD5(String password){
        String digest = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b: hash){
                sb.append(String.format("%02x", b&0xff));
            }
            digest = sb.toString();
        }catch(Exception e){
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
        return digest;
    }
    public static String MD5ToString(String password){
        String md5 = null;
        try{
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(password.getBytes(), 0, password.length());
            md5 = new BigInteger(1, mdEnc.digest()).toString(16);
        }catch(Exception e){
            return null;
        }
        return md5;
    }
}
