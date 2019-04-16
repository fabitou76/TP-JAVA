/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.poo.interfaces.ISaveData;

/**
 * @author Maximilian
 *
 */
public class SaveToXML implements ISaveData {
	
	/**
	 * DONNEES MEMBRES
	 */
	
	private String m_Path;
	List<Shape> m_ListShape;
	
	/**
	 * ctr
	 */
	public SaveToXML(List<Shape> p_ListShapes) {
		this.m_ListShape = p_ListShapes;
	}

	@Override
	public void selectFolder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dataSaver() throws XMLStreamException, FactoryConfigurationError, IOException {
		if (this.m_ListShape != null && !this.m_ListShape.isEmpty()) {
			XMLStreamWriter xmlDoc = null;
			ExportDataInXML format = new ExportDataInXML();
			
			FileWriter outputWriter = new FileWriter(new File("D:\\Eclipse\\data.xml"));
			xmlDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
			format.setXMLStreamWriter(xmlDoc);
			
			// DEBUT ECRITURE DOCUMENT XML
			xmlDoc.writeStartDocument();
				xmlDoc.writeStartElement("ListofShapes");
					for (Shape oneShape : this.m_ListShape) {
						oneShape.export(format);
					}
				xmlDoc.writeEndElement();
			xmlDoc.writeEndDocument();
			
			xmlDoc.flush();
			xmlDoc.close();
			xmlDoc = null;
		}
	}

}
