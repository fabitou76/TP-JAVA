/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

/**
 * @author Maximilian
 *
 */
public interface IReadData {
	public void selectFolder();
	public void dataLoader() throws XMLStreamException, FactoryConfigurationError;
}
