/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;


import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

//import com.sun.xml.internal.txw2.Document;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;


/**
 * @author Maximilian
 *
 */
public class FormatDataToXML implements IFormatDataAndSave  {
	
	
	private final static String ELM_SHAPE = "shape"; 
	private final static String ELM_TYPE = "type"; 
	private final static String ELM_COORD = "coord"; 
	private final static String ELM_STYLE = "style"; 
	private final static String ATTR_INIT_POINT = "initialPoint"; 
	private final static String ATTR_FINAL_POINT = "finalPoint";
	private final static String ATTR_BORDER_COLOR = "borderColor";
	private final static String ATTR_BORDER_WIDTH = "borderWidth";
	private final static String ATTR_FILL_COLOR= "fillColor";
	
	private XMLStreamWriter m_xmlDoc;
	private String m_folderName;
	
	private ArrayList<Shape> m_listOfShapes = null;
	
	/**
	 * ctr par initialisation
	 * @param p_Shape : liste des formes affichées sur le workspace
	 */
	public FormatDataToXML(ArrayList<Shape> p_listOfShapes) {
		this.m_listOfShapes = p_listOfShapes;
	}
	/**
	 * @throws IOException 
	 * @throws FactoryConfigurationError 
	 * @throws XMLStreamException 
	 * 
	 */
	
	@Override
	public String checkFileExtension(String p_folderName) {
		p_folderName = !p_folderName.endsWith(".xml") ? p_folderName += ".xml" : p_folderName;
		return p_folderName;
	}
	
	@Override
	public void formatAndSave(String p_folderName) throws IOException, XMLStreamException, FactoryConfigurationError {
		p_folderName = checkFileExtension(p_folderName);
		
		FileWriter outputWriter = new FileWriter(new File(p_folderName));
		this.m_xmlDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
		
		// DEBUT ECRITURE DOCUMENT XML
		m_xmlDoc.writeStartDocument();
			m_xmlDoc.writeStartElement("ListofShapes");
				for (Shape oneShape : this.m_listOfShapes) {
					oneShape.export(this);
				}
			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndDocument();

		m_xmlDoc.flush();
		m_xmlDoc.close();
		m_xmlDoc = null;
	}
	
	@Override
	public ArrayList<Shape> getShapeList() {
		return this.m_listOfShapes;
	}
	
//	public void setXMLStreamWriter(XMLStreamWriter p_xmlDoc) {
//		this.m_xmlDoc = p_xmlDoc;
//	}
////////////////
/// solution pour conserver Color.color de JavaD2 en XML et vice versa trouvée notamment  : 
///	https://www.javalobby.org/java/forums/t19183.html
///////////////	
	
	
	
	
	@Override
	public void exportRectangle(Rectangle p_Rectangle) throws XMLStreamException {
		String color = null;
		m_xmlDoc.writeStartElement(ELM_SHAPE);
		m_xmlDoc.writeAttribute(ELM_TYPE, p_Rectangle.getName());
		
		//element de position
			m_xmlDoc.writeStartElement(ELM_COORD);
				m_xmlDoc.writeAttribute(ATTR_INIT_POINT, Integer.toString(p_Rectangle.getInitialPoint().x)+
							";"+Integer.toString(p_Rectangle.getInitialPoint().y));
				m_xmlDoc.writeAttribute(ATTR_FINAL_POINT, Integer.toString(p_Rectangle.getFinalPoint().x)+
							";"+Integer.toString(p_Rectangle.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
			//	xmlDoc.writeEndElement();
		
		//		element de style
			m_xmlDoc.writeStartElement(ELM_STYLE);
				color = Integer.toHexString(p_Rectangle.getBorderColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, color);
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_Rectangle.getBorderWidth()));
				color = p_Rectangle.getFillColor() == null ? "" : Integer.toHexString(p_Rectangle.getFillColor().getRGB()& 0xffffff);
//				if (color != null)
//					color = hexa(color);
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, color);
				
				

			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
	}

	@Override
	public void exportLine(Line p_Line) throws XMLStreamException {
		String color = null;
		m_xmlDoc.writeStartElement(ELM_SHAPE);
			m_xmlDoc.writeAttribute(ELM_TYPE, p_Line.getName());
		
			//element de position
			m_xmlDoc.writeStartElement(ELM_COORD);
				m_xmlDoc.writeAttribute(ATTR_INIT_POINT, Integer.toString(p_Line.getInitialPoint().x)+
						";"+Integer.toString(p_Line.getInitialPoint().y));
				m_xmlDoc.writeAttribute(ATTR_FINAL_POINT, Integer.toString(p_Line.getFinalPoint().x)+
							";"+Integer.toString(p_Line.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
			
			//		element de style
			m_xmlDoc.writeStartElement(ELM_STYLE);	
				color = Integer.toHexString(p_Line.getBorderColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, color);
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_Line.getBorderWidth()));
				color = p_Line.getFillColor() == null ? "" : Integer.toHexString(p_Line.getFillColor().getRGB()& 0xffffff);
//				if (color != null)
//					color = hexa(color);
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, color);

			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
	}
	
	@Override

	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException {
		String color = null;
		m_xmlDoc.writeStartElement(ELM_SHAPE);
			m_xmlDoc.writeAttribute(ELM_TYPE, p_Ellipse.getName());
		
		//element de position
			m_xmlDoc.writeStartElement(ELM_COORD);
				m_xmlDoc.writeAttribute(ATTR_INIT_POINT, Integer.toString(p_Ellipse.getInitialPoint().x)+
							";"+Integer.toString(p_Ellipse.getInitialPoint().y));
				m_xmlDoc.writeAttribute(ATTR_FINAL_POINT, Integer.toString(p_Ellipse.getFinalPoint().x)+
							";"+Integer.toString(p_Ellipse.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
				
			
			//		element de style
			m_xmlDoc.writeStartElement(ELM_STYLE);		
				color = Integer.toHexString(p_Ellipse.getBorderColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, color);
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_Ellipse.getBorderWidth()));
				color = p_Ellipse.getFillColor() == null ? "" : Integer.toHexString(p_Ellipse.getFillColor().getRGB()& 0xffffff);
//				if (color != null)
//					color = hexa(color);
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, color);

			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
		
	}
	public String getM_folderName() {
		return m_folderName;
	}
	public void setM_folderName(String m_folderName) {
		this.m_folderName = m_folderName;
	}
	
//	String hexa(String p_hex) {
//		return p_hex.substring(2,p_hex.length());
//	}
	
	
	

	
		
}//class


