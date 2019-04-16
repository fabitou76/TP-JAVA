/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.lang.Object;
import java.util.List;

import ca.csf.dfc.poo.interfaces.ISaveData;

/**
 * @author Maximilian
 *
 */
public class SaveToSVG implements ISaveData {

	/**
	 * DONNEES MEMBRES
	 */
	
	private String m_Path;
	List<Shape> m_ListShape;
	
	/**
	 * ctr
	 */
	public SaveToSVG(List<Shape> p_ListShapes) {
		this.m_ListShape = p_ListShapes;
	}

	/**
	 * Retourne le path
	 * @return the path
	 */
	public String getPath() {
		return this.m_Path;
	}

	/**
	 *Pour modifier le path
	 *@param p_path Nouvelle valeur 
	 */
	public void setPath(String p_path) {
		this.m_Path = p_path;
	}

	@Override
	public void selectFolder() { 
		this.setPath("D:\\Eclipse\\dataSVG.svg");
		
	}

	@Override
	public void dataSaver() throws XMLStreamException, FactoryConfigurationError, IOException {
		if (this.m_ListShape != null && !this.m_ListShape.isEmpty()) {
			XMLStreamWriter xmlDoc = null;
			ExportDatainSVG format = new ExportDatainSVG();
			
			FileWriter outputWriter = new FileWriter(new File(this.m_Path));
			xmlDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
			format.setXMLStreamWriter(xmlDoc);
			
			// DEBUT ECRITURE DOCUMENT SVG
			xmlDoc.writeStartDocument();
				xmlDoc.writeStartElement("svg");
					xmlDoc.writeAttribute("xmlns", "https://www.w3.org/2000/svg");
					xmlDoc.writeAttribute("version","1.1");
					xmlDoc.writeAttribute("Width","à définir");
					xmlDoc.writeAttribute("height","à définir");
					
					xmlDoc.writeStartElement("title", "Exemple simple de figure SVG");
						xmlDoc.writeStartElement("desc", "Cette figure est constituée d'un rectangle, d'une ellipse"+
						"et d'un segment de droite");
						
						xmlDoc.writeEndElement();//desc

					xmlDoc.writeEndElement();//title
					
					
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
