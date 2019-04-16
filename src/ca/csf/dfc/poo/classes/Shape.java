package ca.csf.dfc.poo.classes;

import java.awt.*;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IExportData;
import ca.csf.dfc.poo.interfaces.IImportData;

public interface Shape {

	 public String getName() ;
	 public void setName(String p_name);
	 
	 public Point getInitialPoint();
	 public Point getFinalPoint();
	 public void setIntialPoint(Point p_point);
	 public void setFinalPoint(Point p_point);
	 
	 public void setHeight(int p_height);
	 public void setWidth(int p_width);
	 public int getHeight();
	 public int getWidth();
	
	 public Color getBorderColor();
	 public int getBorderWidth();
	 public Color getFillColor();
	 
	 public void setBorderColor(Color p_borderColor);
	 public void setBorderWidth(int p_borderWidth);
	 public void setFillColor(Color p_fillColor);
	 
	
	 
	 public void export(IExportData p_export) throws XMLStreamException;
	 public void importData (IImportData p_import) throws XMLStreamException;
	 
	
	 
}
