import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class AppFrame extends JFrame {
	public AppFrame() {
		setTitle("Kó³ko i kwadracik");
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		initGUI();
	}
	
	public void initGUI() {
		setLayout(new BorderLayout());
		
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.addTab("Plansza", new PlanszaGry());
		tabPane.addTab("Obrazek", new PanelZObrazkiem());
		tabPane.addTab("Wykres", new Wykres());
		tabPane.addTab("Warcaby", new Warcaby());
		tabPane.addTab("4 Warcaby", new Warcaby4());
		
		add(tabPane, BorderLayout.CENTER);
	}
}
