/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataInterface;

/**
 *
 * @author dense
 */
public class DataRepository implements DataInterface{
    private static DataInterface controller = new DummyControl();

    public static DataInterface getController() {
        return controller;
    }

    public static void setController(DataInterface controller) {
        DataRepository.controller = controller;
    }
    
}
