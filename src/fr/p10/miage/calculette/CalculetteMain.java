package fr.p10.miage.calculette;

public class CalculetteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new Calculatrice();
            }
        });
	}

}
