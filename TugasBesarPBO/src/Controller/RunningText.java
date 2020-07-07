/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author EGIE
*/
public class RunningText extends JPanel implements Runnable {
    private JLabel label;

    public RunningText(String kata){
        setLayout(null);
        label = new JLabel(kata);
        add(label);
    }

    @Override
    public void run() {
        int x = 500, y = 10;
        while(true){
            label.setBounds(x, y, 400, 10);
            if(x == 500){
                x -= 500;
            }else{
                x += 5;
            }
            try{
                Thread.sleep(100);
            }catch(Exception e){
                
            }
        }
    }
}
