package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

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

}
