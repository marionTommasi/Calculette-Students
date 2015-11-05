package fr.p10.miage.calculette;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

public class BorderPanel extends Panel {

	private static final long serialVersionUID = 1397939439478106978L;
	private static final Insets insets = new Insets(10, 10, 10, 10);

	public Insets getInsets() {
		return insets;
	}

	public void paint(Graphics g) {
		Dimension size = getSize();
		g.setColor(getBackground());
		g.draw3DRect(5, 5, size.width - 11, size.height - 11, true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Test");
		f.setLayout(new GridLayout(1, 0));
		f.setBackground(Color.lightGray);
		BorderPanel p = new BorderPanel();
		p.setLayout(new GridLayout(1, 0));
		p.add(new Button("Hello"));
		f.add(p);
		f.setVisible(true);
		f.pack();

	}

}
