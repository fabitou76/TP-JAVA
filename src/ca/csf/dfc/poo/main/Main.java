package ca.csf.dfc.poo.main;


import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import ca.csf.dfc.poo.classes.ReadDataXML;
import ca.csf.dfc.poo.ui.*;

public class Main {

	public static void main(String[] args) throws XMLStreamException, FactoryConfigurationError {
//		new GraphicInterface().setVisible(true);
		new ReadDataXML();
	}

}
