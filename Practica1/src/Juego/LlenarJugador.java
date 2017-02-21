/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Juego.Jugador;
import Juego.Ficha;
import Estructuras.Cola;
import Estructuras.ListaCircular;
import Estructuras.ListaSimple;
import Estructuras.NodoListaSimple;
import java.util.ArrayList;

/**
 *
 * @author Andree
 */
public class LlenarJugador {

    private Jugador jugador;
    private ListaCircular ListaCircular;
    private Cola cola;

    public LlenarJugador() {
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public LlenarJugador(ListaCircular lista) {
        this.ListaCircular = lista;
        jugador = null;
        cola = GenerarFichas();
    }

    public boolean Existe(String nombre) {
        if (ListaCircular.Existe(nombre)) {
            return true;
        } else {
            CrearUsuario(nombre);
            return false;
        }
    }

    public void CrearUsuario(String nombre) {
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setPunteo(0);
        jugador.setLista(GenerarLista());
        ListaCircular.Insertar(jugador);
    }

    public Cola GenerarFichas() {
        cola = new Cola();
        int numeroMax = 94;
        int numero = 0;
        ArrayList listaGenerica = llenarLista();

        Ficha ficha2 = new Ficha();
        while (numeroMax != 0) {
            numero = (int) (Math.random() * numeroMax) + 1;
            ficha2 = (Ficha) listaGenerica.get(numero);
            listaGenerica.remove(numero);
            cola.Insertar(ficha2.getLetra());
//            System.out.println("Numero: " + numeroMax + " Letra Random: " + ficha2.getLetra());
            numeroMax--;
        }
        ficha2 = (Ficha) listaGenerica.get(0);
        listaGenerica.remove(0);
//        System.out.println("Numero: " + numeroMax + " Letra Random: " + ficha2.getLetra());

//        for (int i = 0; i < listaGenerica.size(); i++) {
//            ficha2 = (Ficha) listaGenerica.get(i);
//            System.out.println(ficha2.getLetra());
//        }
        return cola;
    }

    public ListaSimple GenerarLista() {
        ListaSimple lista = new ListaSimple();
        Cola colaP = getCola();
        for (int i = 0; i < 7; i++) {
            lista.insertar(colaP.getPrimero());
        }
        return lista;
    }

    public ListaSimple GenerarLista(Cola colat) {
        ListaSimple lista = new ListaSimple();
        Cola colaP = colat;
        for (int i = 0; i < 7; i++) {
            lista.insertar(colaP.getPrimero());
        }
        return lista;
    }

    private ArrayList llenarLista() {
//        1 punto: A ×12, E ×12, O ×9, I ×6, S ×6, N ×5, L ×4, R ×5, U ×5, T ×4 

        ArrayList listaGenerica = new ArrayList();
        {
            for (int i = 0; i < 12; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(1);
                ficha.setLetra("A");
                listaGenerica.add(ficha);
            }
            for (int i = 0; i < 12; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(1);
                ficha.setLetra("E");
                listaGenerica.add(ficha);
            }
            for (int i = 0; i < 9; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(1);
                ficha.setLetra("O");
                listaGenerica.add(ficha);
            }
            for (int i = 0; i < 6; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(1);
                ficha.setLetra("I");
                listaGenerica.add(ficha);

                Ficha ficha2 = new Ficha();
                ficha2.setPunteo(1);
                ficha2.setLetra("S");
                listaGenerica.add(ficha2);
            }
            for (int i = 0; i < 5; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(1);
                ficha.setLetra("N");
                listaGenerica.add(ficha);
                Ficha ficha2 = new Ficha();
                ficha2.setPunteo(1);
                ficha2.setLetra("R");
                listaGenerica.add(ficha2);
                Ficha ficha3 = new Ficha();
                ficha3.setPunteo(1);
                ficha3.setLetra("U");
                listaGenerica.add(ficha3);
            }
            for (int i = 0; i < 4; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(1);
                ficha.setLetra("L");
                listaGenerica.add(ficha);
                Ficha ficha2 = new Ficha();
                ficha2.setPunteo(1);
                ficha2.setLetra("T");
                listaGenerica.add(ficha2);
            }
        }

//        2 puntos: D ×5, G ×2 
        {
            for (int i = 0; i < 5; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(2);
                ficha.setLetra("D");
                listaGenerica.add(ficha);
            }
            for (int i = 0; i < 2; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(2);
                ficha.setLetra("G");
                listaGenerica.add(ficha);
            }
        }

//        3 puntos: C ×4, B ×2, M ×2, P ×2 
        {
            for (int i = 0; i < 4; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(3);
                ficha.setLetra("C");
                listaGenerica.add(ficha);
            }
            for (int i = 0; i < 2; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(3);
                ficha.setLetra("B");
                listaGenerica.add(ficha);
                Ficha ficha2 = new Ficha();
                ficha2.setPunteo(3);
                ficha2.setLetra("M");
                listaGenerica.add(ficha2);
                Ficha ficha3 = new Ficha();
                ficha3.setPunteo(3);
                ficha3.setLetra("P");
                listaGenerica.add(ficha3);
            }
        }

//        4 puntos: H ×2, F ×1, V ×1, Y ×1 
        {
            for (int i = 0; i < 2; i++) {
                Ficha ficha = new Ficha();
                ficha.setPunteo(4);
                ficha.setLetra("H");
                listaGenerica.add(ficha);
            }

            Ficha ficha = new Ficha();
            ficha.setPunteo(4);
            ficha.setLetra("F");
            listaGenerica.add(ficha);

            Ficha ficha2 = new Ficha();
            ficha2.setPunteo(4);
            ficha2.setLetra("V");
            listaGenerica.add(ficha2);

            Ficha ficha3 = new Ficha();
            ficha3.setPunteo(4);
            ficha3.setLetra("Y");
            listaGenerica.add(ficha3);
        }

//        5 puntos: Q ×1
        {
            Ficha ficha = new Ficha();
            ficha.setPunteo(5);
            ficha.setLetra("Q");
            listaGenerica.add(ficha);
        }

//        8 puntos: J ×1, Ñ ×1, X ×1 
        {
            Ficha ficha = new Ficha();
            ficha.setPunteo(8);
            ficha.setLetra("J");
            listaGenerica.add(ficha);

            Ficha ficha2 = new Ficha();
            ficha2.setPunteo(8);
            ficha2.setLetra("Ñ");
            listaGenerica.add(ficha2);

            Ficha ficha3 = new Ficha();
            ficha3.setPunteo(4);
            ficha3.setLetra("X");
            listaGenerica.add(ficha3);
        }

//        10 puntos: Z ×1, 
        {
            Ficha ficha = new Ficha();
            ficha.setPunteo(10);
            ficha.setLetra("Z");
            listaGenerica.add(ficha);
        }
        return listaGenerica;
    }

    public Jugador cambioTurno(Jugador player) {
        ListaSimple aux = player.getLista();
        Cola aux2 = cola;
        NodoListaSimple Actual = aux.getRaiz();

        for (int i = 0; i < aux.tamaño() + 1; i++) {
            cola.Insertar(Actual.getDato());
            Actual = Actual.getEnlace();
        }
        player.setLista(aux);

        return player;
    }

    public void CambiarLetra(Jugador player, int pos) {
        NodoListaSimple Actual = player.getLista().getRaiz();
        
        for (int i = 0; i < pos; i++) {
            player.getLista().Eliminar(i);
        }
    }

}
