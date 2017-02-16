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
public class ListaSimple {

    private NodoListaSimple raiz;

    public ListaSimple() {
        raiz=null;
    }

    public boolean Vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public ListaSimple insertar(Object dato) {
        NodoListaSimple nuevo = new NodoListaSimple(dato);
        if (Vacia() == true) {
            raiz=nuevo;
        } else {
            nuevo.setEnlace(raiz);
            raiz=nuevo;
        }
        return this;
    }
    public void Visualizar(){
    NodoListaSimple aux;
    aux=raiz;
    while(aux!=null){
        System.out.println(aux.getDato()+ "  ");
        aux=aux.getEnlace();
    }
    
    }
}
