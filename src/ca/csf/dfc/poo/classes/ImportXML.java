/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IImportData;

/**
 * @author Maximilian
 *
 */
public class ImportXML implements IImportData {
	
	private final static String ELM_SHAPE = "shape"; 
	private final static String ELM_TYPE = "type"; 
	private final static String ELM_COORD = "coord"; 
	private final static String ELM_STYLE = "style"; 
	private final static String ATTR_INIT_POINT = "initialPoint"; 
	private final static String ATTR_FINAL_POINT = "finalPoint";
	private final static String ATTR_BORDER_COLOR = "borderColor";
	private final static String ATTR_BORDER_WIDTH = "borderWidth";
	private final static String ATTR_FILL_COLOR= "fillColor";
	
	private XMLStreamReader m_xmlDoc = null;
	

	/**
	 * ctr
	 */
	public ImportXML (XMLStreamReader p_xmlDoc) {
		this.m_xmlDoc = p_xmlDoc;
	}
	

	/**
	 * 
	 */
	@Override
	public Line importDataLine(Line p_shape) throws XMLStreamException {
		p_shape.setName("line");
		this.m_xmlDoc.next();
		
		 m_xmlDoc.getLocalName();//devrait etre coord
		 
		 String [] point1 =  m_xmlDoc.getAttributeValue("", ATTR_INIT_POINT).split(";");
		 String [] point2 = m_xmlDoc.getAttributeValue("", ATTR_FINAL_POINT).split(";");
		 
		 Point initPt = new Point(Integer.parseInt(point1[0]),Integer.parseInt(point1[1]));
		 Point finalPt = new Point(Integer.parseInt(point2[0]),Integer.parseInt(point2[1]));;
		 int width = Integer.parseInt(point2[0]) - Integer.parseInt(point1[0]);
		 int heigth = Integer.parseInt(point2[1]) - Integer.parseInt(point1[1]);
		 p_shape.setWidth(width);
		 p_shape.setHeight(heigth);
		 
		 
		 p_shape.setIntialPoint(initPt);
		 p_shape.setFinalPoint(finalPt);
		 
		 m_xmlDoc.next(); m_xmlDoc.next();
		 String style = m_xmlDoc.getLocalName();//devrait etre style
		 
		 p_shape.setBorderColor(Color.decode("#"+(m_xmlDoc.getAttributeValue("", ATTR_BORDER_COLOR))));
		 p_shape.setBorderWidth(Integer.parseInt(m_xmlDoc.getAttributeValue("", ATTR_BORDER_WIDTH)));

		 Color color = m_xmlDoc.getAttributeValue("", ATTR_FILL_COLOR) == "" ? new Color(1f,0f,0f,.0f):
			 Color.decode("#"+(m_xmlDoc.getAttributeValue("", ATTR_FILL_COLOR)));
		 p_shape.setFillColor(color);
		 
		 m_xmlDoc.next();m_xmlDoc.next();m_xmlDoc.next();
		 
		 System.out.println("ok pour line");
		 return p_shape;
	}
	
	/**
	 * 
	 */
	@Override
	public Elipse importDataEllipse(Elipse p_shape) throws XMLStreamException {
		p_shape.setName("elipse");
		this.m_xmlDoc.next();
		m_xmlDoc.getLocalName();//devrait etre coord
		 
		 String [] point1 =  m_xmlDoc.getAttributeValue("", ATTR_INIT_POINT).split(";");
		 String [] point2 = m_xmlDoc.getAttributeValue("", ATTR_FINAL_POINT).split(";");
		 
		 int width = Integer.parseInt(point2[0]) - Integer.parseInt(point1[0]);
		 int heigth = Integer.parseInt(point2[1]) - Integer.parseInt(point1[1]);
		 p_shape.setWidth(width);
		 p_shape.setHeight(heigth);
		 
		 Point initPt = new Point(Integer.parseInt(point1[0]),Integer.parseInt(point1[1]));
		 Point finalPt = new Point(Integer.parseInt(point2[0]),Integer.parseInt(point2[1]));;
		 
		 p_shape.setIntialPoint(initPt);
		 p_shape.setFinalPoint(finalPt);
		 
		 m_xmlDoc.next(); m_xmlDoc.next();
		 String style = m_xmlDoc.getLocalName();//devrait etre style
		 
		 p_shape.setBorderColor(Color.decode(("#"+m_xmlDoc.getAttributeValue("", ATTR_BORDER_COLOR))));
		 p_shape.setBorderWidth(Integer.parseInt(m_xmlDoc.getAttributeValue("", ATTR_BORDER_WIDTH)));

		 Color color = m_xmlDoc.getAttributeValue("", ATTR_FILL_COLOR) == "" ? new Color(1f,0f,0f,.0f):
			 Color.decode("#"+(m_xmlDoc.getAttributeValue("", ATTR_FILL_COLOR)));
		 p_shape.setFillColor(color);
		 
		 m_xmlDoc.next();m_xmlDoc.next();m_xmlDoc.next();
		 
		 System.out.println("ok pour ellipse");
		 
		 return p_shape;
	}
	
	/**
	 * 
	 */
	@Override
	public Rectangle importDataRectangle(Rectangle p_shape) throws XMLStreamException {
		p_shape.setName("rectangle");
		this.m_xmlDoc.next();
		
		m_xmlDoc.getLocalName();//devrait etre coord
		 
		 String [] point1 =  m_xmlDoc.getAttributeValue("", ATTR_INIT_POINT).split(";");
		 String [] point2 = m_xmlDoc.getAttributeValue("", ATTR_FINAL_POINT).split(";");
		 
		 Point initPt = new Point(Integer.parseInt(point1[0]),Integer.parseInt(point1[1]));
		 Point finalPt = new Point(Integer.parseInt(point2[0]),Integer.parseInt(point2[1]));
		 int width = Integer.parseInt(point2[0]) - Integer.parseInt(point1[0]);
		 int heigth = Integer.parseInt(point2[1]) - Integer.parseInt(point1[1]);
		 p_shape.setWidth(width);
		 p_shape.setHeight(heigth);
		 
		 
		 p_shape.setIntialPoint(initPt);
		 p_shape.setFinalPoint(finalPt);
		 
		 m_xmlDoc.next(); m_xmlDoc.next();
		 String style = m_xmlDoc.getLocalName();//devrait etre style
		 
		 p_shape.setBorderColor(Color.decode("#"+(m_xmlDoc.getAttributeValue("", ATTR_BORDER_COLOR))));
		 p_shape.setBorderWidth(Integer.parseInt(m_xmlDoc.getAttributeValue("", ATTR_BORDER_WIDTH)));
		
		 Color color = m_xmlDoc.getAttributeValue("", ATTR_FILL_COLOR) == "" ? new Color(1f,0f,0f,.0f):
			 Color.decode("#"+(m_xmlDoc.getAttributeValue("", ATTR_FILL_COLOR)));
		 p_shape.setFillColor(color);
		 
		 m_xmlDoc.next();m_xmlDoc.next();m_xmlDoc.next();
		 
		 System.out.println("ok pour rectangle");
		 return p_shape;
	}
	
	


}
