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
		String fill = p_Line.getFillColor() == null ? "": p_Line.getFillColor().toString() ;
		String strokeWidth = Integer.toString(p_Line.getBorderWidth());
		 
		
		m_xmlDoc.writeStartElement("line");
			m_xmlDoc.writeAttribute("x1", x1);
			m_xmlDoc.writeAttribute("y1", x2);
			m_xmlDoc.writeAttribute("x2", y1);
			m_xmlDoc.writeAttribute("y2", y2);
			m_xmlDoc.writeAttribute("stroke", stroke);
			m_xmlDoc.writeAttribute("fill", fill);
			m_xmlDoc.writeAttribute("stroke-width", strokeWidth);
		m_xmlDoc.writeEndElement();
	}

	

	@Override
	public void exportRectangle(Rectangle  p_Rectangle) throws XMLStreamException {
		// GENERATION DES VARIABLES UTILES
		String width = Integer.toString(p_Rectangle.getWidth());
		String height= Integer.toString(p_Rectangle.getHeight());
		String x = Integer.toString(p_Rectangle.getFinalPoint().x);
		String y = Integer.toString(p_Rectangle.getFinalPoint().y);
		String fill = p_Rectangle.getFillColor() == null ? "": p_Rectangle.getFillColor().toString() ;
		String stroke = p_Rectangle.getBorderColor().toString();
		String strokeWidth = Integer.toString(p_Rectangle.getBorderWidth());
		 
		
		m_xmlDoc.writeStartElement("rect");
			m_xmlDoc.writeAttribute("width", width);
			m_xmlDoc.writeAttribute("height", height);
			m_xmlDoc.writeAttribute("x", x);
			m_xmlDoc.writeAttribute("y", y);
			m_xmlDoc.writeAttribute("fill", fill);
			m_xmlDoc.writeAttribute("stroke", stroke);
			m_xmlDoc.writeAttribute("stroke-width", strokeWidth);
		m_xmlDoc.writeEndElement();
		
	}

	@Override
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException {
		 String rx = Integer.toString((p_Ellipse.getFinalPoint().x) - (p_Ellipse.getInitialPoint().x));
		 String ry = Integer.toString((p_Ellipse.getFinalPoint().y) - (p_Ellipse.getInitialPoint().y));
		 String cx = Integer.toString((p_Ellipse.getFinalPoint().x) - (p_Ellipse.getInitialPoint().x) / 2);
		 String cy =  Integer.toString((p_Ellipse.getFinalPoint().y) - (p_Ellipse.getInitialPoint().y) / 2);
		 String fill = p_Ellipse.getFillColor() == null ? "": p_Ellipse.getFillColor().toString() ;
		 String stroke = p_Ellipse.getBorderColor().toString();
		 String strokeWidth = Integer.toString(p_Ellipse.getBorderWidth());
		 
		 m_xmlDoc.writeStartElement("ellipse");
			m_xmlDoc.writeAttribute("cx", cx);
			m_xmlDoc.writeAttribute("cy", cy);
			m_xmlDoc.writeAttribute("rx", rx);
			m_xmlDoc.writeAttribute("ry", ry);
			m_xmlDoc.writeAttribute("fill", fill);
			m_xmlDoc.writeAttribute("stroke-width", strokeWidth);
			m_xmlDoc.writeAttribute("stroke", stroke);
		m_xmlDoc.writeEndElement();
		 
		
	}


	@Override
	public void setXMLStreamWriter(XMLStreamWriter p_xmlDoc) {
		this.m_xmlDoc = p_xmlDoc;
		
	}

}
