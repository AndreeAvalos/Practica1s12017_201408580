/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeerXML;

import Estructuras.Cola;
import Estructuras.ListaCircular;
import Estructuras.ListaSimple;
import static LeerXML.LeerXML.dim;
import MatrizOrtogonal.MatrizOrtogonal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Juego.Jugador;
import Juego.LlenarJugador;
import Juego.NewJugador;
import Juego.Tablero;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Andree
 */
public class LeerArchivo extends javax.swing.JFrame {

    private boolean cargo = false;

    /**
     * Creates new form LeerArchivo
     */
    public LeerArchivo() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Leer XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Jugar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new LeerXML();
        cargo = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        ListaHorizontal lstVertical = new ListaHorizontal();
//        lstVertical.insertar(new NodoMatriz("1", 1, 4));
//        lstVertical.insertar(new NodoMatriz("2", 2, 3));
//        lstVertical.insertar(new NodoMatriz("3", 0, 5));
//        lstVertical.insertar(new NodoMatriz("4", 9, 1));
//
//        lstVertical.recorrer();
//

//        Cabeceras cabecera = new Cabeceras();
//        cabecera.insertar(new NodoCabecera(4));
//        cabecera.insertar(new NodoCabecera(6));
//        cabecera.insertar(new NodoCabecera(0));
//        cabecera.insertar(new NodoCabecera(9));
//        cabecera.recorrer();
//        boolean prueba;
//        prueba = cabecera.Existe(4);
//        System.out.println(prueba);
//        
//        System.out.println("----------------");
//        
//        Laterales Lateral = new Laterales();
//        Lateral.insertar(new NodoLateral(1));
//        Lateral.insertar(new NodoLateral(6));
//        Lateral.insertar(new NodoLateral(0));
//        Lateral.insertar(new NodoLateral(2));
//        Lateral.recorrer();
//        MatrizOrtogonal matri = new MatrizOrtogonal(dim);
//        Cola cola = new Cola();
//        cola.Insertar("1");
//        cola.Insertar("2");
//        cola.Insertar("4");
//        cola.Insertar("3");
//        cola.Insertar("5");
//        cola.Visualizar();
//        Tablero tab = new Tablero();
//        tab.GenerarGrafo(cola.ConstruirTXT());
//        ListaCircular lstcircular = new ListaCircular();
        if (cargo == true) {
            NewJugador jugador = new NewJugador();
            jugador.show();
            this.hide();
        } else{
             JOptionPane.showMessageDialog(this, "No has cargado ningun archivo", "Error", INFORMATION_MESSAGE);
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LeerArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeerArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeerArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeerArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeerArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
