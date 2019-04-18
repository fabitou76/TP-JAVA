package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.IGenerateShapes;

public class Line extends Shape{

	public Line() {
		this(null,null);
	}
	public Line(Point p_initialPoint, Point p_finalPoint) {
		super.setIntialPoint(p_initialPoint);
		super.setFinalPoint(p_finalPoint);
		super.setName("line");
	}
	

	@Override
	public void export(IFormatDataAndSave p_export) throws XMLStreamException {
		p_export.exportLine(this);
		
	}

	@Override
	public void importData(IGenerateShapes p_import) throws XMLStreamException {
		p_import.importDataLine(this);
		
	}
	
	
	
}