package ca.csf.dfc.poo.main;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ca.csf.dfc.poo.classes.Line;
import ca.csf.dfc.poo.classes.Rectangle;
import ca.csf.dfc.poo.classes.SaveDataInXML;
import ca.csf.dfc.poo.classes.Shape;
import ca.csf.dfc.poo.interfaces.ISaveData;
import ca.csf.dfc.poo.ui.*;

public class Main {

	public static void main(String[] args) {
//		new GraphicInterface().setVisible(true);
		
		List<Shape> shapes = new ArrayList<Shape>();
		Point p1 = new Point(200,100);
		Point p2 = new Point (50,50);
		Rectangle rect1 = new Rectangle(p1,p2);
		
		p1 = new Point(20,20);
		p2 = new Point(60,55);
		Line line1 = new Line(p1,p2);
		
		shapes.add(rect1);
		shapes.add(line1);
		
		ISaveData xmlSaver = new SaveDataInXML(shapes);
		xmlSaver.collectData();
		
		
		
		
	}

}
