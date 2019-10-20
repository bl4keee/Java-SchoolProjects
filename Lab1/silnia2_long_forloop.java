package Lab1;

import java.util.Scanner;

public class silnia2_long_forloop {
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
				System.out.println("Silnia dla "+i+" = "+silnia2(i));
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Blad! To nie jest liczba ca³kowita"); 
		}
		
		
	}


public static long silnia2(int x) {
	long res = 1;
	for(int i = 2; i <= x ; i++) {
		res *= i;
	}
	return res;
}
}