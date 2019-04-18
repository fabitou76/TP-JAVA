/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IConnectToDB;

/**
 * Classe permettant une connexion � un document XML sur le disque dur local pour en permettre l'importation de donn�es
 * 
 * CRITIQUE : la faiblesse  de cette classe est qu'elle a 2 objectifs : se connecter EN LOCAL (seulement)  pour acc�der 
 * � d'un document en XML (seulement).
 * Il aurait fallu d�coupler connection et type de fichier lu de sorte � permettre � diff�rents modules de lecture de fichier (XML, SVG, JASON, etc)
 * de n'avoir � faire qu'� une classe par type de support 
 */
public class ConnectToLocalDrive implements IConnectToDB {
	
	private XMLStreamReader m_xmlDoc;
	private String m_pathToFolder = null;
	
	/**
	 * constructeur
	 */
	
	public ConnectToLocalDrive() {
		
	}
	

	public XMLStreamReader getXMLDoc(){
		return this.m_xmlDoc;
	}
	
	public void connectToDB() {
		this.selectDataFolder();
		if (this.m_pathToFolder != null) {
			try {
				this.connect();
			} catch (FileNotFoundException | XMLStreamException | FactoryConfigurationError e) {
				// TODO Auto-generated catch block
				System.out.println("aucune adresse s�lectionn�e");
			}
		}
		
	}
	

	@Override
	public void selectDataFolder() {
		//utiliser JFileChooser
		
		
		String folderName = null;
		
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Sélectionnez un fichier");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xml file | svg file","xml", "svg");
//		fileChooser.setFileFilter(new FileNameExtensionFilter("xml file","xml"));
		fileChooser.addChoosableFileFilter(filter);
		int returnValue = fileChooser.showOpenDialog(fileChooser);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			folderName = (fileChooser.getSelectedFile().getPath());
			if (!folderName.endsWith(".xml")){
				folderName += ".xml";
			}
			this.m_pathToFolder = folderName;
		}
			
	}

	@Override
	public void connect()throws FileNotFoundException, XMLStreamException, FactoryConfigurationError  {
		 FileReader input=new FileReader(new File(m_pathToFolder));
		 this.m_xmlDoc = XMLInputFactory.newInstance().createXMLStreamReader(input);
	}

	@Override
	public void closeConnection() throws XMLStreamException {
		this.m_xmlDoc.close();
		this.m_xmlDoc = null;
		
	}
	

}
