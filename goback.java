import java.util.*;
import java.util.concurrent.TimeUnit;

class goback
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of frames:");
		int n = sc.nextInt();
		String s[] = new String [n];
		System.out.println("Enter data for frames");
		int i;
		for(i = 0; i < n; i++)
		{
			s[i] = sc.next();
		}
		int expected = 1, retransmit = -1,start = 0;
		int ch1,ch2;
		while(true)
		{

			for(i = start; i < n; i++){
				System.out.println("Transmitting frame " + (i+1));
					if(expected == (i+1)){
							
					System.out.println("Send a positive acknowledgement?\n1=Yes\n0=No");
					ch1 = sc.nextInt();
					if(ch1 == 1){
						System.out.println("Is ack lost?\n1=Yes\n0=No");
						ch2 = sc.nextInt();
						if(ch2 == 0){
							System.out.println("Data recieved : " + s[i]);
							expected++;
							retransmit = -1;
						}

					}
					else{
						System.out.println("Data is corrupted");
						retransmit = i;
					}
				}
				else{
					System.out.println("Arrived out of order");
				}
			}
			if(retransmit != -1)
				start = retransmit;
			else
				break;
		}
	}
}