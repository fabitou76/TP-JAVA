package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.classes.*;

class TestLine {

	@Test
	void testLine() {
		Shape line = new Line();
		
		assertTrue(line != null);
		assertTrue(line.getInitialPoint() == null);
		assertTrue(line.getFinalPoint() == null);
		assertTrue(line.getName() == "line");
	}

	@Test
	void testLinePointPoint() {
		Point initialPoint = new Point();
		Point finalPoint = new Point();
		initialPoint.setLocation(56,89);
		finalPoint.setLocation(78, 67);
		
		Shape line = new Line(initialPoint,finalPoint);
		assertTrue(line != null);
		assertTrue(line.getName() == "line");
		assertSame(line.getInitialPoint(), initialPoint);
		assertSame(line.getFinalPoint(),finalPoint);
	}
	@Test
	void testLineSetName() {
		Shape line = new Line();
		
		line.setName("lineeeeee");
		
		assertTrue(line.getName() == "lineeeeee");
		
		assertThrows(IllegalArgumentException.class, () -> line.setName(null));
		assertThrows(IllegalArgumentException.class, () -> line.setName(""));
		
		
	
	}
	
	@Test
	void testLineSetInitialPoint() {
		Shape line = new Line();
		Point initialPoint = new Point();
		initialPoint.setLocation(56,89);
		
		line.setIntialPoint(initialPoint);
		
		assertTrue(line.getInitialPoint() != null);
		assertSame(line.getInitialPoint(), initialPoint);
		
		initialPoint.setLocation(-56,89);
		assertThrows(IllegalArgumentException.class, () -> line.setIntialPoint(initialPoint));

		initialPoint.setLocation(56,-89);
		assertThrows(IllegalArgumentException.class, () -> line.setIntialPoint(initialPoint));
		

	}
	@Test
	void testLineSetFinalPoint() {
		Shape line = new Line();
		Point finalPoint = new Point();
		finalPoint.setLocation(56,89);
		
		line.setIntialPoint(finalPoint);
		
		assertTrue(line.getInitialPoint() != null);
		assertSame(line.getInitialPoint(), finalPoint);
		
		finalPoint.setLocation(-56,89);
		assertThrows(IllegalArgumentException.class, () -> line.setIntialPoint(finalPoint));

		finalPoint.setLocation(56,-89);
		assertThrows(IllegalArgumentException.class, () -> line.setIntialPoint(finalPoint));
		
	}
	@Test
	void testLineSetWidth() {
		Shape line = new Line();
		
		line.setWidth(34);
		
		assertTrue(line.getWidth() == 34);
		
		line.setWidth(545);
		
		assertTrue(line.getWidth() == 545);
		
		/*
		assertThrows(IllegalArgumentException.class, () -> elipse.setWidth(0));
		assertThrows(IllegalArgumentException.class, () -> elipse.setWidth(-1));
		*/
	}
	@Test
	void testLineSetHeight() {
		
		Shape line = new Line();
		
		line.setHeight(23);
		
		assertTrue(line.getHeight() == 23);
		
		line.setHeight(45);
		
		assertTrue(line.getHeight() == 45);
		
		/*
		assertThrows(IllegalArgumentException.class, () -> elipse.setHeight(0));
		assertThrows(IllegalArgumentException.class, () -> elipse.setHeight(-1));
		*/
	}
	@Test
	void testLineSetBorderColor() {
		Shape line = new Line();
		
		line.setBorderColor(Color.black);
		
		assertTrue(line.getBorderColor() == Color.black);
		
		line.setBorderColor(Color.green);
		
		assertTrue(line.getBorderColor() == Color.green);
		
		
	}
	@Test
	void testLineSetBorderWidth() {
		Shape line = new Line();
		
		line.setBorderWidth(1);
		
		assertTrue(line.getBorderWidth() == 1);
		
		line.setBorderWidth(5);
		
		assertTrue(line.getBorderWidth() == 5);
		
		assertThrows(IllegalArgumentException.class, () -> line.setBorderWidth(-1));
		
		
		
		
	}
	@Test
	void testLineSetFillColor() {
		Shape line = new Line();
		
		line.setFillColor(Color.black);
		
		assertTrue(line.getFillColor() == Color.black);
		
		line.setFillColor(Color.green);
		
		assertTrue(line.getFillColor() == Color.green);
		
		
	}

}
