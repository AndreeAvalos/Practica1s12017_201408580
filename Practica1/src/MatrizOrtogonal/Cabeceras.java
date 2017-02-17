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
public class Cabeceras {

    NodoCabecera primero;
    NodoCabecera ultimo;

    public Cabeceras() {
        primero = ultimo = null;
    }

    public void insertar(NodoCabecera insertar) {
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

    public void insertarFrente(NodoCabecera insertar) {
        primero.setAnterior(insertar);
        insertar.setSiguiente(primero);
        primero = primero.getAnterior();
    }

    public void insertarMedio(NodoCabecera insertar) {
        NodoCabecera temp, temp2;
        temp = primero;
        while (temp.getX() < insertar.getX()) {
            temp = temp.getSiguiente();
        }
        temp2 = temp.getAnterior();
        temp2.setSiguiente(insertar);
        temp.setAnterior(insertar);
        insertar.setSiguiente(temp);
        insertar.setAnterior(temp2);
    }

    public void insertarFinal(NodoCabecera insertar) {
        ultimo.setSiguiente(insertar);
        insertar.setAnterior(ultimo);
        ultimo = ultimo.getSiguiente();
    }

    public void recorrer() {
        if (!vacio()) {
            NodoCabecera Actual;
            Actual = primero;
            while (Actual != null) {
                System.out.println(Actual.getX());
                Actual = Actual.getSiguiente();
            }
        }
    }

    public boolean Existe(int x) {
        if (vacio()) {
            return false;
        } else {
            NodoCabecera temp;
            temp = primero;
            while (temp != null) {
                if (temp.getX() == x) {
                    return true;
                } else if (temp.getSiguiente() == null) {
                    return false;
                }
                temp = temp.getSiguiente();
            }
        }
        return false;
    }

    public NodoCabecera Buscar(int x) {
        if (Existe(x)) {
            NodoCabecera temp;
            temp = primero;
            while (temp.getX() != x) {
                temp = temp.getSiguiente();
            }
            return temp;
        } else {
            return (new NodoCabecera(-1));
        }
    }
}