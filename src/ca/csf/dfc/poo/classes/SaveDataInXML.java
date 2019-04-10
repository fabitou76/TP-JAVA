/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.sun.xml.internal.txw2.Document;

import ca.csf.dfc.poo.interfaces.ISaveData;

/**
 * @author Maximilian
 *
 */
public class SaveDataInXML implements ISaveData  {
	private List<Shape> m_ListShape;
	private String folderPath;
	
	
	/**
	 * ctr par initialisation
	 * @param p_Shape : liste des formes affichées sur le workspace
	 */
	public SaveDataInXML(List<Shape>p_Shape) {
		this.m_ListShape = p_Shape;
	}
	
	@Override
	public void collectData(List<Shape> p_Shape) {
		this.m_ListShape = p_Shape;	
		
		if (this.m_ListShape != null && !this.m_ListShape.isEmpty()) {
			
			
			try {
				XMLOutputFactory factory = XMLOutputFactory.newInstance();
				FileWriter outputWriter =new FileWriter(new File("data.xml"));
				XMLStreamWriter xmlDoc = factory.createXMLStreamWriter(outputWriter);
				
				xmlDoc.writeStartDocument();
				xmlDoc.writeStartElement("ListofShapes");
				for (Shape oneShape : this.m_ListShape) {
					
					xmlDoc.writeStartElement("shape");
					xmlDoc.writeAttribute("type", oneShape.getName());
					
					//element de position
					
					//element de style
					xmlDoc.writeStartElement("style");
					xmlDoc.writeAttribute("couleurBordure", oneShape.getBorderColor());
					xmlDoc.writeAttribute("épaisseurBordure", Integer.toString(oneShape.getBorderWidth()));
					xmlDoc.writeAttribute("couleurFond", oneShape.getFillColor());
					
					
				}
				
				
				
				
				
				
				
			}catch (IOException | XMLStreamException | FactoryConfigurationError exp)
			{
				
			}
			
		}//if
	}


	@Override
	public void SaveData() {
		
	}//

	
	/**
	 * 
	 */
	@Override
	public String getFolderPath() {
		// TODO Auto-generated method stub
		return null;
	}


	

	@Override
	public void writeDataInDocument() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Shape> getShapeList() {
		return this.m_ListShape;
	}
	
	
		
}//class


