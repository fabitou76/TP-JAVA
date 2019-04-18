
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
import ca.csf.dfc.poo.interfaces.IImportShapes;


public class GraphicInterface extends JFrame{


	private WorkSpace m_workSpace = new WorkSpace();
	
	JButton m_btn_rectangle = new JButton(new ImageIcon("src/rectangle.png"));
    JButton m_btn_elipse = new JButton(new ImageIcon("src/ellipse.png"));
    JButton m_btn_line = new JButton(new ImageIcon("src/line.png"));
    JButton m_btn_clear = new JButton("Clear");
    
    /* Fabio */
    JButton m_btn_select = new JButton(new ImageIcon("src/select.png"));
    JButton m_btn_delete = new JButton(new ImageIcon("src/delete.png"));
    
    JButton m_btn_up = new JButton("Up");
    JButton m_btn_down = new JButton("Down");
    JButton m_btn_left = new JButton("Left");
    JButton m_btn_right = new JButton("Right");
    
    JButton m_btn_size_up = new JButton("Size +");
    JButton m_btn_size_down = new JButton("Size -");
    
    /**/
    
    String[] m_ColorChoice = {"Aucune", "Blanc", "Noir", "Bleu", "Rouge", "Jaune", "Vert", "Orange"};
    Integer[] m_BorderWidthOptions = {1, 2, 3, 4, 5};
    
    
    JComboBox m_BorderColor = new JComboBox(m_ColorChoice);
    JComboBox m_FillColor = new JComboBox(m_ColorChoice);
    JComboBox m_BorderWidth = new JComboBox(m_BorderWidthOptions);

    JMenuBar menuBar = new JMenuBar();
    
    JMenu m_Fichier = new JMenu("Fichier");
    
    JMenuItem m_newDrawing = new JMenuItem("Nouveau dessin");
    JMenuItem m_loadXML = new JMenuItem("Charger");
    JMenuItem m_saveXML = new JMenuItem("Sauvegarder");
    JMenuItem m_exportSVG = new JMenuItem("Exporter");
    
    

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
		JPanel panneauBorderColor = new JPanel();
		panneauBorderColor.setLayout(new GridLayout(2, 1));
		JPanel panneauFillColor = new JPanel();
		panneauFillColor.setLayout(new GridLayout(2, 1));
		JPanel panneauBorderWidth = new JPanel();
		panneauBorderWidth.setLayout(new GridLayout(2, 1));
		
		/* Fabio */
		
		JPanel panneauShapeProperties = new JPanel();
		panneauShapeProperties.setLayout(new GridLayout(8, 1));
		panneauShapeProperties.add(this.m_btn_up);
		panneauShapeProperties.add(this.m_btn_down);
		panneauShapeProperties.add(this.m_btn_left);
		panneauShapeProperties.add(this.m_btn_right);
		panneauShapeProperties.add(this.m_btn_size_up);
		panneauShapeProperties.add(this.m_btn_size_down);
		
		this.m_btn_up.addActionListener(new ShapePositionHandler());
		this.m_btn_down.addActionListener(new ShapePositionHandler());
		this.m_btn_left.addActionListener(new ShapePositionHandler());
		this.m_btn_right.addActionListener(new ShapePositionHandler());
	    
		this.m_btn_size_up.addActionListener(new ShapeSizeHandler());
		this.m_btn_size_down.addActionListener(new ShapeSizeHandler());
		/**/
		
		this.m_btn_elipse.addActionListener(new ShapeBtnHandler());
		this.m_btn_line.addActionListener(new ShapeBtnHandler());
		this.m_btn_rectangle.addActionListener(new ShapeBtnHandler());
		this.m_btn_clear.addActionListener(new ClearBtnHandler());
		/* Fabio */
		this.m_btn_select.addActionListener(new SelectBtnHandler());
		this.m_btn_delete.addActionListener(new DeleteBtnHandler());
		/**/
		
		this.m_BorderColor.addActionListener(new ComboboxHandler());
		this.m_BorderWidth.addActionListener(new ComboboxHandler());
		this.m_FillColor.addActionListener(new ComboboxHandler());
		
		
        panneauForme.add(this.m_btn_elipse);
        panneauForme.add(this.m_btn_rectangle);
        panneauForme.add(this.m_btn_line);
        panneauForme.add(this.m_btn_clear);
        /* Fabio */
        panneauForme.add(this.m_btn_select);
        panneauForme.add(this.m_btn_delete);
        /* */        
        panneauForme.add(panneauBorderColor);
        panneauForme.add(panneauFillColor);
        panneauForme.add(panneauBorderWidth);
        
