/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.poo.interfaces.IFormatDataAndSave;
import ca.csf.dfc.poo.interfaces.ISaveData;

/**
 * @author Maximilian
 *
 */
public class SaveShapes implements ISaveData {
	
	/**
	 * DONNEES MEMBRES
	 */
	
	private String m_Path = null;
	ArrayList<Shape> m_ListShapes;
	IFormatDataAndSave m_formatDataAndSave = null;
	
	/**
	 * ctr
	 */
	public SaveShapes(IFormatDataAndSave p_formatDataAndSave) {
		this.m_formatDataAndSave = p_formatDataAndSave;
		this.m_ListShapes = this.m_formatDataAndSave.getShapeList();
		
	}
	
	@Override
	public void saveData() throws IOException, XMLStreamException, FactoryConfigurationError {
		String folderName = null;
		if (this.m_ListShapes != null && !this.m_ListShapes.isEmpty()) {
			folderName = selectFolder();
			}
		if (folderName != null ) {
			m_formatDataAndSave.formatAndSave(folderName);
		}
		
		
	}

	@Override
	public String selectFolder() {
		String folderName = null;
		
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Sélectionnez un dossier");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xml file","xml");
//		fileChooser.setFileFilter(new FileNameExtensionFilter("xml file","xml"));
		fileChooser.addChoosableFileFilter(filter);
		int returnValue = fileChooser.showSaveDialog(fileChooser);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			folderName = (fileChooser.getSelectedFile().getPath());
		}
		return folderName;
	}
	

	
	
	
	

	@Override
	public void dataSaver() throws XMLStreamException, FactoryConfigurationError, IOException {
//		if (this.m_ListShapes != null && !this.m_ListShapes.isEmpty()) {
//			XMLStreamWriter xmlDoc = null;
//			
			
			
//			FileWriter outputWriter = new FileWriter(new File("data.xml"));
//			XMLStreamWriter xmlDoc = XMLOutputFactory.newInstance().createXMLStreamWriter(outputWriter);
//			format.setXMLStreamWriter(xmlDoc);
			
//			// DEBUT ECRITURE DOCUMENT XML
//			xmlDoc.writeStartDocument();
//				xmlDoc.writeStartElement("ListofShapes");
//					for (Shape oneShape : this.m_ListShape) {
//						oneShape.export(format);
//					}
//				xmlDoc.writeEndElement();
//			xmlDoc.writeEndDocument();
//			
//			xmlDoc.flush();
//			xmlDoc.close();
//			xmlDoc = null;
//		}
	}

	

}
