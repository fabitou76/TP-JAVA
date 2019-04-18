package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

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
		
		Shape line = new Rectangle(initialPoint,finalPoint);
		assertTrue(line != null);
		assertTrue(line.getName() == "line");
		assertSame(line.getInitialPoint(), initialPoint);
		assertSame(line.getFinalPoint(),finalPoint);
	}

}
