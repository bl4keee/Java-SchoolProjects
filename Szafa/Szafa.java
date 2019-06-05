import java.util.Scanner;
public class Szafa {
	
//----------------- DEKLARACJA ZMIENNYCH -------------------------//
	
	private Kategoria tshirtyikoszule;
	private Kategoria spodnie;
	private Kategoria bielizna;
	private Kategoria skarpetki;
	private Scanner sc;
	
	public Szafa() {
		tshirtyikoszule = new Kategoria("T-shirty i koszule");
		spodnie = new Kategoria("Spodnie");
		bielizna = new Kategoria("Bielizna");
		skarpetki = new Kategoria("Skarpetki");

		
//---------------------- SCANNER -----------------------------//
		
		sc = new Scanner(System.in);
		init();
	}
	private void init(){
	//Kategoria tshirtyikoszule = new Kategoria("T-shirty i koszule");
	//Kategoria spodnie = new Kategoria("Spodnie");
	//Kategoria bielizna = new Kategoria("Bielizna");
	//Kategoria skarpetki = new Kategoria("Skarpetki");

//---------------- DODAWANIE UBRAÑ DO KATEGORII --------------//	
	
	tshirtyikoszule.dodajUbranie(new Ubranie("Bluzka 1"));
	tshirtyikoszule.dodajUbranie(new Ubranie("Bluzka 2"));
	tshirtyikoszule.dodajUbranie(new Ubranie("Bluzka 3"));
	tshirtyikoszule.dodajUbranie(new Ubranie("Bluzka 4"));
	
	spodnie.dodajUbranie(new Ubranie("Spodnie 1"));
	spodnie.dodajUbranie(new Ubranie("Spodnie 2"));
	spodnie.dodajUbranie(new Ubranie("Spodnie 3"));
	spodnie.dodajUbranie(new Ubranie("Spodnie 4"));
	
	bielizna.dodajUbranie(new Ubranie("Bielizna 1"));
	bielizna.dodajUbranie(new Ubranie("Bielizna 2"));
	bielizna.dodajUbranie(new Ubranie("Bielizna 3"));
	bielizna.dodajUbranie(new Ubranie("Bielizna 4"));
	
	skarpetki.dodajUbranie(new Ubranie("Skarpetki 1"));
	skarpetki.dodajUbranie(new Ubranie("Skarpetki 2"));
	skarpetki.dodajUbranie(new Ubranie("Skarpetki 3"));
	skarpetki.dodajUbranie(new Ubranie("Skarpetki 4"));
}
	
//------------------------ PIERWSZA INTERAKCJA Z U¯YTKOWNIKIEM --------------------------------------//
	
	public void wlacz() 
	{
		Kategoria p;
		while (true) {
			System.out.println("Co chcesz zrobiæ? Wybierz opcjê:");
			System.out.println("\t(1) wyœwietliæ zawartoœæ szafy");
			System.out.println("\t(2) dodac nowe ubranie");
			System.out.println("\t(3) wyrzuciæ ubranie");
			System.out.println("\t(5) skomponowaæ strój");
			System.out.println("\t(9) zamkn¹æ szafê");
			
			byte o = sc.nextByte(); sc.nextLine();
			switch (o) {
			case 1 : //wyœwietla zawartoœæ szafy
				p = wybierzKategorie();
				if (p!=null) {
					p.wyswietlUbrania();
				}
			
				break;
			case 2 : //dodaje nowe ubrania
				p = wybierzKategorie();
				if (p!=null) { 
					System.out.print("Podaj nazwê ubrania");
					String nazwaUbrania = sc.nextLine();
					p.dodajUbranie(new Ubranie(nazwaUbrania));
					p.wyswietlUbrania();
				}
				break;
			case 3 : //wyrzuca ubrania
				p = wybierzKategorie();
				if (p!=null) {
					p.wyswietlUbrania(); 
					System.out.print("Które ubranie wyrzuciæ?");
					byte nr_ubrania = sc.nextByte();
					p.usunUbranie(nr_ubrania);
					
				
					}
					break;
			case 9 : //zamyka szafê
				return;
			default :
				System.err.println("Nie rozpoznajê opcji");
		
}
		}
	}
	
//--------------------------- DRUGA INTERAKCJA Z U¯YTKOWNIKIEM -----------------//
	
	private Kategoria wybierzKategorie() {
		Kategoria p = null;
		System.out.println("Któr¹ kategoriê otworzyæ? wybierz opcjê:");
		System.out.println("\t(1) "+ tshirtyikoszule.getNazwa());
		System.out.println("\t(2) "+ spodnie.getNazwa());
		System.out.println("\t(3) "+ bielizna.getNazwa());
		System.out.println("\t(4) "+ skarpetki.getNazwa());
		System.out.print("?");
		byte nr_p = sc.nextByte(); sc.nextLine();
		switch (nr_p) {
		case 1 :
			p = tshirtyikoszule;
			break;
		case 2 :
			p = spodnie;
			break;
		case 3 :
			p = bielizna;
			break;
		case 4 :
			p = skarpetki;
			break;
		default :
			System.err.println("Nie ma takiej kategorii!");
		}
		return p;
		
	}
	public static void main(String[] args) {
		Szafa o = new Szafa();
		o.wlacz();
		System.out.println("---KONIEC---");
}
}
