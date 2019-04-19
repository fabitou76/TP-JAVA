package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.classes.*;

class TestRectangle {

	@Test
	void testRectangle() {
		Shape rect = new Rectangle();
		
		assertTrue(rect != null);
		assertTrue(rect.getInitialPoint() == null);
		assertTrue(rect.getFinalPoint() == null);
		assertTrue(rect.getName() == "rectangle");
	
	}

	@Test
	void testRectanglePointPoint() {
		
		Point initialPoint = new Point();
		Point finalPoint = new Point();
		initialPoint.setLocation(56,89);
		finalPoint.setLocation(78, 67);
		
		Shape rect = new Rectangle(initialPoint,finalPoint);
		assertTrue(rect != null);
		assertTrue(rect.getName() == "rectangle");
		assertSame(rect.getInitialPoint(), initialPoint);
		assertSame(rect.getFinalPoint(),finalPoint);
	}
	@Test
	void testRectangleSetName() {
		Shape rect = new Line();
		
		rect.setName("recttt");
		
		assertTrue(rect.getName() == "recttt");
		
		assertThrows(IllegalArgumentException.class, () -> rect.setName(null));
		assertThrows(IllegalArgumentException.class, () -> rect.setName(""));
		
		
	
	}
	
	@Test
	void testRectangleSetInitialPoint() {
		Shape rect = new Line();
		Point initialPoint = new Point();
		initialPoint.setLocation(56,89);
		
		rect.setIntialPoint(initialPoint);
		
		assertTrue(rect.getInitialPoint() != null);
		assertSame(rect.getInitialPoint(), initialPoint);
		
		initialPoint.setLocation(-56,89);
		assertThrows(IllegalArgumentException.class, () -> rect.setIntialPoint(initialPoint));

		initialPoint.setLocation(56,-89);
		assertThrows(IllegalArgumentException.class, () -> rect.setIntialPoint(initialPoint));
		

	}
	@Test
	void testRectangleSetFinalPoint() {
		Shape rect = new Line();
		Point finalPoint = new Point();
		finalPoint.setLocation(56,89);
		
		rect.setIntialPoint(finalPoint);
		
		assertTrue(rect.getInitialPoint() != null);
		assertSame(rect.getInitialPoint(), finalPoint);
		
		finalPoint.setLocation(-56,89);
		assertThrows(IllegalArgumentException.class, () -> rect.setIntialPoint(finalPoint));

		finalPoint.setLocation(56,-89);
		assertThrows(IllegalArgumentException.class, () -> rect.setIntialPoint(finalPoint));
		
	}
	@Test
	void testRectangleSetWidth() {
		Shape rect = new Line();
		
		rect.setWidth(34);
		
		assertTrue(rect.getWidth() == 34);
		
		rect.setWidth(545);
		
		assertTrue(rect.getWidth() == 545);
		
	
	}
	@Test
	void testRectangleSetHeight() {
		
		Shape rect = new Line();
		
		rect.setHeight(23);
		
		assertTrue(rect.getHeight() == 23);
		
		rect.setHeight(45);
		
		assertTrue(rect.getHeight() == 45);
		

	
	}
	@Test
	void testRectangleSetBorderColor() {
		Shape line = new Line();
		
		line.setBorderColor(Color.black);
		
		assertTrue(line.getBorderColor() == Color.black);
		
		line.setBorderColor(Color.green);
		
		assertTrue(line.getBorderColor() == Color.green);
		
		
	}
	@Test
	void testRectangleSetBorderWidth() {
		Shape line = new Line();
		
		line.setBorderWidth(1);
		
		assertTrue(line.getBorderWidth() == 1);
		
		line.setBorderWidth(5);
		
		assertTrue(line.getBorderWidth() == 5);
		
		assertThrows(IllegalArgumentException.class, () -> line.setBorderWidth(-1));
		
		
		
		
	}
	@Test
	void testRectangleSetFillColor() {
		Shape rect = new Line();
		
		rect.setFillColor(Color.black);
		
		assertTrue(rect.getFillColor() == Color.black);
		
		rect.setFillColor(Color.green);
		
		assertTrue(rect.getFillColor() == Color.green);
		
		
	}

}
