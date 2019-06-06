import java.util.Scanner;

public class Konfiguratorpizzy {
	private Kategoria rodzajciasta;
	private Kategoria sos;
	private Kategoria dodatkiwarz;
	private Kategoria dodatkimies;
	private Scanner sc;
	
	public Konfiguratorpizzy() {
		rodzajciasta = new Kategoria("Rodzaj ciasta");
		sos = new Kategoria("Sos");
		dodatkiwarz = new Kategoria("Dodatki warzywne");
		dodatkimies = new Kategoria("Dodatki miêsne");
		
		sc = new Scanner(System.in);
		init();
	}
	private void init() {		
		rodzajciasta.dodajSkladnik(new Skladnik("Pszenne"));
		rodzajciasta.dodajSkladnik(new Skladnik("Kukurydziane"));
			
		sos.dodajSkladnik(new Skladnik("Pomidorowy"));
		sos.dodajSkladnik(new Skladnik("Œmietanowy"));
				
		dodatkiwarz.dodajSkladnik(new Skladnik("Pieczarki"));
		dodatkiwarz.dodajSkladnik(new Skladnik("Kapary"));
		dodatkiwarz.dodajSkladnik(new Skladnik("Karczochy"));
		dodatkiwarz.dodajSkladnik(new Skladnik("Papryka"));
		dodatkiwarz.dodajSkladnik(new Skladnik("Pomidor"));
		
		dodatkimies.dodajSkladnik(new Skladnik("Salami"));
		dodatkimies.dodajSkladnik(new Skladnik("Szynka Parmeñska"));
		dodatkimies.dodajSkladnik(new Skladnik("Boczek"));
		dodatkimies.dodajSkladnik(new Skladnik("Kurczak"));

	}
	
	public void wlacz(){
		Kategoria k;
		while(true) {
			System.out.println("Co chcesz zrobiæ? Wybierz opcje: ");
			System.out.println("\t(1) wyœwietliæ sk³adniki");
			System.out.println("\t(2) dodac nowy sk³adnik");
			System.out.println("\t(3) usun¹æ sk³adnik");
			System.out.println("\t(4) skomponowaæ pizzê");
			System.out.println("\t(5) zrezygnowaæ z pizzy");
			System.out.print("? ");
			byte o = sc.nextByte(); sc.nextLine();
			switch (o) {
				case 1: 
					k = wybierzKategorie();
					if(k!=null) {
						k.wyswietlSkladniki();
					}
					break;
				case 2:
					k = wybierzKategorie();
					if(k!=null) {
						System.out.print("Podaj nazwê sk³adnika");
						String nazwa = sc.nextLine();				
						k.dodajSkladnik(new Skladnik(nazwa));
						k.wyswietlSkladniki();
					}
					break;
				case 3:

					 k = wybierzKategorie();
					if(k!=null) {
						k.wyswietlSkladniki();
						
						System.out.print("Ktory sk³adnik usuwasz? ");
						byte nr_skladnika= sc.nextByte();
						k.usunSkladnik(nr_skladnika);
					}
					break;
				case 4:
					System.out.print("Wybierz ciasto do pizzy");
					rodzajciasta.wyswietlSkladniki();
					byte ou = sc.nextByte();
					
					System.out.print("Wybierz sos do pizzy");
					sos.wyswietlSkladniki();
					byte oo = sc.nextByte();
					
					System.out.print("Wybierz pierwszy sk³adnik");
					dodatkiwarz.wyswietlSkladniki();
					byte op = sc.nextByte();
					
					System.out.print("Wybierz drugi sk³adnik");
					dodatkimies.wyswietlSkladniki();
					byte oi = sc.nextByte();
					
					System.out.println("Twoja pizza ma ciasto: "+rodzajciasta.dodajDoPizzy(ou) +", sos do pizzy " +sos.dodajDoPizzy(oo)+", oraz "+dodatkiwarz.dodajDoPizzy(op)+" i "+dodatkimies.dodajDoPizzy(oi));
					
					
					break;
				
				case 5:
					return;
				default:
					System.err.println("Nie rozpoznajê opcji!");
			}
		}
	}

	
	private Kategoria wybierzKategorie() {
		Kategoria k=null;
		System.out.println("Której kategorii u¿yæ? Wybierz opcjê: ");
		System.out.println("\t(1)"+rodzajciasta.getNazwa());
		System.out.println("\t(2)"+sos.getNazwa());
		System.out.println("\t(3)"+dodatkiwarz.getNazwa());
		System.out.println("\t(4)"+dodatkimies.getNazwa());
		System.out.println("? ");
		byte nr_p = sc.nextByte(); sc.nextLine();
		switch(nr_p) {
			case 1: 
				k=rodzajciasta;
				break;
			case 2:
				k=sos;
				break;
			case 3:
				k=dodatkiwarz;
				break;
			case 4:
				k=dodatkimies;
				break;
			default:
				System.err.println("Nie ma takiej kategorii!");
		}
		return k;
	}
	
	public static void main(String[] args) {
		Konfiguratorpizzy o = new Konfiguratorpizzy();
		o.wlacz();
		System.out.println(" --- KONIEC ---");
	}

}