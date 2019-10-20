package Lab1;
import java.util.Scanner;

public class fibonacci_recursion {
	public static void main (String args[]) {
		int max=0;
		System.out.println("Podaj, do której liczby chcesz obliczyæ ci¹g fibonacciego: ");
		Scanner sc = new Scanner(System.in);
		max = sc.nextInt(); 
		sc.close();
		try {
			
			for (int i=0; i<=max; i++)
			{
				System.out.println("Fibonacci dla "+i+" = "+fibonacci(i));
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Blad! To nie jest liczba ca³kowita"); 
		}
	}
	public static int fibonacci(int number) {
		if(number == 0)
			return 0;
		else if(number == 1)
			return 1;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
}
}
