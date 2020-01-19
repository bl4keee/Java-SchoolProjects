package sortowanie;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ramka extends JFrame implements ActionListener {

	
	// Deklaracje
	public JTextField pierwszaLiczbaTxt, drugaLiczbaTxt, trzeciaLiczbaTxt; // for user information
	public JTextField pierwszaLiczbaUser, drugaLiczbaUser, trzeciaLiczbaUser; // for user input 
	public JButton sortuj;
	
	// Konstruktor
	public Ramka() {
		
		// Panel
		Panel mojPanel = new Panel();
		this.add(mojPanel);
		
		// Grid
		GridLayout mojGrid = new GridLayout(4, 2);
		mojPanel.setLayout(mojGrid);
		
		// Text fields and buttons
		pierwszaLiczbaTxt = new JTextField("Pierwsza liczba:");
		mojPanel.add(pierwszaLiczbaTxt);
		
		pierwszaLiczbaUser = new JTextField();
		mojPanel.add(pierwszaLiczbaUser);
		
		drugaLiczbaTxt = new JTextField("Druga liczba:");
		mojPanel.add(drugaLiczbaTxt);
		
		drugaLiczbaUser = new JTextField();
		mojPanel.add(drugaLiczbaUser);
		
		trzeciaLiczbaTxt = new JTextField("Trzecia liczba:");
		mojPanel.add(trzeciaLiczbaTxt);
		
		trzeciaLiczbaUser = new JTextField();
		mojPanel.add(trzeciaLiczbaUser);
		
		sortuj = new JButton("Sortuj");
		mojPanel.add(sortuj);
		sortuj.addActionListener(this);
		
		// Setting fields non editable
		pierwszaLiczbaTxt.setEditable(false);
		drugaLiczbaTxt.setEditable(false);
		trzeciaLiczbaTxt.setEditable(false);
		
		
		// Pack
		pack();
	}
	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = new Object();
		zrodlo = e.getSource();
		if (zrodlo == sortuj) {
			try {
				
				// Get user input
				String pierwszaLiczbaStr = pierwszaLiczbaUser.getText();
				String drugaLiczbaStr = drugaLiczbaUser.getText();
				String trzeciaLiczbaStr = trzeciaLiczbaUser.getText();
				
				// Parse user input from String to Int
				int pierwszaLiczbaInt = Integer.parseInt(pierwszaLiczbaStr);
				int drugaLiczbaInt = Integer.parseInt(drugaLiczbaStr);
				int trzeciaLiczbaInt = Integer.parseInt(trzeciaLiczbaStr);
				
				// Create array
				int[] liczby = {pierwszaLiczbaInt, drugaLiczbaInt, trzeciaLiczbaInt};
				Arrays.sort(liczby);
				pierwszaLiczbaUser.setText(String.valueOf(liczby[0]));
				drugaLiczbaUser.setText(String.valueOf(liczby[1]));
				trzeciaLiczbaUser.setText(String.valueOf(liczby[2]));
				
			} catch(Exception e2) {
			JOptionPane.showMessageDialog(null, "Wype³nij wszystkie komórki!");
		}
		
	}
}
}