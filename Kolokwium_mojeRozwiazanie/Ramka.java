import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 KOLOKWIUM A 
 AUTOR: Bartosz Walczak
 */

public class Ramka extends JFrame implements ActionListener {

	// Deklaracje
	public JTextField godzinaPrzyjsciaUser, minutyPrzyjsciaUser; // for user input "przyj�cie do pracy"
	public JTextField godzinaPrzyjsciaInfo, minutyPrzyjsciaInfo; // for user information (only showcase)
	public JTextField godzinaWyjsciaUser, minutyWyjsciaUser; // for user input "wyj�cie z pracy" 
	public JTextField godzinaWyjsciaInfo, minutyWyjsciaInfo; // for user information (only showcase)
	public JTextField wynikGodzinyInfo, wynikMinutyInfo;
	public JTextField wynikGodzinyFinalny, wynikMinutyFinalny;
	public JTextField puste1, puste2;
	public JButton oblicz; 
	
	// Konstruktor
	public Ramka() {
		
		// Panel
		JPanel mojPanel = new JPanel();
		this.add(mojPanel);
		
		// GridLayout
		GridLayout mojGrid = new GridLayout(7, 2);
		mojPanel.setLayout(mojGrid);
		
		// TextFields and Button
		godzinaPrzyjsciaInfo = new JTextField("Godzina przyj�cia: ");
		mojPanel.add(godzinaPrzyjsciaInfo);
		godzinaPrzyjsciaInfo.setEditable(false);
		
		godzinaPrzyjsciaUser = new JTextField();
		mojPanel.add(godzinaPrzyjsciaUser);
		
		minutyPrzyjsciaInfo = new JTextField("Minuty przyj�cia: ");
		mojPanel.add(minutyPrzyjsciaInfo);
		minutyPrzyjsciaInfo.setEditable(false);
		
		minutyPrzyjsciaUser = new JTextField();
		mojPanel.add(minutyPrzyjsciaUser);
		
		godzinaWyjsciaInfo = new JTextField("Godzina wyj�cia: ");
		mojPanel.add(godzinaWyjsciaInfo);
		godzinaWyjsciaInfo.setEditable(false);
		
		godzinaWyjsciaUser = new JTextField();
		mojPanel.add(godzinaWyjsciaUser);
		
		minutyWyjsciaInfo = new JTextField("Minuty wyj�cia: ");
		mojPanel.add(minutyWyjsciaInfo);
		minutyWyjsciaInfo.setEditable(false);
		
		minutyWyjsciaUser = new JTextField();
		mojPanel.add(minutyWyjsciaUser);
		
		oblicz = new JButton("Oblicz");
		mojPanel.add(oblicz);
		oblicz.addActionListener(this);
		
		puste1 = new JTextField();
		mojPanel.add(puste1);
		puste1.setEditable(false);
		
		wynikGodzinyInfo = new JTextField("Wynik godziny: ");
		mojPanel.add(wynikGodzinyInfo);
		wynikGodzinyInfo.setEditable(false);
		
		wynikGodzinyFinalny = new JTextField();
		mojPanel.add(wynikGodzinyFinalny);
		
		wynikMinutyInfo = new JTextField("Wynik minuty: ");
		mojPanel.add(wynikMinutyInfo);
		wynikMinutyInfo.setEditable(false);
		
		wynikMinutyFinalny = new JTextField();
		mojPanel.add(wynikMinutyFinalny);
		
		// Pack
		pack();
	}

	// ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = new Object();
		zrodlo = e.getSource();
		if (zrodlo == oblicz) {
			try {
			if (godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") == false && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") == false && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") == false && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("") == false
					|| godzinaPrzyjsciaUser.getText().equals("") == false && minutyPrzyjsciaUser.getText().equals("") == false && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") == false && minutyPrzyjsciaUser.getText().equals("") == false && godzinaWyjsciaUser.getText().equals("") == false && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") == false && minutyWyjsciaUser.getText().equals("") == false
					|| godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") == false && godzinaWyjsciaUser.getText().equals("") == false && minutyWyjsciaUser.getText().equals("") == false
					|| godzinaPrzyjsciaUser.getText().equals("") == false && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") == false && minutyWyjsciaUser.getText().equals("")
					|| godzinaPrzyjsciaUser.getText().equals("") == false && minutyPrzyjsciaUser.getText().equals("") && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("") == false
					|| godzinaPrzyjsciaUser.getText().equals("") && minutyPrzyjsciaUser.getText().equals("") == false && godzinaWyjsciaUser.getText().equals("") && minutyWyjsciaUser.getText().equals("") == false
			)      
			{
				JOptionPane.showMessageDialog(null, "Wprowadz dane");
			}
			
