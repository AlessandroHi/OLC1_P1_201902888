/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;

import java.util.LinkedList;

/**
 *
 * @author ivann
 */
public class TransicionAFND {

    public String valor;
    public EstadoAFND estado_inicial;
    public EstadoAFND estado_final;
    public LinkedList<EstadoAFND> recorrido = new LinkedList<>();

    public TransicionAFND(EstadoAFND estado_inicial, String valor, EstadoAFND estado_final) {
        this.estado_inicial = estado_inicial;
        this.valor = valor;
        this.estado_final = estado_final;
    }
}
