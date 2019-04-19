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
 * classe utilis�e pour g�n�rer une connexion � un fichier sur le disque local pour r�cup�rer des donn�es au format XML 
 * qui seront utilis�es pour g�n�rer des formes de type SHape
 * @author Maximilian
 *
 */
public class ImportShapesFromXML implements IImportShapes {
	
	private final static String ELM_TYPE = "type"; 
		
	/**
	 * DONNEES MEMBRES
	 */
	IConnectToDB m_connectToDB;
	IGenerateShapes m_importData;
	List<Shape> m_ListShapes = null;
	XMLStreamReader m_xmlDoc;
	
	
	/**
	 * constructeur
	 * 
	 */
	public ImportShapesFromXML() {
		this.m_connectToDB = new ConnectToLocalDrive();
		this.m_importData = new GenerateShapesXML(this.m_xmlDoc);
	}
	
	/**
	 * retourne la connection utilis�e pour acc�der � un fichier XML en lecture sur le disque local
	 * @return
	 */
	public IConnectToDB getM_connectToDB() {
		return m_connectToDB;
	}

	/**
	 * set  la connection utilis�e pour acc�der � un fichier XML en lecture sur le disque local
	 * @param m_connectToDB
	 */
	public void setM_connectToDB(IConnectToDB m_connectToDB) {
		this.m_connectToDB = m_connectToDB;
	}


	/**
	 * fait de la donn�e local m_ListShapes une r�f�rence � la liste contenant les formes
	 * @param p_shapeList
	 */
	@Override
	public void setShapeList (List<Shape> p_shapeList) {
		this.m_ListShapes = p_shapeList;
	}
	
	
	/**
	 * g�n�ere le processus de cr�ation de formes � partir de donn�es XML r�cup�r�e sur le disque local
	 */
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
	
	/**
	 * Pour faire la connection en lecture � un fichier XML sur le disque local
	 */
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
	
	/**
	 * Pour v�rifier que le fichier pris en lecture sur le disque local correspondat bien � une liste de formes du 
	 * type de notre application
	 * @throws XMLStreamException si jamais le fichier une erreur 
	 */
	private void checkFile() throws XMLStreamException {
		this.m_xmlDoc.next();
		 if (!this.m_xmlDoc.getLocalName().equals("ListofShapes")) {
               throw new XMLStreamException(
                   "Pas la bonne racine : " + this.m_xmlDoc.getLocalName());
           }		
	}

	/**
	 * Selon le type de forme qui est lu dans le fichier sur le disque local, le syst�me lance la g�n�ration d'un rectangle, 
	 * d'une ellipse ou d'une ligne  
	 */
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
				 break;
			 }			 
		 }
	}
	
	
	
	

	
	
	

}
