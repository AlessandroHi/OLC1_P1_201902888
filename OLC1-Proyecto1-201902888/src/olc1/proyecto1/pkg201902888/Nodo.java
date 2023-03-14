/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author ivann
 */
public class Nodo {

    public String Anulabilidad;
    public ArrayList<Integer> Primeros = new ArrayList<Integer>();
    public ArrayList<Integer> Ultinos = new ArrayList<Integer>();
    public ArrayList<Integer> Siguientes = new ArrayList<Integer>();
    public ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public Nodo Hijo_Izq;
    public Nodo Hijo_Der;
    public Nodo Padre;
    public String Token;
    public String Lexema;
    public int id;

    public Nodo(String anulabilidad, ArrayList<Integer> primeros, ArrayList<Integer> ultimos, Nodo hijo_izq, Nodo hijo_der, Nodo padre, String token, String lexema, int id) {
        this.Anulabilidad = anulabilidad;
        this.Primeros = primeros;
        this.Ultinos = ultimos;
        this.Hijo_Izq = hijo_izq;
        this.Hijo_Der = hijo_der;
        this.Padre = padre;
        this.Token = token;
        this.Lexema = lexema;
        this.id = id;

        if (hijo_izq != null) {
            this.hijos.add(hijo_izq);
        }
        if (hijo_der != null) {
            this.hijos.add(hijo_der);
        }

    }

  
}
