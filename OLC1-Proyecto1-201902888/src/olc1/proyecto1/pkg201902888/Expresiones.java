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
public class Expresiones {
    public Arbol raiz; 
    public String id;
    
    public Expresiones(String id, Arbol raiz){
        this.raiz = raiz;
        this.id = id;
    }
     
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
     public Arbol getArbol(){
        return raiz;
    }
    
    
    
    
}
