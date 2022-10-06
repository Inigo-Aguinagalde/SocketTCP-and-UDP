package Cliente;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Cliente {


  // Los argumentos proporcionan el mensaje y el nombre del servidor
  public static void main(String args[]) {

    try {
    	Scanner sc = new Scanner(System.in);
    	
    	
    			
    	 DatagramSocket socketUDP = new DatagramSocket();
    	
         InetAddress hostServidor = InetAddress.getByName("10.10.17.205");
         int puertoServidor = 1234;
         byte[] meg = null;
         System.out.println("Cliente en linea");
         while (true) {
			
			String msg = sc.nextLine();
			meg = msg.getBytes();
			
			DatagramPacket dp = new DatagramPacket(meg, meg.length, hostServidor, puertoServidor);
			
			socketUDP.send(dp);
			
			if(msg.equalsIgnoreCase("quit")) {
				break;
			}
			meg =  new byte[65535];
			DatagramPacket peticion = new DatagramPacket(meg, meg.length);

			socketUDP.receive(peticion);
			System.out.println("Server: "+data(meg));
         
         }
         
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} 
     

 }
  
	public static StringBuilder data(byte[] a) {
		if(a==null) {
			return null;
		}
		
		StringBuilder ret = new StringBuilder();
		int i=0;
		while (a[i] !=0) {
			ret.append((char) a[i]);
			i++;
			
		}
		return ret;
		
	}
}