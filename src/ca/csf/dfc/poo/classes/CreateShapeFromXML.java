/**
 * 
 */
package ca.csf.dfc.poo.classes;

import ca.csf.dfc.poo.interfaces.ICreateShapeFromData;
import ca.csf.dfc.poo.interfaces.IImportData;

/**
 * @author Maximilian
 *
 */
public class CreateShapeFromXML implements ICreateShapeFromData {
	IImportData m_importXML = new ImportXML();
	
	
	/**
	 * ctr
	 */
	
	public CreateShapeFromXML(ImportXML p_importXML) {
		
	}

}
