package kolos2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ramk2 extends JFrame implements ActionListener {
	
	// Deklaracje
	public JTextField liczbaRzutowInput;
	public JTextField liczbaRzutowTxt;
	public JTextField liczbaScianKostkiInput;
	public JTextField liczbaScianKostkiTxt;
	public JTextField wyswietlWynik; // odsetek rzutów, w których wypad³a "1"
	public JButton startSymulacji;

	// Konstruktor
	public Ramk2() {
		
		// JPanel
		JPanel mojPanel = new JPanel();
		this.add(mojPanel);
		
		// Grid
		GridLayout mojGrid = new GridLayout(3, 2);
		mojPanel.setLayout(mojGrid);
		
		// Buttons and stuff
		liczbaRzutowInput = new JTextField();
		
		liczbaRzutowTxt = new JTextField("Liczba rzutów:");
		
		liczbaScianKostkiInput = new JTextField();
		
		liczbaScianKostkiTxt = new JTextField("Liczba œcian:");
		
		startSymulacji = new JButton("Start symulacji");
		startSymulacji.addActionListener(this);
		
		wyswietlWynik = new JTextField();
		
		// Setting editability 
		liczbaRzutowTxt.setEditable(false);
		liczbaScianKostkiTxt.setEditable(false);
		
		// Adding everything to the panel
		mojPanel.add(liczbaRzutowTxt);
		mojPanel.add(liczbaRzutowInput);
		mojPanel.add(liczbaScianKostkiTxt);
		mojPanel.add(liczbaScianKostkiInput);
		mojPanel.add(startSymulacji);
		mojPanel.add(wyswietlWynik);
		
		// pack
		this.pack();
	}

	// Metoda losuj¹ca
	public double losuj(int liczbaLosowan, int liczbaScian) {
		
		double otrzymaneJedynki = 0;
		double odsetekJedynek = 0;
		double wylosowanaLiczba;
		Random rand = new Random();
		
		for (int i = 0; i < liczbaLosowan; i ++) {
			wylosowanaLiczba = rand.nextInt(liczbaScian)+1;
			if (wylosowanaLiczba == 1) {
				otrzymaneJedynki++;
			}
		}
		
		odsetekJedynek = (liczbaLosowan / otrzymaneJedynki) * 100;
		return odsetekJedynek;
		
	}
	
	
	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object zrodlo = new Object();
		zrodlo = e.getSource();
		if (zrodlo == startSymulacji) {
			try {
				String liczbaRzutow;
				String liczbaScian;
				
				liczbaRzutow = liczbaRzutowInput.getText();
				liczbaScian = liczbaScianKostkiInput.getText();
				
				int liczbaRzutowInt = Integer.parseInt(liczbaRzutow);
				int liczbaScianInt = Integer.parseInt(liczbaScian);
				
				if (liczbaRzutowInt <= 0) {
					JOptionPane.showMessageDialog(null, "Liczba Rzutów musi byæ wiêksza od zera!");
				} 
				
				if (liczbaScianInt <= 0) {
					JOptionPane.showMessageDialog(null, "liczba Œcian musi byæ wiêksza od zera!");
				} else {
					double odsetekJedynek = losuj(liczbaRzutowInt, liczbaScianInt);
					String wynik = Double.toString(odsetekJedynek);
					wyswietlWynik.setText(wynik);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}
}
