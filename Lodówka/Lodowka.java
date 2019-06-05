import java.util.Scanner;

public class Lodowka {
	private Kategoria mieso;
	private Kategoria nabial;
	private Kategoria warzywka;
	private Scanner sc;
	
	public Lodowka() {
		mieso = new Kategoria("Miêso");
		nabial = new Kategoria("Nabia³");
		warzywka = new Kategoria("Warzywa");
		
		sc = new Scanner(System.in);
		init();
	}
	private void init() {		
		mieso.dodajProdukt(new Produkt("Szynka",3.5,1));
		mieso.dodajProdukt(new Produkt("Kie³basa",2,2));
		mieso.dodajProdukt(new Produkt("Stek",3.4,2));
		mieso.dodajProdukt(new Produkt("Kurczak",2,3));
		mieso.dodajProdukt(new Produkt("Schabowy",4.1,1));
		
		nabial.dodajProdukt(new Produkt("Mleko",3.5,1));
		nabial.dodajProdukt(new Produkt("Jajka",2,2));
		nabial.dodajProdukt(new Produkt("Ser",3.4,2));
		nabial.dodajProdukt(new Produkt("Jogurt",2,3));
		nabial.dodajProdukt(new Produkt("Inny ser",4.1,1));
				
		warzywka.dodajProdukt(new Produkt("Pomidorek",3.5,1));
		warzywka.dodajProdukt(new Produkt("Ogóreczek",2,2));
		warzywka.dodajProdukt(new Produkt("Ziemniaczek",3.4,2));
		warzywka.dodajProdukt(new Produkt("Kapustka",2,3));
		warzywka.dodajProdukt(new Produkt("Seler",4.1,1));
	}
	
	public void wlacz(){
		Kategoria k;
		while(true) {
			System.out.println("Co chcesz zrobiæ? Wybierz opcje: ");
			System.out.println("\t(1) otworzyæ lodówke");
			System.out.println("\t(2) dodac nowy produkt");
			System.out.println("\t(3) usun¹æ produkt");
			System.out.println("\t(9) zamkn¹æ lodówkê");
			System.out.print("? ");
			byte o = sc.nextByte(); sc.nextLine();
			switch (o) {
				case 1: 
					k = wybierzKategorie();
					if(k!=null) {
						k.wyswietlProdukty();
					}
					break;
				case 2:
					k = wybierzKategorie();
					if(k!=null) {
						System.out.print("Podaj nazwe produktu");
						String nazwa = sc.nextLine();
						System.out.print("Podaj iloœæ produktu");
						double ilosc = sc.nextDouble();
						int ileMaDni = 0;				
						k.dodajProdukt(new Produkt(nazwa, ilosc, ileMaDni));
						k.wyswietlProdukty();
					}
					break;
				case 3:

					 k = wybierzKategorie();
					if(k!=null) {
						k.wyswietlProdukty();
						
						System.out.print("Ktory produkt usuwasz? ");
						byte nr_produktu= sc.nextByte();
						k.usunProdukt(nr_produktu);
					}
					break;
				case 9:
					return;
				default:
					System.err.println("Nie rozpoznajê opcji!");
			}
		}
	}
	
	private Kategoria wybierzKategorie() {
		Kategoria k=null;
		System.out.println("Której kategorii u¿yæ? Wybierz opcjê: ");
		System.out.println("\t(1)"+mieso.getNazwa());
		System.out.println("\t(2)"+nabial.getNazwa());
		System.out.println("\t(3)"+warzywka.getNazwa());
		System.out.println("? ");
		byte nr_p = sc.nextByte(); sc.nextLine();
		switch(nr_p) {
			case 1: 
				k=mieso;
				break;
			case 2:
				k=nabial;
				break;
			case 3:
				k=warzywka;
				break;
			default:
				System.err.println("Nie ma takiej kategorii!");
		}
		return k;
	}
	
	public static void main(String[] args) {
		Lodowka o = new Lodowka();
		o.wlacz();
		System.out.println(" --- KONIEC ---");
	}

}