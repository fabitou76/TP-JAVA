/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Cette interface doit permettre au système de se connecter à différents supports de données
 * @author Maximilian
 *
 */
public interface IConnectToDB {
	public void  selectDataFolder();
	public void connectToDB() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError;
	public void closeConnection() throws XMLStreamException;
	void connect() throws FileNotFoundException, XMLStreamException, FactoryConfigurationError;
	public XMLStreamReader getXMLDoc(); 
	// CRITIQUE : théoriquement la fonction XMLStreamReaderne devrait pas se trouver ici. 
	// C est une marque de couplage qu'il faudrait corriger dans une autre étape

}
