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

/**
 * @author Maximilian
 *
 */
public class ExportDataInXML implements IExportData  {
	
	
	
	/**
	 * ctr par initialisation
	 * @param p_Shape : liste des formes affichées sur le workspace
	 */
	public ExportDataInXML() {
		
	}

	@Override
	public void exportRectangle(ArrayList p_shapeData) {
		p_shapeData.forEach(s->System.out.println(s));
	}

	@Override
	public void exportLine(ArrayList p_shapeData) {
		p_shapeData.forEach(s->System.out.println(s));
	}

	@Override
	public void exportEllipse(ArrayList p_shapeData) {
		p_shapeData.forEach(s->System.out.println(s));
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


