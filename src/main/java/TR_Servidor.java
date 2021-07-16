

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
public class TR_Servidor {

    public static void main(String[] args) throws Exception {

        try {

            while (true) {
                System.out.println("Servidor Funcionando\n");
                DatagramSocket Conexion = new DatagramSocket(3000);
                byte[] Buffer = new byte[1024];//creamos un buffer
                DatagramPacket ConexionCliente = new DatagramPacket(Buffer, 1024);//datagrama para el paquete de conexion
                
                byte[] Buffer2 = new byte[1024];//creamos un buffer
                DatagramPacket TipoTraduccion = new DatagramPacket(Buffer2, 1024);//datagrama para obtener el tipo de traduccion
                DatagramPacket PalabraTraducir = new DatagramPacket(Buffer2, 1024);//datagrama para la palabra a traducir
                
                Conexion.receive(ConexionCliente);//recibimos el tipo de traduccion
                InetAddress ip = ConexionCliente.getAddress();//obtenemos la ip del cliente
                int puerto = ConexionCliente.getPort();//obtenemos el puerto
                System.out.println("Conexion Exitosa");

                Conexion.receive(TipoTraduccion);//recibimos el tipo de traduccion
                String Traduccion = new String(TipoTraduccion.getData(), 0, TipoTraduccion.getLength());//desempaquetamos el paquete

                if (Traduccion.equals("-1")) {
                    System.out.println("\nOpcion invalida");
                    Conexion.close();
                    break;
                }else if (Traduccion.equals("3")) {
                    System.out.println("\nFinalizado");
                    Conexion.close();
                    break;
                }

                Conexion.receive(PalabraTraducir);//recibimos la palabra
                String Palabra = new String(PalabraTraducir.getData(), 0, PalabraTraducir.getLength());//desempaquetamos el paquete

                DataTR_Servidor FuncionTraductor = new DataTR_Servidor();//creamos un constructor de la clase
                String PalabraTraducida = FuncionTraductor.MetodoDataTR_Servidor(Palabra, Traduccion);//llamamos a un metodo de la clase y obtenemos el retorno

                byte[] BytesTraductor = PalabraTraducida.getBytes();
                DatagramPacket Translate = new DatagramPacket(BytesTraductor, BytesTraductor.length, ip, puerto);//empaquetamos la respuesta
                
                Conexion.send(Translate);//enviamos al respuesta
                Conexion.close();//cerramos la conexion

            }//Cierre del while

        }//Cierre del primer try
        catch (SocketException Error) {
            JOptionPane.showMessageDialog(null, Error);

        } //Cierre del catch

    }//Cierre del main

}//Cierre de la clase Tr_Server
