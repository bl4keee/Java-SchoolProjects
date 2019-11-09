import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ramka extends JFrame implements ActionListener {

	public JButton przycisk1;
	public JButton przycisk2;
	public GridLayout grid;
	public JTextField text;
	
	public Ramka() {
		setTitle("Aplikacja Bartka");
		przycisk1 = new JButton("Klikaæ na w³asne ryzyko");
		przycisk2 = new JButton("ABC");
		GridLayout mojGrid = new GridLayout(2,2);
		JTextField text = new JTextField();
		add(text);
		add(przycisk1);
		add(przycisk2);
		pack();
		przycisk1.addActionListener(this);
		przycisk2.addActionListener(this);
		setLayout(mojGrid);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if(zrodlo == przycisk1) {
			JOptionPane.showMessageDialog(null, "Dzia³a! Jestem genialny.");  	
	}	else if (zrodlo == przycisk2) {
			przycisk2.setText("Klikniête"); 
		
	}

}
}