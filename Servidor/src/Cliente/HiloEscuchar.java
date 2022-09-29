package Cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloEscuchar extends Thread{
	
	private DataInputStream br;
	
	public HiloEscuchar( DataInputStream br) {
		this.br=br;
		
		
	}
	
	@Override
	public void run() {
		try {
		String linea;
		
			while((linea=br.readUTF())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
