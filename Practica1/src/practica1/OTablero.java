/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Image;
import javax.swing.JLabel;

/**
 *
 * @author Andree
 */
public class OTablero {

    private int posx;
    private int posy;
    private Image imagen;
    private JLabel contenedor;
    private String letra;
    private int num;

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public JLabel getContenedor() {
        return contenedor;
    }

    public void setContenedor(JLabel contenedor) {
        this.contenedor = contenedor;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
