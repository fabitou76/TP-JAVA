/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.util.List;

import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
public interface ISaveData {
	public void SaveData();
	public String getFolderPath();
	public void collectData();
	public void writeDataInDocument();
	public List<Shape> getShapeList();


}
