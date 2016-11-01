import java.util.*;
import java.net.*;
import java.io.*;

class client
{
	public static void main(String args[]) throws IOException
	{
		Socket s = new Socket("localhost",8080);
		Scanner sc = new Scanner(System.in);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		while(true){
			System.out.println("Enter message to send to 8080");
			String m = sc.next();
			dos.writeUTF(m);
			System.out.println("Sent");
			m = (String)dis.readUTF();
			System.out.println("Server replied with " + m);
			//sc.next();	
		}
		

	}
}