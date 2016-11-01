import java.util.*;
import java.net.*;
import java.io.*;

class server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(8080);
		Socket s = ss.accept();
		Scanner sc = new Scanner(System.in);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		while(true){
			String m = (String)dis.readUTF();
			System.out.println("Client sent " + m);
			System.out.println("Enter message to send to client");
			m = sc.next();
			dos.writeUTF(m);
			System.out.println("Sent");
			
			//sc.next();	
		}
		

	}
}