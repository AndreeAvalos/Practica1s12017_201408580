/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Juego.Valor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Andree
 */
public class ListaSimple {

    private NodoListaSimple raiz, ultimo;
    int tamaño;

    public ListaSimple() {
        raiz = null;
        ultimo = null;
    }

    public boolean Vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Object dato) {
        NodoListaSimple nuevo = new NodoListaSimple(dato);
        if (empy()) {
            raiz = nuevo;
            ultimo = nuevo;
            ultimo.setEnlace(raiz);
        } else {
            ultimo.setEnlace(nuevo);
            nuevo.setEnlace(raiz);
            ultimo = nuevo;
        }
    }

    public int ExistePos(int x, int y) {
        NodoListaSimple Actual = raiz;
        if (empy()) {
            return 1;
        } else {
            while (Actual != ultimo) {
                Valor valor = (Valor) Actual.getDato();
                if (x == valor.getPosx() && y == valor.getPosy()) {
                    return valor.getValor();
                }
                Actual = Actual.getEnlace();
            }
        }
        return 1;
    }

    public void Visualizar() {
        NodoListaSimple aux;
        aux = raiz;
        while (aux != ultimo) {
            System.out.println(aux.getDato() + "  ");
            aux = aux.getEnlace();
        }
        if (aux == ultimo) {
            System.out.println(aux.getDato() + "  ");
        }
    }

    public boolean empy() {
        return raiz == null;
    }

    public void eliminar() {
        raiz = null;
    }

    public int tamaño() {
        NodoListaSimple Actual;
        tamaño = 0;
        Actual = raiz;

        while (Actual != ultimo) {
            tamaño++;
            Actual = Actual.getEnlace();
        }
        return tamaño;
    }

    public void Eliminar(Object dato) {
        NodoListaSimple Actual, Aux;
        boolean encontrado = false;
        Actual = raiz;
        Aux = null;
        while ((Actual != null) && (!encontrado)) {
            encontrado = (Actual.getDato() == dato);
            if (!encontrado) {
                Aux = Actual;
                Actual = Actual.getEnlace();
            }
        }
        if (Actual != null) {
            if (Actual == raiz) {
                raiz = Actual.getEnlace();
            } else {
                Aux.setEnlace(Actual.getEnlace());
            }
        }
    }

    public String ConstruirTXT(ListaSimple lista) throws IOException {

        //instanciamos un objeto FileWriter que sera el archivo
        FileWriter file = null;
        //instanciamos un objeto PrintWriter para escribir dentro del archivo
        PrintWriter writer = null;

        try {
            //La ubicacion del archivo 
            file = new FileWriter("C:\\graficas\\ListaSimple.txt");

            //declaramos especificaciones del archivo 
            writer = new PrintWriter(file);
            writer.append("digraph ListaSimple{ ");
            writer.append("\tnode [fontcolor=\"cyan\", height=0.5, color=\"black\"]\n");
            writer.append("[shape=box, style=filled, color=black]");
            writer.append("\tedge  [color=\"black\", dir=fordware]\n");
            writer.append("\trankdir=UD \n");
            writer.append("\n");
            if (!empy()) {

                NodoListaSimple Actual = lista.getRaiz();
                int pos = 0;

                do {
                    if (pos == 0) {
                        writer.append("\n" + Actual.getDato().toString());
                    }
                    if (Actual.getEnlace() != null && pos != 0) {
                        writer.append("->" + Actual.getDato().toString());
                    }
                    Actual = Actual.getEnlace();
                    pos++;
                } while (Actual != raiz);

                if (Actual == Actual.getEnlace()) {
                    Actual = null;
                }
            }

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
        return "ListaSimple";
    }

    public NodoListaSimple getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoListaSimple raiz) {
        this.raiz = raiz;
    }

    public NodoListaSimple getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaSimple ultimo) {
        this.ultimo = ultimo;
    }

}
