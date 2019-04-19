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
import ca.csf.dfc.poo.interfaces.ISaveShapes;

/**
 * Classe utilisée pour sauvegarder sur le disque local les formes en mémoire / affichées
 * le format de convertion est passé en paramètre
 * @author Maximilian
 * @param format de convertion souhaité pour la sauvegarde des données
 *
 */
public class SaveShapesOnLocalDrive implements ISaveShapes {
	
	/**
	 * DONNEES MEMBRES
	 */
	
	private String m_Path = null;
	ArrayList<Shape> m_ListShapes;
	IFormatDataAndSave m_formatDataAndSave = null;
	
	

	/**
	 * constructeur
	 */
	public SaveShapesOnLocalDrive(IFormatDataAndSave p_formatDataAndSave) {
		this.m_formatDataAndSave = p_formatDataAndSave;
		this.m_ListShapes = this.m_formatDataAndSave.getShapeList();
		
	}
	
	/**
	 * permet à l'utilisateur de sélectionner le dossier de sauvegarde de ses données en format XML
	 */
	@Override
	public void saveData() throws IOException, XMLStreamException, FactoryConfigurationError {
		
		if (this.m_ListShapes != null && !this.m_ListShapes.isEmpty()) {
			selectFolder();
			}
		if (this.getM_Path() != null ) {
			m_formatDataAndSave.formatAndSave(this.getM_Path());
		}
		
		
	}
	
	
	/**
	 * Fenêtre permettant à l'utilisateur de parcourir les dossiers de son système pour sauvegarder ses formes
	 */
	@Override
	public void selectFolder() {
		String folderName = null;
		
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("SÃ©lectionnez un dossier");
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
	
	/**
	 * Pour returner le path.
	 * @return le path
	 */
	public String getM_Path() {
		return m_Path;
	}
	
	/**
	 * Pour modifier le path.
	 * @param m_Path le path
	 */
	public void setM_Path(String m_Path) {
		this.m_Path = m_Path;
	}
	
	/**
	 * Pour returner une liste de shapes.
	 * @return la liste de shapes
	 */
	public ArrayList<Shape> getM_ListShapes() {
		return m_ListShapes;
	}
	
	/**
	 * Pour modifier la liste de shapes
	 * @param m_ListShapes la liste de shapes
	 */
	public void setM_ListShapes(ArrayList<Shape> m_ListShapes) {
		this.m_ListShapes = m_ListShapes;
	}
	
	/**
	 * Pour returner type de formatage du fichier
	 * @return le type de formatage
	 */
	public IFormatDataAndSave getM_formatDataAndSave() {
		return m_formatDataAndSave;
	}
	
	/**
	 * Pour modifier le type de formatage
	 * @param m_formatDataAndSave le type de formatage
	 */
	public void setM_formatDataAndSave(IFormatDataAndSave m_formatDataAndSave) {
		this.m_formatDataAndSave = m_formatDataAndSave;
	}

	/**
	 *Pour modifier le path
	 *@param p_path Nouvelle valeur 
	 */
	public void setPath(String p_path) {
		this.m_Path = p_path;
	}

	

}
