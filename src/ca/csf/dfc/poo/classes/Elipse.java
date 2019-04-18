package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.IImportData;

public class Elipse extends Shape{

	public Elipse() {
		this(null,null);
	}
	public Elipse(Point p_initialPoint, Point p_finalPoint) {
		super.setIntialPoint(p_initialPoint);
		super.setFinalPoint(p_finalPoint);
		super.setName("elipse");
	}
	

	@Override
	public void export(IFormatDataAndSave p_export) throws XMLStreamException {
		p_export.exportEllipse(this);
		
	}

	@Override
	public void importData(IImportData p_import) throws XMLStreamException {
		p_import.importDataEllipse(this);
		
	}
	
	
	
}