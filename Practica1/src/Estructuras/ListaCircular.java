/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Juego.Jugador;

/**
 *
 * @author Andree
 */
public class ListaCircular {

    NodoListaCircular inicio, ultimo;
    int tamaño = 0;

    public ListaCircular() {
        inicio = ultimo = null;
    }

    public boolean Vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void Insertar(Object dato) {
        NodoListaCircular nuevo = new NodoListaCircular(dato);

        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);

        } else {
            ultimo.setSiguiente(nuevo);

            nuevo.setSiguiente(inicio);

            ultimo = nuevo;
        }

        tamaño++;
    }

    public String ConstruirTXT(ListaCircular lista) throws IOException {
        //instanciamos un objeto FileWriter que sera el archivo
        FileWriter file = null;
        //instanciamos un objeto PrintWriter para escribir dentro del archivo
        PrintWriter writer = null;

        try {
            //La ubicacion del archivo 
            file = new FileWriter("C:\\graficas\\ListaCircular.txt");

            //declaramos especificaciones del archivo 
            writer = new PrintWriter(file);
            writer.append("digraph ListaSimple{ ");
            writer.append("\tnode [fontcolor=\"cyan\", height=0.5, color=\"black\"]\n");
            writer.append("[shape=box, style=filled, color=black]");
            writer.append("\tedge  [color=\"black\", dir=fordware]\n");
            writer.append("\trankdir=LR \n");
            writer.append("\n");

            Jugador jugador;

            NodoListaCircular aux = lista.inicio;

            do {
                jugador = (Jugador) aux.getDato();
                writer.append(jugador.getNombre() + "->");
                aux = aux.getSiguiente();
            } while (aux != lista.inicio);

            if (aux == lista.inicio) {
                jugador = (Jugador) lista.inicio.getDato();
                writer.append(jugador.getNombre());
            }

            writer.append("\n}");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != file) {
                    writer.append("\n}");
                    writer.close();
                    file.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "ListaCircular";
    }

    public boolean Existe(String nombre) {
        if (!esVacia()) {
            NodoListaCircular Actual = inicio;
            Jugador jugador;
            do {
                jugador = (Jugador) Actual.getDato();
                if (jugador.getNombre().equals(nombre)) {
                    return true;
                } else {
                    Actual = Actual.getSiguiente();
                }
            } while (Actual != inicio);
        }
        return false;
    }

    public NodoListaCircular getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaCircular inicio) {
        this.inicio = inicio;
    }

    public NodoListaCircular getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaCircular ultimo) {
        this.ultimo = ultimo;
    }

}
