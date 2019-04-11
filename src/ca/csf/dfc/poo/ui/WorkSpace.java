package ca.csf.dfc.poo.ui;

import ca.csf.dfc.poo.classes.*;
import ca.csf.dfc.poo.classes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.sun.prism.paint.Color;



public class WorkSpace extends JPanel{

	private static final long serialVersionUID = 6100091375438707781L;
	private List<Shape> m_shapeList;
	private Point m_initialPoint;
	private Point m_finalPoint;
	private ShapeFactory m_shapeFactory = new ShapeFactory();
	private String m_selectedShape = "elipse";
	private int m_selectedColorFill;
	
	
	
	
    //test
    JLabel m_testShapeName = new JLabel("nom");
    JLabel m_testP1 = new JLabel("p1");
    JLabel m_testP2 = new JLabel("p2");
    //fin
    
    
	public WorkSpace() {
		super();
		//this.setForeground(Color.BLACK);
		this.m_shapeList = new ArrayList<Shape>();
		
      
       //Panel test
        JPanel panelTest = new JPanel();
        panelTest.setLayout(new GridLayout(3,1));
        panelTest.add(m_testShapeName);
        panelTest.add(m_testP1);
        panelTest.add(m_testP2);
        this.add(panelTest, BorderLayout.EAST);
       //fin test

	    this.addMouseListener(new MouseHandler());
	      
	}
	
	
	public List<Shape> getShapeList(){
		return this.m_shapeList;
	}
	
	
	public void setSelectedShape(String p_shapeType) {
		this.m_selectedShape = p_shapeType;
	}
	
	
	
	/*
	public void addShape(Shape p_shape) {
		this.m_shapeList.add(p_shape);
	}
	*/
	
	private void addShapeToWorkSpace() {
		Shape shape = this.m_shapeFactory.createShape(this.m_selectedShape, this.m_initialPoint, this.m_finalPoint);
		this.m_shapeList.add(shape);
		//test
		System.out.println("--------Début liste workspace---------");
		for(Shape s: this.m_shapeList) {
			System.out.println("-"+s.toString());
			System.out.println(s.getInitialPoint().toString() + "  " + s.getFinalPoint().toString());
			System.out.println("Hauteur:" + s.getHeight() + " " + "Largeur:" + s.getWidth());
		}
		System.out.println("--------Fin liste workspace---------");
		//fin
		this.repaint();
		this.m_initialPoint = null;
		this.m_finalPoint = null;
	}
	
	
	@Override
	protected void paintComponent(Graphics p_Graphic) {
		super.paintComponent(p_Graphic);		
		if(!this.m_shapeList.isEmpty()) {
			for(Shape shape : this.m_shapeList) {
				
				int coordX2, coordY2, width, height,coordX1,coordY1;
				switch (shape.getName()) {
				case "rectangle":
					height = shape.getHeight();
					width = shape.getWidth();
					coordX1 = shape.getInitialPoint().x;
					coordY1 = shape.getInitialPoint().y;
					p_Graphic.drawRect(coordX1,coordY1, width, height);
					break;
				case "line":
					coordX1 = shape.getInitialPoint().x;
					coordY1 = shape.getInitialPoint().y;
					coordX2 = shape.getFinalPoint().x;
					coordY2 = shape.getFinalPoint().y;
					p_Graphic.drawLine(coordX1, coordY1, coordX2, coordY2);
					break;
				case "elipse":
					height = shape.getHeight();
					width = shape.getWidth();
					coordX1 = shape.getInitialPoint().x;
					coordY1 = shape.getInitialPoint().y;
					p_Graphic.drawOval(coordX1,coordY1, width, height);
				default:
					break;
					
				
				}
			}
		}
		
	}
	
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent p_arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent p_arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent p_arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent p_arg0) {
			Point point = new Point();
			if(WorkSpace.this.m_initialPoint == null) {
				point.x = p_arg0.getX();
				point.y = p_arg0.getY();
				WorkSpace.this.m_initialPoint = point;
				WorkSpace.this.m_testP1.setText(WorkSpace.this.m_initialPoint.toString());
				
			}
			else if (WorkSpace.this.m_finalPoint == null) {
				point.x = p_arg0.getX();
				point.y = p_arg0.getY();
				WorkSpace.this.m_finalPoint = point;
				WorkSpace.this.m_testP2.setText(WorkSpace.this.m_finalPoint.toString());
			}
			
			if(WorkSpace.this.m_initialPoint != null && WorkSpace.this.m_finalPoint != null) {
				WorkSpace.this.addShapeToWorkSpace();
				//FenetrePrincipal.this.drawShapes();
				
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent p_arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	
}
