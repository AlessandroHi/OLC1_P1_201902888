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
public class AFND {

    public String identificador;
    public int cantestados;
    public LinkedList<TransicionAFND> transiciones = new LinkedList<>();
    public LinkedList<EstadoAFND> lista_estados = new LinkedList<>();

    public AFND() {
    }

    public void GenerarAFND() {
        Interfaz inter = new Interfaz();
        String grafica = "digraph Automata{\n node[shape=\"circle\"]\n rankdir = LR\n";

        for (int i = 0; i < this.lista_estados.size(); i++) {
            EstadoAFND estado = this.lista_estados.get(i);
            String identificador = this.lista_estados.get(i).identificador;
            if (estado.es_aceptacion) {
                grafica = grafica + identificador + "[label=\" " + i + " \", shape = \"doublecircle\", color=\"green\"]\n";
            } else {
                grafica = grafica + identificador + "[label=\" " + i + " \"]\n";
            }
        }

        for (int i = 0; i < this.transiciones.size(); i++) {
            TransicionAFND transicion = this.transiciones.get(i);
            String valor = transicion.valor;
            String identificador1 = transicion.estado_inicial.identificador;
            String identificador2 = transicion.estado_final.identificador;

            valor = valor.replace("\"", "\'");
            identificador1.replace("\"","");
            identificador2.replace("\"","");
            grafica = grafica + identificador1 + "->" + identificador2 + "[label=\"" + valor + "\"]\n";
        }
        grafica = grafica + "}";
        inter.GenerarDot(grafica, this.identificador, "AFND_201902888");
    }
}
