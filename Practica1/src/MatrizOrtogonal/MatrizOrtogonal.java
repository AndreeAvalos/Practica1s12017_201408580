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
public class MatrizOrtogonal {

    Matriz mat = new Matriz();

    public MatrizOrtogonal(int dimension) {
        mat.llenar(dimension, dimension);
    }

}
