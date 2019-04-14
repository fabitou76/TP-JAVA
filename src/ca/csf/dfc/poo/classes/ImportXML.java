/**
 * 
 */
package ca.csf.dfc.poo.classes;

import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IImportData;

/**
 * @author Maximilian
 *
 */
public class ImportXML implements IImportData {
	
	private XMLStreamReader m_xmlDoc = null;
	
	/**
	 * ctr
	 */
	public ImportXML (XMLStreamReader p_xmlDoc) {
		this.m_xmlDoc = p_xmlDoc;
	}
	


	@Override
	public void importDataLine(Shape p_shape) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void importDataEllipse(Shape p_shape) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void importDataRectangle(Shape p_shape) {
		// TODO Auto-generated method stub
		
	}
	
	


}
