/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ivann
 */
public class OLC1Proyecto1201902888 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }catch(UnsupportedLookAndFeelException e){
        }
      Interfaz ventana = new Interfaz();
      ventana.setVisible(true);
    }
    
}
