/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;

/**
 *
 * @author ivann
 */
public class EstadoAFND {
    public int id;
    public String identificador;
    public boolean es_inicial;
    public boolean es_aceptacion;
    
    public EstadoAFND(int id,String identificador, boolean inicial, boolean aceptacion){
        this.id = id;
        this.identificador = identificador;
        this.es_inicial = inicial;
        this.es_aceptacion = aceptacion;
    
    }
}
