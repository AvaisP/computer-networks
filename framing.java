import java.util.*;

class framing
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu:\n1.Character Count\n2.Character Stuffing\n3.Bit Stuffing");
		int ch = sc.nextInt();
		switch(ch)
		{
			case 1:
				System.out.println("Too easy");
				break;

			case 2:
				char_stuffing();
				break;

			case 3:
				bit_stuffing();
				break;

			default:
				System.out.println("Wrong I/P");
		}
	}

	public static void char_stuffing()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		String data = sc.next();
		System.out.println("Enter Flag");
		String flag = sc.next();
		System.out.println("Enter escape character");
		String esc = sc.next();
		String escpl = esc + esc;
		data = data.replaceAll(esc, escpl);
		System.out.println(data);
		String flagpl = esc + flag;
		data = data.replaceAll(flag, flagpl);
		String transmit = flag + data + flag;
		System.out.println("Transmitted:" + transmit);
	}

	public static void bit_stuffing()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		String data = sc.next();
		String flag = "111111";
		data = data.replaceAll("111111", "1111101");
		String transmit = flag + data + flag;
		System.out.println("Transmitted:" + transmit);
	}
}