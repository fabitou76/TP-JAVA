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
	private final static String ATTR_FINAL_POINT = "initialPoint";
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
	public void exportRectangle(Rectangle p_shapeData) throws XMLStreamException {
		m_xmlDoc.writeStartElement("ELM_SHAPE");
		m_xmlDoc.writeAttribute("ELM_TYPE", p_shapeData.getName());
		
		//element de position
			m_xmlDoc.writeStartElement("ELM_COORD");
				m_xmlDoc.writeAttribute("ATTR_INIT_POINT", Integer.toString(p_shapeData.getInitialPoint().x)+
							";"+Integer.toString(p_shapeData.getInitialPoint().y));
				m_xmlDoc.writeAttribute("ATTR_FINAL_POINT", Integer.toString(p_shapeData.getFinalPoint().x)+
							";"+Integer.toString(p_shapeData.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
			//	xmlDoc.writeEndElement();
		
		//		element de style
			m_xmlDoc.writeStartElement("ELM_STYLE");								    
				m_xmlDoc.writeAttribute("ATTR_BORDER_COLOR", p_shapeData.getBorderColor());
				m_xmlDoc.writeAttribute("ATTR_BORDER_WIDTH", Integer.toString(p_shapeData.getBorderWidth()));
				m_xmlDoc.writeAttribute("ATTR_FILL_COLOR", "");
			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
	}

	@Override
	public void exportLine(Line p_shapeData) throws XMLStreamException {
		m_xmlDoc.writeStartElement("ELM_SHAPE");
			m_xmlDoc.writeAttribute("ELM_TYPE", p_shapeData.getName());
		
			//element de position
			m_xmlDoc.writeStartElement("ELM_COORD");
				m_xmlDoc.writeAttribute("ATTR_INIT_POINT", Integer.toString(p_shapeData.getInitialPoint().x)+
						";"+Integer.toString(p_shapeData.getInitialPoint().y));
				m_xmlDoc.writeAttribute("ATTR_FINAL_POINT", Integer.toString(p_shapeData.getFinalPoint().x)+
							";"+Integer.toString(p_shapeData.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
			
			//		element de style
			m_xmlDoc.writeStartElement("ELM_STYLE");								    
				m_xmlDoc.writeAttribute("ATTR_BORDER_COLOR", p_shapeData.getBorderColor());
				m_xmlDoc.writeAttribute("ATTR_BORDER_WIDTH", Integer.toString(p_shapeData.getBorderWidth()));
				m_xmlDoc.writeAttribute("ATTR_FILL_COLOR", "");
			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
	}
	
	@Override
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException {
		m_xmlDoc.writeStartElement("ELM_SHAPE");
			m_xmlDoc.writeAttribute("ELM_TYPE", p_Ellipse.getName());
		
		//element de position
			m_xmlDoc.writeStartElement("ELM_COORD");
				m_xmlDoc.writeAttribute("ATTR_INIT_POINT", Integer.toString(p_Ellipse.getInitialPoint().x)+
							";"+Integer.toString(p_Ellipse.getInitialPoint().y));
				m_xmlDoc.writeAttribute("ATTR_FINAL_POINT", Integer.toString(p_Ellipse.getFinalPoint().x)+
							";"+Integer.toString(p_Ellipse.getFinalPoint().y));
			m_xmlDoc.writeEndElement();
				
			
			//		element de style
			m_xmlDoc.writeStartElement("ELM_STYLE");								    
				m_xmlDoc.writeAttribute("ATTR_BORDER_COLOR", p_Ellipse.getBorderColor());
				m_xmlDoc.writeAttribute("ATTR_BORDER_WIDTH", Integer.toString(p_Ellipse.getBorderWidth()));
				m_xmlDoc.writeAttribute("ATTR_FILL_COLOR", "");
			m_xmlDoc.writeEndElement();
		m_xmlDoc.writeEndElement();
		
	}
	
	

	
//	@Override
//	public void collectData() {
//		
//		
//		if (this.m_ListShape != null && !this.m_ListShape.isEmpty()) {
//			XMLStreamWriter xmlDoc = null;
//			
//			try {
//				FileWriter outputWriter =new FileWriter(new File("data.xml"));
////				XMLOutputFactory factory = XMLOutputFactory.newInstance();
//				xmlDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
//				
//			
//				
////				xmlDoc = factory.createXMLStreamWriter(outputWriter);
//				
//				xmlDoc.writeStartDocument();
//					xmlDoc.writeStartElement("ListofShapes");
//						for (Shape oneShape : this.m_ListShape) {
//						
//							xmlDoc.writeStartElement("shape");
//								xmlDoc.writeAttribute("type", oneShape.getName());
//								
//								//element de position
//								xmlDoc.writeStartElement("coord");
//									xmlDoc.writeAttribute("initialPoint", Integer.toString(oneShape.getInitialPoint().x)+
//											";"+Integer.toString(oneShape.getInitialPoint().y));
//									xmlDoc.writeAttribute("finalPoint", Integer.toString(oneShape.getFinalPoint().x)+
//											";"+Integer.toString(oneShape.getFinalPoint().y));
//								xmlDoc.writeEndElement();
////							xmlDoc.writeEndElement();
//								
////								element de style
//								xmlDoc.writeStartElement("style");								    
//								    xmlDoc.writeAttribute("borderColor", oneShape.getBorderColor());
//								    xmlDoc.writeAttribute("borderWidth", Integer.toString(oneShape.getBorderWidth()));
//									xmlDoc.writeAttribute("fillColor", "");
//								xmlDoc.writeEndElement();
//							xmlDoc.writeEndElement();
//						}//for
//					xmlDoc.writeEndElement();
//				xmlDoc.writeEndDocument();
//			}catch (IOException  exp)
//			{
//				System.err.println("Erreur écriture : " + exp);
//			}catch (XMLStreamException exp)
//			{
//				System.err.println("Erreur de XML : " + exp);
//			}catch (FactoryConfigurationError exp)
//			{
//				System.err.println("Erreur de XML : " + exp);
//			}
////			catch(NullPointerException exp)
////			{
////				System.err.println("erreur de pointeur" + exp);
////			}
//			finally {
//			
//				if (xmlDoc != null) {
//					try {
//						xmlDoc.flush();
//						xmlDoc.close();
//					}catch(XMLStreamException exp) {
//						System.err.println("Erreur lors de la fermeture" + exp);
//						
//					} finally {
//						xmlDoc = null;
//					}
//				}
//			
//			}//finally
//		}//if
//	}//collectData
//
//	@Override
//	public void SaveData() {
//		
//	}//
//
//	
//	/**
//	 * 
//	 */
//	@Override
//	public String getFolderPath() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	
//
//	@Override
//	public void writeDataInDocument() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Shape> getShapeList() {
//		return null;
//	}
//
//	@Override
//	public void exportRectangle(String [] p_exportRectangle) {
//		// TODO Auto-generated method stub	
//	}
//
//	
//
//	@Override
//	public void exportLine(String[] p_shapeData) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void exportEllipse(String[] p_shapeData) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
		
}//class


