package ca.csf.dfc.poo.ui;

import javax.swing.JFrame;

import ca.csf.dfc.poo.Dessin;

public class WorkSpace extends JFrame {
	
	/**
	 * Constructeur pour ouvrir une nouvelle fenêtre
	 * Test
	 */
	public WorkSpace() {
		
		super("TP JAVA - Mini Paint");
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Dessin d = new Dessin();
		
	}
}
