/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

/**
 * @author Maximilian
 *
 */
public interface IConnectToDB {
	public void  selectDataFolder();
	public void connectToDB() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError;
	public void closeConnection() throws XMLStreamException;

}
