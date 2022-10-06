package Server;

import java.io.IOException;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			DatagramSocket socket = new DatagramSocket(1234);
			byte[] buffer = new byte[65535];
			
			System.out.println("Servidor en linea");
			while(true) {
				
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
				
				socket.receive(peticion);
				System.out.println("Client: "+data(buffer));
				
				socket.send(peticion);
				
				//System.out.println("Host: "+peticion.getAddress()+" \n Puerto: "+peticion.getPort());
				//DatagramPacket respuesta = new DatagramPacket(peticion.getData(),peticion.getLength());
			//	String received = new String(peticion.getData(), 0, peticion.getLength());
			
				buffer = new byte[65535];
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
