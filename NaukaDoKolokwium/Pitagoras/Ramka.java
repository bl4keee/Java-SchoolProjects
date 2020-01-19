package trojkat;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ramka extends JFrame implements ActionListener {

		// Deklaracje
		public JTextField a; // przyprostok¹tna "a"
		public JTextField b; // przyprostok¹tna "b"
		public JTextField c; // przeciwprostok¹tna "c"
		public JTextField aUser, bUser, cUser; // used for user input
		public JButton wylicz;
	
		// Konstruktor
		public Ramka() {
			
			// Panel
			JPanel mojPanel = new JPanel();
			this.add(mojPanel);
			
			// Grid
			GridLayout mojGrid = new GridLayout(4, 2);
			mojPanel.setLayout(mojGrid);
			
			// Adding TextFields and Button to the Panel
			a = new JTextField("Przyprostok¹tna A: ");
			mojPanel.add(a);
			
			aUser = new JTextField();
			mojPanel.add(aUser);
			
			b = new JTextField("Przyprostok¹tna B: ");
			mojPanel.add(b);
			
			bUser = new JTextField();
			mojPanel.add(bUser);
			
			c = new JTextField("Przeciwprostok¹tna C: ");
			mojPanel.add(c);
			
			cUser = new JTextField();
			mojPanel.add(cUser);
			
			wylicz = new JButton("Wylicz");
			mojPanel.add(wylicz);
			wylicz.addActionListener(this);
			
			// Pack
			pack();
					
		}
		// actionPerformed
		@Override
		public void actionPerformed(ActionEvent e) {
			Object zrodlo = new Object();
			zrodlo = e.getSource();
			if (zrodlo == wylicz) {
				// if all fields are empty; if one of the fields is empty or if all of the fields are full
				if (aUser.getText().isEmpty() && bUser.getText().isEmpty() && cUser.getText().isEmpty() || 
						aUser.getText().isEmpty() == false && bUser.getText().isEmpty() && cUser.getText().isEmpty() ||
						aUser.getText().isEmpty() && bUser.getText().isEmpty() == false && cUser.getText().isEmpty() ||
						aUser.getText().isEmpty() && bUser.getText().isEmpty() && cUser.getText().isEmpty() == false ||
						aUser.getText().isEmpty() == false && bUser.getText().isEmpty() == false && cUser.getText().isEmpty() == false) {
					
					// if user didn't do something correctly
					aUser.setText("Podaj dwie d³ugoœci");
					bUser.setText("Podaj dwie d³ugoœci");
					cUser.setText("Podaj dwie d³ugoœci");
				} else {
					
					double wynik;
					double wynikKoncowy;
					
					// if user didn't pass the A parameter
					// a^2 = b^2 - c^2
					if (aUser.getText().isEmpty() == true) {
						int b = Integer.parseInt(bUser.getText());
						int c = Integer.parseInt(cUser.getText());
						wynik = (Math.pow(b, 2) - Math.pow(c, 2));
						wynikKoncowy = Math.sqrt(wynik);
						aUser.setText(String.valueOf(wynikKoncowy));	
					}
					
					// if user didn't pass the C parameter
					//b^2=c^2-a^2
					if (bUser.getText().isEmpty() == true) {
						int c = Integer.parseInt(cUser.getText());
						int a = Integer.parseInt(aUser.getText());
						wynik = (Math.pow(c, 2) - Math.pow(a, 2));
						wynikKoncowy = Math.sqrt(wynik);
						bUser.setText(String.valueOf(wynikKoncowy));	
					}
					
					// if user didn't pas the C parameter
					//c^2=a^2+b^2
					if (cUser.getText().isEmpty() == true) {
						int a = Integer.parseInt(aUser.getText());
						int b = Integer.parseInt(bUser.getText());
						wynik = (Math.pow(a, 2) + Math.pow(b, 2));
						wynikKoncowy = Math.sqrt(wynik);
						cUser.setText(String.valueOf(wynikKoncowy));	
					}
				}
			}
			
		}
	
		
			
}
