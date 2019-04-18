package ca.csf.dfc.poo.classes;

/**
 * Classe représentant une forme avec un nom, un point initial et un point final  
 */

import java.awt.Point;
import java.util.*;

import com.sun.prism.paint.Color;

import ca.csf.dfc.poo.classes.*;

public class ShapeFactory {
	
	/**
	 * Ctr
	 */
	public ShapeFactory() {
	}
	
	/**
	 * Constructeur d'initialisation pour créer un new shape
	 * @param 1 p_shapeName nom du shape
	 * @param 2 p_initialPoint point initial du shape
	 * @param 3 p_finalPoint point final du shape
	 * @return un new shape
	 */
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
		
		if(newShape != null) {
			newShape.setHeight(Math.abs(height));
			newShape.setWidth(Math.abs(width));
		}
		return newShape;

	}
	
	/**
	 * Pour ajuster les coordonnées du shape
	 * @param 1 p_initialPoint point initial du shape
	 * @param 2 p_finalPoint point final du shape
	 * @return les coordonnés ajustée
	 */
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
