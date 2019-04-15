package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IExportData;
import ca.csf.dfc.poo.interfaces.IImportData;

public class Rectangle implements Shape{
	
	private Point m_initialPoint;
	private Point m_finalPoint;
	private String m_nom = "elipse";
	private int m_height = 0;
	private int m_width = 0;
	private Color m_fillColor;
	private int m_borderWidth;
	private Color m_borderColor;

	
	public Rectangle() {
		this(null,null);
	}
	public Rectangle(Point p_initialPoint, Point p_finalPoint) {
		this.m_initialPoint = p_initialPoint;
		this.m_finalPoint = p_finalPoint;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.m_nom;
	}
	
	@Override
	public void setName(String p_name) {
		this.m_nom = p_name;;
	}

	@Override
	public Point getInitialPoint() {
		// TODO Auto-generated method stub
		return this.m_initialPoint;
	}

	@Override
	public Point getFinalPoint() {
		// TODO Auto-generated method stub
		return this.m_finalPoint;
	}

	@Override
	public void setIntialPoint(Point p_point) {
		this.m_initialPoint = p_point;
		
	}

	@Override
	public void setFinalPoint(Point p_point) {
		this.m_finalPoint = p_point;
		
	}

	@Override
	public void setHeight(int p_height) {
		this.m_height = p_height;
		
	}

	@Override
	public void setWidth(int p_width) {
		this.m_width = p_width;
		
	}

	@Override
	public int getHeight() {
	
		return this.m_height;
	}

	@Override
	public int getWidth() {
		
		return this.m_width;
	}

	@Override
	public Color getBorderColor() {
		return this.m_borderColor;
	}

	@Override
	public int getBorderWidth() {
		return this.m_borderWidth;
	}

	@Override
	public Color getFillColor() {
		return this.m_fillColor;
	}

	
	@Override
	public void export(IExportData p_export) throws XMLStreamException {
		p_export.exportRectangle(this);
		
	}


	@Override
	public void importData(IImportData p_import) throws XMLStreamException {
		p_import.importDataRectangle(this);
		
	}
	@Override
	public void setBorderColor(Color p_borderColor) {
		this.m_borderColor = p_borderColor;
		
	}
	@Override
	public void setBorderWidth(int p_borderWidth) {
		this.m_borderWidth = p_borderWidth;
		
	}
	@Override
	public void setFillColor(Color p_fillColor) {
		this.m_fillColor = p_fillColor;
		
	}
	
	
	
	
}
