import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Warcaby extends JPanel {

	public void paint(Graphics g) {
		super.paint(g);
		
		setBackground(Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		Stroke defaultStroke = g2.getStroke();
		
		Stroke lineStroke = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, null, 1.0f);
		g2.setStroke(lineStroke);
		g2.setColor(Color.BLACK);
		
		for (int i = 1; i <= 9; i++) {
			g2.draw(new Line2D.Double(i*50-25, 25, i*50-25, 425));
			g2.draw(new Line2D.Double(25, i*50-25, 425, i*50-25));
		}
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				if ((i + j) % 2 == 0) {
					g2.fill(new Rectangle2D.Double(j*50-25, i*50-25, 50, 50));
				}
			}
		}
	}
}
