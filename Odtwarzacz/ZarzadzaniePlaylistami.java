import java.util.Scanner;

public class ZarzadzaniePlaylistami {


		// TODO Auto-generated method stub
		//Playlista pop = new Playlista("Pop");
		//Playlista rock = new Playlista("Rock");

		private Playlista p1;
		private Playlista p2;
		private Scanner sc;
		

		
		public ZarzadzaniePlaylistami() {
			p1 = new Playlista("Pop");
			p2 = new Playlista("Rock");
			
			sc = new Scanner(System.in);
			init();
		}
		
		
		private void init() {		
			p1.dodajUtwor(new Utwor("Toxic","Britney Spears",2003));
			p1.dodajUtwor(new Utwor("Shake It Off","Taylor Swift",2014));
			p1.dodajUtwor(new Utwor("Barbie Girl","Aqua",1997));
			p1.dodajUtwor(new Utwor("Every Night","Madonna",2005));
			p1.dodajUtwor(new Utwor("Baby","Justin Bieber",2010));
			p1.dodajUtwor(new Utwor("Like a Virgin","Madonna",1984));
			p1.dodajUtwor(new Utwor("Waka Waka","Shakira",2010));
			p1.dodajUtwor(new Utwor("Take on Me","Aha",1985));
			
			p2.dodajUtwor(new Utwor("Highway to Hell","ACDC",1979));
			p2.dodajUtwor(new Utwor("Smells Like a Teen Spirit","Nirvana",1991));
			p2.dodajUtwor(new Utwor("Piece of My Heart","Jenice Joplin",1967));
			p2.dodajUtwor(new Utwor("Nothing Else Matters","Metallica",1991));
			p2.dodajUtwor(new Utwor("Keine Lust","Ramstein",1975));
			p2.dodajUtwor(new Utwor("TNT","ACDC",1975));
			p2.dodajUtwor(new Utwor("Bohemian Rhapsody","Queen",1975));
			
		}
			public void wlacz(){
				Playlista p;
				while(true) {
					System.out.println("Co chcesz zrobiæ? Wybierz opcje: ");
					System.out.println("\t(1) wyswietlic playliste");
					System.out.println("\t(2) dodac nowy utwor");
					System.out.println("\t(3) przeniesc utwor");
					System.out.println("\t(4) skopiowac utwor");
					System.out.println("\t(5) skasowac utwor");
					System.out.println("\t(9) wylaczyc odtwarzanie");
					System.out.print("? ");
					byte o = sc.nextByte(); sc.nextLine();
					switch (o) {
						case 1: 
							p = wybierzPlayliste();
							if(p!=null) {
								p.wyswietlUtwory();
							}
							break;
						case 2:
							p = wybierzPlayliste();
							if(p!=null) {
								// zapytaj o dane utworu
								System.out.print("Podaj tytul utworu");
								String tytul = sc.nextLine();
								System.out.print("Podaj wykonawce utworu");
								String wykonawca = sc.nextLine();
								System.out.print("Podaj rok wydania utworu");
								int rok_wydania = sc.nextInt();
								//dodawanie
								p.dodajUtwor(new Utwor(tytul, wykonawca, rok_wydania));
								p.wyswietlUtwory();
							}
							break;
						case 3:

							p = wybierzPlayliste();
							if(p!=null) {
								p.wyswietlUtwory();
								// zapytaj ktory utwor przeniesc
								System.out.print("Ktory utwor przeniesc do drugiej playlisty? ");
								byte nr_utworu= sc.nextByte();
								//przenies utwor
								Utwor u = p.usunUtwor(nr_utworu);
								if(u!=null) {
									Playlista p_do = p.equals(p1) ? p2:p1;
									p_do.dodajUtwor(u);
								}
							}
							break;
						case 4:
							
							p = wybierzPlayliste();
							if(p!=null) {
								p.wyswietlUtwory();
								// zapytaj ktory utwor skopiowaæ
								System.out.print("Ktory utwor skopiowac do drugiej playlisty? ");
								byte nr_utworu= sc.nextByte();
								//skopiuj utwor
								Utwor u = p.utwor(nr_utworu);
								if(u!=null) {
									Playlista p_do = p.equals(p1) ? p2:p1;
									p_do.dodajUtwor(u);
								}
							}
							break;
						case 5:
							
							p = wybierzPlayliste();
							if(p!=null) {
								p.wyswietlUtwory();
								// zapytaj ktory utwor skasowaæ
								System.out.print("Ktory utwor skasowac? ");
								byte nr_utworu= sc.nextByte();
								//usun utwor
								p.usunUtwor(nr_utworu);
							}
							break;
						case 9:
							return;
						default:
							System.err.println("Nie rozpoznajê opcji!");
					}
				}
			}
			
			private Playlista wybierzPlayliste() {
				Playlista p=null;
				System.out.println("Której playlisty u¿yæ? Wybierz opcjê: ");
				System.out.println("\t(1)"+p1.getNazwa());
				System.out.println("\t(2)"+p2.getNazwa());
				System.out.println("? ");
				byte nr_p = sc.nextByte(); sc.nextLine();
				switch(nr_p) {
					case 1: 
						p=p1;
						break;
					case 2:
						p=p2;
						break;
					default:
						System.err.println("Nie ma takiej playlisty!");
				}
				return p;
			}
			
			public static void main(String[] args) {
				ZarzadzaniePlaylistami o = new ZarzadzaniePlaylistami();
				o.wlacz();
				System.out.println(" --- KONIEC ---");
			}
	
}