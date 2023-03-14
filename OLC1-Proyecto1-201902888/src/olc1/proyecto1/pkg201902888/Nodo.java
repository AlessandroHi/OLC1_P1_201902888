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

    public void CalcularAnulabilidad() {
        switch (this.Token) {
            case "|":
                this.Anulabilidad = AnulabilidadEspeciales("|", this.Hijo_Izq.Anulabilidad, this.Hijo_Der.Anulabilidad);
                break;
            case "?":
                this.Anulabilidad = AnulabilidadEspeciales("?", this.Hijo_Izq.Anulabilidad, "");
                break;
            case "*":
                this.Anulabilidad = AnulabilidadEspeciales("*", this.Hijo_Izq.Anulabilidad, "");
                break;
            case ".":
                this.Anulabilidad = AnulabilidadEspeciales(".", this.Hijo_Izq.Anulabilidad, this.Hijo_Der.Anulabilidad);
                break;
            case "+":
                this.Anulabilidad = AnulabilidadEspeciales("+", this.Hijo_Izq.Anulabilidad, "");
            default:
                this.Anulabilidad = "N";
                break;
        }

    }

    private String AnulabilidadEspeciales(String Simbolo, String Anulabilidad_HI, String Anulabilidad_HD) {
        String anulabilidad = "";

        if (Simbolo == "|") {
            if (Anulabilidad_HI == "N" && Anulabilidad_HD == "N") {
                anulabilidad = "N";
            } else {
                anulabilidad = "A";
            }
        } else if (Simbolo == "*") {
            anulabilidad = "A";
        } else if (Simbolo == ".") {
            if (Anulabilidad_HI == "A" && Anulabilidad_HD == "A") {
                anulabilidad = "A";
            } else {
                anulabilidad = "N";
            }
        } else if (Simbolo == "+") {
            anulabilidad = "N";
        } else if (Simbolo == "?") {
            anulabilidad = "A";
        }

        return anulabilidad;
    }

    public void CalcularPrimerosUltimos() {
        ArrayList<Integer> vacio = new ArrayList<Integer>();
        switch (this.Token) {
            case "|":
                this.Primeros = PrimerosEspeciales("|", this.Hijo_Izq.Primeros, this.Hijo_Izq.Anulabilidad, this.Hijo_Der.Anulabilidad, this.Hijo_Der.Primeros, this.id);
                this.Ultinos = UltimosEspeciales("|", this.Hijo_Izq.Ultinos, this.Hijo_Izq.Anulabilidad, this.Hijo_Der.Anulabilidad, this.Hijo_Der.Ultinos, this.id);
                break;
            case "?":
                this.Primeros = PrimerosEspeciales("?", this.Hijo_Izq.Primeros, this.Hijo_Izq.Anulabilidad, "", vacio, this.id);
                this.Ultinos = UltimosEspeciales("?", this.Hijo_Izq.Ultinos, this.Hijo_Izq.Anulabilidad, "", vacio, this.id);
                break;
            case "*":
                this.Primeros = PrimerosEspeciales("*", this.Hijo_Izq.Primeros, this.Hijo_Izq.Anulabilidad, "", vacio, this.id);
                this.Ultinos = UltimosEspeciales("*", this.Hijo_Izq.Ultinos, this.Hijo_Izq.Anulabilidad, "", vacio, this.id);
                break;
            case ".":
                this.Primeros = PrimerosEspeciales(".", this.Hijo_Izq.Primeros, this.Hijo_Izq.Anulabilidad, this.Hijo_Der.Anulabilidad, this.Hijo_Der.Primeros, this.id);
                this.Ultinos = UltimosEspeciales(".", this.Hijo_Izq.Ultinos, this.Hijo_Izq.Anulabilidad, this.Hijo_Der.Anulabilidad, this.Hijo_Der.Ultinos, this.id);
                break;
            case "+":
                this.Primeros = PrimerosEspeciales("+", this.Hijo_Izq.Primeros, this.Hijo_Izq.Anulabilidad, "", vacio, this.id);
                this.Ultinos = UltimosEspeciales("+", this.Hijo_Izq.Ultinos, this.Hijo_Izq.Anulabilidad, "", vacio, this.id);
                break;
        }

    }

    private ArrayList<Integer> PrimerosEspeciales(String Simbolo, ArrayList<Integer> Primeros_HI, String Anulabilidad_HI, String Anulabilidad_HD, ArrayList<Integer> Primeros_HD, int id) {
        ArrayList<Integer> primeros = new ArrayList<Integer>();
        if (Simbolo == "|") {
            for (int i = 0; i < Math.max(Primeros_HI.size(), Primeros_HD.size()); i++) {
                if (i < Primeros_HI.size()) {
                    primeros.add(Primeros_HI.get(i));
                }
                if (i < Primeros_HD.size()) {
                    primeros.add(Primeros_HD.get(i));
                }
            }

        } else if (Simbolo == "*" || Simbolo == "+" || Simbolo == "?") {

            for (int i = 0; i < Primeros_HI.size(); i++) {
                if (i < Primeros_HI.size()) {
                    primeros.add(Primeros_HI.get(i));
                }
            }

        } else if (Simbolo == ".") {
            if (Anulabilidad_HI == "A") {
                for (int i = 0; i < Math.max(Primeros_HI.size(), Primeros_HD.size()); i++) {
                    if (i < Primeros_HI.size()) {
                        primeros.add(Primeros_HI.get(i));
                    }
                    if (i < Primeros_HD.size()) {
                        primeros.add(Primeros_HD.get(i));
                    }
                }
            } else {
                for (int i = 0; i < Primeros_HI.size(); i++) {
                    if (i < Primeros_HI.size()) {
                        primeros.add(Primeros_HI.get(i));
                    }
                }
            }
        }
        Collections.sort(primeros);
        return primeros;
    }

    private ArrayList<Integer> UltimosEspeciales(String Simbolo, ArrayList<Integer> Ultimos_HI, String Anulabilidad_HI, String Anulabilidad_HD, ArrayList<Integer> Ultimos_HD, int id) {
        ArrayList<Integer> ultimos = new ArrayList<Integer>();
        if (Simbolo == "|") {
            for (int i = 0; i < Math.max(Ultimos_HI.size(), Ultimos_HD.size()); i++) {
                if (i < Ultimos_HI.size()) {
                    ultimos.add(Ultimos_HI.get(i));
                }
                if (i < Ultimos_HD.size()) {
                    ultimos.add(Ultimos_HD.get(i));
                }
            }

        } else if (Simbolo == "*" || Simbolo == "+" || Simbolo == "?") {

            for (int i = 0; i < Ultimos_HI.size(); i++) {
                if (i < Ultimos_HI.size()) {
                    ultimos.add(Ultimos_HI.get(i));
                }
            }

        } else if (Simbolo == ".") {
            if (Anulabilidad_HD == "A") {
                for (int i = 0; i < Math.max(Ultimos_HI.size(), Ultimos_HD.size()); i++) {
                    if (i < Ultimos_HI.size()) {
                        ultimos.add(Ultimos_HI.get(i));
                    }
                    if (i < Ultimos_HD.size()) {
                        ultimos.add(Ultimos_HD.get(i));
                    }
                }
            } else {
                for (int i = 0; i < Ultimos_HD.size(); i++) {
                    if (i < Ultimos_HD.size()) {
                        ultimos.add(Ultimos_HD.get(i));
                    }
                }
            }
        }
        Collections.sort(ultimos);
        return ultimos;
    }
