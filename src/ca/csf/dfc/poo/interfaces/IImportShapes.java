/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
public interface IImportShapes {
	
	public void generateShapes() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError;

	void setShapeList(List<Shape> p_shapeList);

}
