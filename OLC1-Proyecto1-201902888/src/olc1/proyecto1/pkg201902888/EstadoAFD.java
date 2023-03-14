/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;

import java.util.ArrayList;

/**
 *
 * @author ivann
 */
public class EstadoAFD {
    public String Id;
    public boolean Es_Aceptacion;
    public boolean Es_Inicial;
    public ArrayList<Integer> conjunto;
    
    
    public EstadoAFD(String id, boolean aceptacion, boolean inicial, ArrayList<Integer> conjunto) {
        this.Id = id;
        this.Es_Aceptacion = aceptacion;
        this.Es_Inicial = inicial;
        this.conjunto = conjunto;
    }
}
