package ca.csf.dfc.poo.ui;

import ca.csf.dfc.poo.classes.*;
import ca.csf.dfc.poo.classes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class WorkSpace extends JPanel{

	private static final long serialVersionUID = 6100091375438707781L;
	
	private static final Color DEFAULT_BORDER_COLOR = Color.black;
	private static final int DEFAULT_BORDER_WIDTH = 1;
	private static final String DEFAULT_SHAPE = "elipse";
	
	private List<Shape> m_shapeList;
	private Point m_initialPoint;
	private Point m_finalPoint;
	private ShapeFactory m_shapeFactory = new ShapeFactory();
	
	private String m_selectedShape = DEFAULT_SHAPE;
	private int m_selectedBorderWidth = DEFAULT_BORDER_WIDTH;
	private Color m_selectedBorderColor = DEFAULT_BORDER_COLOR;
	private Color m_selectedFillColor = null;
	
	
    //test
    JLabel m_testShapeName = new JLabel("nom");
    JLabel m_testP1 = new JLabel("p1");
    JLabel m_testP2 = new JLabel("p2");
    //fin
    
	public WorkSpace() {
		super();
		this.setBackground(Color.white);
		this.m_shapeList = new ArrayList<Shape>();
		this.addMouseListener(new MouseHandler());

	
       //Panel test
        JPanel panelTest = new JPanel();
        panelTest.setLayout(new GridLayout(3,1));
        panelTest.add(m_testShapeName);
        panelTest.add(m_testP1);
        panelTest.add(m_testP2);
        this.add(panelTest);
       //fin test

	}
	
	public List<Shape> getShapeList(){
		return this.m_shapeList;
	}
	
	public void setSelectedFillColor(Color p_color) {
		this.m_selectedFillColor = p_color;
	}
	
	public void setSelectedBorderWidth(int p_width) {
		this.m_selectedBorderWidth = p_width;
	}
	
	public void setSelectedBorderColor(Color p_color) {
		this.m_selectedBorderColor = p_color;
	}
	
	public void setSelectedShape(String p_shapeType) {
		this.m_selectedShape = p_shapeType;
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
		
			if(WorkSpace.this.m_initialPoint == null) {
				Point point = new Point();
				point.x = p_arg0.getX();
				point.y = p_arg0.getY();
				WorkSpace.this.m_initialPoint = point;
				WorkSpace.this.m_testP1.setText(WorkSpace.this.m_initialPoint.toString()); //test
			}
			else if (WorkSpace.this.m_finalPoint == null) {
				Point point = new Point();
				point.x = p_arg0.getX();
				point.y = p_arg0.getY();
				WorkSpace.this.m_finalPoint = point;
				WorkSpace.this.m_testP2.setText(WorkSpace.this.m_finalPoint.toString()); //test
			}
			
			if(WorkSpace.this.coordinatesAreSet()) {
				Shape newShape = WorkSpace.this.createShape();
				WorkSpace.this.addShapeToWorkSpace(newShape);

				WorkSpace.this.refreshWorkSpace();
			

				WorkSpace.this.resetCoordinates();
			}
		}

		@Override
		public void mouseReleased(MouseEvent p_arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	

	private boolean coordinatesAreSet() {

		boolean coordsAreSet = false;
		if(WorkSpace.this.m_initialPoint != null && WorkSpace.this.m_finalPoint != null) {
			coordsAreSet = true;
		}
		return coordsAreSet;
	}


	private Shape createShape() {

		Shape newShape = this.m_shapeFactory.createShape(this.m_selectedShape, this.m_initialPoint, this.m_finalPoint);
		newShape.setFillColor(this.m_selectedFillColor);
		newShape.setBorderWidth(this.m_selectedBorderWidth);
		newShape.setBorderColor(this.m_selectedBorderColor);
		
		return newShape;
	}
	

	private void addShapeToWorkSpace(Shape p_shape) {

		this.m_shapeList.add(p_shape);
		//test
		System.out.println("--------Début liste workspace---------");
		for(Shape s: this.m_shapeList) {
			System.out.println("-"+s.toString());
			System.out.println(s.getInitialPoint().toString() + "  " + s.getFinalPoint().toString());
			System.out.println("Hauteur:" + s.getHeight() + " " + "Largeur:" + s.getWidth());
		}
		System.out.println("--------Fin liste workspace---------");
		//fin
	}
	

	public void refreshWorkSpace() {
		this.repaint();
	}
	
	public void resetCoordinates(){
		this.m_initialPoint = null;
		this.m_finalPoint = null;
	}


	
	@Override
	protected void paintComponent(Graphics p_Graphic) {
		
		super.paintComponent(p_Graphic);
		Graphics2D g2 = (Graphics2D) p_Graphic;
		
		if(!this.m_shapeList.isEmpty() && this.m_shapeList != null) {
			
			for(Shape shape : this.m_shapeList) {
				
				g2.setStroke(new BasicStroke(shape.getBorderWidth()));
				int coordX2, coordY2, width, height,coordX1,coordY1;
				
				coordX1 = shape.getInitialPoint().x;
				coordY1 = shape.getInitialPoint().y;
	
				height = shape.getHeight();
				width = shape.getWidth();
				
				boolean shapeHasFillColor = false;
				if(shape.getFillColor() != null) {
					shapeHasFillColor = true;
				}
				
				switch (shape.getName()) {
				
					case "rectangle":
						if(shapeHasFillColor) {
							g2.setColor(shape.getFillColor());
							p_Graphic.fillRect(coordX1,coordY1, width, height);
						}
						g2.setColor(shape.getBorderColor());
						p_Graphic.drawRect(coordX1,coordY1, width, height);
						break;
						
					case "line":
						coordX2 = shape.getFinalPoint().x;
						coordY2 = shape.getFinalPoint().y;
						if(shapeHasFillColor) {
							g2.setColor(shape.getFillColor());
						}
						p_Graphic.drawLine(coordX1, coordY1, coordX2, coordY2);
						break;
						
					case "elipse":
						if(shapeHasFillColor){
							g2.setColor(shape.getFillColor());
							p_Graphic.fillOval(coordX1,coordY1, width, height);
						}
						g2.setColor(shape.getBorderColor());
						p_Graphic.drawOval(coordX1,coordY1, width, height);
						
					default:
						break;
					
				}
			}
		}
	}
	

	
	
			
		
	
}
