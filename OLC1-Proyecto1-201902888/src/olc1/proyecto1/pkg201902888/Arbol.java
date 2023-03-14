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
public class Arbol {

    public String path = System.getProperty("user.dir");

    public Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public void GraficarSintactico(String id) {
        Interfaz inter = new Interfaz();
        String grafica = "digraph Arbol_Sintactico{\n\n node[shape=\"record\"] \n\n" + GraficaNodos(this.raiz, "0", this.raiz.id) + "\n\n}";
        inter.GenerarDot(grafica, id, "ARBOLES_201902888");
    }

    private String GraficaNodos(Nodo nodo, String i, int id) {
        int k = 0;
        String r = "";
        String nodoTerm = nodo.Token;
        String nodoId = String.valueOf(nodo.id);
        nodoTerm = nodoTerm.replace("\"", "");
        nodoTerm = nodoTerm.replace("|", "\\|");

        nodoId = nodoId.replace("-1", "0");
        r = "node" + i + "[label = \"" + nodo.Primeros + "|{" + nodo.Anulabilidad + "|" + nodoTerm + "|id: " + nodoId + "}|" + nodo.Ultinos + "\"];\n";

        for (int j = 0; j <= nodo.hijos.size() - 1; j++) {
            r = r + "node" + i + " -> node" + i + k + "\n";
            r = r + GraficaNodos(nodo.hijos.get(j), "" + i + k, nodo.hijos.get(j).id);
            k++;
        }

        if (!(nodo.Lexema.equals(""))) {
            String nodoToken = nodo.Lexema;
            nodoToken = nodoToken.replace("\"", "");
            r += "node" + i + "c[label = \"" + nodoToken + "\"];\n";
            r += "node" + i + " -> node" + i + "c\n";
        }

        return r;
    }

    public void GenerarTablaTransiciones(String id_er) {
        String identificador = id_er;

        EstadoAFD estado_inicial = new EstadoAFD("S0", false, true, this.raiz.Primeros);

        ArrayList<EstadoAFD> lista_estados = new ArrayList<>();
        lista_estados.add(estado_inicial);

        ArrayList<EstadoAFD> Estados_Aceptacion = new ArrayList<>();

        ArrayList<TransicionAFD> lista_transiciones = new ArrayList<>();

        crearTransiciones(estado_inicial, lista_estados, Estados_Aceptacion, lista_transiciones);

        AFD automata = new AFD(identificador);
        automata.Estado_Inicial = estado_inicial;
        automata.Estados = lista_estados;
        automata.Estados_Aceptacion = Estados_Aceptacion;
        automata.Transiciones = lista_transiciones;
        automata.ImprimirTablaTransiciones();
        automata.GenerarAFD();

        if (!Interfaz.AutomatasAFD.contains(automata)) {
            Interfaz.AutomatasAFD.add(automata);
        }

    }

    private void crearTransiciones(EstadoAFD estado, ArrayList<EstadoAFD> lista_estados, ArrayList<EstadoAFD> lista_estados_aceptacion, ArrayList<TransicionAFD> lista_transiciones) {
        if (estado.conjunto != null) {
            int contador = 1;
            boolean creado = false;
            for (int i = 0; i < lista_estados.size(); i++) {
                for (int j = 0; j < lista_estados.get(i).conjunto.size(); j++) {
                    int id_nodo_hoja = lista_estados.get(i).conjunto.get(j);
                    creado = recorrerArbol(this.raiz, id_nodo_hoja, contador, lista_estados, lista_estados_aceptacion, lista_transiciones, lista_estados.get(i));
                    if (creado) {
                        contador++;
                    }
                }
            }
        }
    }