        panneauBorderColor.add(new JLabel("Border Color"));
        panneauFillColor.add(new JLabel("Fill Color"));
        panneauBorderWidth.add(new JLabel("Line Width"));
        panneauBorderColor.add(this.m_BorderColor);
        panneauFillColor.add(this.m_FillColor);
        panneauBorderWidth.add(this.m_BorderWidth);
    
        this.add(panneauForme, BorderLayout.NORTH);
        this.add(panneauShapeProperties, BorderLayout.EAST);
        
	}
	
	protected void disableEditShapeFields() {
		this.m_btn_up.setEnabled(false);
		this.m_btn_down.setEnabled(false);
		this.m_btn_left.setEnabled(false);
		this.m_btn_right.setEnabled(false);
		this.m_btn_size_up.setEnabled(false);
		this.m_btn_size_down.setEnabled(false);
	}
	
	protected void enableEditShapeFields() {
		this.m_btn_up.setEnabled(true);
		this.m_btn_down.setEnabled(true);
		this.m_btn_left.setEnabled(true);
		this.m_btn_right.setEnabled(true);
		this.m_btn_size_up.setEnabled(true);
		this.m_btn_size_down.setEnabled(true);
	}

	
	private void initMenu() {
		
		m_Fichier.add(m_newDrawing);
		m_Fichier.add(m_loadXML);
		m_Fichier.add(m_saveXML);
		m_Fichier.add(m_exportSVG);
		
		menuBar.add(m_Fichier);
		
		this.setJMenuBar(menuBar);
		
		m_saveXML.addActionListener(new GestSaveXML());
		m_loadXML.addActionListener(new GestChargerXML());
		m_exportSVG.addActionListener(new GestExportSVG());
		

	}
	
	/**
	 * 
	 * @author Maximilian
	 *
	 */
	
	
	private class GestSaveXML implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			
			try {
				ArrayList<Shape> listOfShapes = GraphicInterface.this.m_workSpace.getShapeList();
				new SaveShapesOnLocalDrive(new FormatDataToXML(listOfShapes)).saveData();
			} catch (FactoryConfigurationError | IOException | XMLStreamException e) {
				e.printStackTrace();
			};
			System.out.println("sauvegarde en cours");
		}
		
	}
	private class GestExportSVG implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			try {
				ArrayList<Shape> listOfShapes = GraphicInterface.this.m_workSpace.getShapeList();
				new SaveShapesOnLocalDrive(new FormatDataToSVG(listOfShapes)).saveData();
			} catch (FactoryConfigurationError | IOException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println("sauvegarde en cours");
		}
		
	}

	private class GestChargerXML  implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			IImportShapes importFromXML = new ImportShapesFromXML();
			ArrayList<Shape> listShapes = GraphicInterface.this.m_workSpace.getShapeList();
			importFromXML.setShapeList(listShapes);
			
			importFromXML.createShapes();
			
			
			GraphicInterface.this.m_workSpace.repaint();
		}
		
	}
	
	
	private class ComboboxHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			Object compt = p_arg0.getSource();
			if(compt.equals(GraphicInterface.this.m_BorderColor)) {
				if (GraphicInterface.this.m_workSpace.getSelectedShape() != null) {
					GraphicInterface.this.m_workSpace.getSelectedShape().setBorderColor(GraphicInterface.this.getBorderColor());
					GraphicInterface.this.m_workSpace.repaint();
				}
				
				GraphicInterface.this.m_workSpace.setSelectedBorderColor(GraphicInterface.this.getBorderColor());
			}
			else if (compt.equals(GraphicInterface.this.m_FillColor)) {

				if (GraphicInterface.this.m_workSpace.getSelectedShape() != null) {
					GraphicInterface.this.m_workSpace.getSelectedShape().setFillColor(GraphicInterface.this.getFillColor());
					GraphicInterface.this.m_workSpace.repaint();
				}
				
				GraphicInterface.this.m_workSpace.setSelectedFillColor(GraphicInterface.this.getFillColor());
			}
			else if(compt.equals(GraphicInterface.this.m_BorderWidth)){
				if (GraphicInterface.this.m_workSpace.getSelectedShape() != null) {
					GraphicInterface.this.m_workSpace.getSelectedShape().setBorderWidth(GraphicInterface.this.getBorderWidth());
					GraphicInterface.this.m_workSpace.repaint();
				}
				
				GraphicInterface.this.m_workSpace.setSelectedBorderWidth(GraphicInterface.this.getBorderWidth());
			}
		}
	}
	
	
	private class ShapeSizeHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			Object compt = p_arg0.getSource();
			if (GraphicInterface.this.m_workSpace.getSelectedShape() != null) {
				if(compt.equals(GraphicInterface.this.m_btn_size_up)) {
				
					int width = GraphicInterface.this.m_workSpace.getSelectedShape().getWidth();
					int height = GraphicInterface.this.m_workSpace.getSelectedShape().getHeight();
					Point finalPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getFinalPoint();
					
					GraphicInterface.this.m_workSpace.getSelectedShape().setHeight(height+1);
					GraphicInterface.this.m_workSpace.getSelectedShape().setWidth(width+1);
					finalPoint.x = finalPoint.x + 1;
					finalPoint.y = finalPoint.y + 1;
					
					GraphicInterface.this.m_workSpace.repaint();
				
				} else if(compt.equals(GraphicInterface.this.m_btn_size_down)) {
					int width = GraphicInterface.this.m_workSpace.getSelectedShape().getWidth();
					int height = GraphicInterface.this.m_workSpace.getSelectedShape().getHeight();
					Point finalPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getFinalPoint();
					
					if (height > 1 && width > 1) {
						GraphicInterface.this.m_workSpace.getSelectedShape().setHeight(height-1);
						GraphicInterface.this.m_workSpace.getSelectedShape().setWidth(width-1);
						finalPoint.x = finalPoint.x - 1;
						finalPoint.y = finalPoint.y - 1;
						
						GraphicInterface.this.m_workSpace.repaint();
					}
				} 
			}
			
		}
		
	}
	
	
	private class ShapePositionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			Object compt = p_arg0.getSource();
			
			if (GraphicInterface.this.m_workSpace.getSelectedShape() != null) {
				if(compt.equals(GraphicInterface.this.m_btn_up)) {
					Point initialPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getInitialPoint();
					Point finalPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getFinalPoint();
					
					if (initialPoint.y > 1) {
						initialPoint.y = initialPoint.y - 1;
						
						finalPoint.y = finalPoint.y - 1;
						
						GraphicInterface.this.m_workSpace.repaint();
					}
				} else if(compt.equals(GraphicInterface.this.m_btn_down)) {
					Point initialPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getInitialPoint();
					Point finalPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getFinalPoint();
				
					initialPoint.y = initialPoint.y + 1;
					
					finalPoint.y = finalPoint.y + 1;
					
					GraphicInterface.this.m_workSpace.repaint();
					
				} else if(compt.equals(GraphicInterface.this.m_btn_left)) {
					Point initialPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getInitialPoint();
					Point finalPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getFinalPoint();
					
					if (initialPoint.x > 1) {
						initialPoint.x = initialPoint.x - 1;
						
						finalPoint.x = finalPoint.x - 1;
						
						GraphicInterface.this.m_workSpace.repaint();
					}
				} else if(compt.equals(GraphicInterface.this.m_btn_right)) {
					Point initialPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getInitialPoint();
					Point finalPoint = GraphicInterface.this.m_workSpace.getSelectedShape().getFinalPoint();
				
					initialPoint.x = initialPoint.x + 1;
					
					finalPoint.x = finalPoint.x + 1;
					
					GraphicInterface.this.m_workSpace.repaint();
				}
			}
			
		}		
	}

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
			GraphicInterface.this.m_workSpace.clearShapeSelection();
		}
		
	}
	
	private class ClearBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			GraphicInterface.this.m_workSpace.getShapeList().clear();
			GraphicInterface.this.m_workSpace.repaint();
		}
	}
	
	/* Fabio */
	private class SelectBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			GraphicInterface.this.m_workSpace.setSelectedShape("select");
			GraphicInterface.this.m_workSpace.m_testShapeName.setText("select");
		}
	}
	
	private class DeleteBtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_arg0) {
			Shape selectedShape = GraphicInterface.this.m_workSpace.getSelectedShape();
			if (selectedShape != null) {
				GraphicInterface.this.m_workSpace.removeShape(selectedShape);
			}
			
		}
	}
	/* Fabio */
	
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
		
		if(p_selectedColor == 1)
			chosenColor = Color.WHITE;
		else if(p_selectedColor == 2)
			chosenColor = Color.BLACK;
		else if(p_selectedColor == 3)
			chosenColor = Color.BLUE;
		else if(p_selectedColor == 4)
			chosenColor = Color.RED;
		else if(p_selectedColor == 5)
			chosenColor = Color.YELLOW;
		else if(p_selectedColor == 6)
			chosenColor = Color.GREEN;
		else if(p_selectedColor == 7)
			chosenColor = Color.ORANGE;
		
		return chosenColor;
	}
	
	
	
	
}
