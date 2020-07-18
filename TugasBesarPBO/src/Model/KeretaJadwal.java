/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MelvinS
 */
public class KeretaJadwal {
    private String lokasiDepart;
    private String lokasiArrive;
    private String jamDepart;
    private String jamArrive;
    private int keretaID;
    private int scheduleID;
    private String departure;
    
    public String getDeparture(){
        return departure;
    }
    public void setDeparture(String departure){
        this.departure = departure;
    }
    public int getKeretaID(){
        return keretaID;
    }
    public void setKeretaID(int keretaID){
        this.keretaID = keretaID;
    }
    public int getScheduleID(){
        return scheduleID;
    }
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }
    public String getLokasiDepart() {
        return lokasiDepart;
    }

    public void setLokasiDepart(String lokasiDepart) {
        this.lokasiDepart = lokasiDepart;
    }

    public String getLokasiArrive() {
        return lokasiArrive;
    }

    public void setLokasiArrive(String lokasiArrive) {
        this.lokasiArrive = lokasiArrive;
    }

    public String getJamDepart() {
        return jamDepart;
    }

    public void setJamDepart(String jamDepart) {
        this.jamDepart = jamDepart;
    }

    public String getJamArrive() {
        return jamArrive;
    }

    public void setJamArrive(String jamArrive) {
        this.jamArrive = jamArrive;
    }
    
    
}
