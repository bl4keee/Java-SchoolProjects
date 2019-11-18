import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ramka extends JFrame {
	
	// Deklaracje
	//ArrayList<Dokument> listadokumentow;
	public ArrayList<Dokument> dokumenty;
	public ArrayList<JTextField> polaTekstoweTytuly;
	public ArrayList<JTextField> polaTekstoweTresci;
	public JPanel mojPanel;
	
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
		GridLayout mojGrid = new GridLayout(dokumenty.size(), 2);
		mojPanel.setLayout(mojGrid);
		polaTekstoweTytuly = new ArrayList<JTextField>();
		polaTekstoweTresci = new ArrayList<JTextField>();
		
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
		}
		pack();
	}
}
