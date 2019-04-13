package ca.csf.dfc.poo.classes;

import java.awt.Point;
import java.util.ArrayList;

import ca.csf.dfc.poo.interfaces.IExportData;
import ca.csf.dfc.poo.interfaces.IImportData;

public class Rectangle implements Shape{
	
	private Point m_initialPoint = null;
	private Point m_finalPoint = null;
	private String m_nom = "rectangle";
	private int m_height;
	private int m_width;
	
	private String m_borderColor = "black";
	private int m_borderWidth = 2;
	private String m_fillColor = "black";
	
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
	public String getBorderColor() {
		return this.m_borderColor;
	}

	@Override
	public int getBorderWidth() {
		return this.m_borderWidth;
	}

	@Override
	public String getFillColor() {
		return this.m_fillColor;
	}

	@Override
	public void toExport(IExportData p_modelExportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toImport(IImportData p_modelImportation) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList getData() {
		
		ArrayList dataRectangle = new ArrayList();
		dataRectangle.add(this.getName());
		dataRectangle.add(this.getInitialPoint().x+";"+this.getInitialPoint().y);
//		ArrayList [] dataRectangle = {this.getName(),
//						this.getInitialPoint().x+";"+this.getInitialPoint().y,
//						this.getFinalPoint().x+";"+this.getFinalPoint().y,
//						this.getBorderColor(),
//						Integer.toString(this.getBorderWidth()),
//						this.getFillColor()};
		return dataRectangle;
	}

	@Override
	public void export(IExportData p_export) {
		p_export.exportRectangle(this.getData());
		
	}
	
	
	
	
	
	
}
