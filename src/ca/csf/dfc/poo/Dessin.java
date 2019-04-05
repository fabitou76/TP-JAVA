package ca.csf.dfc.poo;

import java.awt.Color;

import javax.swing.JPanel;
import com.sun.prism.Graphics;

public class Dessin extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		//super.paintComponent(g);
		
	    int pixel=0;
	     
	    for(pixel=0 ; pixel <= getHeight() ; pixel += 10) {
	    	g.drawLine(0, pixel, pixel, getHeight());
	    }

	    for(pixel=getHeight() ; pixel >=0 ; pixel -= 10) {
	    	g.drawLine(0, pixel, getHeight() - pixel, 0);
	    }
	     
	    for(pixel=0 ; pixel <= getHeight() ; pixel +=10) {
	    	g.drawLine(getWidth(), pixel, getWidth() - pixel, getHeight());
	    }
	     
	    for(pixel=getHeight() ; pixel >=0 ; pixel -= 10) {
	    	g.drawLine(getWidth(), pixel, getWidth() - (getHeight() - pixel), 0);
	    }
	}
	
//	public Dessin() {
//		
//		//super("New Dessin");
//		
//		setSize(600, 400);
//		setBackground(Color.WHITE);
//		setLocationRelativeTo(null);
//		//setVisible(true);
//	}
}
