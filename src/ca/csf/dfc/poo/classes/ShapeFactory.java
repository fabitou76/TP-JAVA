package ca.csf.dfc.poo.classes;


import java.awt.Point;
import java.util.*;

import com.sun.prism.paint.Color;

import ca.csf.dfc.poo.classes.*;

public class ShapeFactory {
	
	public ShapeFactory() {
	}
	
	public Shape createShape(String p_shapeName, Point p_initialPoint, Point p_finalPoint) {
		Shape newShape;
		int height = p_finalPoint.y - p_initialPoint.y;
		int width = p_finalPoint.x - p_initialPoint.x;
		
		if(height < 0 && width < 0) {
			Point temp;
			temp = p_initialPoint;
			p_initialPoint = p_finalPoint;
			p_finalPoint = p_initialPoint;
		}
		else if (height < 0) {
			p_initialPoint.y = p_finalPoint.y;
		}
		
		
		switch(p_shapeName.toLowerCase()) {
		case "rectangle" :
			newShape = new Rectangle(p_initialPoint, p_finalPoint);
			break;
		case "line" :
			newShape = new Line(p_initialPoint, p_finalPoint);
			break;
		case "elipse" : 
			newShape = new Elipse(p_initialPoint, p_finalPoint);
			break;
		default:
			newShape = null;
		}

		newShape.setHeight(Math.abs(height));
		newShape.setWidth(Math.abs(width));
		return newShape;
		
		
	}
	
	
}
