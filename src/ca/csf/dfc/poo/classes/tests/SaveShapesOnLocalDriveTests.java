package ca.csf.dfc.poo.classes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.poo.classes.Elipse;
import ca.csf.dfc.poo.classes.FormatDataToSVG;
import ca.csf.dfc.poo.classes.FormatDataToXML;
import ca.csf.dfc.poo.classes.Line;
import ca.csf.dfc.poo.classes.Rectangle;
import ca.csf.dfc.poo.classes.SaveShapesOnLocalDrive;
import ca.csf.dfc.poo.classes.Shape;

class SaveShapesOnLocalDriveTests {

	@Test
	//verifier que la classe passée en paramètre est la bonne et 
	//est attribuée à la bonne variable : cas pour XML
	
	void ctrInit_appelDeFormatDataToXML_normal() {
		//Arranger
		
		ArrayList<Shape> list = null;   
		SaveShapesOnLocalDrive test1 = new SaveShapesOnLocalDrive(new FormatDataToXML(list));		
		
		//Agir & Auditer
//		assertSame(test1.getM_formatDataAndSave().getClass().getName(),"ca.csf.dfc.poo.classes.FormatDataToXML");
		assertSame(test1.getClass().getName(),"ca.csf.dfc.poo.classes.FormatDataToXML");
	}
	
	//verifier que la liste passée en paramètres est attribuée à la bonne variable
	// cas pour XML
		@Test
		void ctrInit_casFormatDataToXML_listShapes() {
			
			//Arranger
			Rectangle rect1 = new Rectangle();
			rect1.setName("Rectangle de test pour un  test");
			ArrayList<Shape> list = new ArrayList<Shape>();   
			list.add(rect1);
			SaveShapesOnLocalDrive test1 = new SaveShapesOnLocalDrive(new FormatDataToXML(list));	
			
			//Agir & Auditer
			assertSame(test1.getM_ListShapes().get(0).getName(),"Rectangle de test pour un  test");
			
			//cas avec beaucoup 
			for (int i = 0; i < 100 ; i++ ) {
				list.add(new Line());
				list.add(new Elipse());
				list.add(new Rectangle());
			}
			SaveShapesOnLocalDrive test2 = new SaveShapesOnLocalDrive(new FormatDataToXML(list));
			assertTrue(test2.getM_ListShapes().size() ==301);
		}
		
		//verifier que la classe passée en paramètres est attribuée à la bonne variable
		//cas SVG
		@Test
		void ctrInit_casFormatDataToSVG_normal() {
			//Arranger
			ArrayList<Shape> listShapes = null;
			SaveShapesOnLocalDrive test1 = new SaveShapesOnLocalDrive(new FormatDataToSVG(listShapes));		
			
			//Agir & Auditer
			assertSame(test1.getM_formatDataAndSave().getClass().getName(),"ca.csf.dfc.poo.classes.FormatDataToSVG");
		}
		
		//verifier que la liste passée en paramètres est attribuée à la bonne variable
		// et contient ses objets cas SVG
		@Test
		void ctrInit_casFormatDataToSVG_liste() {
			
			//Arranger
			Rectangle rect1 = new Rectangle();
			rect1.setName("Rectangle de test pour un  test");
			ArrayList<Shape> list = new ArrayList<Shape>();   
			list.add(rect1);
			SaveShapesOnLocalDrive test1 = new SaveShapesOnLocalDrive(new FormatDataToSVG(list));	
			
			//Agir & Auditer
			assertSame(test1.getM_ListShapes().get(0).getName(),"Rectangle de test pour un  test");
			
			//cas avec beaucoup d'objet
			for (int i = 0; i < 100 ; i++ ) {
				list.add(new Line());
				list.add(new Elipse());
				list.add(new Rectangle());
			}
			SaveShapesOnLocalDrive test2 = new SaveShapesOnLocalDrive(new FormatDataToSVG(list));
			assertTrue(test2.getM_ListShapes().size() ==301);
			assertTrue(test2.getM_ListShapes().get(1).getClass().getName() == 
					"ca.csf.dfc.poo.classes.Line");
			assertTrue(test2.getM_ListShapes().get(300).getClass().getName() == 
					"ca.csf.dfc.poo.classes.Rectangle");
		}

//	@Test
//	void testSaveData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSelectFolder() {
//		// cette méthode ne permet pas de test automatisé, car elle demande une saisie à l'utilisateur
//	}
//
//	@Test
//	void testGetPath() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetPath() {
//		fail("Not yet implemented");
//	}

}
