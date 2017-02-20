/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Estructuras.ListaCircular;
import Estructuras.ListaSimple;
import Estructuras.NodoListaCircular;
import Estructuras.NodoListaSimple;
import static Juego.NewJugador.ListaJugadores;
import static LeerXML.LeerXML.ListaPalabras;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Andree
 */
public class Tablero extends javax.swing.JFrame {

    ListaCircular Jugadores;
    ListaSimple Palabras, listaLetras;
    DefaultListModel modelo;
    NodoListaCircular PlayerActual;
    Jugador jugador;
    LlenarJugador cambio;
    private String grafoActual = "img";
    private int Constructor = 0;
    boolean fin = false;

    JLabel label;

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        this.Jugadores = ListaJugadores;
        this.Palabras = ListaPalabras;
        this.jugador = null;
        cambio = new LlenarJugador(Jugadores);
        PlayerActual = Jugadores.getInicio();
        llenarJList();
        llenarComponentes();
        cambio();

    }

    public void llenarJList() {
        NodoListaCircular inicio = Jugadores.getInicio();
        NodoListaCircular ultimo = Jugadores.getUltimo();
        NodoListaCircular Actual = inicio;

        jList1.removeAll();
        Jugador jugador2;
        modelo = new DefaultListModel();

        do {
            jugador2 = (Jugador) Actual.getDato();
            modelo.addElement(jugador2.getNombre());
            Actual = Actual.getSiguiente();
        } while (Actual != inicio);
        jList1.setModel(modelo);

    }

    public void llenarComponentes() {
        jugador = (Jugador) PlayerActual.getDato();

        NodoListaSimple Auxiliar;

        if (jugador.getLista() != null) {
            listaLetras = jugador.getLista();
            Auxiliar = listaLetras.getRaiz();
        } else {
            Auxiliar = new NodoListaSimple();

        }
        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    jButton7.setText(Auxiliar.getDato().toString());
                    break;
                case 1:
                    jButton8.setText(Auxiliar.getDato().toString());
                    break;
                case 2:
                    jButton9.setText(Auxiliar.getDato().toString());
                    break;
                case 3:
                    jButton10.setText(Auxiliar.getDato().toString());
                    break;
                case 4:
                    jButton11.setText(Auxiliar.getDato().toString());
                    break;
                case 5:
                    jButton12.setText(Auxiliar.getDato().toString());
                    break;
                case 6:
                    jButton13.setText(Auxiliar.getDato().toString());
                    break;
                default:
                    jButton14.setText(Auxiliar.getDato().toString());
                    break;
            }
            Auxiliar = Auxiliar.getEnlace();
        }

    }

    public void agregarJugador(String nombre) {
        if (Jugadores.Existe(nombre) == true) {
            JOptionPane.showMessageDialog(this, "Usuario Existe", "Error", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, nombre, "Error", INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pseudo Scrabble");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jButton1.setText("Matriz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Lista Fichas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Diccionario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cola Ficha");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Jugadores");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton7.setText("jButton7");
        jButton7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButton7MouseDragged(evt);
            }
        });

        jButton8.setText("jButton8");

        jButton9.setText("jButton9");

        jButton10.setText("jButton10");
        jButton10.setPreferredSize(new java.awt.Dimension(73, 23));

        jButton11.setText("jButton11");
        jButton11.setPreferredSize(new java.awt.Dimension(73, 23));

        jButton12.setText("jButton12");
        jButton12.setPreferredSize(new java.awt.Dimension(73, 23));

        jButton13.setText("jButton13");
        jButton13.setPreferredSize(new java.awt.Dimension(73, 23));

        jLabel1.setText("Ingresar Palabra");

        jButton14.setText("Ingresar");

        jScrollPane1.setViewportView(jList1);

        jButton15.setText("jButton15");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("jButton16");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(1015, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseDragged

    private void jButton7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton7MouseDragged

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:

        jugador = cambio.cambioTurno(jugador);
        jugador.setLista(cambio.GenerarLista(jugador.getCola()));
        PlayerActual = PlayerActual.getSiguiente();
        llenarComponentes();

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Constructor = 2;
        Imagen.stop();
        cambio();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Constructor = 3;
        Imagen.stop();
        cambio();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Constructor = 4;
        Imagen.stop();
        cambio();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Constructor = 5;
        Imagen.stop();
        cambio();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);

            }
        });
    }

    public void GenerarGrafo(String Nombre) {
        try {
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void run() {
//        while (fin != true) {
//            switch (Constructor) {
//                case 1:
//
//                    break;
//                case 2: {
//                    try {
//                        listaLetras.ConstruirTXT(listaLetras);
//                        grafoActual = "ListaSimple";
//                        GenerarGrafo(grafoActual);
//                        String path = "C:\\graficas\\" + grafoActual + ".png";
//                        jLabel2.setIcon(new ImageIcon(path));
//                    } catch (IOException ex) {
//                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                break;
//                case 3: {
//                    try {
//                        Palabras.ConstruirTXT(Palabras);
//                        grafoActual = "ListaSimple";
//                        GenerarGrafo(grafoActual);
//                        String path = "C:\\graficas\\" + grafoActual + ".png";
//                        jLabel2.setIcon(new ImageIcon(path));
//                    } catch (IOException ex) {
//                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                break;
//                case 4:
//                    jugador.getCola().ConstruirTXT(jugador.getCola());
//                    grafoActual = "Cola";
//                    GenerarGrafo(grafoActual);
//                    String path = "C:\\graficas\\" + grafoActual + ".png";
//                    jLabel2.setIcon(new ImageIcon(path));
//                    break;
//                case 5: {
//                    try {
//                        Jugadores.ConstruirTXT(Jugadores);
//                        grafoActual = "ListaCircular";
//                        GenerarGrafo(grafoActual);
//                        String patht = "C:\\graficas\\" + grafoActual + ".png";
//                        jLabel2.setIcon(new ImageIcon(patht));
//                    } catch (IOException ex) {
//                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                break;
//                default:
//                    break;
//            }
//
//            String path = "C:\\graficas\\" + grafoActual + ".png";
//            jLabel2.setIcon(new ImageIcon(path));
//        }
//    }
//
//    public void iniciarHilo() {
//        hilo = new Thread(this);
//        hilo.start();
//        System.out.println("Inicio Hilo");
//
//    }
    ImageIcon image = new ImageIcon();
    Thread Imagen;
    String path = "C:\\graficas\\" + grafoActual + ".png";

    int con;

    public void cambio() {
        con = 0;

        Imagen = new Thread() {
            @Override
            public void run() {

                try {
                    while (true) {
                        label = jLabel2;

                        con++;
                        switch (Constructor) {
                            case 1:

                                break;
                            case 2: {
                                try {
                                    listaLetras.ConstruirTXT(listaLetras);
                                    grafoActual = "ListaSimple";
                                    GenerarGrafo(grafoActual);
                                    path = "C:\\graficas\\" + grafoActual + ".png";
                                    label.setIcon(new ImageIcon(path));
                                } catch (IOException ex) {
                                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                            case 3: {
                                try {
                                    Palabras.ConstruirTXT(Palabras);
                                    grafoActual = "ListaSimple";
                                    GenerarGrafo(grafoActual);
                                    path = "C:\\graficas\\" + grafoActual + ".png";
                                   label.setIcon(new ImageIcon(path));

                                } catch (IOException ex) {
                                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                            case 4:
                                jugador.getCola().ConstruirTXT(jugador.getCola());
                                grafoActual = "Cola";
                                GenerarGrafo(grafoActual);
                                path = "C:\\graficas\\" + grafoActual + ".png";
                                label.setIcon(new ImageIcon(path));

                                break;
                            case 5: {
                                try {
                                    Jugadores.ConstruirTXT(Jugadores);
                                    grafoActual = "ListaCircular";
                                    GenerarGrafo(grafoActual);
                                    path = "C:\\graficas\\" + grafoActual + ".png";
                                   label.setIcon(new ImageIcon(path));

                                } catch (IOException ex) {
                                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;
                            default:
                                break;
                        }
                        Thread.sleep(500);
                        jLabel2=label;
//                        System.out.println(con + "");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        };
        Imagen.start();
    }
}
