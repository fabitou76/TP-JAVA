/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IConnectToDB;

/**
 * @author Maximilian
 *
 */
public class ConnectionToXMLOnDrive implements IConnectToDB {
	
	XMLStreamReader m_xmlDoc;
	String m_pathToFolder = null;
	
	/**
	 * ctr
	 */
	
	public ConnectionToXMLOnDrive() {
		
	}
	

	public XMLStreamReader getXMLDoc(){
		return this.m_xmlDoc;
	}
	
	public void connect() {
		this.selectDataFolder();
		try {
			this.connectToDB();
		} catch (FileNotFoundException | XMLStreamException | FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void selectDataFolder() {
		//utiliser JFileChooser
		
		this.m_pathToFolder = "dataXML.xml";
	}

	@Override
	public void connectToDB()throws FileNotFoundException, XMLStreamException, FactoryConfigurationError  {
		 FileReader input=new FileReader(new File(m_pathToFolder));
		 this.m_xmlDoc = XMLInputFactory.newInstance().createXMLStreamReader(input);
	}

	@Override
	public void closeConnection() throws XMLStreamException {
		this.m_xmlDoc.close();
		this.m_xmlDoc = null;
		
	}
	

}
