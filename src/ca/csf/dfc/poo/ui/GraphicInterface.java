package ca.csf.dfc.poo.ui;
import ca.csf.dfc.poo.classes.*;

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



public class  GraphicInterface extends JFrame{

	
	private WorkSpace m_workSpace = new WorkSpace();
	
	
	
	JButton m_btn_rectangle = new JButton("Rectangle");
    JButton m_btn_elipse = new JButton("Elipse");
    JButton m_btn_line = new JButton("Ligne");
    //private Point m_initialPoint;
    //private Point m_finalPoint;
    
    //test
    //JLabel m_testShapeName = new JLabel("nom");
    //JLabel m_testP1 = new JLabel("p1");
    //JLabel m_testP2 = new JLabel("p2");
    //fin
    
    
	
	private static final long serialVersionUID = 1L;

	public GraphicInterface() {
  	  super("FenetrePrincipale");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());
     
      

      
      
      
      this.add(this.m_workSpace, BorderLayout.CENTER);
      //this.m_workSpace.addMouseListener(new MouseHandler());
      
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
		
        panneauForme.add(this.m_btn_elipse);
        panneauForme.add(this.m_btn_rectangle);
        panneauForme.add(this.m_btn_line);
        
        this.add(panneauForme, BorderLayout.WEST);
        
	}
	
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);
		this.setJMenuBar(menuBar);
		
	}
	

	

	
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
	
}
	
	

