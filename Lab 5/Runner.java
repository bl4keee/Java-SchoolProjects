import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		
		// Deklaracje
		ArrayList<Dokument> listadokumentow = new ArrayList<Dokument>();
		
		// Obiekty klasy Dokument
		Dokument dok1 = new Dokument("Tytu� 1", "Tre�� 1");
		Dokument dok2 = new Dokument("Tytu� 2", "Tre�� 2");
		Dokument dok3 = new Dokument("Tytu� 3", "Tre�� 3");
		
		listadokumentow.add(dok1);
		listadokumentow.add(dok2);
		listadokumentow.add(dok3);
		
		// Przypisanie listy dokument�w do mojej ramki
		Ramka mojaRamka = new Ramka(listadokumentow);
		mojaRamka.setVisible(true);
}
}