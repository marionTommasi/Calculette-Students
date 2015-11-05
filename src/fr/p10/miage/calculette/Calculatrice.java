package fr.p10.miage.calculette;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculatrice extends Frame {

	private static final long serialVersionUID = 1L;
	private static final String[] TAB_STRING = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
		".", "=", "C", "+", "-", "*", "/" };
	
	private final Panel container ;
	private final Button[] tabButton; 
	private final Dimension dim;
	private final Dimension dim2;
	
	private Label ecran;
	private double chiffre1;
	private boolean clicOperateur, update;
	private String operateur;

	public Calculatrice() {
		container = new Panel();
		container.setLayout(new BorderLayout());
		tabButton = new Button[TAB_STRING.length];
		ecran = new Label();
		dim = new Dimension(50, 40);
		dim2 = new Dimension(50, 31);
		clicOperateur = false;
		update = false;
		operateur = "";
		this.setSize(240, 260);
		this.setTitle("Calculette");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();

		this.add(container);
		this.pack();
		this.setVisible(true);
	}

	private void initComposant() {

		Font police = new Font("Arial", Font.BOLD, 20);
		ecran = new Label("0");
		ecran.setFont(police);
		ecran.setAlignment(Label.RIGHT);
		ecran.setPreferredSize(new Dimension(220, 20));

		Panel operateur = new Panel();
		operateur.setPreferredSize(new Dimension(55, 225));
		Panel chiffre = new Panel();
		chiffre.setPreferredSize(new Dimension(165, 225));
		Panel panEcran = new Panel();
		panEcran.setLayout(new GridLayout(1, 0));
		panEcran.setPreferredSize(new Dimension(220, 30));
		
		for (int i = 0; i < TAB_STRING.length; i++) {

			tabButton[i] = new Button(TAB_STRING[i]);
			tabButton[i].setPreferredSize(dim);

			switch (i) {

			case 11:
				tabButton[i].addActionListener(new EgalListener());
				chiffre.add(tabButton[i]);
				break;

			case 12:
				tabButton[i].setForeground(Color.red);
				tabButton[i].addActionListener(new ResetListener());
				operateur.add(tabButton[i]);
				break;

			case 13:
				tabButton[i].addActionListener(new PlusListener());
				tabButton[i].setPreferredSize(dim2);
				operateur.add(tabButton[i]);
				break;

			case 14:
				tabButton[i].addActionListener(new MoinsListener());
				tabButton[i].setPreferredSize(dim2);
				operateur.add(tabButton[i]);
				break;

			case 15:
				tabButton[i].addActionListener(new MultiListener());
				tabButton[i].setPreferredSize(dim2);
				operateur.add(tabButton[i]);
				break;

			case 16:
				tabButton[i].addActionListener(new DivListener());
				tabButton[i].setPreferredSize(dim2);
				operateur.add(tabButton[i]);
				break;

			default:
				chiffre.add(tabButton[i]);
				tabButton[i].addActionListener(new ChiffreListener());
				break;
			}

		}
		panEcran.add(ecran);

		container.add(panEcran, BorderLayout.NORTH);
		container.add(chiffre, BorderLayout.CENTER);
		container.add(operateur, BorderLayout.EAST);
	}

	private void calcul() {
		// A COMPLETER : effectuer les operations de calcul et 
		// afficher le resultat dans ecran.
	}
	
	class ChiffreListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// On affiche le chiffre en plus dans le label
			String str = ((Button) e.getSource()).getLabel();

			if (update) {
				update = false;
			} else {
				if (!ecran.getText().equals("0"))
					str = ecran.getText() + str;
			}

			ecran.setText(str);
		}

	}

	class EgalListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			calcul();
			update = true;
			clicOperateur = false;
		}

	}

	class PlusListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			if (clicOperateur) {
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			} else {
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "+";
			update = true;
		}

	}

	class MoinsListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (clicOperateur) {
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			} else {
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "-";
			update = true;
		}

	}

	class MultiListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (clicOperateur) {
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			} else {
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "*";
			update = true;
		}

	}

	class DivListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (clicOperateur) {
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			} else {
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;

			}
			operateur = "/";
			update = true;
		}

	}

	class ResetListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			clicOperateur = false;
			update = true;
			chiffre1 = 0;
			operateur = "";
			ecran.setText("");
		}

	}

}
