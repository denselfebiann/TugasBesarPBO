/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Pesanan;
import Model.Konsumsi;
import Model.Kereta;
import java.util.ArrayList;

/**
 *
 * @author MelvinS
 */
public class extPesanan extends Pesanan{
    private Kereta detailKereta;
    private String gerbong;
    private String kursiDipilih;
    private ArrayList<Konsumsi> konsumsi;
}
