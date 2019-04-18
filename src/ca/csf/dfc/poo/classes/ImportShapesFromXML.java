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
import ca.csf.dfc.poo.interfaces.IImportShapes;
import ca.csf.dfc.poo.interfaces.IGenerateShapes;

/**
 * @author Maximilian
 *
 */
public class ImportShapesFromXML implements IImportShapes {
	
	private final static String ELM_SHAPE = "shape"; 
	private final static String ELM_TYPE = "type"; 
	private final static String ELM_COORD = "coord"; 
	private final static String ELM_STYLE = "style"; 
	private final static String ATTR_INIT_POINT = "initialPoint"; 
	private final static String ATTR_FINAL_POINT = "finalPoint";
	private final static String ATTR_BORDER_COLOR = "borderColor";
	private final static String ATTR_BORDER_WIDTH = "borderWidth";
	private final static String ATTR_FILL_COLOR= "fillColor";
	
	/**
	 * DONNEES MEMBRES
	 */
	IConnectToDB m_connectToDB;
	IGenerateShapes m_importData;
	List<Shape> m_ListShapes = null;
	XMLStreamReader m_xmlDoc;
	
	
	/**
	 * ctr
	 */
	public ImportShapesFromXML() {
		this.m_connectToDB = new ConnectToLocalDrive();
		this.m_importData = new GenerateShapesXML(this.m_xmlDoc);
	}
	

	public IConnectToDB getM_connectToDB() {
		return m_connectToDB;
	}


	public void setM_connectToDB(IConnectToDB m_connectToDB) {
		this.m_connectToDB = m_connectToDB;
	}


	/**
	 * 
	 * @param p_shapeList
	 */
	@Override
	public void setShapeList (List<Shape> p_shapeList) {
		this.m_ListShapes = p_shapeList;
	}
	
	public void createShapes() {
		this.connection();
		try {
			this.checkFile();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.generateShapes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connection() {
		try {
			this.m_connectToDB.connectToDB();
			if (this.getM_connectToDB() !=null) {

				this.m_xmlDoc = this.m_connectToDB.getXMLDoc();
				this.m_importData = new GenerateShapesXML(this.m_xmlDoc);
			}
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void checkFile() throws XMLStreamException {
		this.m_xmlDoc.next();
		 if (!this.m_xmlDoc.getLocalName().equals("ListofShapes")) {
               throw new XMLStreamException(
                   "Pas la bonne racine : " + this.m_xmlDoc.getLocalName());
           }		
	}

	@Override
	public void generateShapes() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		this.m_xmlDoc.next();
		
		 while(this.m_xmlDoc.isStartElement()) {
			 //lire quelle forme il faut créer
			 this.m_xmlDoc.getLocalName();
			 String shapeType  = this.m_xmlDoc.getAttributeValue("", ELM_TYPE);
			 
			 switch(shapeType) {
			 case "rectangle":
				 this.m_ListShapes.add(this.m_importData.importDataRectangle(new Rectangle()));
				 
				 break;
			 case "elipse":
				 this.m_ListShapes.add(this.m_importData.importDataEllipse(new Elipse()));
				 break;
			 case"line":
				 this.m_ListShapes.add(this.m_importData.importDataLine(new Line()));
			 }			 
		 }
	}
	
	
	
	

	
	
	

}
