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
public class Cola {

    NodoCola raiz;
    NodoCola ultimo;

    public Cola() {
        raiz = ultimo = null;
    }

    public boolean Vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Insertar(Object objeto) {
        NodoCola nuevo = new NodoCola(objeto);

        nuevo.setInicio(null);
        if (Vacia()) {
            raiz = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setUltimo(nuevo);
            ultimo = nuevo;
        }
    }

    public Object getPrimero() {
        if (!Vacia()) {
            Object dato = raiz.getDato();
            if (raiz == ultimo) {
                raiz = ultimo = null;
            } else {
                raiz = raiz.getUltimo();
            }
            return dato;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void Visualizar() {
        NodoCola Actual;
        Actual = raiz;
        while (Actual != null) {
            System.out.println(Actual.getDato());
            Actual = Actual.getUltimo();
        }
    }

}
