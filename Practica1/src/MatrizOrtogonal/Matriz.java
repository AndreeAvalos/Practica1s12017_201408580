/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizOrtogonal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import Juego.OTablero;
import Juego.Tablero;
import static LeerXML.LeerXML.ListaValores;
import static LeerXML.LeerXML.dim;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

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
                JTextField posT = pos.getContenedor();
                //posT.setText(Integer.toString(pos.getNum()));
                posT.setBorder(LineBorder.createGrayLineBorder());
                posT.setBounds(i * 50, j * 35, 50, 35);
                tab.add(posT);
                i++;
                //System.out.print(pos.getLetra() + "  ");
                abajo = abajo.getAbajo();
                Actual = Actual.getAbajo();
            }
            j++;
            i = 0;
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
        JTextField posT;
        String con = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                OTablero data = new OTablero();
                data.setPosx(i);
                data.setPosy(j);
                posT = new JTextField();

                //con = Integer.toString(contador);
                //System.out.println("POS x:"+data.getPosx()+" Y: "+data.getPosy());
                data.setNum(contador);
                MouseListener ml = new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        JComponent jc = (JComponent) e.getSource();
                        TransferHandler th = jc.getTransferHandler();
                        th.exportAsDrag(jc, e, TransferHandler.COPY);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                };
                
                posT.addMouseListener(ml);
                data.setContenedor(posT);
                switch (ListaValores.ExistePos(i, j)) {
                    case 1:
                        data.setValor(1);
                        break;
                    case 2:
                        data.setValor(2);
                        break;
                    case 3:
                        data.setValor(3);
                        break;
                    default:
                        data.setValor(1);
                        break;
                }
                insertar(i, j, data);
                contador++;
            }
        }

    }

    public String ConstruirTXT() {
        FileWriter file = null;
        //instanciamos un objeto PrintWriter para escribir dentro del archivo
        PrintWriter writer = null;

        try {
            //La ubicacion del archivo 
            file = new FileWriter("C:\\graficas\\Matriz.txt");

            //declaramos especificaciones del archivo 
            writer = new PrintWriter(file);
            writer.append("digraph Matriz{ ");
//            writer.append("\tnode [fontcolor=\"cyan\", height=0.5, color=\"black\"]\n");
//            writer.append("[shape=box, style=filled, color=black]");
//            writer.append("\tedge  [color=\"black\", dir=fordware]\n");
//            writer.append("\trankdir=LR \n");
            writer.append("\n");

            NodoMatriz abajo, arriba, derecha, izquierda, Actual, Auxiliar, Auxiliar2, Auxiliar3;
            derecha = lateral.primero.getFila().primero;

            Actual = derecha;
            OTablero pos, pos2, pos3;
            int x = 0;
            int y = 0;

            int nncolumna = 0;
            int nnfila = dim;

            {
                do {
                    abajo = cabecera.getPrimero().getColumna().getPrimero();
                    do {
                        pos = (OTablero) Actual.getDato();
//
//                    if (y == 0) {
//                        writer.append("\n" + pos.getNum());
//                    } else {
//                        writer.append("->" + pos.getNum());
//                    }
                        writer.append(pos.getNum() + "[style =\"filled\"; label=\"" + pos.getPosx() + "," + pos.getPosy() + "\"; pos= \"" + nncolumna + "," + nnfila + "!\"];\n");

                        abajo = abajo.getAbajo();
                        Actual = Actual.getAbajo();
                        nncolumna++;
                        y++;
                    } while (abajo != null);

                    derecha = derecha.getDerecha();
                    Actual = derecha;
                    x++;
                    nncolumna = 0;
                    nnfila--;
                } while (derecha != null);
            }

            x = 0;
            y = 0;

            derecha = lateral.primero.getFila().primero;
            Actual = derecha;
            do {
                abajo = cabecera.getPrimero().getColumna().getPrimero();
                do {
                    pos = (OTablero) Actual.getDato();

                    if (y == 0) {

                        writer.append("\n" + pos.getNum());
                    } else {
                        writer.append("->" + pos.getNum());
                    }
                    abajo = abajo.getAbajo();
                    Actual = Actual.getAbajo();
                    y++;

                } while (abajo != null);

                derecha = derecha.getDerecha();
                Actual = derecha;
                x++;
            } while (derecha != null);

            /*------------------------------------------------------------------------------------*/
            x = 0;
            y = 0;

            izquierda = cabecera.getUltimo().getColumna().getUltimo();
            Auxiliar = izquierda;
            while (izquierda != cabecera.getPrimero().getColumna().getPrimero() && izquierda != null) {
                arriba = lateral.getUltimo().getFila().getUltimo();
                while (arriba != lateral.getPrimero().getFila().getPrimero() && arriba != null) {
                    pos2 = (OTablero) Auxiliar.getDato();
                    if (y == 0) {
                        writer.append("\n" + pos.getNum());
                    } else {
                        writer.append("->" + pos2.getNum());
                    }

                    arriba = arriba.getArriba();
                    Auxiliar = Auxiliar.getArriba();
                    y++;
                }
                izquierda = izquierda.getIzquierda();
                Auxiliar = izquierda;
                x++;

            }

            /*---------------------------------------------------*/
            x = 0;
            y = 0;
            abajo = cabecera.getPrimero().getColumna().getPrimero();
            Auxiliar3 = abajo;
            while (abajo != null) {
                derecha = lateral.getPrimero().getFila().getPrimero();
                while (derecha != null) {
                    pos3 = (OTablero) Auxiliar3.getDato();
                    if (x == 0) {
                        writer.append("\n" + pos3.getNum());
                    } else {
                        writer.append("->" + pos3.getNum());
                    }
                    derecha = derecha.getDerecha();
                    Auxiliar3 = Auxiliar3.getDerecha();
                    x++;
                }

                abajo = abajo.getAbajo();
                Auxiliar3 = abajo;
                y++;
            }

            ///********************************************************/
            /*---------------------------------------------------*/
            arriba = cabecera.getUltimo().getColumna().getUltimo();
            Auxiliar3 = arriba;
            x = 0;
            y = 0;
            while (arriba != null) {
                izquierda = lateral.getUltimo().getFila().getUltimo();
                while (izquierda != null) {
                    pos3 = (OTablero) Auxiliar3.getDato();
                    if (x == 0) {
                        writer.append("\n" + pos3.getNum());
                    } else {
                        writer.append("->" + pos3.getNum());
                    }
                    izquierda = izquierda.getIzquierda();
                    Auxiliar3 = Auxiliar3.getIzquierda();
                    x++;
                }

                arriba = arriba.getArriba();
                Auxiliar3 = arriba;
                y++;
            }
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
        return "Matriz";
    }

    public void GenerarGrafo(String Nombre) {
        try {
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\fdp.exe";

            String fileInputPath = "C:\\graficas\\" + Nombre + ".txt";
            String fileOutputPath = "C:\\graficas\\" + Nombre + ".png";

            String tParam = "-Tpng";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
        } catch (IOException e) {
        }
    }

}
