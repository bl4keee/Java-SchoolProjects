public class Kategoria {
	String nazwa;
	Produkt[] lista_produktow;
	int ile_produktow;
	public Kategoria(String n) {
		nazwa = n;
		lista_produktow = new Produkt[5];
		ile_produktow = 0;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void dodajProdukt(Produkt p) {
		if(p== null) {
			System.err.println(nazwa + ": Nie mo¿na dodaæ produktu o pustej nazwie");
			return;
		}
		if (ile_produktow >= lista_produktow.length) {
			System.err.println(nazwa + ": Nie mozna dodac wiecej produktów");
			return;
		}
		lista_produktow[ile_produktow++] = p;
	}
	
	public void wyswietlProdukty() {
		if(ile_produktow == 0) {
			System.out.println(nazwa + ": Brak produktów na liscie");
			return;
		}
		System.out.println(nazwa + " - lista produktów:");
		
		for(int i = 0; i < ile_produktow; i++) {
			System.out.println(i+1 + ". " + lista_produktow[i].toString());
		}
	}
	public Produkt produkt(int nr_produktu) {
		if (nr_produktu < 0 || nr_produktu > ile_produktow) {
			System.err.println(nazwa + ": Nie ma takiego produktu na liscie");
			return null;
		}
		return lista_produktow[nr_produktu-1];
	}
	
	public Produkt usunProdukt(int nr_produktu) {
		if (nr_produktu < 0 || nr_produktu > nr_produktu) {
			System.err.println(nazwa + ": Nie ma takiego produktu na liscie");
			return null;
		}
		Produkt produkt = lista_produktow[nr_produktu-1];
		lista_produktow[nr_produktu-1] = null;
		ile_produktow--;
		for(int i = nr_produktu-1; i < ile_produktow; i++) {
			lista_produktow[i] = lista_produktow[i+1];
		}
		return produkt;
	}
	
}