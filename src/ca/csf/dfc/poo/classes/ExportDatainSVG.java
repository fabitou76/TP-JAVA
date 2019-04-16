/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.poo.interfaces.IExportData;
import javafx.scene.shape.Ellipse;

/**
 * Classe formatant les données de chaque forme pour une sauvegarde en SVG 
 * @author Maximilian
 *
 */
public class ExportDatainSVG implements IExportData {
	private XMLStreamWriter m_xmlDoc;


	@Override
	public void exportLine(Line p_Line) throws XMLStreamException {
		// GENERATION DES VARIABLES UTILES
		String x1 = Integer.toString(p_Line.getInitialPoint().x);
		String y1 = Integer.toString(p_Line.getInitialPoint().y);
		String x2 = Integer.toString(p_Line.getFinalPoint().x);
		String y2 = Integer.toString(p_Line.getFinalPoint().y);
		String stroke = p_Line.getFillColor().toString();
		 
		
		m_xmlDoc.writeStartElement("line");
			m_xmlDoc.writeAttribute("x1", x1);
			m_xmlDoc.writeAttribute("y1", x2);
			m_xmlDoc.writeAttribute("x2", y1);
			m_xmlDoc.writeAttribute("y2", y2);
			m_xmlDoc.writeAttribute("stroke", stroke);
		m_xmlDoc.writeEndElement();
	}

	

	@Override
	public void exportRectangle(Rectangle  p_Rectangle) throws XMLStreamException {
		// GENERATION DES VARIABLES UTILES
		String width = Integer.toString(p_Rectangle.getWidth());
		String height= Integer.toString(p_Rectangle.getHeight());
		String x = Integer.toString(p_Rectangle.getFinalPoint().x);
		String y = Integer.toString(p_Rectangle.getFinalPoint().y);
		String fill = p_Rectangle.getFillColor().toString();
		 
		
		m_xmlDoc.writeStartElement("rect");
			m_xmlDoc.writeAttribute("width", width);
			m_xmlDoc.writeAttribute("height", height);
			m_xmlDoc.writeAttribute("x", x);
			m_xmlDoc.writeAttribute("y", y);
			m_xmlDoc.writeAttribute("fill", fill);
		m_xmlDoc.writeEndElement();
		
	}

	@Override
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException {
		 String cs = Integer.toString((p_Ellipse.getFinalPoint().x) - (p_Ellipse.getInitialPoint().x));
		 String cy = Integer.toString((p_Ellipse.getFinalPoint().y) - (p_Ellipse.getInitialPoint().y));
		 String 
		 String r = ()
		
	}


	@Override
	public void setXMLStreamWriter(XMLStreamWriter p_xmlDoc) {
		this.m_xmlDoc = p_xmlDoc;
		
	}

}
