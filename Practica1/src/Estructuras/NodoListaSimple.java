/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Andree
 */
public class NodoListaSimple {
    private NodoListaSimple enlace;
    private Object Dato;
    
    public NodoListaSimple(Object objeto){
    this.enlace= null;
    this.Dato = objeto;
    }

    public NodoListaSimple getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoListaSimple enlace) {
        this.enlace = enlace;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    
    
}
