/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
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
public interface IFormatDataAndSave {


	
	public void exportRectangle(Rectangle p_Rectangle) throws XMLStreamException;
	public void exportLine(Line p_Line) throws XMLStreamException;
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException;
	public ArrayList<Shape> getShapeList();
	public void formatAndSave(String p_folderName) throws IOException, XMLStreamException, FactoryConfigurationError;
	String checkFileExtension(String p_folderName);

}
