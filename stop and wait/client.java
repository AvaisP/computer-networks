import java.util.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class client
{
	public static void main(String args[]) throws IOException
	{
		Socket s = new Socket("localhost",8080);
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(s.getOutputStream());
		BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println("Enter number of frames");
		int n = sc.nextInt();
		try{
			for(int i = 0; i < n; i++)
			{
				ps.println(i);
				System.out.println("Sent Packet " + i);
				String m = bf.readLine();
				TimeUnit.SECONDS.sleep(2);
				if(m!=null){
					System.out.println("Acknowledgement received for packet " + i);
				}
				else{
					System.out.println("Acknowledgement not received. Resending");
					i -= 1;
				}
				//sc.next();	
			}
			ps.println("exit");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
		

	}
}