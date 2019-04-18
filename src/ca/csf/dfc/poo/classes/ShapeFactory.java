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
		
		if(p_shapeName != "line") {
			Point adjustedCoords[] = this.coordinatesAdjustment(p_initialPoint, p_finalPoint);
			p_initialPoint = adjustedCoords[0];
			p_finalPoint = adjustedCoords[1];
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
			break;
		}
		
		if(newShape != null && newShape.getName() != "line") {
			System.out.println(Math.abs(height));
			System.out.println(Math.abs(width));
			
			height = Math.abs(height);
			width = Math.abs(width);
			newShape.setHeight(height);
			newShape.setWidth(width);
		}
		return newShape;

	}
	
	private Point[] coordinatesAdjustment(Point p_initialPoint, Point p_finalPoint) {
		
		
		int height = p_finalPoint.y - p_initialPoint.y;
		int width = p_finalPoint.x - p_initialPoint.x;
		
		if((height < 0 && width < 0)) {
			Point temp;
			temp = p_initialPoint;
			p_initialPoint = p_finalPoint;
			p_finalPoint = p_initialPoint;
		}
		else if (height < 0) {
			p_initialPoint.y = p_finalPoint.y;
		}
		else if(width < 0) {
			p_initialPoint.x = p_finalPoint.x;
			p_initialPoint.y = p_finalPoint.y - (p_finalPoint.y - p_initialPoint.y);
		}
		
		Point adjustedCoords[] = {p_initialPoint, p_finalPoint};
		return adjustedCoords;
	}

}
