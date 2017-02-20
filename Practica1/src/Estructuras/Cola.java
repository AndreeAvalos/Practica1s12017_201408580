/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public int tamaño() {
        int tama = 0;
        NodoCola Actual;
        Actual = raiz;
        while (Actual != null) {
            tama++;
            Actual = Actual.getUltimo();
        }
        return tama;
    }

    public String ConstruirTXT(Cola cola) {
        //instanciamos un objeto FileWriter que sera el archivo
        FileWriter file = null;
        //instanciamos un objeto PrintWriter para escribir dentro del archivo
        PrintWriter writer = null;

        try {
            //La ubicacion del archivo 
            file = new FileWriter("C:\\graficas\\Cola.txt");

            //declaramos especificaciones del archivo 
            writer = new PrintWriter(file);
            writer.append("digraph ListaSimple{ ");
            writer.append("\tnode [fontcolor=\"cyan\", height=0.5, color=\"black\"]\n");
            writer.append("[shape=box, style=filled, color=black]");
            writer.append("\tedge  [color=\"black\", dir=fordware]\n");
            writer.append("\trankdir=UD \n");
            writer.append("\n");
            int contador = 0;
            if (!Vacia()) {

                NodoCola Actual;
                Actual = cola.raiz;
                while (Actual != null) {
                    contador++;
                    Actual = Actual.getUltimo();
                }

            }
            NodoCola Actual = cola.raiz;
            for (int i = 0; i < contador - 1; i++) {
                writer.append(Actual.getDato() + "->");
                Actual = Actual.getUltimo();
            }
            writer.append(cola.ultimo.getDato() + "");

        } catch (IOException e) {
        } finally {
            try {
                if (null != file) {
                    writer.append("\n}");
                    writer.close();
                    file.close();
                }
            } catch (IOException e2) {
            }
        }
        return "Cola";
    }
}
