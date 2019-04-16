/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.sun.xml.internal.txw2.Document;

import ca.csf.dfc.poo.interfaces.IExportData;
import javafx.scene.shape.Ellipse;

/**
 * @author Maximilian
 *
 */
public class ExportDataInXML implements IExportData  {
	
	
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
	
	/**
	 * ctr par initialisation
	 * @param p_Shape : liste des formes affichées sur le workspace
	 */
	public ExportDataInXML() {
		
	}
	/**
	 * 
	 */
	public void setXMLStreamWriter(XMLStreamWriter p_xmlDoc) {
		this.m_xmlDoc = p_xmlDoc;
	}

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
<<<<<<< HEAD
			m_xmlDoc.writeStartElement(ELM_STYLE);								    
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, p_shapeData.getBorderColor().toString());
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_shapeData.getBorderWidth()));
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, p_shapeData.getFillColor().toString());
=======
			m_xmlDoc.writeStartElement(ELM_STYLE);
				color = Integer.toHexString(p_Rectangle.getBorderColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, color);
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_Rectangle.getBorderWidth()));
				color = p_Rectangle.getFillColor() == null ? "" : Integer.toHexString(p_Rectangle.getFillColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, "");
>>>>>>> Develop
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
<<<<<<< HEAD
			m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, p_shapeData.getBorderColor().toString());
			m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_shapeData.getBorderWidth()));
			m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, p_shapeData.getFillColor().toString());
=======
				color = Integer.toHexString(p_Line.getBorderColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, color);
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_Line.getBorderWidth()));
				color = p_Line.getFillColor() == null ? "" : Integer.toHexString(p_Line.getFillColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, color);
>>>>>>> Develop
			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
	}
	
	@Override
<<<<<<< HEAD
	public void exportEllipse(Elipse p_shapeData) throws XMLStreamException {
=======
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException {
		String color = null;
>>>>>>> Develop
		m_xmlDoc.writeStartElement(ELM_SHAPE);
			m_xmlDoc.writeAttribute(ELM_TYPE, p_shapeData.getName());
		
		//element de position
			m_xmlDoc.writeStartElement(ELM_COORD);
				m_xmlDoc.writeAttribute(ATTR_INIT_POINT, Integer.toString(p_shapeData.getInitialPoint().x)+
							";"+Integer.toString(p_shapeData.getInitialPoint().y));
				m_xmlDoc.writeAttribute(ATTR_FINAL_POINT, Integer.toString(p_shapeData.getFinalPoint().x)+
							";"+Integer.toString(p_shapeData.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
				
			
			//		element de style
			m_xmlDoc.writeStartElement(ELM_STYLE);								    
<<<<<<< HEAD
			m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, p_shapeData.getBorderColor().toString());
			m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_shapeData.getBorderWidth()));
			m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, p_shapeData.getFillColor().toString());
=======
				color = Integer.toHexString(p_Ellipse.getBorderColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_BORDER_COLOR, color);
				m_xmlDoc.writeAttribute(ATTR_BORDER_WIDTH, Integer.toString(p_Ellipse.getBorderWidth()));
				color = p_Ellipse.getFillColor() == null ? "" : Integer.toHexString(p_Ellipse.getFillColor().getRGB()& 0xffffff);
				m_xmlDoc.writeAttribute(ATTR_FILL_COLOR, color);
>>>>>>> Develop
			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
		
	}
	
	

	
	
		
}//class


