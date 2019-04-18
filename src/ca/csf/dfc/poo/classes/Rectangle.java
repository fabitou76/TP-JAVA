package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.IGenerateShapes;

public class Rectangle extends Shape{

	public Rectangle() {
		this(null,null);
	}
	public Rectangle(Point p_initialPoint, Point p_finalPoint) {
		super.setIntialPoint(p_initialPoint);
		super.setFinalPoint(p_finalPoint);
		super.setName("rectangle");
	}
	

	@Override
	public void export(IFormatDataAndSave p_export) throws XMLStreamException {
		p_export.exportRectangle(this);
		
	}

	@Override
	public void importData(IGenerateShapes p_import) throws XMLStreamException {
		p_import.importDataRectangle(this);
		
	}
	
	
	
}
