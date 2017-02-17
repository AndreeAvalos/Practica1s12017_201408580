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
public class Matriz {

    Cabeceras cabecera;
    Laterales lateral;

    public Matriz() {
        cabecera = new Cabeceras();
        lateral = new Laterales();
    }

    public void insertar(int x, int y, Object objeto) {
        NodoMatriz pos = new NodoMatriz(objeto, x, y);

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
        System.out.println("Inserto: " + x + " " + y);
    }

    public void llenar(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                insertar(i, j, 0);
            }
        }
    }
}
