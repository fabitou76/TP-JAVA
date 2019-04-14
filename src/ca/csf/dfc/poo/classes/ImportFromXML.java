/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IConnectToDB;
import ca.csf.dfc.poo.interfaces.ICreateShapeFromData;
import ca.csf.dfc.poo.interfaces.IImportData;

/**
 * @author Maximilian
 *
 */
public class CreateShapeFromXML implements ICreateShapeFromData {
	
	/**
	 * DONNEES MEMBRES
	 */
	ConnectionToXMLOnDrive m_connectToDB;
	IImportData m_importXML;
	List<Shape> m_ListShapes = null;
	XMLStreamReader m_xmlDoc;
	
	
	/**
	 * ctr
	 */
	public CreateShapeFromXML() {
		this.m_connectToDB = new ConnectionToXMLOnDrive();
	}
	

	/**
	 * 
	 * @param p_shapeList
	 */
	public void setShapeList (List<Shape> p_shapeList) {
		this.m_ListShapes = p_shapeList;
	}
	
	public void createShapes() throws FileNotFoundException, XMLStreamException {
		try {
			this.m_connectToDB.connect();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.create();
		
	}
	
	
	public void create() {
		
	}
	
	
	

	
	
	

}
