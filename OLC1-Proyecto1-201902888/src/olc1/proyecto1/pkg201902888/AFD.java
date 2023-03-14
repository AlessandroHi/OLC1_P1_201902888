/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.proyecto1.pkg201902888;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ivann
 */
public class AFD {

    public String Identificador;
    public LinkedList<String> alfabeto;
    public EstadoAFD Estado_Inicial;
    public ArrayList<EstadoAFD> Estados = new ArrayList<>();
    public ArrayList<EstadoAFD> Estados_Aceptacion = new ArrayList<>();
    public ArrayList<TransicionAFD> Transiciones = new ArrayList<>();

    public AFD(String identificador) {
        this.Identificador = identificador;
    }

    public void GenerarAFD() {
        Interfaz inter = new Interfaz();
        String grafica = "digraph Automata{\n node[shape=\"circle\"]\n rankdir = LR\n";

        for (int i = 0; i < this.Estados.size() - 1; i++) {
            EstadoAFD estado = this.Estados.get(i);
            if (estado.Es_Aceptacion) {
                grafica = grafica + estado.Id + "[label=\" " + estado.Id + " \", shape = \"doublecircle\", color=\"green\"]\n";
            } else {
                grafica = grafica + estado.Id + "[label=\" " + estado.Id + " \"]\n";
            }
        }

        for (int i = 0; i < this.Transiciones.size() - 1; i++) {
            TransicionAFD transicion = this.Transiciones.get(i);
            String valor = transicion.valor;
            valor = valor.replace("\"", " ");
            grafica = grafica + transicion.Estado_Origen.Id + "->" + transicion.Estado_Destino.Id + "[label=\"" + valor + "\"]\n";
        }
        grafica = grafica + "}";
        inter.GenerarDot(grafica, this.Identificador, "AFD_201902888");
    }

    public void ImprimirTablaTransiciones() {
        Interfaz inter = new Interfaz();
        String grafica = "digraph Tabla_Siguientes{\n node[shape=\"record\"] \n"
                + "nodo[ label =<\n"
                + "<table border ='1'>\n"
                + GraficarTransiciones() + "\n\n"
                + "</table>\n"
                + ">]\n"
                + "}";

        inter.GenerarDot(grafica, this.Identificador, "TRANSICIONES_201902888");
    }

    private String GraficarTransiciones() {
        String cadena = "<tr>\n";
        cadena = cadena + "<td>Estado</td>";
        ArrayList<String> encabezado = new ArrayList<>();
        encabezado.add("Estado");

        for (int i = 0; i < Interfaz.lista_nodos_arbols.size() - 1; i++) {
            if (!encabezado.contains(Interfaz.lista_nodos_arbols.get(i).Token)) {
                encabezado.add(Interfaz.lista_nodos_arbols.get(i).Token);
                cadena = cadena + "<td>" + Interfaz.lista_nodos_arbols.get(i).Token + "</td>\n";
            }
        }
        cadena = cadena + "</tr>\n";

        for (int i = 0; i < this.Estados.size() - 1; i++) {
            cadena = cadena + "<tr>\n";
            EstadoAFD estado_actual = this.Estados.get(i);
            cadena = cadena + "<td>" + estado_actual.Id + estado_actual.conjunto + "</td>\n";

            for (int j = 1; j < encabezado.size(); j++) {
                String valor_actual = encabezado.get(j);
                boolean encontrado = false;

                for (int k = 0; k < this.Transiciones.size() - 1; k++) {
                    TransicionAFD transicion = this.Transiciones.get(k);
                    if (estado_actual.equals(transicion.Estado_Origen)) {
                        if (transicion.valor.equals(valor_actual)) {
                            cadena = cadena + "<td>" + transicion.Estado_Destino.Id + "</td>\n";
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (encontrado == false) {
                    cadena = cadena + "<td> -- </td>\n";
                }
            }
            cadena = cadena + "</tr>";
        }
        return cadena;

    }
}
