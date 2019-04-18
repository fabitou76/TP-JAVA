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
		
		if (this.m_ListShapes != null && !this.m_ListShapes.isEmpty()) {
			selectFolder();
			}
		if (this.getPath() != null ) {
			m_formatDataAndSave.formatAndSave(this.getPath());
		}
		
		
	}

	@Override
	public void selectFolder() {
		String folderName = null;
		
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Sélectionnez un dossier");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xml file | svg file","xml", "svg");
//		fileChooser.setFileFilter(new FileNameExtensionFilter("xml file","xml"));
		fileChooser.addChoosableFileFilter(filter);
		int returnValue = fileChooser.showSaveDialog(fileChooser);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			folderName = (fileChooser.getSelectedFile().getPath());
			this.setPath(folderName);
		}
		
	}
	
	public String getM_Path() {
		return m_Path;
	}

	public void setM_Path(String m_Path) {
		this.m_Path = m_Path;
	}

	public ArrayList<Shape> getM_ListShapes() {
		return m_ListShapes;
	}

	public void setM_ListShapes(ArrayList<Shape> m_ListShapes) {
		this.m_ListShapes = m_ListShapes;
	}

	public IFormatDataAndSave getM_formatDataAndSave() {
		return m_formatDataAndSave;
	}

	public void setM_formatDataAndSave(IFormatDataAndSave m_formatDataAndSave) {
		this.m_formatDataAndSave = m_formatDataAndSave;
	}
	
	
	
	

	/**
	 * Retourne le path
	 * @return the path
	 */
	public String getPath() {
		return this.m_Path;
	}

	/**
	 *Pour modifier le path
	 *@param p_path Nouvelle valeur 
	 */
	public void setPath(String p_path) {
		this.m_Path = p_path;
	}

	

}
