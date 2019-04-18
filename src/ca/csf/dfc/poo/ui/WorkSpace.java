package ca.csf.dfc.poo.ui;

import ca.csf.dfc.poo.classes.*;
import ca.csf.dfc.poo.classes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.*;
import java.util.List;

import javax.swing.*;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class WorkSpace extends JPanel{

	private static final long serialVersionUID = 6100091375438707781L;
	
	private static final Color DEFAULT_BORDER_COLOR = Color.black;
	private static final int DEFAULT_BORDER_WIDTH = 1;
	private static final String DEFAULT_SHAPE = "elipse";
	
	private ArrayList<Shape> m_shapeList;
	private Point m_initialPoint;
	private Point m_finalPoint;
	private ShapeFactory m_shapeFactory = new ShapeFactory();
	private Shape selectedShape;
	
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
	
	public ArrayList<Shape> getShapeList(){
		return this.m_shapeList;
	}
	
	public void setSelectedFillColor(Color p_color) {
		this.m_selectedFillColor = p_color;
	}
	
	public void setSelectedBorderWidth(int p_width) {
		if(p_width < 1 || p_width > 5) {
			throw new IllegalArgumentException();
		}
		this.m_selectedBorderWidth = p_width;
	}
	
	public void setSelectedBorderColor(Color p_color) {
		if(p_color == null) {
			throw new IllegalArgumentException();
		}
		this.m_selectedBorderColor = p_color;
	}
	
	public void setSelectedShape(String p_shapeType) {
		if((p_shapeType != "rectangle" && p_shapeType != "elipse" && p_shapeType != "line" && p_shapeType != "select")
		   || p_shapeType == null) {
			throw new IllegalArgumentException();
		}
		this.m_selectedShape = p_shapeType;
	}
	
	public void setInitialPoint(Point p_point) {
		if(p_point != null) {
			if(p_point.x < 0 || p_point.y < 0) {
				throw new IllegalArgumentException();
			}
		}
		this.m_initialPoint = p_point;
	}
	
	public void setFinalPoint(Point p_point) {
		if(p_point != null) {
			if(p_point.x < 0 || p_point.y < 0) {
				throw new IllegalArgumentException();
			}
		}
		this.m_finalPoint = p_point;
	}
	
	public Point getInitialPoint() {
		return this.m_initialPoint;
	}
	
	public Point getFinalPoint() {
		return this.m_finalPoint;
	}
	
	public Shape getSelectedShape() {
		return this.selectedShape;
	}

	public void clearShapeSelection() {
		this.selectedShape = null;
		this.repaint();
		System.out.println("No shape selected");
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
		
			if ("select".equals(WorkSpace.this.m_selectedShape))
			{
				List<Shape> shapeList = WorkSpace.this.getShapeList();
				
				for (Shape shape : shapeList) {
					java.awt.Shape drawnShape = null;
					
					if (shape.getName().equals("rectangle")) {
						drawnShape = new Rectangle2D.Double(shape.getInitialPoint().getX(), shape.getInitialPoint().getY(), shape.getWidth(), shape.getHeight());
					} else if (shape.getName().equals("line")) {
						drawnShape = new Line2D.Double(shape.getInitialPoint().getX(), shape.getInitialPoint().getY(), shape.getFinalPoint().getX(), shape.getFinalPoint().getY()).getBounds2D();
					} else if (shape.getName().equals("elipse")) {
						drawnShape = new Ellipse2D.Double(shape.getInitialPoint().getX(), shape.getInitialPoint().getY(), shape.getWidth(), shape.getHeight());
					} 
					
					if (drawnShape != null && drawnShape.contains(p_arg0.getX(), p_arg0.getY())) {
						WorkSpace.this.selectedShape = shape;
						WorkSpace.this.repaint();
						System.out.println("Shape Selected: " + shape.getName());
						return;
					}
					
					WorkSpace.this.clearShapeSelection();
				}
			}
			else
			{
				if(WorkSpace.this.m_initialPoint == null) {
					Point point = new Point();
					point.x = p_arg0.getX();
					point.y = p_arg0.getY();
					WorkSpace.this.setInitialPoint(point);
					WorkSpace.this.m_testP1.setText(WorkSpace.this.m_initialPoint.toString()); //test
				}
				else if (WorkSpace.this.m_finalPoint == null) {
					Point point = new Point();
					point.x = p_arg0.getX();
					point.y = p_arg0.getY();
					WorkSpace.this.setFinalPoint(point);
					WorkSpace.this.m_testP2.setText(WorkSpace.this.m_finalPoint.toString()); //test
				}
				
				if(WorkSpace.this.coordinatesAreSet()) {
					Shape newShape = WorkSpace.this.createShape();
					WorkSpace.this.addShapeToWorkSpace(newShape);
	
					WorkSpace.this.refreshWorkSpace();
	
					WorkSpace.this.resetCoordinates();
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent p_arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	

	public boolean coordinatesAreSet() {

		boolean coordsAreSet = false;
		if(WorkSpace.this.m_initialPoint != null && WorkSpace.this.m_finalPoint != null) {
			coordsAreSet = true;
		}
		return coordsAreSet;
	}


	public Shape createShape() {

		Shape newShape = this.m_shapeFactory.createShape(this.m_selectedShape, this.m_initialPoint, this.m_finalPoint);
		newShape.setFillColor(this.m_selectedFillColor);
		newShape.setBorderWidth(this.m_selectedBorderWidth);
		newShape.setBorderColor(this.m_selectedBorderColor);
		
		return newShape;
	}
	
	
	public void addShapeToWorkSpace(Shape p_shape) {
		
		if(p_shape == null) {
			throw new IllegalArgumentException();
		}
		
		this.m_shapeList.add(p_shape);

	}
	

	public void refreshWorkSpace() {
		this.repaint();
	}
	
	public void resetCoordinates(){
		this.m_initialPoint = null;
		this.m_finalPoint = null;
	}

	public void removeShape(Shape shape) {
		if (this.m_shapeList.contains(shape)) {
			this.m_shapeList.remove(shape);
			this.repaint();
		}
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
				
				if (selectedShape != null && shape.equals(selectedShape)) {
					g2.setColor(Color.GRAY);
					g2.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
					p_Graphic.drawRect(coordX1-5,coordY1-5, width+10, height+10);
				}
			}
		}
	}
	

	
	
			
		
	
}
