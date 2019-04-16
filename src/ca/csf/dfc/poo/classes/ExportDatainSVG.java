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
 * Classe formatant les données de chaque forme pour une sauvegarde en SVG 
 * @author Maximilian
 *
 */
public class ExportDatainSVG implements IExportData {


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
