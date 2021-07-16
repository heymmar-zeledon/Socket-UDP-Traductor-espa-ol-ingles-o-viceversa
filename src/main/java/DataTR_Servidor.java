
import java.io.*;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eliazith & gersson
 */
public class DataTR_Servidor {

    public String MetodoDataTR_Servidor(String PalabraTraducir, String TipoTraduccion) {
        String LineaActualFichero;
        String Excepcion = "Palabra no encontrada";
        int Validador = 0;

        if (TipoTraduccion.equals("1")) {

            System.out.println("\nIngles >> Español");

            try ( BufferedReader BufferFichero = new BufferedReader(new FileReader("Traducciones.txt"))) {

                while ((LineaActualFichero = BufferFichero.readLine()) != null) {

                    String[] Lectura = LineaActualFichero.split("=");
                    Validador++;

                    if (Lectura[1].equals(PalabraTraducir)) {
                        System.out.println("\nPalabra encontrada:\nPalabra" + PalabraTraducir + "\nTraduccion: " + Lectura[0] + "\n");

                        Validador = -1;
                        return Lectura[0];

                    }//Cierre del if interno 1

                }//Cierre del while 1 

                if (Validador != -1) {
                    JOptionPane.showMessageDialog(null, Excepcion+"\n");
                    return Excepcion;

                }//Cierre del if(Validador != -1)

            }//Cierre del try 1
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se pudo acceder al fichero");
            }//Cierre del catch

        }//Cierre del if principal
        else {
            if (TipoTraduccion.equals("2")) {

                JOptionPane.showMessageDialog(null, "\nEspañol >> Ingles");

                try ( BufferedReader BufferFichero = new BufferedReader(new FileReader("Traducciones.txt"))) {
                    while ((LineaActualFichero = BufferFichero.readLine()) != null) {
                        String[] Lectura = LineaActualFichero.split("=");

                        if (Lectura[0].equals(PalabraTraducir)) {

                            System.out.println("\nPalabra encontrada: \nPalabra: " + PalabraTraducir + "\nTraduccion: " + Lectura[1] + "\n");

                            Validador = -1;
                            return Lectura[1];

                        }//Cierre del if interno 

                    }//Cierre del while 2

                    if (Validador != -1) {
                        JOptionPane.showMessageDialog(null,"Excepcion"+"\n");
                        return Excepcion;

                    }//Cierre del if(cent !=-1) 
                }//Cierre del try 2
                catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Fichero Inaccesible");
                    e.printStackTrace();

                }//Cierre del catch 2 

            }//Cierre del if 2
            else {
                if (TipoTraduccion.equals("3")) {
                    JOptionPane.showMessageDialog(null, "Error!  Opcion no valida");

                }//Cierre del if interno 3

            }//Cierre del else  2

        }//cierre del else principal
        return "";
    }

}//Cierre de la class Clase_dataTR_servidor