    private boolean recorrerArbol(Nodo nodo, int id, int contador, ArrayList<EstadoAFD> lista_estados, ArrayList<EstadoAFD> lista_estados_aceptacion, ArrayList<TransicionAFD> lista_transiciones, EstadoAFD estado_origen) {
        boolean creado = false;
        int numeroAceptacion = this.raiz.Hijo_Der.id;
        for (int i = 0; i < Interfaz.lista_nodos_arbols.size(); i++) {
            nodo = Interfaz.lista_nodos_arbols.get(i);
            if (!creado) {
                if (nodo.id == id) {//creado                              
                    String id_estado = "S" + String.valueOf(contador);
                    EstadoAFD nuevoEstado = new EstadoAFD(id_estado, false, false, nodo.Siguientes);

                    if (nuevoEstado.conjunto.contains(numeroAceptacion)) {
                        nuevoEstado.Es_Aceptacion = true;
                        lista_estados_aceptacion.add(nuevoEstado);
                    }

                    EstadoAFD estado = null;
                    for (int j = 0; j < lista_estados.size(); j++) {
                        if (lista_estados.get(j).conjunto.equals(nuevoEstado.conjunto)) {
                            estado = lista_estados.get(j);
                            break;
                        }
                    }

                    if (estado == null) {
                        TransicionAFD transicion = new TransicionAFD(estado_origen, nodo.Token, nuevoEstado);
                        lista_transiciones.add(transicion);
                        lista_estados.add(nuevoEstado);
                        contador++;
                        creado = true;
                    } else {
                        TransicionAFD transicion = new TransicionAFD(estado_origen, nodo.Token, estado);
                        lista_transiciones.add(transicion);
                    }
                }
            } else {
                break;
            }
        }
        return creado;
    }

    private int contador = 0;

    public void GenerarTransicionesAFND(Nodo raiz, String id_er) {
        contador = 0;
        AFND automataAFND = new AFND();
        automataAFND.identificador = id_er;
        automataAFND.transiciones = ObtenerTransicionesAFND(raiz, automataAFND);
        automataAFND.cantestados = contador;

        automataAFND.GenerarAFND();
    }