			// Getting user input as String
			String godzinaPrzyjsciaUserStr = godzinaPrzyjsciaUser.getText();
			String minutyPrzyjsciaUserStr = minutyPrzyjsciaUser.getText();
			String godzinaWyjsciaUserStr = godzinaWyjsciaUser.getText();
			String minutyWyjsciaUserStr = minutyWyjsciaUser.getText();
			
			// Parsing user input from String to Int
			try {
			int godzinaPrzyjsciaUserInt = Integer.parseInt(String.valueOf(godzinaPrzyjsciaUserStr));
			int minutyPrzyjsciaUserInt = Integer.parseInt(String.valueOf(minutyPrzyjsciaUserStr));
			int godzinaWyjsciaUserInt = Integer.parseInt(String.valueOf(godzinaWyjsciaUserStr));
			int minutyWyjsciaUserInt = Integer.parseInt(String.valueOf(minutyWyjsciaUserStr));
			
			if ((godzinaPrzyjsciaUserInt > 24 || godzinaPrzyjsciaUserInt < 0) || (minutyPrzyjsciaUserInt > 60 || minutyPrzyjsciaUserInt < 0) || (godzinaWyjsciaUserInt > 24 || godzinaWyjsciaUserInt < 0) || (minutyWyjsciaUserInt > 60 || minutyWyjsciaUserInt < 0)) {
				JOptionPane.showMessageDialog(null, "Wprowadz poprawny czas");
				wynikGodzinyFinalny.setText("");
				wynikMinutyFinalny.setText("");
			} else {
			
			// godzinyPracy 
			if (godzinaPrzyjsciaUserInt > 0 || godzinaPrzyjsciaUserInt < 24 || godzinaWyjsciaUserInt > 0 || godzinaWyjsciaUserInt < 24) {
				if (godzinaPrzyjsciaUserInt > godzinaWyjsciaUserInt) {
					int godzinyPracy = (24 - godzinaPrzyjsciaUserInt) + godzinaWyjsciaUserInt;
					String godzinyPracyStr = Integer.toString(godzinyPracy);
					wynikGodzinyFinalny.setText(godzinyPracyStr);
				} else if (godzinaWyjsciaUserInt > godzinaPrzyjsciaUserInt) {
					int godzinyPracy = godzinaWyjsciaUserInt - godzinaPrzyjsciaUserInt;
					String godzinyPracyStr = Integer.toString(godzinyPracy);
					wynikGodzinyFinalny.setText(godzinyPracyStr);
				}
			}
			// minutyPracy
			if (minutyPrzyjsciaUserInt > 0 || minutyPrzyjsciaUserInt < 60 || minutyWyjsciaUserInt > 0 || minutyWyjsciaUserInt < 60 ) {
				if (minutyPrzyjsciaUserInt > minutyWyjsciaUserInt) {
					int minutyPracy = (60 - minutyPrzyjsciaUserInt) + minutyWyjsciaUserInt;
					String minutyPracyStr = Integer.toString(minutyPracy);
					wynikMinutyFinalny.setText(minutyPracyStr);
				} else {
					int minutyPracy = minutyWyjsciaUserInt - minutyPrzyjsciaUserInt;
					String minutyPracyStr = Integer.toString(minutyPracy);
					wynikMinutyFinalny.setText(minutyPracyStr);
				}
			}
			
			}} catch (NumberFormatException e2) {
				System.err.print("Wprowadz dane liczbowe");
			}
				
			
		} catch (NumberFormatException e3) {
			System.err.print("Wprowadz dane liczbowe");
		}

		
		
	}
	
	

	}
}

