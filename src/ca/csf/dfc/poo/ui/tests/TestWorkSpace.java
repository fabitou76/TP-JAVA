package ca.csf.dfc.poo.ui.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.ui.WorkSpace;

class TestWorkSpace {
	
	private void shapeListTest() {
		WorkSpace ws = new WorkSpace();
		Point initialPoint1 = new Point();
		Point finalPoint1 = new Point();
		
		initialPoint1.setLocation(15, 45);
		finalPoint1.setLocation(45, 67);
		
		Point initialPoint2 = new Point();
		Point finalPoint2 = new Point();
		
		initialPoint2.setLocation(45, 45);
		finalPoint2.setLocation(67, 78);
		

	}

	@Test
	void testWorkSpace() {
		WorkSpace ws = new WorkSpace();
		assertTrue(ws != null);
	}

	@Test
	void testGetShapeList() {
		
	}

	@Test
	void testSetSelectedFillColor() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSelectedBorderWidth() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSelectedBorderColor() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSelectedShape() {
		fail("Not yet implemented");
	}

	@Test
	void testCoordinatesAreSet() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateShape() {
		fail("Not yet implemented");
	}

	@Test
	void testAddShapeToWorkSpace() {
		fail("Not yet implemented");
	}

	@Test
	void testRefreshWorkSpace() {
		fail("Not yet implemented");
	}

	@Test
	void testResetCoordinates() {
		fail("Not yet implemented");
	}

}
