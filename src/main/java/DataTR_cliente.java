
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ELiazith & gersson
 */
public class DataTR_cliente {
    
    public String Metodo_DataTR_Cliente_Escribir() {
        
        String Palabra = JOptionPane.showInputDialog(">>Introduzca la palabra a traducir: ");
        return Palabra;
    }//Cierre del Metodo_DataTR_Cliente_Escribir

    public String Metodo_DataTR_Cliente_Eleccion() {

        String Opcion = JOptionPane.showInputDialog("<< TRADUCTOR UDP >>\n  1) Ingles >> Español \n  2) Español >> Ingles\n  3) Salir");
        int Numero = Integer.parseInt(Opcion);
        if (Numero > 3) {
            Opcion = "-1";
        }//Cierre del if(num >3) 

        return Opcion;
    }//Cierre del Metodo_DataTR_Cliente_Eleccion

}//Cierre de DataTR_cliente
