import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Window extends JFrame {

	//First panel components
	private JPanel mainPanel;
	private GridLayout mainGrid;
	private int numberOfSubjects;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Second panel components
	private JPanel calculations;
	private GridLayout calculationsGrid;
	JButton calculateButton;
	JTextField textField;
	
	public Window(int n){
		
		super("Grades Calculator");
		numberOfSubjects = n;
		
		//Basic configurations of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1300, 700);
		setLocationRelativeTo(null);
	}
	
	public void addContentsToPane(final Container pane) {
		
		mainGrid = new GridLayout(2, numberOfSubjects);	//layout for the tables
		calculationsGrid = new GridLayout(1, 2);	//layout for the button
	
        
		mainPanel = new JPanel();	//panel for the tables
		mainPanel.setLayout(mainGrid);	//Sets the layout for the panel
	
		Subject[] subjects = new Subject[numberOfSubjects];	//Creates array of subjects
		int tableWidth = (int) (screenSize.getWidth()/5.5);	//tables width
		int tableHeight = (int) (screenSize.getHeight()/4);	//tables height
		
		//Cycle for creating and adding tables to the main panel
		for (int i=0; i<numberOfSubjects; i++) {
		
			subjects[i] = new Subject(4, 4, tableWidth, tableHeight);	//creates subject 
			mainPanel.add(subjects[i]);	//adds the subject to the main panel
		}
		
		//Creates and fills the button panel
		calculations = new JPanel();
		calculations.setLayout(calculationsGrid);
		//Creates and adds the button to the panel
		calculateButton = new JButton("Calcular");
		calculations.add(calculateButton);
		//Creates and adds the textfield to the panel
		textField = new JTextField("Promedio acumulado");
		calculations.add(textField);

		//Adds the panels to the frame container
		pane.add(mainPanel);
		pane.add(calculations, BorderLayout.SOUTH);
	}
}