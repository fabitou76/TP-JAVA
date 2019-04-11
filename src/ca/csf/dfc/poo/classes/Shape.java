package ca.csf.dfc.poo.classes;

import java.awt.*;

public interface Shape {


	 public String getName() ;
	 
	 
	/*
	 public int getX1() ;
	 public int getX2() ;
	 public int getY1() ;
	 public int getY2() ;
	 
	 public int setX1();
	 public int setX2();
	 public int setY1();
	 public int setY2();
	 */
	 
	 public Point getInitialPoint();
	 public Point getFinalPoint();
	 public void setIntialPoint(Point p_point);
	 public void setFinalPoint(Point p_point);
	 
	 public void setHeight(int p_height);
	 public void setWidth(int p_width);
	 public int getHeight();
	 public int getWidth();
	 
	 public Color getFillColor();
	 public void setFillColor(Color p_color);
	 
	 
	 public int getBorderWidth();
	 public void setBorderWidth(int p_borderWidth);
	 
	 public Color getBorderColor();
	 public void setBorderColor(Color p_color);
	 
	 
	 
	 
	 
}
