import java.util.Arrays;
public class Kategoria {

//------------ DEKLARACJA -----------------//
	
	String nazwa;
	Ubranie[] lista_ubran;
	int ile_ubran;

//--------------------- METODY ---------------------------//
	
	public Kategoria(String n) {
		nazwa = n;
		lista_ubran = new Ubranie[10];
		ile_ubran = 0;
}
	public String getNazwa() {
		return nazwa;
}
	public void dodajUbranie(Ubranie u) {
		if (u == null){
			System.err.println(nazwa+ ": Nie mo¿na dodaæ ubrania o pustej nazwie");
			return;
		}
		if (ile_ubran >= lista_ubran.length) {
			System.err.println(nazwa+ ": Nie mo¿na dodaæ wiêcej ubrañ");
			return;
		}
		lista_ubran[ile_ubran++] = u; 
}
	public void wyswietlUbrania() {
		if (ile_ubran==0){
			System.out.println(nazwa+ ": Brak ubrañ na liscie");
			return;	
		}
		System.out.println(nazwa +" - lista ubrañ:");
		for (int i = 0; i< ile_ubran; i++) {
		System.out.println(i + 1 + " . "+lista_ubran[i].toString());
		}
	}
	public Ubranie ubranie(int nr_ubrania) {
		if (nr_ubrania < 0 || nr_ubrania > ile_ubran){
			System.err.println(nazwa+ ": Nie ma takiego ubrania na liscie");
			return null;
		}
		return lista_ubran[nr_ubrania -1]; 
}
	public Ubranie usunUbranie(int nr_ubrania) {
		if (nr_ubrania < 0 || nr_ubrania > ile_ubran){
			System.err.println(nazwa+ ": Nie ma takiego ubrania na liscie");
			return null;
		}
		Ubranie ubranie = lista_ubran[nr_ubrania-1];
		lista_ubran[nr_ubrania-1] = null;
		ile_ubran--;
		for (int i = nr_ubrania-1; i<ile_ubran; i++) {
			lista_ubran[i] = lista_ubran[i+1];
			
		}
		return ubranie;
		
}
	public void posortujUbrania() {
		Arrays.sort(lista_ubran, 0, ile_ubran);;
	}
	}



