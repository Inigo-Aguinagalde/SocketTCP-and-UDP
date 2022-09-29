package Servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class HiloHablarServidor extends Thread {

	private DataOutputStream bw;
	
	public HiloHablarServidor(DataOutputStream bw) {
		this.bw=bw;
	}
	
	@Override
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		String mensaje;
		while(true) {
			
			
			mensaje=sc.nextLine();
			String mensajeFinal="Servidor: "+mensaje;
			try {
				bw.writeUTF(mensajeFinal);
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
}
