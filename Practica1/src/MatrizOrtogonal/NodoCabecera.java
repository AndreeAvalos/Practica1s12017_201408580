/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizOrtogonal;

import MatrizOrtogonal.ListaVertical;

/**
 *
 * @author Andree
 */
public class NodoCabecera {

    int x;
    Object Dato;
    NodoCabecera siguiente;
    NodoCabecera anterior;
    ListaVertical columna;

    public NodoCabecera(int x) {
        this.x = x;
        columna = new ListaVertical();
        siguiente = anterior = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public NodoCabecera getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCabecera siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCabecera getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCabecera anterior) {
        this.anterior = anterior;
    }

    public ListaVertical getColumna() {
        return columna;
    }

    public void setColumna(ListaVertical columna) {
        this.columna = columna;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    

}
