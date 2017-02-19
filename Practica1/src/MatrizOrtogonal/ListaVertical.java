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
public class ListaVertical {

    NodoMatriz primero;
    NodoMatriz ultimo;

    public NodoMatriz getPrimero() {
        return primero;
    }

    public void setPrimero(NodoMatriz primero) {
        this.primero = primero;
    }

    public NodoMatriz getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoMatriz ultimo) {
        this.ultimo = ultimo;
    }

    public ListaVertical() {
        primero = ultimo = null;
    }

    public void insertar(NodoMatriz insertar) {
        if (vacio() == true) {
            primero = ultimo = insertar;
        } else {
            if (insertar.getY() < primero.getY()) {
                insertarFrente(insertar);
            } else if (insertar.getY() > ultimo.getY()) {
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
        primero.setArriba(insertar);
        insertar.setAbajo(primero);
        primero = primero.getArriba();
    }

    public void insertarMedio(NodoMatriz insertar) {
        NodoMatriz temp, temp2;
        temp = primero;
        while (temp.getY() < insertar.getY()) {
            temp = temp.getAbajo();
        }
        temp2 = temp.getArriba();
        temp2.setAbajo(insertar);
        temp.setArriba(insertar);
        insertar.setAbajo(temp);
        insertar.setArriba(temp2);
    }

    public void insertarFinal(NodoMatriz insertar) {
        ultimo.setAbajo(insertar);
        insertar.setArriba(ultimo);
        ultimo = ultimo.getAbajo();
    }

    public void recorrer() {
        if (!vacio()) {
            NodoMatriz Actual;
            Actual = primero;
            while (Actual != null) {
                System.out.println(Actual.getDato().toString());
                Actual = Actual.getAbajo();
            }
        }
    }
}
