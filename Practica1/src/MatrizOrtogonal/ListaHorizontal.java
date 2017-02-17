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
public class ListaHorizontal {
    NodoMatriz primero;
    NodoMatriz ultimo;

    public ListaHorizontal() {
        primero = ultimo = null;
    }

    public void insertar(NodoMatriz insertar) {
        if (vacio() == true) {
            primero = ultimo = insertar;
        } else {
            if (insertar.getX() < primero.getX()) {
                insertarFrente(insertar);
            } else if (insertar.getX() > ultimo.getX()) {
                insertarFinal(insertar);
            } else {
                insertarMedio(insertar);
            }
        }
    }

    public boolean vacio() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarFrente(NodoMatriz insertar) {
        primero.setIzquierda(insertar);
        insertar.setDerecha(primero);
        primero = primero.getIzquierda();
    }

    public void insertarMedio(NodoMatriz insertar) {
        NodoMatriz temp, temp2;
        temp = primero;
        while (temp.getX() < insertar.getX()) {
            temp = temp.getDerecha();
        }
        temp2 = temp.getIzquierda();
        temp2.setDerecha(insertar);
        temp.setIzquierda(insertar);
        insertar.setDerecha(temp);
        insertar.setIzquierda(temp2);
    }

    public void insertarFinal(NodoMatriz insertar) {
        ultimo.setDerecha(insertar);
        insertar.setIzquierda(ultimo);
        ultimo = ultimo.getDerecha();
    }

    public void recorrer() {
        if (!vacio()) {
            NodoMatriz Actual;
            Actual = primero;
            while (Actual != null) {
                System.out.println(Actual.getDato().toString());
                Actual = Actual.getDerecha();
            }
        }
    }
}
