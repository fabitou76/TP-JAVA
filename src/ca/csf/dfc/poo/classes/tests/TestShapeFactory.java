package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.classes.*;


class TestShapeFactory {

	@Test
	void testShapeFactory() {
		ShapeFactory sf = new ShapeFactory();
		
		assertTrue(sf != null);
				
	}

	@Test
	void testCreateShape() {
		ShapeFactory sf = new ShapeFactory();
		Point initialPoint = new Point();
		Point finalPoint = new Point();
		initialPoint.setLocation(56,89);
		finalPoint.setLocation(78, 67);
		Shape rect2 = new Rectangle(initialPoint,finalPoint);
		Shape elip2 = new Elipse(initialPoint,finalPoint);
		Shape line2 = new Line(initialPoint,finalPoint);
	
		
		Shape rect = sf.createShape("rectangle", initialPoint, finalPoint);
		
		assertTrue(rect != null);
		assertTrue(rect.getClass() == rect2.getClass());
		
		initialPoint.setLocation(5,83);
		finalPoint.setLocation(78, 57);
		
		Shape elipse = sf.createShape("elipse", initialPoint, finalPoint);
		
		assertTrue(elipse != null);
		assertTrue(elipse.getClass() == elip2.getClass());
		
		initialPoint.setLocation(5,8);
		finalPoint.setLocation(78, 7);
		
		Shape line = sf.createShape("line", initialPoint, finalPoint);
		assertTrue(line != null);
		assertTrue(line.getClass() == line2.getClass());
		
		Shape nonExistingShape = sf.createShape("dsada", initialPoint, finalPoint);
		assertTrue(nonExistingShape == null);
	}

}
