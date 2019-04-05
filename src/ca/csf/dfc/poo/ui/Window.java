package ca.csf.dfc.poo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Window extends JFrame {

	public Window() {
		super("Mini-paint");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);	

		menuTP();
		workSpace();
	}

	private void menuTP() {

		JMenu menuFile = new JMenu("File");
		JMenuItem menuItemNew = new JMenuItem("New");
		JMenuItem menuItemOpen = new JMenuItem("Open");
		JMenuItem menuItemSave = new JMenuItem("Save");
		JMenuItem menuItemExport = new JMenuItem("Export");
		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);
		menuFile.add(menuItemSave);
		menuFile.add(menuItemExport);

		JMenu menuEdit = new JMenu("Edit");
		JMenuItem menuItemUndo = new JMenuItem("Undo");
		menuEdit.add(menuItemUndo);

		JMenu menuDesign = new JMenu("Design");
		JMenuItem menuItemLigne = new JMenuItem("Ligne");
		JMenuItem menuItemRectangle = new JMenuItem("Rectangle");
		JMenuItem menuItemellipse = new JMenuItem("Ellipse");
		menuDesign.add(menuItemLigne);
		menuDesign.add(menuItemRectangle);
		menuDesign.add(menuItemellipse);

		JMenu menuHelp = new JMenu("Help");
		JMenuItem menuItemAbout = new JMenuItem("About");
		menuHelp.add(menuItemAbout);

		// Menubar with all JMenus
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuDesign);
		menuBar.add(menuHelp);

	}

	private void workSpace() {
		
		setLayout(new BorderLayout());
				
		//Panel menuButtonsFile
		//JLabel label = new JLabel("Titled Border");
	    //label.setHorizontalAlignment(JLabel.CENTER);

//	    TitledBorder titled = new TitledBorder("Title");
//	    label.setBorder(titled);
//		
		JButton btnNew = new JButton("New");
		JButton btnOpen = new JButton("Open");
		JButton btnSave = new JButton("Save");
		JButton btnExport = new JButton("Export");		
		
		//Panel menuButtonsDesign
		JPanel panelButtonsDesign = new JPanel();
		panelButtonsDesign.setLayout(new FlowLayout());
		
		JButton btnLigne = new JButton("Ligne");
		JButton btnRectangle = new JButton("Rectangle");
		JButton btnEllipse = new JButton("Ellipse");
		
		//File
		panelButtonsDesign.add(btnNew);
		panelButtonsDesign.add(btnOpen);
		panelButtonsDesign.add(btnSave);
		panelButtonsDesign.add(btnExport);
		//Design
		panelButtonsDesign.add(btnLigne);
		panelButtonsDesign.add(btnRectangle);
		panelButtonsDesign.add(btnEllipse);
		
		
		//Panel for workspace
		JPanel panelWorkSpace = new JPanel();
		panelWorkSpace.setBackground(Color.WHITE);
		
		//Panel footer with select for change the size of workspace
		JPanel panelFooter = new JPanel();
		
		panelFooter.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblSize = new JLabel("Size ");
		JComboBox<Integer> comboSize = new JComboBox<Integer>();
		comboSize.addItem(20);
		comboSize.addItem(40);
		comboSize.addItem(60);
		comboSize.addItem(80);
		comboSize.addItem(100);
		JLabel lblPorcent = new JLabel(" %");
		
		panelFooter.add(lblSize);
		panelFooter.add(comboSize);
		panelFooter.add(lblPorcent);
		
		//add(label, BorderLayout.NORTH);
		add(panelButtonsDesign, BorderLayout.NORTH);
		add(panelWorkSpace, BorderLayout.CENTER);
		add(panelFooter, BorderLayout.SOUTH);
	}

	
}
