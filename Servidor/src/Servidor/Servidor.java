package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	static ArrayList<HiloConexion> conexiones = new ArrayList<>();
	
	public static void main(String [] args) {
		
		try {
			ServerSocket server = new ServerSocket(1234);
			System.out.println("Servidor en linea");
			
			
			while(true) {
				
				Socket s= server.accept();
				HiloConexion conexion = new HiloConexion(s);
				conexion.start();
				conexiones.add(conexion);
				System.out.println("Cliente conectado");
				
				
				
			}
			
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void brodcast(String linea) {
		
		for(HiloConexion c : conexiones) {
			c.enviarMensaje(linea);
		}
	}
}
