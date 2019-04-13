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
public interface IExportData {
//	public void SaveData();
//	public String getFolderPath();
//	public void collectData();
//	public void writeDataInDocument();
//	public List<Shape> getShapeList();
	
	public void exportRectangle(String[] p_shapeData);
	public void exportLine(String[] p_shapeData);
	public void exportEllipse(String[] p_shapeData);


}
