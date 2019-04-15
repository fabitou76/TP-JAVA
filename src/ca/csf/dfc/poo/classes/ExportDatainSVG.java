/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import ca.csf.dfc.poo.interfaces.IExportData;
import javafx.scene.shape.Ellipse;

/**
 * @author Maximilian
 *
 */
public class ExportDatainSVG implements IExportData {

//	@Override
//	public void SaveData() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getFolderPath() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void collectData() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void writeDataInDocument() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Shape> getShapeList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void exportRectangle(String[] p_shapeData) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void exportLine(Line p_shapeData) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void exportRectangle(Rectangle  p_shapeData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportEllipse(Elipse p_Ellipse) throws XMLStreamException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setXMLStreamWriter(XMLStreamWriter p_xmlDoc) {
		// TODO Auto-generated method stub
		
	}

}