/////////////////////////////

    public void CalcSiguientes(String nombre_er, LinkedList<Nodo> lista_siguientes) {

        this.RecorrerSiguientes(lista_siguientes);
        this.GraficarTablaSiguientes(nombre_er);

    }

    private void RecorrerSiguientes(LinkedList<Nodo> lista_siguientes) {
        if (this != null) {
            Siguientes(this, lista_siguientes);
            if (this.Hijo_Izq != null) {
                this.Hijo_Izq.RecorrerSiguientes(lista_siguientes);
            }
            if (this.Hijo_Der != null) {
                this.Hijo_Der.RecorrerSiguientes(lista_siguientes);
            }
        }
    }

    private void Siguientes(Nodo nodo, LinkedList<Nodo> lista_siguientes) {
        if (nodo.Token == ".") {
            ArrayList<Integer> ultimosHI = nodo.Hijo_Izq.Ultinos;
            ArrayList<Integer> primerosHD = nodo.Hijo_Der.Primeros;

            for (int i = 0; i < ultimosHI.size(); i++) {
                AsignacionSiguientes(nodo, ultimosHI.get(i), primerosHD, lista_siguientes);
            }
        } else if (nodo.Token == "*" || nodo.Token == "+") {
            ArrayList<Integer> primerosHI = nodo.Hijo_Izq.Primeros;
            ArrayList<Integer> ultimosHI = nodo.Hijo_Izq.Ultinos;

            for (int i = 0; i < ultimosHI.size(); i++) {
                AsignacionSiguientes(nodo, ultimosHI.get(i), primerosHI, lista_siguientes);
            }
        }

        if (!lista_siguientes.contains(nodo) && nodo.Token == "#") {
            lista_siguientes.add(nodo);
        }

        Collections.sort(nodo.Siguientes);
        if (nodo.id != -1) {
            System.out.println("Nodo Token: " + nodo.Token + " nodo Id: " + String.valueOf(id) + " Siguientes: " + nodo.Siguientes);
        }
    }

    private void AsignacionSiguientes(Nodo nodo, int id, ArrayList<Integer> PrimerosHD, LinkedList<Nodo> lista_siguientes) {
        if (nodo != null) {

            if (nodo.id == id) {
                for (int i = 0; i < PrimerosHD.size(); i++) {
                    nodo.Siguientes.add(PrimerosHD.get(i));
                }
                if (!lista_siguientes.contains(nodo)) {
                    lista_siguientes.add(nodo);

                }
            } else {
                if (nodo.Hijo_Izq != null) {
                    AsignacionSiguientes(nodo.Hijo_Izq, id, PrimerosHD, lista_siguientes);
                } else {
                    return;
                }
                if (nodo.Hijo_Der != null) {
                    AsignacionSiguientes(nodo.Hijo_Der, id, PrimerosHD, lista_siguientes);
                }
            }

        }
    }
////////////////////////////////

    private void GraficarTablaSiguientes(String nombre_imagen) {
        Interfaz inter = new Interfaz();
        String grafica = "digraph Tabla_Siguientes{\n node[shape=\"record\"] \n"
                + "nodo[ label =<"
                + "<table border ='1'>\n"
                + "<tr>"
                + "<td>Hoja</td>\n"
                + "<td>Siguientes</td>\n"
                + "</tr>\n"
                + this.GraficarSiguientes() + "\n\n"
                + "</table>\n"
                + ">]\n"
                + "}";

        inter.GenerarDot(grafica, nombre_imagen, "SIGUIENTES_201902888");

    }

    private String GraficarSiguientes() {
        String cadena = "";
        if (this != null) {
            if (this.id != -1) {
                cadena = cadena + "<tr><td>" + String.valueOf(this.id) + " - " + this.Token + "</td><td>" + this.Siguientes + "</td></tr>";
            }
            if (this.Hijo_Izq != null) {
                cadena = cadena + this.Hijo_Izq.GraficarSiguientes();
            }
            if (this.Hijo_Der != null) {
                cadena = cadena + this.Hijo_Der.GraficarSiguientes();
            }
        }

        return cadena;
    }

}
