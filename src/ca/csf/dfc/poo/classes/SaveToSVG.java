/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


import java.util.List;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.ISaveData;

/**
 * @author Maximilian
 *
 */
public class SaveToSVG   {

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

//	@Override
//	public void selectFolder() { 
//		this.setPath("dataSVG.svg");
		
	}

//	@Override
//	public void dataSaver() throws XMLStreamException, FactoryConfigurationError, IOException {
//		if (this.m_ListShape != null && !this.m_ListShape.isEmpty()) {
//			XMLStreamWriter svgDoc = null;
//			ExportDatainSVG format = new ExportDatainSVG();
//			
//			FileWriter outputWriter = new FileWriter(new File("dataSVG.svg"));
//			svgDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
//			format.setXMLStreamWriter(svgDoc);
//			
//			// DEBUT ECRITURE DOCUMENT SVG
//			svgDoc.writeStartDocument();
//				svgDoc.writeStartElement("svg");
//					svgDoc.writeAttribute("xmlns", "https://www.w3.org/2000/svg");
//					svgDoc.writeAttribute("version","1.1");
//					svgDoc.writeAttribute("Width","à définir");
//					svgDoc.writeAttribute("height","à définir");
//					
//					svgDoc.writeStartElement("title");
//					svgDoc.writeEndElement();//title
//						svgDoc.writeStartElement("desc");
//						
//						svgDoc.writeEndElement();//desc
//
//					
//					
//					
//					for (Shape oneShape : this.m_ListShape) {
//						oneShape.export(format);
//					}
//					
//			svgDoc.writeEndElement();
//			svgDoc.writeEndDocument();
//			
//			svgDoc.flush();
//			svgDoc.close();
//			svgDoc = null;
//		}
//	}


