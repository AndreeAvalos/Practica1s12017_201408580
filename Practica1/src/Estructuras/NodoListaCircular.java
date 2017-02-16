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
public class NodoListaCircular {
    private Object Dato;
    private NodoListaCircular siguiente;

    public NodoListaCircular(Object Dato) {
        this.Dato = Dato;
        this.siguiente=null;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    public NodoListaCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaCircular siguiente) {
        this.siguiente = siguiente;
    }
    
}
