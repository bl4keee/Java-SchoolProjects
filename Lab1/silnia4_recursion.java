package Lab1;

import java.util.Scanner;

public class silnia4_recursion {
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
				System.out.println("Silnia dla "+i+" = "+silnia4(i));
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Blad! To nie jest liczba ca³kowita"); 
		}
		
		
	}

public static long silnia4(int x) {
	if( x == 0 ) {
		return 1;
	} else {
	if( x <= 2 ) {
		return x;
	}
	return x * silnia4(x - 1);
}
}
}