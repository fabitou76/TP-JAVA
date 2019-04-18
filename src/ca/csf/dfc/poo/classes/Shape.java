package ca.csf.dfc.poo.classes;

import java.awt.*;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.IImportData;

/*
 * Classe abstraite Shape
 * 
 * Défini les données membres et les méthodes des formes
 * 
 * Auteur: Hugo
 */
public abstract class Shape {

	//private static final int DEFAULT_WIDTH = 0;
	//private static final int DEFAULT_HEIGHT = 0;
	
	private Point m_initialPoint;
	private Point m_finalPoint;
	private String m_nom = "rectangle";
	private int m_height;
	private int m_width;
	private Color m_fillColor;
	private int m_borderWidth;
	private Color m_borderColor;
	
	/*
	 * getName 
	 * retourne le nom (String)
	 */
	public String getName() {
		return this.m_nom;
	}
	
	/*
	 * Remplace m_nom par le string en paramètre
	 * ne retourne rien
	 */
	public void setName(String p_name) {
		if(p_name == null || p_name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.m_nom = p_name;;
	}

	/*
	 * Retourne le point (coordonnés) du premier clic de la souris dans le workspace
	 */
	public Point getInitialPoint() {
		return this.m_initialPoint;
	}

	/*
	 * Retourne le point (coordonnés) du deuxième clic de la souris dans le workspace
	 */
	public Point getFinalPoint() {
		return this.m_finalPoint;
	}


	public void setIntialPoint(Point p_point) {
		if(p_point != null) {
			if(p_point.x < 0 || p_point.y < 0) {
				throw new IllegalArgumentException();
			}
		}
		this.m_initialPoint = p_point;
		
	}


	public void setFinalPoint(Point p_point) {
		if(p_point != null) {
			if(p_point.x < 0 || p_point.y < 0) {
				throw new IllegalArgumentException();
			}
		}
		this.m_finalPoint = p_point;
		
	}


	public void setHeight(int p_height) {
		if(p_height < 1) {
			throw new IllegalArgumentException();
		}
		this.m_height = p_height;
		
	}

	
	public void setWidth(int p_width) {
		if(p_width < 1) {
			throw new IllegalArgumentException();
		}
		this.m_width = p_width;
		
	}


	public int getHeight() {
	
		return this.m_height;
	}

	
	public int getWidth() {
		
		return this.m_width;
	}


	public Color getBorderColor() {
		return this.m_borderColor;
	}

	
	public int getBorderWidth() {
		return this.m_borderWidth;
	}


	public Color getFillColor() {
		return this.m_fillColor;
	}

	

	
	public void setBorderColor(Color p_borderColor) {
		this.m_borderColor = p_borderColor;
		
	}
	
	public void setBorderWidth(int p_borderWidth) {
		this.m_borderWidth = p_borderWidth;
		
	}

	public void setFillColor(Color p_fillColor) {
		this.m_fillColor = p_fillColor;
		
	}
	 

	public abstract void export(IFormatDataAndSave p_export) throws XMLStreamException;
	public abstract void importData(IImportData p_import) throws XMLStreamException;
	
	 
}
