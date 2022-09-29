package Cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class HiloHablar extends Thread {

	private DataOutputStream bw;
	public HiloHablar(DataOutputStream bw) {
		this.bw=bw;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String mensaje;
		while(true) {
			System.out.println("Introduzca el mensaje");
			mensaje="";
			mensaje=sc.nextLine();
			String mensajeFinal="Cliente: "+mensaje;
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
