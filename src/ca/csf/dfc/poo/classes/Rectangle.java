package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;

public class Rectangle implements Shape{
	
	private Point m_initialPoint;
	private Point m_finalPoint;
	private String m_nom = "rectangle";
	private int m_height = 0;
	private int m_width = 0;
	private Color m_fillColor;
	private int m_borderWidth;
	private Color m_borderColor;

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
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return this.m_fillColor;
	}


	@Override
	public void setFillColor(Color p_color) {
		// TODO Auto-generated method stub
		this.m_fillColor = p_color;
	}


	@Override
	public int getBorderWidth() {
		// TODO Auto-generated method stub
		return this.m_borderWidth;
	}


	@Override
	public void setBorderWidth(int p_borderWidth) {
		// TODO Auto-generated method stub
		this.m_borderWidth = p_borderWidth;
		
	}


	@Override
	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return this.m_borderColor;
	}


	@Override
	public void setBorderColor(Color p_color) {
		// TODO Auto-generated method stub
		this.m_borderColor = p_color;
		
	}
	
	
	
	
	
	
}
