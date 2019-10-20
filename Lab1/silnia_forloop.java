package Lab1;
import java.util.Scanner;

public class silnia_forloop {
	
	
	public static void main (String args[])
	{
		int max=0;
		System.out.println("Podaj a");
		Scanner sc = new Scanner(System.in);
		max = sc.nextInt(); 
		sc.close();
		try {
			
			for (int i=0; i<=max; i++)
			{
				System.out.println("Silnia dla "+i+" = "+silnia(i));
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Blad! To nie jest liczba ca³kowita"); 
		}
		
		
	}

	private static int silnia(int x) {
		if(x == 0) {
			return 1;
		} else {
		int res = 1;
		for (int i = 1; i <= x ; i++)
			res *= i;
		return res;
	}
	
	}
}
