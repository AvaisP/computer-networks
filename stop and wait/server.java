import java.util.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(8080);
		Socket s = ss.accept();
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(s.getOutputStream());
		BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
		try{
			while(true){
				String temp = bf.readLine();
				if(temp.compareTo("exit") == 0){
					break;
				}
				else{
					System.out.println("Frame " + temp + "receieved");
					ps.println("Ack");
					TimeUnit.SECONDS.sleep(2);
				}
				//sc.next();	
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
		

	}
}