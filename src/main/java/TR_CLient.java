
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;
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
public class TR_CLient {

    public static void main(String[] args) throws Exception {

        String DireccionIP = JOptionPane.showInputDialog("Ingresa la IP del servidor:");
        String TipoTraduccion = "";

        try {
            while (!"3".equals(TipoTraduccion)) {
                DatagramSocket Conexion = new DatagramSocket();
                InetAddress IpServidor = InetAddress.getByName(DireccionIP);

                String Mensaje = "Inicio";
                DatagramPacket PaqueteInicio = new DatagramPacket(Mensaje.getBytes(), Mensaje.length(), IpServidor, 3000);
                Conexion.send(PaqueteInicio);

                byte[] Buffer1 = new byte[1024];
                DatagramPacket Paquete2;
                DatagramPacket Paquete3 = new DatagramPacket(Buffer1, 1024);
                DataTR_cliente Funcion = new DataTR_cliente();

                TipoTraduccion = Funcion.Metodo_DataTR_Cliente_Eleccion();
                DatagramPacket TipTraduccion = new DatagramPacket(TipoTraduccion.getBytes(), TipoTraduccion.length(), IpServidor, 3000);
                Conexion.send(TipTraduccion);

                String Resultado, PalabraTraducir;

                switch (TipoTraduccion) {

                    case "1":

                        JOptionPane.showMessageDialog(null, "\nIngles >> Español");
                        PalabraTraducir = Funcion.Metodo_DataTR_Cliente_Escribir();
                        Paquete2 = new DatagramPacket(PalabraTraducir.getBytes(), PalabraTraducir.length(), IpServidor, 3000);
                        Conexion.send(Paquete2);
                        Conexion.receive(Paquete3);
                        Resultado = new String(Paquete3.getData(), 0, Paquete3.getLength());
                        JOptionPane.showMessageDialog(null, "Respuesta: " + Resultado);
                        break;

                    case "2":

                        JOptionPane.showMessageDialog(null, "\nEspañol >> Ingles");
                        PalabraTraducir = Funcion.Metodo_DataTR_Cliente_Escribir();
                        Paquete2 = new DatagramPacket(PalabraTraducir.getBytes(), PalabraTraducir.length(), IpServidor, 3000);
                        Conexion.send(Paquete2);
                        Conexion.receive(Paquete3);
                        Resultado = new String(Paquete3.getData(), 0, Paquete3.getLength());
                        JOptionPane.showMessageDialog(null, "Respuesta: " + Resultado);
                        break;

                    case "3":

                        JOptionPane.showMessageDialog(null, "\nServer: Conexion Detenida");
                        Conexion.close();
                        break;
                }

            }

        }//Cierre del try
        catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "\nExcepcion: " + e);
        }//cierre del catch

    }//Cierre del main

}//Cierre de Tr_Client
