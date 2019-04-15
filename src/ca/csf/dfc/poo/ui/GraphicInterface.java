package ca.csf.dfc.poo.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.awt.color.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import com.sun.prism.paint.Color;


import ca.csf.dfc.poo.classes.*;

public class  GraphicInterface extends JFrame{

	private static final long serialVersionUID = 1L;



	// TEST POUR HUGO
	private WorkSpace m_workSpace = new WorkSpace();
	
	JButton m_btn_rectangle = new JButton("Rectangle");
    JButton m_btn_elipse = new JButton("Elipse");
    JButton m_btn_line = new JButton("Ligne");
    JButton m_btn_clear = new JButton("Clear");
    

	public GraphicInterface() {
  	  super("FenetrePrincipale");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());
      this.add(this.m_workSpace);
      this.m_workSpace.setSize(150, 150);
      

      this.initMenu();
      this.initShapeGrid();
      
      this.setSize(800, 400);
      this.setLocationRelativeTo(null);
      
	}
	
	private void initShapeGrid() {
		JPanel panneauForme = new JPanel();
		panneauForme.setLayout(new GridLayout(3,1));
		
		this.m_btn_elipse.addActionListener(new ShapeBtnHandler());
		this.m_btn_line.addActionListener(new ShapeBtnHandler());
		this.m_btn_rectangle.addActionListener(new ShapeBtnHandler());
		this.m_btn_clear.addActionListener(new ClearBtnHandler());
		
        panneauForme.add(this.m_btn_elipse);
        panneauForme.add(this.m_btn_rectangle);
        panneauForme.add(this.m_btn_line);
        panneauForme.add(this.m_btn_clear);
        
        this.add(panneauForme, BorderLayout.WEST);
	}
	
	
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem menuSauvegarderXML = new JMenuItem("Sauvegarder XML");
		JMenuItem menuChargerXML = new JMenuItem("Charger XML");
		menuFichier.add(menuSauvegarderXML);
		menuFichier.add(menuChargerXML);
		menuBar.add(menuFichier);
		this.setJMenuBar(menuBar);
		
		menuSauvegarderXML.addActionListener(new GestSaveXML());
		menuChargerXML.addActionListener(new GestChargerXML());
	}

	private class GestChargerXML  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			ImportShapesFromXML importFromXML = new ImportShapesFromXML();
			ArrayList<Shape> listShapes = GraphicInterface.this.m_workSpace.getList();
			importFromXML.setShapeList(listShapes);
			
			try {
				importFromXML.createShapes();
			} catch (FileNotFoundException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			GraphicInterface.this.m_workSpace.repaint();
		}
		
	}
	
	private class GestSaveXML implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			
			try {
				new SaveToXML(GraphicInterface.this.m_workSpace.getList()).dataSaver();
			} catch (XMLStreamException | FactoryConfigurationError | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println("sauvegarde en cours");
			
		}
		
	}
	
	/**
	 * 
	 * @author Maximilian
	 *
	 */
//	private class GestLoadXML implements ActionListener {
//
//
//		public void actionPerformed(ActionEvent p_arg0) {
//			
//			try {
//				new SaveToXML(GraphicInterface.this.m_workSpace.getList()).FileWriter();
//			} catch (XMLStreamException | FactoryConfigurationError | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
	

	
	//OK
	private class ShapeBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			String itemSelected = "";
			Object compt = p_arg0.getSource();
			if(compt.equals(GraphicInterface.this.m_btn_elipse)) {
				GraphicInterface.this.m_workSpace.setSelectedShape("elipse");
				itemSelected = "elipse";
			}
			else if (compt.equals(GraphicInterface.this.m_btn_line)) {
				GraphicInterface.this.m_workSpace.setSelectedShape("line");
				itemSelected = "line";
			}
			else if(compt.equals(GraphicInterface.this.m_btn_rectangle)){
				GraphicInterface.this.m_workSpace.setSelectedShape("rectangle");
				itemSelected = "rectangle";
			}
			
			
			GraphicInterface.this.m_workSpace.m_testShapeName.setText(itemSelected);
		}
		
	}
	
	private class ClearBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			GraphicInterface.this.m_workSpace.getShapeList().clear();
			GraphicInterface.this.m_workSpace.repaint();
		}
	}
}
	
	

