package Lab1;
import java.util.Scanner;
import java.util.ArrayList;

public class nwd2 {

	// Main method
	public static void main(String[] args) {
	
	// Declaring variables
	int a; // user will provide it as a 1st number through scanner
	int b; // user will provide it as a 2nd number through scanner
	int allA = 0; // used in for loop
	int allB = 0; // used in for loop
	
	// Declaring ArrayLists
	ArrayList<Integer> czynnikiPierwszeA = new ArrayList<Integer>();
	ArrayList<Integer> czynnikiPierwszeB = new ArrayList<Integer>();
	ArrayList<Integer> czynnikiWspolne = new ArrayList<Integer>(); // needed to compare other both lists 
	
	// Scanner stuff
	Scanner scanner = new Scanner(System.in);
	System.out.println("Proszê podaæ pierwsz¹ liczbê: ");
	a = scanner.nextInt();
	System.out.println("Proszê podaæ drug¹ liczbê: ");
	b = scanner.nextInt();
	
	int a1 = a; // in order to print it in "Czynniki pierwsze liczby a1...", cos it's then evaluated
	int b1 = b; // in order to print it in "Czynniki pierwsze liczby b1...", cos it's then evaluated
	
	// For loop to find a's prime numbers and add them to czynnikiPierwszeA list
	for (int i = 2; i <= a; i++) {
		while (a % i == 0) {
			czynnikiPierwszeA.add(allA, i);
			allA++;
			a = a / i;
		}
	}
	
	// Print all of a's prime numbers from czynnikiPierwszeA list
	int m = 0;
	System.out.print("Czynniki pierwsze liczby " + a1 + " = ");
	while (m < czynnikiPierwszeA.size()) {
		System.out.print(czynnikiPierwszeA.get(m) + "*");
		m++;
	}
	
	// For loop to find out b's prime numbers and add them to czynnikiPierwszeB list
	for (int i = 2; i <= b; i++) {
		while (b % i == 0) {
			czynnikiPierwszeB.add(allB, i);
			allB++;
			b = b / i;
		}
	}
	
	// Print all of b's prime numbers from czynnikiPierwszeB list
	System.out.println("");
	int k = 0;
	System.out.print("Czynniki pierwsze liczby " + b1 + " = ");
	while (k < czynnikiPierwszeB.size()) {
		System.out.print(czynnikiPierwszeB.get(k) + "*");
		k++;
	}
	
	// Compare both lists - czynnikiPierwszeA and czynnnikiPierwszeB
	int licznikWspolnych = 0;
	int indexA = 0;
	int indexB = 0;
	
	while (indexA < czynnikiPierwszeA.size() && indexB < czynnikiPierwszeB.size()) {
		if (czynnikiPierwszeA.get(indexA) == czynnikiPierwszeB.get(indexB)) {
			czynnikiWspolne.add(licznikWspolnych, czynnikiPierwszeA.get(indexA));
			indexA++;
			indexB++;
			licznikWspolnych++;
		} else {
			if (czynnikiPierwszeA.get(indexA) < czynnikiPierwszeB.get(indexB))
				indexA++;
			else 
				indexB++;
		}
	}
	
	// Collect and print "Najwiêkszy wspólny dzielnik obu liczb"
	System.out.println("");
	System.out.print("Najwiêkszy wspólny dzielnik liczby " + a1 + " i " + b1 + " = ");
	int p = 0;
	while (p < czynnikiWspolne.size()) {
		System.out.print(czynnikiWspolne.get(p) + "*");
		p++;
	}
	
	scanner.close();
}
}
