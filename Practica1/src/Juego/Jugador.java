/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Estructuras.Cola;
import Estructuras.ListaSimple;

/**
 *
 * @author Andree
 */
public class Jugador {

    private String nombre;
    private int punteo;
    private ListaSimple lista;
    private Cola cola;

    public Jugador() {
    }

    public Jugador(String nombre, int punteo, ListaSimple lista, Cola cola) {
        this.nombre = nombre;
        this.punteo = punteo;
        this.lista = lista;
        this.cola = cola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public ListaSimple getLista() {
        return lista;
    }

    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

}
