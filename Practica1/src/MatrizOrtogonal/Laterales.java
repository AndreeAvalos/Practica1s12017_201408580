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
public class Laterales {

    NodoLateral primero;
    NodoLateral ultimo;

    public Laterales() {
        primero = ultimo = null;
    }

    public void insertar(NodoLateral insertar) {
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

    public void insertarFrente(NodoLateral insertar) {
        primero.setAnterior(insertar);
        insertar.setSiguiente(primero);
        primero = primero.getAnterior();
    }

    public void insertarMedio(NodoLateral insertar) {
        NodoLateral temp, temp2;
        temp = primero;
        while (temp.getY() < insertar.getY()) {
            temp = temp.getSiguiente();
        }
        temp2 = temp.getAnterior();
        temp2.setSiguiente(insertar);
        temp.setAnterior(insertar);
        insertar.setSiguiente(temp);
        insertar.setAnterior(temp2);
    }

    public void insertarFinal(NodoLateral insertar) {
        ultimo.setSiguiente(insertar);
        insertar.setAnterior(ultimo);
        ultimo = ultimo.getSiguiente();
    }

    public void recorrer() {
        if (!vacio()) {
            NodoLateral Actual;
            Actual = primero;
            while (Actual != null) {
                System.out.println(Actual.getY());
                Actual = Actual.getSiguiente();
            }
        }
    }

    public boolean Existe(int y) {
        if (vacio()) {
            return false;
        } else {
            NodoLateral temp;
            temp = primero;
            while (temp != null) {
                if (temp.getY() == y) {
                    return true;
                } else if (temp.getSiguiente() == null) {
                    return false;
                }
                temp = temp.getSiguiente();
            }
        }
        return false;
    }

    public NodoLateral Buscar(int y) {
        if (Existe(y)) {
            NodoLateral temp;
            temp = primero;
            while (temp.getY() != y) {
                temp = temp.getSiguiente();
            }
            return temp;
        } else {
            return (new NodoLateral(-1));
        }
    }

    public NodoLateral getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLateral primero) {
        this.primero = primero;
    }

    public NodoLateral getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLateral ultimo) {
        this.ultimo = ultimo;
    }
    
}
