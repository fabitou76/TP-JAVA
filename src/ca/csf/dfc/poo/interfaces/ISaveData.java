/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

/**
 * @author Maximilian
 *
 */
public interface ISaveData {
	public void selectFolder();
	public void saveData() throws IOException, XMLStreamException, FactoryConfigurationError;

}
