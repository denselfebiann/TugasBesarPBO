/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Kereta;

/**
 *
 * @author dense
 */
public class KeretaManager {
    static KeretaManager instance;
    private Kereta kereta;

    public static KeretaManager getInstance() {
        if (instance == null) {
            instance = new KeretaManager();
        }
        return instance;
    }
    
    public Kereta getKereta() {
        return kereta;
    }

    public void setKereta(Kereta kereta) {
        this.kereta = kereta;
    }
}
