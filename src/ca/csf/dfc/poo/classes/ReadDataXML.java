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

import ca.csf.dfc.poo.interfaces.IReadData;

/**
 * @author Maximilian
 *
 */
public class ReadDataXML implements IReadData {
	 XMLStreamReader documentXML = null;
	 
	 public ReadDataXML() throws XMLStreamException, FactoryConfigurationError {
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
				 String coord = documentXML.getLocalName();//devrait etre coord
				 String initialPoint = documentXML.getAttributeValue("", "initialPoint");
				 String finalPoint = documentXML.getAttributeValue("", "finalPoint");
				 String style = documentXML.getLocalName();//devrait etre style
				 String borderColor = documentXML.getAttributeValue("", "borderColor");
				 String borderWidth = documentXML.getAttributeValue("", "borderWidth");
				 String fillColor = documentXML.getAttributeValue("", "fillColor");
				 
				 System.out.println(elementType+shapeType+coord+
						 initialPoint+finalPoint+style+borderColor+borderWidth+fillColor);
			     documentXML.next();
			     
			 }
			 
		 }catch (IOException exp) {
			 System.err.println("Erreur de lecture de fichier : " + exp);
		 }
	 }

}
