public class Kategoria {
	String nazwa;
	Skladnik[] lista_skladnikow;
	int ile_skladnikow;
	public Kategoria(String n) {
		nazwa = n;
		lista_skladnikow = new Skladnik[5];
		ile_skladnikow = 0;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void dodajSkladnik(Skladnik p) {
		if(p== null) {
			System.err.println(nazwa + ": Nie mo¿na dodaæ sk³adnika o pustej nazwie");
			return;
		}
		if (ile_skladnikow >= lista_skladnikow.length) {
			System.err.println(nazwa + ": Nie mozna dodac wiecej sk³adników");
			return;
		}
		lista_skladnikow[ile_skladnikow++] = p;
	}
	
	public void wyswietlSkladniki() {
		if(ile_skladnikow == 0) {
			System.out.println(nazwa + ": Brak sk³adników na liscie");
			return;
		}
		System.out.println(nazwa + " - lista sk³adników:");
		
		for(int i = 0; i < ile_skladnikow; i++) {
			System.out.println(i+1 + ". " + lista_skladnikow[i].toString());
		}
	}
	public Skladnik skladnik(int nr_skladnika) {
		if (nr_skladnika < 0 || nr_skladnika > ile_skladnikow) {
			System.err.println(nazwa + ": Nie ma takiego sk³adnika na liscie");
			return null;
		}
		return lista_skladnikow[nr_skladnika-1];
	}
	
	public Skladnik usunSkladnik(int nr_skladnika) {
		if (nr_skladnika < 0 || nr_skladnika > nr_skladnika) {
			System.err.println(nazwa + ": Nie ma takiego sk³adnika na liscie");
			return null;
		}
		Skladnik skladnik = lista_skladnikow[nr_skladnika-1];
		lista_skladnikow[nr_skladnika-1] = null;
		ile_skladnikow--;
		for(int i = nr_skladnika-1; i < ile_skladnikow; i++) {
			lista_skladnikow[i] = lista_skladnikow[i+1];
		}
		return skladnik;
	}
	
	public Skladnik dodajDoPizzy(int nr_skladnika) {
		if(nr_skladnika<0 || nr_skladnika > nr_skladnika) {
			System.err.println(nazwa + ": Nie ma takiego sk³adnika na liœcie");
			return null;
		}
		Skladnik skladnik = lista_skladnikow[nr_skladnika-1];
		return lista_skladnikow[nr_skladnika-1];
	}
	
	}
	
	

	
