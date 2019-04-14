/**
 * 
 */
package ca.csf.dfc.poo.classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ca.csf.dfc.poo.interfaces.IImportData;

/**
 * @author Maximilian
 *
 */
public class ImportDataFromXML implements IImportData {
	
	private final static String ELM_SHAPE = "shape"; 
	private final static String ELM_TYPE = "type"; 
	private final static String ELM_COORD = "coord"; 
	private final static String ELM_STYLE = "style"; 
	private final static String ATTR_INIT_POINT = "initialPoint"; 
	private final static String ATTR_FINAL_POINT = "finalPoint";
	private final static String ATTR_BORDER_COLOR = "borderColor";
	private final static String ATTR_BORDER_WIDTH = "borderWidth";
	private final static String ATTR_FILL_COLOR= "fillColor";

	
	 private XMLStreamReader documentXML = null;
	 private List<Shape> m_ListShapes;
	 private FileReader input;
	 private String  pathToImportFrom;
	  /**
	   * constructeur
	   * @param p_ListShapes
	   */
	 public ImportDataFromXML(List<Shape>p_ListShapes)  {
		 this.m_ListShapes = p_ListShapes;
	 }
	 
	 /**
	  * charge les données XML dans la liste des shapes
	  * @throws XMLStreamException
	  * @throws FactoryConfigurationError
	  */

	 public void  dataLoader () throws XMLStreamException, FactoryConfigurationError {
		 try {

			 FileReader input=new FileReader(new File("data.xml"));

//			 input=new FileReader(new File(pathToImportFrom));


			 documentXML = XMLInputFactory.newInstance().createXMLStreamReader(input);
			 
			 documentXML.next();
			 if (!documentXML.getLocalName().equals("ListofShapes")) {
	                throw new XMLStreamException(
	                    "Pas la bonne racine : " + documentXML.getLocalName());
	            }
			 documentXML.next();
			 
			 while(documentXML.isStartElement()) {
				 //lire quelle forme il faut créer
				 String elementType = documentXML.getLocalName();
				 String shapeType  = documentXML.getAttributeValue("", ELM_TYPE);
				 documentXML.next();
				 String coord = documentXML.getLocalName();//devrait etre coord
				 String finalPoint= documentXML.getAttributeValue("", ATTR_FINAL_POINT);
				 String  initialPoint  = documentXML.getAttributeValue("", ATTR_INIT_POINT);
				 documentXML.next();
				 documentXML.next();
				 String style = documentXML.getLocalName();//devrait etre style
				 String fillColor = documentXML.getAttributeValue("", ATTR_FILL_COLOR);
				 String borderWidth = documentXML.getAttributeValue("", ATTR_BORDER_WIDTH);
				 String borderColor = documentXML.getAttributeValue("", ATTR_BORDER_COLOR);
				 documentXML.next();documentXML.next();
				 documentXML.next();
				 System.out.println(elementType+shapeType+coord+
						 finalPoint+initialPoint+style+fillColor+borderWidth+borderColor);
			 }
			 
		 }catch (IOException exp) {
			 System.err.println("Erreur de lecture de fichier : " + exp);
		 }
	 }

	@Override
	public String getPathToImportFrom() {
		JFileChooser path = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter (
										"XML files", "xml");
		path.setFileFilter(filter);
		int returnVal = path.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return path.getSelectedFile().getName();
		}
		
		return null;
	}

}
