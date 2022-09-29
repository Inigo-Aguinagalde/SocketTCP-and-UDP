package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	
	public static void main(String [] args) {
		
		
		try {
			Socket s = new Socket("localhost",1234);
		
			DataInputStream br = new DataInputStream(s.getInputStream());
			DataOutputStream bw = new DataOutputStream(s.getOutputStream());
			
			HiloHablar hablar = new HiloHablar(bw);
			HiloEscuchar esuchar = new HiloEscuchar(br);
			hablar.start();
			esuchar.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
