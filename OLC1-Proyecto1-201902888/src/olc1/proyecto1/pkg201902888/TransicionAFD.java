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
public class TransicionAFD {
    public EstadoAFD Estado_Origen;
    public String valor;
    public EstadoAFD Estado_Destino;
    
    public TransicionAFD(EstadoAFD origen, String valor, EstadoAFD destino){
        this.Estado_Origen = origen;
        this.valor = valor;
        this.Estado_Destino = destino;
    }
}
