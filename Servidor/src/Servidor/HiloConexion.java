package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Cliente.HiloHablar;

public class HiloConexion extends Thread {
	
	private Socket s;
	private DataOutputStream bw;
	private DataInputStream br;
	
	
	public HiloConexion(Socket socket) {
		s=socket;
	}
	
	@Override
	public void run() {
		try {
			bw=new DataOutputStream(s.getOutputStream());
			br= new DataInputStream(s.getInputStream());
			
			HiloHablarServidor hilohablar = new HiloHablarServidor(bw);
			hilohablar.start();
			String linea;
			while((linea=br.readUTF())!=null) {
				System.out.println(linea);
				Servidor.brodcast(linea);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	public void enviarMensaje(String linea) {
		
		try {
			bw.writeUTF(linea);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
