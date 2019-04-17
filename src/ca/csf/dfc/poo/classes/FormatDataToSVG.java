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

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;

/**
 * @author Maximilian
 *
 */
public class FormatDataToSVG implements IFormatDataAndSave {
	
	private XMLStreamWriter m_svgDoc;
	
	private ArrayList<Shape> m_listOfShapes = null; 
	
	/**
	 * ctr
	 * @throws XMLStreamException 
	 * @throws IOException 
	 */
	
	public  FormatDataToSVG(ArrayList<Shape>p_ListOfShapes) throws XMLStreamException, IOException{
		this.m_listOfShapes = p_ListOfShapes;
		
		if (this.m_listOfShapes != null && !this.m_listOfShapes.isEmpty()) {
			ExportDatainSVG format = new ExportDatainSVG();
			
			FileWriter outputWriter = new FileWriter(new File("dataSVG.svg"));
			m_svgDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
			format.setXMLStreamWriter(m_svgDoc);
			
			// DEBUT ECRITURE DOCUMENT SVG
			m_svgDoc.writeStartDocument();
			m_svgDoc.writeStartElement("svg");
			m_svgDoc.writeAttribute("xmlns", "https://www.w3.org/2000/svg");
			m_svgDoc.writeAttribute("version","1.1");
			m_svgDoc.writeAttribute("Width","à définir");
			m_svgDoc.writeAttribute("height","à définir");
					
			m_svgDoc.writeStartElement("title");
			m_svgDoc.writeEndElement();//title
			m_svgDoc.writeStartElement("desc");
						
			m_svgDoc.writeEndElement();//desc
					
					for (Shape oneShape : this.m_listOfShapes) {
						oneShape.export(format);
					}
					
					m_svgDoc.writeEndElement();
					m_svgDoc.writeEndDocument();
			
					m_svgDoc.flush();
					m_svgDoc.close();
					m_svgDoc = null;
		}
	}

	@Override
	public void formatAndSave(String p_folderName) throws IOException, XMLStreamException, FactoryConfigurationError {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exportRectangle(Rectangle p_Rectangle) throws XMLStreamException {
		// GENERATION DES VARIABLES UTILES
				String width = Integer.toString(p_Rectangle.getWidth());
				String height= Integer.toString(p_Rectangle.getHeight());
				String x = Integer.toString(p_Rectangle.getFinalPoint().x);
				String y = Integer.toString(p_Rectangle.getFinalPoint().y);
				String fill = p_Rectangle.getFillColor() == null ? "": p_Rectangle.getFillColor().toString() ;
				String stroke = p_Rectangle.getBorderColor().toString();
				String strokeWidth = Integer.toString(p_Rectangle.getBorderWidth());
				 
				
				m_svgDoc.writeStartElement("rect");
				m_svgDoc.writeAttribute("width", width);
				m_svgDoc.writeAttribute("height", height);
				m_svgDoc.writeAttribute("x", x);
				m_svgDoc.writeAttribute("y", y);
				m_svgDoc.writeAttribute("fill", fill);
				m_svgDoc.writeAttribute("stroke", stroke);
				m_svgDoc.writeAttribute("stroke-width", strokeWidth);
				m_svgDoc.writeEndElement();
		
	}

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
		 
		
		m_svgDoc.writeStartElement("line");
		m_svgDoc.writeAttribute("x1", x1);
			m_svgDoc.writeAttribute("y1", x2);
			m_svgDoc.writeAttribute("x2", y1);
			m_svgDoc.writeAttribute("y2", y2);
			m_svgDoc.writeAttribute("stroke", stroke);
			m_svgDoc.writeAttribute("fill", fill);
			m_svgDoc.writeAttribute("stroke-width", strokeWidth);
			m_svgDoc.writeEndElement();
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
		 
		 m_svgDoc.writeStartElement("ellipse");
		 m_svgDoc.writeAttribute("cx", cx);
		 m_svgDoc.writeAttribute("cy", cy);
		 m_svgDoc.writeAttribute("rx", rx);
		 m_svgDoc.writeAttribute("ry", ry);
		 m_svgDoc.writeAttribute("fill", fill);
		 m_svgDoc.writeAttribute("stroke-width", strokeWidth);
		 m_svgDoc.writeAttribute("stroke", stroke);
		 m_svgDoc.writeEndElement();
		
	}

	@Override
	public ArrayList<Shape> getShapeList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
