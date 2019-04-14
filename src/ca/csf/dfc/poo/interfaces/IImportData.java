/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
public interface IImportData {
	void importDataEllipse(Shape p_shape);
	void importDataLine(Shape p_shape);
	void importDataRectangle(Shape p_shape);
	


}
