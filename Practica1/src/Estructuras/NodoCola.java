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
public class NodoCola {

    private NodoCola inicio;
    private NodoCola ultimo;
    private Object dato;

    public NodoCola() {
        this.inicio = null;
        this.ultimo = null;
        this.dato = null;
    }

    public NodoCola(Object dato) {
        this.dato = dato;
        inicio = ultimo = null;

    }

    public NodoCola getInicio() {
        return inicio;
    }

    public void setInicio(NodoCola inicio) {
        this.inicio = inicio;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

}
