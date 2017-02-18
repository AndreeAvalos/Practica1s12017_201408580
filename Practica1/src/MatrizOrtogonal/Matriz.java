/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizOrtogonal;

import javax.swing.JLabel;
import practica1.OTablero;
import practica1.Tablero;

/**
 *
 * @author Andree
 */
public class Matriz {

    Cabeceras cabecera;
    Laterales lateral;
    Object dato;

    public Matriz() {
        cabecera = new Cabeceras();
        lateral = new Laterales();
    }

    public void insertar(int x, int y, Object objeto) {
        NodoMatriz pos = new NodoMatriz(objeto, x, y);
        OTablero posT;
        if (cabecera.Existe(x) == false) {
            cabecera.insertar(new NodoCabecera(x));
        }
        if (lateral.Existe(y) == false) {
            lateral.insertar(new NodoLateral(y));
        }
        NodoCabecera temp;
        NodoLateral temp2;

        temp = cabecera.Buscar(x);
        temp2 = lateral.Buscar(y);

        temp.getColumna().insertar(pos);
        temp2.getFila().insertar(pos);
        posT = (OTablero) pos.getDato();
        //System.out.println("Posicion: " + posT.getPosx() + " " + posT.getPosy() + " Dato: " + posT.getLetra());
    }

    public void recorrer() {
        NodoMatriz arriba, abajo, izquierda, derecha, Actual;
        OTablero pos;
        Actual = null;
        derecha = lateral.primero.fila.primero;
        Actual = derecha;
        izquierda = arriba = null;
        int i = 0;
        int j = 0;
        Tablero tab = new Tablero();
        while (derecha != null) {
            abajo = cabecera.primero.columna.primero;

            while (abajo != null) {

                arriba = abajo;
                //System.out.print(derecha.getX()+ "," + abajo.getY()+ " ");
                pos = (OTablero) Actual.getDato();
                //System.out.print(pos.getPosx() + "," + pos.getPosy() + " ");
                JLabel posT = pos.getContenedor();
                posT.setText(pos.getLetra());
                posT.setBounds(i * 35, j * 35, 35, 35);
                tab.add(posT);
                i++;
                
                System.out.print(pos.getLetra() + "  ");

                abajo = abajo.getAbajo();
                Actual = Actual.getAbajo();
            }
            j++;
            i=0;
            System.out.println();
            izquierda = derecha;
            derecha = derecha.getDerecha();
            Actual = derecha;
        }
        tab.show();

    }

    public boolean vacio() {
        if (cabecera == null && lateral == null) {
            return true;
        } else {
            return false;
        }
    }
    int contador = 0;

    public void llenar(int x, int y) {
        JLabel posT;
        String con = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                OTablero data = new OTablero();
                data.setPosx(i);
                data.setPosy(j);
                posT = new JLabel();
                data.setContenedor(posT);
                con = Integer.toString(contador);
                //System.out.println("POS x:"+data.getPosx()+" Y: "+data.getPosy());
                data.setLetra("A" + contador);
                insertar(i, j, data);
                contador++;
            }
        }
    }
}
