package Lab1;
import java.util.Scanner;
public class nwd {

/*
 Program obliczaj�cy najwi�kszy wsp�lny dzielnik z wykorzystaniem
 rekurencyjnej metody "nwd" korzystaj�cej z algorytmu Euklidesa
 nwd(a,b) = a dla b = 0
 nwd(a,b) = nwd(b, a%b) dla b >= 1
*/
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Oblicz� najwi�kszy wsp�lny dzielnik "
				+ "dw�ch liczb. \nPodaj pierwsz� liczb�: ");
		
		int first = scanner.nextInt();
		
		System.out.println("Podaj drug� liczb�: ");
		
		int second = scanner.nextInt();
		
		System.out.println("Najwi�kszy wsp�lny dzielnik tych liczb to: " + nwd(first, second));
		
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

