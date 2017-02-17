/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizOrtogonal;

import MatrizOrtogonal.ListaHorizontal;

/**
 *
 * @author Andree
 */
public class NodoLateral {

    int y;

    NodoLateral siguiente;
    NodoLateral anterior;
    ListaHorizontal fila;

    public NodoLateral(int y) {
        this.y = y;
        fila = new ListaHorizontal();
        siguiente = anterior = null;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public NodoLateral getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLateral siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLateral getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLateral anterior) {
        this.anterior = anterior;
    }

    public ListaHorizontal getFila() {
        return fila;
    }

    public void setFila(ListaHorizontal fila) {
        this.fila = fila;
    }
}