    private LinkedList<TransicionAFND> ObtenerTransicionesAFND(Nodo raiz, AFND automata) {
        LinkedList<TransicionAFND> lista = new LinkedList<>();
        LinkedList<TransicionAFND> transiciones_izq;
        LinkedList<TransicionAFND> transiciones_der;
        EstadoAFND nuevo_inicial;
        EstadoAFND nuevo_final;
        TransicionAFND transicion;

        if (raiz != null) {

            if (raiz.id != -1) {
                nuevo_inicial = new EstadoAFND(contador, "S" + contador, true, false);
                automata.lista_estados.add(nuevo_inicial);
                contador++;
                nuevo_final = new EstadoAFND(contador, "S" + contador, false, true);
                automata.lista_estados.add(nuevo_final);
                contador++;

                transicion = new TransicionAFND(nuevo_inicial, raiz.Token, nuevo_final);
                lista.add(transicion);

            } else {

                if (".".equals(raiz.Token)) {
                    transiciones_izq = ObtenerTransicionesAFND(raiz.Hijo_Izq, automata);
                    transiciones_der = ObtenerTransicionesAFND(raiz.Hijo_Der, automata);

                    automata.lista_estados.remove(transiciones_izq.get(transiciones_izq.size() - 1).estado_final);
                    for (int i = 0; i <transiciones_izq.size(); i++) {
                        if(transiciones_izq.get(transiciones_izq.size() - 1).estado_final == transiciones_izq.get(i).estado_final){
                            transiciones_izq.get(i).estado_final = transiciones_der.get(0).estado_inicial;
                        }
                    }
                    
                    
                    for (int i = 0; i < transiciones_izq.size(); i++) {
                        lista.add(transiciones_izq.get(i));
                    }
                    for (int i = 0; i < transiciones_der.size(); i++) {
                        lista.add(transiciones_der.get(i));
                    }

                } else if ("|".equals(raiz.Token)) {

                    transiciones_izq = ObtenerTransicionesAFND(raiz.Hijo_Izq, automata);
                    transiciones_der = ObtenerTransicionesAFND(raiz.Hijo_Der, automata);

                    nuevo_inicial = new EstadoAFND(contador, "S"+contador, true, false);
                    automata.lista_estados.add(nuevo_inicial);
                    contador++;

                    nuevo_final = new EstadoAFND(contador, "S"+contador, false, true);
                    automata.lista_estados.add(nuevo_final);
                    contador++;

                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", transiciones_izq.get(0).estado_inicial);
                    lista.add(transicion);
                    for (int i = 0; i < transiciones_izq.size(); i++) {
                        lista.add(transiciones_izq.get(i));
                    }
                    
                    transiciones_izq.get(transiciones_izq.size() - 1).estado_final.es_aceptacion=false;
                    transicion = new TransicionAFND(transiciones_izq.get(transiciones_izq.size() - 1).estado_final, "&#949;", nuevo_final);
                    lista.add(transicion);

                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", transiciones_der.get(0).estado_inicial);
                    lista.add(transicion);
                    for (int i = 0; i < transiciones_der.size(); i++) {
                        lista.add(transiciones_der.get(i));
                    }
                    
                    transiciones_der.get(transiciones_der.size() - 1).estado_final.es_aceptacion=false;
                    TransicionAFND transicion2 = new TransicionAFND(transiciones_der.get(transiciones_der.size() - 1).estado_final, "&#949;", nuevo_final);
                    lista.add(transicion2);

                } else if ("+".equals(raiz.Token)) {
                    transiciones_izq = ObtenerTransicionesAFND(raiz.Hijo_Izq, automata);

                    nuevo_inicial = new EstadoAFND(contador, "S"+contador, true, false);
                    automata.lista_estados.add(nuevo_inicial);
                    contador++;
                    nuevo_final = new EstadoAFND(contador, "S"+contador, false, true);
                    automata.lista_estados.add(nuevo_final);
                    contador++;

                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", transiciones_izq.get(0).estado_inicial);
                    lista.add(transicion);

                    for (int i = 0; i < transiciones_izq.size(); i++) {
                        lista.add(transiciones_izq.get(i));
                    }

                    transicion = new TransicionAFND(transiciones_izq.get(transiciones_izq.size() - 1).estado_final, "&#949;", transiciones_izq.get(0).estado_inicial);
                    lista.add(transicion);

                    transiciones_izq.get(transiciones_izq.size() - 1).estado_final.es_aceptacion= false;
                    transicion = new TransicionAFND(transiciones_izq.get(transiciones_izq.size() - 1).estado_final, "&#949;", nuevo_final);
                    lista.add(transicion);

                } else if ("?".equals(raiz.Token)) {
                    transiciones_izq = ObtenerTransicionesAFND(raiz.Hijo_Izq, automata);
                    nuevo_inicial = new EstadoAFND(contador, "S"+contador, true, false);
                    automata.lista_estados.add(nuevo_inicial);
                    contador++;
                    
                    nuevo_final = new EstadoAFND(contador, "S"+contador, false, true);
                    automata.lista_estados.add(nuevo_final);
                    contador++;
                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", transiciones_izq.get(0).estado_inicial);
                    lista.add(transicion);

                    for (int i = 0; i < transiciones_izq.size(); i++) {
                        lista.add(transiciones_izq.get(i));
                    }

                    transiciones_izq.get(transiciones_izq.size() - 1).estado_final.es_aceptacion=false;
                    transicion = new TransicionAFND(transiciones_izq.get(transiciones_izq.size() - 1).estado_final, "&#949;", nuevo_final);
                    lista.add(transicion);

                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", nuevo_final);
                    lista.add(transicion);

                } else if ("*".equals(raiz.Token)) {
                    transiciones_izq = ObtenerTransicionesAFND(raiz.Hijo_Izq, automata);
                    
                    nuevo_inicial = new EstadoAFND(contador, "S"+contador, true, false);
                    automata.lista_estados.add(nuevo_inicial);
                    contador++;
                    
                    nuevo_final = new EstadoAFND(contador, "S"+contador, false, true);
                    automata.lista_estados.add(nuevo_final);
                    contador++;

                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", transiciones_izq.get(0).estado_inicial);
                    lista.add(transicion);

                    for (int i = 0; i < transiciones_izq.size(); i++) {
                        lista.add(transiciones_izq.get(i));
                    }

                    transicion = new TransicionAFND(transiciones_izq.get(transiciones_izq.size() - 1).estado_final, "&#949;", transiciones_izq.get(0).estado_inicial);
                    lista.add(transicion);

                    transiciones_izq.get(transiciones_izq.size() - 1).estado_final.es_aceptacion = false;
                    transicion = new TransicionAFND(transiciones_izq.get(transiciones_izq.size() - 1).estado_final, "&#949;", nuevo_final);
                    lista.add(transicion);

                    transicion = new TransicionAFND(nuevo_inicial, "&#949;", nuevo_final);
                    lista.add(transicion);
                }
            }
        }
        return lista;
    }

}
