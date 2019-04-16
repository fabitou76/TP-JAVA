/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.poo.classes.Elipse;
import ca.csf.dfc.poo.classes.Line;
import ca.csf.dfc.poo.classes.Rectangle;
import ca.csf.dfc.poo.classes.Shape;
import javafx.scene.shape.Ellipse;

/**
 * Interface pour formater les données des objets Shape dans un format particulier (ex: XML,SCG, etc.) 
 * @author Maximilian
 *
 */
public interface IExportData {
//	public void SaveData();
//	public String getFolderPath();
//	public void collectData();
//	public void writeDataInDocument();
//	public List<Shape> getShapeList();
	
	public void exportRectangle(Rectangle p_Rectangle) throws XMLStreamException;
	public void exportLine(Line p_Line) throws XMLStreamException;
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException;
	public void setXMLStreamWriter(XMLStreamWriter p_xmlDoc); // a supprimer la référence ici à un format en particulier. rendre plus générique 
	

//	public void SaveData();
//	public String getFolderPath();
//	public void collectData();
//	public void writeDataInDocument();
//	public List<Shape> getShapeList();
//	public String getPathToSave();

}
