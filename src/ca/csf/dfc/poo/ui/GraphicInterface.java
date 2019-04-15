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
import java.awt.Color;
import java.util.*;
import java.awt.color.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;




import ca.csf.dfc.poo.classes.*;
import ca.csf.dfc.poo.classes.Shape;


public class GraphicInterface extends JFrame{


	private WorkSpace m_workSpace = new WorkSpace();
	
	JButton m_btn_rectangle = new JButton(new ImageIcon("src/rectangle.png"));
    JButton m_btn_elipse = new JButton(new ImageIcon("src/ellipse.png"));
    JButton m_btn_line = new JButton(new ImageIcon("src/line.png"));
    JButton m_btn_clear = new JButton("Clear");
    
    String[] m_ColorChoice = {"Aucune", "Blanc", "Noir", "Bleu", "Rouge", "Jaune", "Vert", "Orange"};
    Integer[] m_BorderWidthOptions = {1, 2, 3, 4, 5};
    
    
    JComboBox m_BorderColor = new JComboBox(m_ColorChoice);
    JComboBox m_FillColor = new JComboBox(m_ColorChoice);
    JComboBox m_BorderWidth = new JComboBox(m_BorderWidthOptions);
    
    JMenuBar menuBar = new JMenuBar();
    
    JMenu m_newDrawing = new JMenu("Nouveau dessin");
	JMenu m_loadXML = new JMenu("Charger");
	JMenu m_saveXML = new JMenu("Sauvegarder");
	JMenu m_exportSVG = new JMenu("Exporter");
    
    

	public GraphicInterface() {
  	  super("Dessin vectoriel");
  	  
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());
      this.setSize(800, 400);
      this.setLocationRelativeTo(null);

      this.initMenu();
      this.initShapeGrid();
      
      this.add(this.m_workSpace, BorderLayout.CENTER);
      
  
      
	}
	
	private void initShapeGrid() {
		JPanel panneauForme = new JPanel();
		panneauForme.setLayout(new GridLayout(1,10));
		
		this.m_btn_elipse.addActionListener(new ShapeBtnHandler());
		this.m_btn_line.addActionListener(new ShapeBtnHandler());
		this.m_btn_rectangle.addActionListener(new ShapeBtnHandler());
		this.m_btn_clear.addActionListener(new ClearBtnHandler());
		
        panneauForme.add(this.m_btn_elipse);
        panneauForme.add(this.m_btn_rectangle);
        panneauForme.add(this.m_btn_line);
        panneauForme.add(this.m_btn_clear);
        
        panneauForme.add(this.m_BorderColor);
        panneauForme.add(this.m_FillColor);
        panneauForme.add(this.m_BorderWidth);
    
        this.add(panneauForme, BorderLayout.NORTH);
        
	}

	
	private void initMenu() {
		
		menuBar.add(m_newDrawing);
		menuBar.add(m_loadXML);
		menuBar.add(m_saveXML);
		menuBar.add(m_exportSVG);
		
		this.setJMenuBar(menuBar);
		

	}

	private class GestChargerXML  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			ImportShapesFromXML importFromXML = new ImportShapesFromXML();
			ArrayList<Shape> listShapes = GraphicInterface.this.m_workSpace.getShapeList();
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
				new SaveToXML(GraphicInterface.this.m_workSpace.getShapeList()).dataSaver();
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
	
	public Integer getBorderWidth() {
		return  Integer.valueOf(this.m_BorderWidth.getSelectedItem().toString());
	}
	
	public Color getFillColor(){

		Color chosenColor = getColor(this.m_FillColor.getSelectedIndex());
	
		return chosenColor;
	}
	
	public Color getBorderColor(){

		Color chosenColor = getColor(this.m_BorderColor.getSelectedIndex());
		
		return chosenColor;
	}
	
	private Color getColor(int p_selectedColor) {
		
		Color chosenColor = null;
		
		if(p_selectedColor == 0)
			chosenColor = Color.WHITE;
		else if(p_selectedColor == 1)
			chosenColor = Color.BLACK;
		else if(p_selectedColor == 2)
			chosenColor = Color.BLUE;
		else if(p_selectedColor == 3)
			chosenColor = Color.RED;
		else if(p_selectedColor == 4)
			chosenColor = Color.YELLOW;
		else if(p_selectedColor == 5)
			chosenColor = Color.GREEN;
		else if(p_selectedColor == 6)
			chosenColor = Color.ORANGE;
		
		return chosenColor;
	}
	
	
}
