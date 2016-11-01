import java.util.*;

class crc
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter message:");
		String m = sc.next();
		String temp = m;
		System.out.println("Enter generator:");
		String g = sc.next();
		int zeros = g.length()-1;
		int i,j;
		System.out.println(zeros + " zeros are to be appended.");
		for(i = 0; i < zeros; i++)
		{
			m += "0";
		}
		System.out.println("String with appended zeroes:" + m);
		int mes [] = toArr(m);
		int gen [] = toArr(g);
		mes = divide(mes,gen);
		for(i = mes.length - zeros; i < mes.length; i++)
		{
			temp += mes[i];
		}
		System.out.println("Transmitted:" + temp);
		System.out.println("Enter receievd:");
		String rec = sc.next();
		int reci[] = divide(toArr(rec),gen);
		int flag = -1;
		for (i = 0; i < reci.length; i++)
		{
			if(reci[i] == 1)
			{
				flag = 0;
				System.out.println("Data is corrupted");
				break;
			}
		}  
		if (flag == -1)
		{
			System.out.println("Data is correct");
		}
	}

	public static int[] toArr(String x)
	{
		int arr[] = new int[x.length()];
		for(int i = 0; i <x.length(); i++)
		{
			arr[i] = x.charAt(i) - 48;
		}
		return arr;
	} 

	public static int[] divide(int mes[], int gen[])
	{
		int i,j,k;
		int gen_len = gen.length;
		for(i = 0; i < mes.length;i++)
		{
			if(mes[i] == 1 && i + gen_len -1 < mes.length)
				for(j = i,k = 0 ; j < gen_len + i; k++,j++)
				{
					mes[j] =  mes[j] ^ gen[k];
				}
		}
		return mes;
	}
}