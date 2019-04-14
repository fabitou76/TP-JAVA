/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IReadData;

/**
 * @author Maximilian
 *
 */
public class LoadFromXML implements IReadData {
	
	private XMLStreamReader m_xmlDoc = null;
	private List<Shape> m_ListShapes;
	private FileReader input;
	private String  pathToImportFrom;
	
	public LoadFromXML (List<Shape>p_ListShapes) {
		this.m_ListShapes = p_ListShapes;
	}

	@Override
	public void selectFolder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dataLoader() throws XMLStreamException, FactoryConfigurationError {
		 try {

			 FileReader input=new FileReader(new File("data.xml"));

//			 input=new FileReader(new File(pathToImportFrom));


			 m_xmlDoc = XMLInputFactory.newInstance().createXMLStreamReader(input);
			 
			 m_xmlDoc.next();
			 if (!m_xmlDoc.getLocalName().equals("ListofShapes")) {
	                throw new XMLStreamException(
	                    "Pas la bonne racine : " + m_xmlDoc.getLocalName());
	            }
			 m_xmlDoc.next();
			 
			 while(m_xmlDoc.isStartElement()) {
				 //lire quelle forme il faut créer
				 String elementType = m_xmlDoc.getLocalName();
				 String shapeType  = m_xmlDoc.getAttributeValue("", "type");
				 m_xmlDoc.next();
				 String coord = m_xmlDoc.getLocalName();//devrait etre coord
				 String finalPoint= m_xmlDoc.getAttributeValue("", "finalPoint");
				 String  initialPoint  = m_xmlDoc.getAttributeValue("", "initialPoint");
				 m_xmlDoc.next();
				 m_xmlDoc.next();
				 String style = m_xmlDoc.getLocalName();//devrait etre style
				 String fillColor = m_xmlDoc.getAttributeValue("", "fillColor");
				 String borderWidth = m_xmlDoc.getAttributeValue("", "borderWidth");
				 String borderColor = m_xmlDoc.getAttributeValue("", "borderColor");
				 m_xmlDoc.next();m_xmlDoc.next();
				 m_xmlDoc.next();
				 System.out.println(elementType+shapeType+coord+
						 finalPoint+initialPoint+style+fillColor+borderWidth+borderColor);
			 }
			 
		 }catch (IOException exp) {
			 System.err.println("Erreur de lecture de fichier : " + exp);
		 }

		
	}

}
