/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.awt.Color;
import java.awt.Point;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IGenerateShapes;

/**
 * Classe générant un Shape selon les données lu depuis le disque local
 * @author Maximilian
 *
 */
public class GenerateShapesXML implements IGenerateShapes {
	

	private final static String ATTR_INIT_POINT = "initialPoint"; 
	private final static String ATTR_FINAL_POINT = "finalPoint";
	private final static String ATTR_BORDER_COLOR = "borderColor";
	private final static String ATTR_BORDER_WIDTH = "borderWidth";
	private final static String ATTR_FILL_COLOR= "fillColor";
	
	private XMLStreamReader m_xmlDoc = null;
	

	/**
	 * constructeur
	 */
	public GenerateShapesXML (XMLStreamReader p_xmlDoc) {
		this.m_xmlDoc = p_xmlDoc;
	}
	
	/**
	 * méthode appelée lorsque les données chargées depuis le disque local est une ligne
	 */
	@Override
	public Line importDataLine(Line p_shape) throws XMLStreamException {
		p_shape.setName("line");
		
		this.generateShapeFromXML(p_shape);
		 System.out.println("ok pour la ligne");
		 return p_shape;
	}
	
	/**
	 * méthode appelée lorsque les données chargées depuis le disque local est une ellipse
	 */
	@Override
	public Elipse importDataEllipse(Elipse p_shape) throws XMLStreamException {
		p_shape.setName("elipse");
//		
		 
		this.generateShapeFromXML(p_shape);
		 System.out.println("ok pour l'ellipse");
		 
		 return p_shape;
	}
	
	/**
	 * méthode appelée lorsque les données chargées depuis le disque local est un carré
	 */
	@Override
	public Rectangle importDataRectangle(Rectangle p_shape) throws XMLStreamException {
		p_shape.setName("rectangle");
		 
		this.generateShapeFromXML(p_shape);
		 
		 return p_shape;
	}
	
	/**
	 * méthode utilisant les données récupérées sur le disque local pour créer une forme du format de notre application (Shape)
	 * @param p_shape
	 * @throws XMLStreamException
	 */
	public void generateShapeFromXML(Shape p_shape) throws XMLStreamException {
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
	}	


}
