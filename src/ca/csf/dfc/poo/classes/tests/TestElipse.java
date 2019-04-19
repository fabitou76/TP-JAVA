package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.classes.*;


class TestElipse {

	@Test
	void testElipse() {
		Shape elipse = new Elipse();
		
		assertTrue(elipse != null);
		assertTrue(elipse.getInitialPoint() == null);
		assertTrue(elipse.getFinalPoint() == null);
		assertTrue(elipse.getName() == "elipse");
	}

	@Test
	void testElipsePointPoint() {
		Point initialPoint = new Point();
		Point finalPoint = new Point();
		initialPoint.setLocation(56,89);
		finalPoint.setLocation(78, 67);
		
		Shape elipse = new Elipse(initialPoint,finalPoint);
		assertTrue(elipse != null);
		assertTrue(elipse.getName() == "elipse");
		assertSame(elipse.getInitialPoint(), initialPoint);
		assertSame(elipse.getFinalPoint(),finalPoint);
	}
	
	@Test
	void testElipseSetName() {
		Shape elipse = new Elipse();
		
		elipse.setName("elipsoide");
		
		assertTrue(elipse.getName() == "elipsoide");
		
		assertThrows(IllegalArgumentException.class, () -> elipse.setName(null));
		assertThrows(IllegalArgumentException.class, () -> elipse.setName(""));
		
		
	
	}
	
	@Test
	void testElipseSetInitialPoint() {
		Shape elipse = new Elipse();
		Point initialPoint = new Point();
		initialPoint.setLocation(56,89);
		
		elipse.setIntialPoint(initialPoint);
		
		assertTrue(elipse.getInitialPoint() != null);
		assertSame(elipse.getInitialPoint(), initialPoint);
		
		initialPoint.setLocation(-56,89);
		assertThrows(IllegalArgumentException.class, () -> elipse.setIntialPoint(initialPoint));

		initialPoint.setLocation(56,-89);
		assertThrows(IllegalArgumentException.class, () -> elipse.setIntialPoint(initialPoint));
		

	}
	@Test
	void testElipseSetFinalPoint() {
		Shape elipse = new Elipse();
		Point finalPoint = new Point();
		finalPoint.setLocation(56,89);
		
		elipse.setIntialPoint(finalPoint);
		
		assertTrue(elipse.getInitialPoint() != null);
		assertSame(elipse.getInitialPoint(), finalPoint);
		
		finalPoint.setLocation(-56,89);
		assertThrows(IllegalArgumentException.class, () -> elipse.setIntialPoint(finalPoint));

		finalPoint.setLocation(56,-89);
		assertThrows(IllegalArgumentException.class, () -> elipse.setIntialPoint(finalPoint));
		
	}
	@Test
	void testElipseSetWidth() {
		Shape elipse = new Elipse();
		
		elipse.setWidth(34);
		
		assertTrue(elipse.getWidth() == 34);
		
		elipse.setWidth(545);
		
		assertTrue(elipse.getWidth() == 545);

	}
	@Test
	void testElipseSetHeight() {
		
		Shape elipse = new Elipse();
		
		elipse.setHeight(23);
		
		assertTrue(elipse.getHeight() == 23);
		
		elipse.setHeight(45);
		
		assertTrue(elipse.getHeight() == 45);

	}
	@Test
	void testElipseSetBorderColor() {
		Shape elipse = new Elipse();
		
		elipse.setBorderColor(Color.black);
		
		assertTrue(elipse.getBorderColor() == Color.black);
		
		elipse.setBorderColor(Color.green);
		
		assertTrue(elipse.getBorderColor() == Color.green);
		
		
	}
	@Test
	void testElipseSetBorderWidth() {
		Shape elipse = new Elipse();
		
		elipse.setBorderWidth(1);
		
		assertTrue(elipse.getBorderWidth() == 1);
		
		elipse.setBorderWidth(5);
		
		assertTrue(elipse.getBorderWidth() == 5);
		
		assertThrows(IllegalArgumentException.class, () -> elipse.setBorderWidth(-1));
		
		
		
		
	}
	@Test
	void testElipseSetFillColor() {
		Shape elipse = new Elipse();
		
		elipse.setFillColor(Color.black);
		
		assertTrue(elipse.getFillColor() == Color.black);
		
		elipse.setFillColor(Color.green);
		
		assertTrue(elipse.getFillColor() == Color.green);
		
		
	}
}