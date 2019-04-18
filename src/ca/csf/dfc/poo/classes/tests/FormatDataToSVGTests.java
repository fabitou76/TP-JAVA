/**
 * 
 */
package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.classes.FormatDataToXML;
import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
class FormatDataToSVGTests {

	@Test
	void checkFileExtention_avecXML() {
		
		//ARRANGER
		ArrayList<Shape> p_list = new ArrayList<Shape>();
		FormatDataToXML format1 = new FormatDataToXML(p_list);
		FormatDataToXML format2 = new FormatDataToXML(p_list);
		//AGIR & AUDITER
		String name1 = format1.checkFileExtension("test.xml");
		assertTrue(name1 == "test.xml");
		String name2 = format2.checkFileExtension("test");
		assertEquals(format2.checkFileExtension("test"), "test.xml");
	}

}
