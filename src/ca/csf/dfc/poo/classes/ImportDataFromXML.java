/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import ca.csf.dfc.poo.interfaces.IImportData;
import java.lang.reflect.*;
import java.awt.*;
/**
 * @author Maximilian
 *
 */
public class ImportDataFromXML implements IImportData {
	 private XMLStreamReader documentXML = null;
	 private List<Shape> m_ListShapes;
	 private FileReader input;
	  /**
	   * constructeur
	   * @param p_ListShapes
	   */
	 public ImportDataFromXML(List<Shape>p_ListShapes)  {
		 this.m_ListShapes = p_ListShapes;
	 }
	 
	 /**
	  * charge les données XML dans la liste des shapes
	  * @throws XMLStreamException
	  * @throws FactoryConfigurationError
	  */
	 
	 public void loadDataXML() throws XMLStreamException, FactoryConfigurationError {
		 try {
			 input=new FileReader(new File("data.xml"));
			 documentXML = XMLInputFactory.newInstance().createXMLStreamReader(input);
			 
			 documentXML.next();
			 if (!documentXML.getLocalName().equals("ListofShapes")) {
	                throw new XMLStreamException(
	                    "Pas la bonne racine : " + documentXML.getLocalName());
	            }
			 documentXML.next();
			 
			 while(documentXML.isStartElement()) {
				 //lire quelle forme il faut créer
				 Shape newShape = null;
				 
				 
				 String elementType = documentXML.getLocalName();
				 String shapeType  = documentXML.getAttributeValue("", "type");				 
				 documentXML.next();
				 
				 switch (shapeType) {
				 case "rectangle":
					 newShape = new Rectangle();
					 break;
					 
				 case "ellipse":
					 newShape = new Ellipse();
					 break;
				 case "line" :
					 newShape = new Line();
				 default:
						 break;
				 }
				  
				 String coord = documentXML.getLocalName();//devrait etre coord
				 
				 String  initialPoint  = documentXML.getAttributeValue("", "initialPoint");
				 String[] pt = initialPoint.split(";");
				 int initX = Integer.parseInt(pt[0]);
				 int initY = Integer.parseInt(pt[1]);
				 newShape.setIntialPoint(newShape.createPoint(initX, initY));
				 
				 String finalPoint= documentXML.getAttributeValue("", "finalPoint");
				 pt = finalPoint.split(";");
				 int finalX = Integer.parseInt(pt[0]);
				 int finalY = Integer.parseInt(pt[1]);
				 newShape.setFinalPoint(newShape.createPoint(finalX, finalY));
				 
				 newShape.setWidth(finalX - initX);
				 newShape.setHeight(finalY - initY);
				 
				 documentXML.next();
				 documentXML.next();
				 String style = documentXML.getLocalName();//devrait etre style
				 newShape.setBorderColor(documentXML.getAttributeValue("", "borderColor"));
				 newShape.setBorderWidth(Integer.parseInt(documentXML.getAttributeValue("", "borderWidth")));
				 newShape.setFillColor(documentXML.getAttributeValue("", "borderColor"));

				 documentXML.next();documentXML.next();
				 documentXML.next();
				 this.m_ListShapes.add(newShape);

				 System.out.println();
			 }
			 
		 }catch (IOException| SecurityException exp) {
			 System.err.println("Erreur de lecture de fichier : " + exp);
		 }
	 }

}
