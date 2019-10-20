package Lab1;
import java.util.Scanner;

public class fibonacci_forloop {
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
		int prevprevNumber = 0; // previous previous number
		int prevNumber = 0; // previous number
		int currentNumber = 1;
		
		for (int i = 1; i < number; i++) {
			prevprevNumber = prevNumber;
			prevNumber = currentNumber;
			currentNumber = prevprevNumber + prevNumber;
		}
		return currentNumber;
	}
}
