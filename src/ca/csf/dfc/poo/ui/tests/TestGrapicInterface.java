package ca.csf.dfc.poo.ui.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.ui.GraphicInterface;

class TestGrapicInterface {

	@Test
	void testGraphicInterface() {
		GraphicInterface gf = new GraphicInterface();
		
		assertTrue(gf != null);
	}

}
