/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.classes.Elipse;
import ca.csf.dfc.poo.classes.Line;
import ca.csf.dfc.poo.classes.Rectangle;

/**
 * Interface permettant  d'importer les données de formes pour ensuite les générer sous formes d'objet Shape
 * @author Maximilian
 *
 */
public interface IGenerateShapes {

	Elipse importDataEllipse(Elipse p_shape) throws XMLStreamException;
	Line importDataLine(Line p_shape) throws XMLStreamException;
	Rectangle importDataRectangle(Rectangle p_shape) throws XMLStreamException;
}
