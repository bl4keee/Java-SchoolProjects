import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ramka extends JFrame implements ActionListener {
	
	// Deklaracje
	public ArrayList<Dokument> dokumenty;
	public ArrayList<JTextField> polaTekstoweTytuly;
	public ArrayList<JTextField> polaTekstoweTresci;
	public JPanel mojPanel;
	public ArrayList<JButton> przyciski;
	public JButton przyciskDodaj;
	public ArrayList<JButton> przyciskiZmien;
	public JButton zapisz;
	public JButton odczytaj;
	
	// Konstruktor
	public Ramka(ArrayList<Dokument> listadokumentow) {
		dokumenty = listadokumentow;
		mojPanel = new JPanel();
		this.add(mojPanel);
		WypelnijPanel();
	}
	
	// Metoda WypelnijPanel
	public void WypelnijPanel() { 
		mojPanel.removeAll();
		GridLayout mojGrid = new GridLayout(dokumenty.size()+1, 4);
		mojPanel.setLayout(mojGrid);
		polaTekstoweTytuly = new ArrayList<JTextField>();
		polaTekstoweTresci = new ArrayList<JTextField>();
		przyciski = new ArrayList<JButton>();
		przyciskiZmien = new ArrayList<JButton>();
		
		// Pêtla for
		for (int i = 0; i < dokumenty.size(); i++) {
			JTextField jtf1 = new JTextField();
			mojPanel.add(jtf1);
			jtf1.setText(dokumenty.get(i).getTytul());
			polaTekstoweTytuly.add(jtf1);
			
			JTextField jtf2 = new JTextField();
			mojPanel.add(jtf2);
			jtf2.setText(dokumenty.get(i).getTresc());
			polaTekstoweTresci.add(jtf2);
			
			// Tworzenie przycisków "Usuñ" obok wyœwietlanych dokumentów
			JButton przycisk = new JButton("Usuñ");
			przyciski.add(przycisk);
			mojPanel.add(przycisk);
			przycisk.addActionListener(this);
			
			// Tworzenie przycisków "Zmieñ" obok wyœwietlanych dokumentów
			JButton przycisk2 = new JButton("Zmieñ");
			przyciskiZmien.add(przycisk2);
			mojPanel.add(przycisk2);
			przycisk2.addActionListener(this);
		}
		
		// Przycisk "Dodaj" - onclick promptuje z pytaniem o tytu³, nastêpnie o treœæ
		przyciskDodaj = new JButton("Dodaj nowy");
		mojPanel.add(przyciskDodaj);
		przyciskDodaj.addActionListener(this);
		pack();
		
		// Przycisk "Zapisz" 
		zapisz = new JButton("Zapisz");
		mojPanel.add(zapisz);
		zapisz.addActionListener(this);
		
		// Przycisk "Odczytaj"
		odczytaj = new JButton("Odczytaj");
		mojPanel.add(odczytaj);
		odczytaj.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		
		// Pêtla for usuwaj¹ca dokumenty
		for (int i = 0; i < przyciski.size(); i++) {
			if (zrodlo == przyciski.get(i)) {
				dokumenty.remove(i);
				break;
			}
		}
		
		// Pêtla for zmieniaj¹ca dokumenty
		for (int i = 0; i < przyciskiZmien.size(); i++ ) {
			
			if (zrodlo == przyciskiZmien.get(i)) {
				String tytul = JOptionPane.showInputDialog(null, "Nazwa dokumentu",
						 "Nowy dokument", JOptionPane.OK_CANCEL_OPTION);
				String tresc = JOptionPane.showInputDialog(null, "Treœæ dokumentu",
						 "Nowy dokument", JOptionPane.OK_CANCEL_OPTION);
				
				dokumenty.get(i).setTytul(tytul);
				dokumenty.get(i).setTresc(tresc);
			}
		}
		
		// Je¿eli user kliknie "Dodaj"
		if (zrodlo == przyciskDodaj) {
			String tytul = JOptionPane.showInputDialog(null, "Nazwa dokumentu",
					 "Nowy dokument", JOptionPane.OK_CANCEL_OPTION);
			String tresc = JOptionPane.showInputDialog(null, "Treœæ dokumentu",
					 "Nowy dokument", JOptionPane.OK_CANCEL_OPTION);
			
			Dokument nowyDokument = new Dokument(tytul, tresc);
			dokumenty.add(nowyDokument);
			
			// Je¿eli user nie wype³ni pola tytu³ albo pola treœæ
			if (tytul == null || tresc == null) {
				dokumenty.remove(nowyDokument);
			}
		}
		
		// Je¿eli user kliknie "Zapisz"
		if (zrodlo == zapisz) {
			try {
				save(dokumenty);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// Je¿eli user kliknie "Odczytaj"
		if (zrodlo == odczytaj) {
			try {
				load(dokumenty);
			} catch (FileNotFoundException e2) {
				JOptionPane.showMessageDialog(null, "Plik nie istnieje!");
			} catch (IOException e3) {
				JOptionPane.showMessageDialog(null, "Plik istnieje, ale wyst¹pi³ b³¹d...");
			}
		}
		
		// Refreshes the panel
		WypelnijPanel();
	}

	// Zapis do pliku tekstowego
	private static void save(ArrayList <Dokument> listadokumentow) throws IOException {
		File file = new File("dokumenty.txt");
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		for (int i=0; i < listadokumentow.size(); i++)
		{
			bwriter.write("Dokument\n");
			bwriter.write(listadokumentow.get(i).getTytul()+"\n");
			bwriter.write(listadokumentow.get(i).getTresc()+"\n");
		}
		bwriter.close();
		JOptionPane.showMessageDialog(null, "Dokumenty zosta³y zapisane do pliku!");
	}
	
	// Odczyt z pliku tekstowego
	private static void load(ArrayList <Dokument> lista) throws IOException{
		File file = new File("dokumenty.txt");
		FileReader freader = new FileReader(file);
		BufferedReader breader = new BufferedReader(freader);
		lista.clear();
		String line;
		while ((line = breader.readLine()) != null) {
			if (line.equals("Dokument")) {
				String tytul = breader.readLine();
				String tresc = breader.readLine();
				Dokument mojDokumentTekstowy = new Dokument(tytul, tresc);
				lista.add(mojDokumentTekstowy);
			}
		}
		breader.close();
		JOptionPane.showMessageDialog(null, "Dokumenty zosta³y wczytane z pliku!");
	}
}

