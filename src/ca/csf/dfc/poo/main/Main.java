package ca.csf.dfc.poo.main;


import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.ui.*;

public class Main {

	public static void main(String[] args) throws XMLStreamException, FactoryConfigurationError {
		
//		List<Shape> shapes = new ArrayList<Shape>();
//		Point p1 = new Point(200,100);
//		Point p2 = new Point (50,50);
//		Rectangle rect1 = new Rectangle(p1,p2);
//		p1 = new Point(20,20);
//		p2 = new Point(60,55);
//		Line line1 = new Line(p1,p2);
//		shapes.add(rect1);
//		shapes.add(line1);
//		IExportData xmlSaver = new FormatDataToXML(shapes);
//		xmlSaver.collectData();
//		new ImportDataFromXML();
		
		new GraphicInterface().setVisible(true);
//		System.out.print(Color.BLACK.toString());
	}

}
