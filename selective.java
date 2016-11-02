import java.util.*;
import java.util.concurrent.TimeUnit;

class selective
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
		int expected = 1, retransmit = -1,start = 0, lak = -1;
		int ch1, ch2;
		int buff[] = new int[n];
 		for(i = 0; i < n; i++){
			buff[i] =  0;
		}
		while(true)
		{
			for(i = start; i < n; i++){
				if(buff[i] == 0 || expected == (i+1)){
					if(buff[i] == 0)
					{System.out.println("Transmitting frame " + (i+1));
					System.out.println("Is data correct?\n1=Yes\n0=No");
					ch1 = sc.nextInt();}
					else{
						ch1 = 1;
					}
					if(ch1 == 1){
						if(expected != (i+1)){
							buff[i] = 1;
						}
						else{
							lak = i;
							buff[i] = 1;
							expected++;
						}
					}
					else{
						System.out.println("Data is corrupted");
						retransmit = i;
					}
				}
				else if(buff[i] == 1 && i > lak){
					System.out.println("Frame " + (i+1) + "is buffered");

				}
			}
			System.out.println("Last Ack received for frame" + (lak+1));
			start = lak;
			if(start == n-1)
				break;
		}
	}
}