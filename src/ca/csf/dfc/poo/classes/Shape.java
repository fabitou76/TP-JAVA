package ca.csf.dfc.poo.classes;

/**
 * Classe représentant un shape  
 */

import java.awt.*;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.IGenerateShapes;

/*
 * Classe abstraite Shape
 * 
 * D�fini les donn�es membres et les m�thodes des formes
 * 
 * Auteur: Hugo
 */
public abstract class Shape {

	
	/**
	 * Le point initial d'un shape
	 */
	private Point m_initialPoint;
	
	/**
	 * Le point final d'un shape
	 */
	private Point m_finalPoint;
	
	/**
	 * Le nom d'un shape
	 */
	private String m_nom = "rectangle";
	
	/**
	 * L'hauteur d'un shape
	 */
	private int m_height;
	
	/**
	 * La largeur d'un shape
	 */
	private int m_width;
	
	/**
	 * La couleur de ?remplissage? d'un shape
	 */
	private Color m_fillColor;
	
	/**
	 * La taile de bordure d'un shape
	 */
	private int m_borderWidth;
	
	/**
	 * La couleur de bordure d'un shape
	 */
	private Color m_borderColor;
	
	public String getName() {
		return this.m_nom;
	}
	
	
	public void setName(String p_name) {
		if(p_name == null || p_name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.m_nom = p_name;;
	}


	public Point getInitialPoint() {
		return this.m_initialPoint;
	}


	public Point getFinalPoint() {
		return this.m_finalPoint;
	}

	/**
	 * Pour modifier le point initial
	 * @param p_point le point a modifier
	 */
	public void setIntialPoint(Point p_point) {
		
		if(p_point != null) {
			if(p_point.x < 0 || p_point.y < 0) {
				throw new IllegalArgumentException();
			}
		}
		
		this.m_initialPoint = p_point;
		
	}

	/**
	 * Pour modifier le point final
	 * @param p_point le point a modifier
	 */
	public void setFinalPoint(Point p_point) {
		
		if(p_point != null) {
			if(p_point.x < 0 || p_point.y < 0) {
				throw new IllegalArgumentException();
			}
		}
		
		this.m_finalPoint = p_point;
		
	}

	/**
	 * Pour modifier la hauteur
	 * @param p_height le point a modifier
	 */
	public void setHeight(int p_height) {

		
		this.m_height = p_height;
	}

	/**
	 * Pour modifier la largeur
	 * @param p_width la largeur a modifier
	 */
	public void setWidth(int p_width) {
		this.m_width = p_width;
		
	}

	/**
	 * Pour returner la hauteur
	 * @return le hauteur
	 */
	public int getHeight() {
	
		return this.m_height;
	}

	/**
	 * Pour returner la largeur
	 * @return le largeur
	 */
	public int getWidth() {
		
		return this.m_width;
	}

	/**
	 * Pour returner la couleur de la bordure
	 * @return la couleur de la bordure
	 */
	public Color getBorderColor() {
		return this.m_borderColor;
	}

	/**
	 * Pour returner la largeur de la bordure
	 * @return la largeur de la bordure
	 */
	public int getBorderWidth() {
		return this.m_borderWidth;
	}

	/**
	 * Pour returner la couleur de la remplissage
	 * @return la couleur de la remplissage
	 */
	public Color getFillColor() {
		return this.m_fillColor;
	}
	
	/**
	 * Pour modifier la couleur de la bordure
	 * @param p_borderColor la couleur a modifier
	 */
	public void setBorderColor(Color p_borderColor) {
		this.m_borderColor = p_borderColor;
		
	}
	
	/**
	 * Pour modifier la largeur de la bordure
	 * @param p_borderWidth la largeur a modifier
	 */
	public void setBorderWidth(int p_borderWidth) {
		if(p_borderWidth < 0) {
			throw new IllegalArgumentException();
		}
		
		this.m_borderWidth = p_borderWidth;
		
	}
	
	/**
	 * Pour modifier la couleur de remplissage
	 * @param p_fillColor la couleur de remplissage a modifier
	 */
	public void setFillColor(Color p_fillColor) {
		this.m_fillColor = p_fillColor;
		
	}
	 
	
	public abstract void export(IFormatDataAndSave p_export) throws XMLStreamException;
	public abstract void importData(IGenerateShapes p_import) throws XMLStreamException;
	
	 
}
