package Lab1;
import java.util.Scanner;
public class nwd {

/*
 Program obliczaj¹cy najwiêkszy wspólny dzielnik z wykorzystaniem
 rekurencyjnej metody "nwd" korzystaj¹cej z algorytmu Euklidesa
 nwd(a,b) = a dla b = 0
 nwd(a,b) = nwd(b, a%b) dla b >= 1
*/
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Obliczê najwiêkszy wspólny dzielnik "
				+ "dwóch liczb. \nPodaj pierwsz¹ liczbê: ");
		
		int first = scanner.nextInt();
		
		System.out.println("Podaj drug¹ liczbê: ");
		
		int second = scanner.nextInt();
		
		System.out.println("Najwiêkszy wspólny dzielnik tych liczb to: " + nwd(first, second));
		
		scanner.close();
	}
	public static int nwd(int first, int second) {
		if(second == 0) {
			return first;
		} else {
			return nwd(second, first % second);
		}
	}
}

