/**
 * 
 */
package ca.csf.dfc.poo.interfaces;

import java.util.ArrayList;
import java.util.List;

import ca.csf.dfc.poo.classes.Shape;

/**
 * @author Maximilian
 *
 */
public interface IExportData {
<<<<<<< Updated upstream
//	public void SaveData();
//	public String getFolderPath();
//	public void collectData();
//	public void writeDataInDocument();
//	public List<Shape> getShapeList();
	
	public void exportRectangle(ArrayList p_shapeData);
	public void exportLine(ArrayList p_shapeData);
	public void exportEllipse(ArrayList p_shapeData);
=======
	public void SaveData();
	public String getFolderPath();
	public void collectData();
	public void writeDataInDocument();
	public List<Shape> getShapeList();
	public String getPathToSave();
>>>>>>> Stashed changes


}
