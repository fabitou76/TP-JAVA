/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IImportData;

/**
 * @author Maximilian
 *
 */
public class ImportDataFromXML implements IImportData {
	 XMLStreamReader documentXML = null;
	 
	 public ImportDataFromXML() throws XMLStreamException, FactoryConfigurationError {
		 try {
			 FileReader input=new FileReader(new File("data.xml"));
			 documentXML = XMLInputFactory.newInstance().createXMLStreamReader(input);
			 
			 documentXML.next();
			 if (!documentXML.getLocalName().equals("ListofShapes")) {
	                throw new XMLStreamException(
	                    "Pas la bonne racine : " + documentXML.getLocalName());
	            }
			 documentXML.next();
			 
			 while(documentXML.isStartElement()) {
				 //lire quelle forme il faut créer
				 String elementType = documentXML.getLocalName();
				 String shapeType  = documentXML.getAttributeValue("", "type");
				 documentXML.next();
				 String coord = documentXML.getLocalName();//devrait etre coord
				 String finalPoint= documentXML.getAttributeValue("", "finalPoint");
				 String  initialPoint  = documentXML.getAttributeValue("", "initialPoint");
				 documentXML.next();
				 documentXML.next();
				 String style = documentXML.getLocalName();//devrait etre style
				 String fillColor = documentXML.getAttributeValue("", "fillColor");
				 String borderWidth = documentXML.getAttributeValue("", "borderWidth");
				 String borderColor = documentXML.getAttributeValue("", "borderColor");
				 documentXML.next();documentXML.next();
				 documentXML.next();
				 System.out.println(elementType+shapeType+coord+
						 finalPoint+initialPoint+style+fillColor+borderWidth+borderColor);
			 }
			 
		 }catch (IOException exp) {
			 System.err.println("Erreur de lecture de fichier : " + exp);
		 }
	 }

}
