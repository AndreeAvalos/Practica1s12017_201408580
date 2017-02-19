/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeerXML;

import Estructuras.ListaSimple;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Andree
 */
public class LeerXML {

    private String ruta = "";
    public static int dim=0;
    public LeerXML() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos XML", "xml");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
            ruta = chooser.getSelectedFile().getPath();
            LeerXML(ruta);
        }
    }

    public void LeerXML(String ruta) {
        SAXBuilder constructor = new SAXBuilder();
        File archivo = new File(ruta);

        try {
            //Se crea el archivo
            Document documento = (Document) constructor.build(archivo);
            //Obtenemos Raiz
            Element raiz = documento.getRootElement();

            //se Obtienen los hijos 
            //List lstDimension = raiz.getChildren("dimension");
            //List lstTriples = raiz.getChildren("triples");
            //List lstDiccionario = raiz.getChildren("diccionario");
            String dimension = "";
            System.out.println("DIMENSIONES");
            for (int i = 0; i < raiz.getChildren("dimension").size(); i++) {
                Element campo = (Element) raiz.getChildren("dimension").get(i);
                dimension = campo.getTextTrim();
                dim = Integer.parseInt(dimension);
                //System.out.println("Dimension: " + dimension);
            }
           

            /*---------------------------------------------------------------------------*/
            //Se obtiene el valor de dobles
            System.out.println("DOBLES");
            for (int i = 0; i < raiz.getChildren("dobles").size(); i++) {
                Element tabla = (Element) raiz.getChildren("dobles").get(i);
                for (int j = 0; j < tabla.getChildren().size(); j++) {
                    Element campo = (Element) tabla.getChildren().get(j);
                    //System.out.println("x: " + campo.getChildTextTrim("x") + " y: " + campo.getChildTextTrim("y"));

                }
            }

            /*-----------------------------------------------------------------------------*/
            //se obtienen valores de casillas triples
            System.out.println("Triples");
            for (int i = 0; i < raiz.getChildren("triples").size(); i++) {
                Element tabla = (Element) raiz.getChildren("triples").get(i);
                for (int j = 0; j < tabla.getChildren().size(); j++) {
                    Element campo = (Element) tabla.getChildren().get(j);
                    //System.out.println("x: " + campo.getChildTextTrim("x") + " y: " + campo.getChildTextTrim("y"));
                }
            }
            /*----------------------------------------------------------------------------*/

            //instanciamos la clase de la lista simple
            ListaSimple lstSimple = new ListaSimple();

            //se obtienen palabras
            System.out.println("PALABRAS");
            for (int i = 0; i < raiz.getChildren("diccionario").size(); i++) {
                Element tabla = (Element) raiz.getChildren("diccionario").get(i);
                for (int j = 0; j < tabla.getChildren().size(); j++) {
                    Element campo = (Element) tabla.getChildren("palabra").get(j);
                    //System.out.println("Palabra: " + campo.getTextTrim());

                    //llamamos el metodo para insertar en la lista 
                    lstSimple.insertar(campo.getTextTrim());
                }
            }
            lstSimple.ConstruirTXT();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }

}
