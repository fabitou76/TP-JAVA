/**
 * 
 */
package ca.csf.dfc.poo.classes.leurres;

import java.io.IOException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.interfaces.ISaveShapes;

/**
 * @author Maximilian
 *
 */
public class SaveShapesOnLocalDrive_pourTest implements ISaveShapes {
	
	private int m_compteurAppelConstructeur;
	private int m_compteurAppel;
	
	public SaveShapesOnLocalDrive_pourTest() {
		this.m_compteurAppelConstructeur = 0;
	}

	@Override
	public void selectFolder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveData() throws IOException, XMLStreamException, FactoryConfigurationError {
		// TODO Auto-generated method stub
		
	}
	
//	public int getM_CompteurDAppel() {
//		return this.m_compteurDAppel;
//	}
	
	

}
