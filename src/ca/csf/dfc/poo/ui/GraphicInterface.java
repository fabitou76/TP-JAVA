package ca.csf.dfc.poo.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.sun.prism.paint.Color;

//<<<<<<< HEAD
import ca.csf.dfc.poo.classes.*;

public class  GraphicInterface extends JFrame{

	private static final long serialVersionUID = 1L;
//=======
//

	// TEST POUR HUGO
//>>>>>>> master
	private WorkSpace m_workSpace = new WorkSpace();
	
	JButton m_btn_rectangle = new JButton(new ImageIcon("src/rectangle.png"));
    JButton m_btn_elipse = new JButton(new ImageIcon("src/ellipse.png"));
    JButton m_btn_line = new JButton(new ImageIcon("src/line.png"));
    JButton m_btn_clear = new JButton("Clear");
    
    String[] m_ColorChoice = {"Aucune", "Blanc", "Noir", "Bleu", "Rouge", "Jaune", "Vert", "Orange", "Mauve"};
    Double[] m_BorderWidthOptions = {0.5, 1.0, 1.5, 2.0};
    
    
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
	
	public Color getFillColor(){
		
	    String[] m_ColorChoice = {"Aucune", "Blanc", "Noir", "Bleu", "Rouge", "Jaune", "Vert", "Orange", "Mauve"};

		int selectedColor = this.m_FillColor.getSelectedIndex();
		
		Color chosenColor = Color.TRANSPARENT;
		
		Switch (selectedColor){
			case 1:
				color = Color.WHITE;
				break;
			case 2:
				color = Color.BLACK;
				break;
			default:
				color = Color.TRANSPARENT;
				break;
			
			
			
		}
		
		
		
		
		return Color.BLACK;
	}


	private void Switch(Object selectedColor) {
		// TODO Auto-generated method stub
		
	}
}
	

