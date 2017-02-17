/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizOrtogonal;

/**
 *
 * @author Andree
 */
public class NodoMatriz {

    //Apuntadores
    private NodoMatriz arriba;
    private NodoMatriz abajo;
    private NodoMatriz derecha;
    private NodoMatriz izquierda;

    private Object Dato;
    private int x,y;

    public NodoMatriz() {
    }

    public NodoMatriz(Object Dato, int x, int y) {
        this.Dato = Dato;
        this.x=x;
        this.y=y;
        arriba = abajo = derecha = izquierda = null;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }

    public NodoMatriz getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoMatriz derecha) {
        this.derecha = derecha;
    }

    public NodoMatriz getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoMatriz izquierda) {
        this.izquierda = izquierda;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    } 
}
