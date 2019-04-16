package ca.csf.dfc.poo.ui.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.ui.WorkSpace;
import ca.csf.dfc.poo.classes.*;
import ca.csf.dfc.poo.classes.Rectangle;
import ca.csf.dfc.poo.classes.Shape;

class TestWorkSpace {

	private ArrayList<Shape> getTestShapeList(){
		WorkSpace ws = new WorkSpace();
		
		Point initialPoint1 = new Point();
		Point finalPoint1 = new Point();
		initialPoint1.setLocation(34,56);
		finalPoint1.setLocation(56, 78);

		Shape rect = new Rectangle(initialPoint1,finalPoint1);

		Point initialPoint2 = new Point();
		Point finalPoint2 = new Point();
		initialPoint2.setLocation(56,89);
		finalPoint2.setLocation(78, 67);
		
		Shape line = new Line(initialPoint2,finalPoint2);
		
		Point initialPoint3 = new Point();
		Point finalPoint3 = new Point();
		initialPoint3.setLocation(56,89);
		finalPoint3.setLocation(78, 67);
		
		Shape elipse= new Elipse(initialPoint3,finalPoint3);
		
		ws.addShapeToWorkSpace(rect);
		ws.addShapeToWorkSpace(line);
		ws.addShapeToWorkSpace(elipse);
		
		
		return ws.getShapeList();
	}
	
	private WorkSpace workSpaceForTest() {
		WorkSpace ws = new WorkSpace();
		Point initialPoint = new Point();
		Point finalPoint = new Point();
		initialPoint.setLocation(56,89);
		finalPoint.setLocation(78, 67);
		ws.setInitialPoint(initialPoint);
		ws.setFinalPoint(finalPoint);
		
		return ws;
	}
	
	
	@Test
	void testWorkSpace() {
		WorkSpace ws = new WorkSpace();
		
		assertTrue(ws != null);
	}

	@Test
	void testGetShapeList() {
		
	
		WorkSpace ws = new WorkSpace();
		
		//liste vide
		ArrayList<Shape> liste = ws.getShapeList();
		
		assertTrue(liste != null);
		
		//liste avec 3 item différents
		Point initialPoint1 = new Point();
		Point finalPoint1 = new Point();
		initialPoint1.setLocation(34,56);
		finalPoint1.setLocation(56, 78);

		Shape rect = new Rectangle(initialPoint1,finalPoint1);

		Point initialPoint2 = new Point();
		Point finalPoint2 = new Point();
		initialPoint2.setLocation(56,89);
		finalPoint2.setLocation(78, 67);
		
		Shape line = new Line(initialPoint2,finalPoint2);
		
		Point initialPoint3 = new Point();
		Point finalPoint3 = new Point();
		initialPoint3.setLocation(56,89);
		finalPoint3.setLocation(78, 67);
		
		Shape elipse= new Elipse(initialPoint3,finalPoint3);
		
		ws.addShapeToWorkSpace(rect);
		ws.addShapeToWorkSpace(line);
		ws.addShapeToWorkSpace(elipse);
		
		liste = ws.getShapeList();
		
		for(Shape s : liste) {
			assertTrue(s != null);
		}
		
		assertTrue(liste.get(0).getName() == "rectangle");
		assertTrue(liste.get(1).getName() == "line");
		assertTrue(liste.get(2).getName() == "elipse");
		
	}

	@Test
	void testSetSelectedFillColor() {
		WorkSpace ws = this.workSpaceForTest();
		ws.setSelectedShape("rectangle");
		
		ws.setSelectedFillColor(null);
		Shape rect = ws.createShape();
		
		assertTrue(rect.getFillColor() == null);
		
		ws.setSelectedShape("line");
		ws.setSelectedFillColor(Color.black);
		Shape line = ws.createShape();
		
		assertTrue(line.getFillColor() == Color.black);
		
		
	}

	@Test
	void testSetSelectedBorderWidth() {
		WorkSpace ws = this.workSpaceForTest();
		ws.setSelectedShape("rectangle");
		
		ws.setSelectedBorderWidth(1);
		Shape rect = ws.createShape();
		
		assertTrue(rect.getBorderWidth() == 1);
		
		ws.setSelectedBorderWidth(5);
		Shape rect2 = ws.createShape();
		
		assertTrue(rect2.getBorderWidth() == 5);
		
		assertThrows(IllegalArgumentException.class, () -> ws.setSelectedBorderWidth(7));
		
		

	}

	@Test
	void testSetSelectedBorderColor() {
		WorkSpace ws = this.workSpaceForTest();
		ws.setSelectedShape("rectangle");
		
		ws.setSelectedBorderColor(Color.red);;
		Shape rect = ws.createShape();
		
		assertTrue(rect.getBorderColor() == Color.red);
		
		ws.setSelectedShape("line");
		ws.setSelectedBorderColor(Color.yellow);
		Shape line = ws.createShape();
		
		assertTrue(line.getBorderColor() == Color.yellow);
		
		assertThrows(IllegalArgumentException.class, () -> ws.setSelectedBorderColor(null));
		
		
	}

	@Test
	void testSetSelectedShape() {
		WorkSpace ws = this.workSpaceForTest();
	
	}

	@Test
	void testResetCoordinates() {
		fail("Not yet implemented");
	}

}
