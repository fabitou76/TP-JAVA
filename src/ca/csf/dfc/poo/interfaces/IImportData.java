/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
public interface IImportData {
	public String getPathToImportFrom();
	public void importData(Shape p_shape);

}
