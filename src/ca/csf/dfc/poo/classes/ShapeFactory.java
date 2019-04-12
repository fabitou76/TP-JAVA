package ca.csf.dfc.poo.classes;


import java.awt.Point;
import java.util.*;



public class ShapeFactory {
	
	public ShapeFactory() {
	}
	
	public Shape createShape(String p_shapeName, Point p_initialPoint, Point p_finalPoint) {
		Shape newShape;
		switch(p_shapeName.toLowerCase()) {
		case "rectangle" :
			newShape = new Rectangle(p_initialPoint, p_finalPoint);
			break;
		case "line" :
			newShape = new Line(p_initialPoint, p_finalPoint);
			break;
		case "elipse" : 
			newShape = new Ellipse(p_initialPoint, p_finalPoint);
			break;
		default:
			newShape = null;
		}
		//Oups, j'attribue une hauteur et un largeur à la ligne..p-e mieux de 
		//déterminer la hauteur et la largeur dans le paintComponent
		int height = p_finalPoint.y - p_initialPoint.y;
		int width = p_finalPoint.x - p_initialPoint.x;
		newShape.setHeight(height);
		newShape.setWidth(width);
		return newShape;
		
	}
	
	
}
