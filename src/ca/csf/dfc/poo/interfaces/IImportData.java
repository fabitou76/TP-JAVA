/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.classes.Elipse;
import ca.csf.dfc.poo.classes.Line;
import ca.csf.dfc.poo.classes.Rectangle;
import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
public interface IImportData {
<<<<<<< Updated upstream
	Elipse importDataEllipse(Elipse p_shape) throws XMLStreamException;
	Line importDataLine(Line p_shape) throws XMLStreamException;
	Rectangle importDataRectangle(Rectangle p_shape) throws XMLStreamException;
	

=======
	public String getPathToImportFrom();
>>>>>>> Stashed changes

}
