import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame {
	
	//First panel components
	private JPanel mainPanel;
	private GridLayout mainGrid;
	private int numberOfSubjects;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	int tableWidth = (int) (screenSize.getWidth()/5.5);	//tables width
	int tableHeight = (int) (screenSize.getHeight()/4);	//tables height
	
	//Second panel components
	private JPanel calculations;
	private GridLayout calculationsGrid;
	JButton calculateButton;
	JButton saveButton;
	JTextField GPATextField;
	
	//subjects of the program
	Subject[] subjects;
	
	public Window(int n){
		
		super("Grades Calculator V1.0");
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
	
		subjects = new Subject[numberOfSubjects];	//Creates array of subjects
		
		//Creates and adds the textfield to the panel
		GPATextField = new JTextField("Promedio acumulado");

		//Creates and fills the button panel
		calculations = new JPanel();
		calculations.setLayout(calculationsGrid);
		
		//Creates and adds the button to the panel
		calculateButton = new JButton("Calcular");
		calculateButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				calculateSubjectGrades();
				calculateGPA();
		    }
		});
		
		//creates the save button
		saveButton = new JButton("Guardar");
		
		//adds the components to the calculation panel
		calculations.add(GPATextField);
		calculations.add(calculateButton);
		calculations.add(saveButton);
		
		//Adds the panels to the frame container
		pane.add(mainPanel);
		pane.add(calculations, BorderLayout.SOUTH);
	}

	public void addDataToSubjects(String fileName, int numberOfSubjects) throws IOException {
		
		FileReader fr = new FileReader("resources\\" + fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		if (line != null) {
			//redundant line just to pass through the first line
			numberOfSubjects = Integer.parseInt(line); 
			//Cycle for creating and adding tables to the main panel
			for (int i=0; i<numberOfSubjects; i++) {
				//creates subject 
				subjects[i] = new Subject(10, 4, tableWidth, tableHeight);	
				subjects[i].setName(br.readLine()); //sets subject name
				line = br.readLine();
				String[] splited = line.split("\\s+");
				subjects[i].setGrade(splited[0]); //sets subject grade
				subjects[i].setCredits(splited[1]); //sets subject credits
				String string = br.readLine();
				int numberOfRows = Integer.parseInt(string); //sets number of rows
				subjects[i].setNumberOfRows(numberOfRows);
				//Filling the table
				for (int j=0; j < numberOfRows; j++) {
					line = br.readLine();
					splited = line.split("\\s+");
					subjects[i].setValueAt(splited[0], j, 0);
					subjects[i].setValueAt(splited[1], j, 1);
					subjects[i].setValueAt(splited[2], j, 2);
				}
				subjects[i].centerTextInTable();
				mainPanel.add(subjects[i]);	//adds the subject to the main panel
			}
		}
		else {
			//Cycle for creating and adding empty tables to the main panel
			for (int i=0; i<numberOfSubjects; i++) {
				//creates subject 
				subjects[i] = new Subject(10, 4, tableWidth, tableHeight);
				subjects[i].setName("Nombre materia #" + Integer.toString(i+1));
				subjects[i].setGrade("Nota acumulada");
				mainPanel.add(subjects[i]);	//adds the subject to the main panel
			}
		}
	}
	
	private void calculateSubjectGrades() {
			
		for (int i=0; i<numberOfSubjects; i++) {
			
			float x = 0, percent, value;
			
			for (int j=0; j<subjects[i].getNumberOfRows(); j++) {
				percent = Float.parseFloat(subjects[i].getValueAt(j, 1));
				value = Float.parseFloat(subjects[i].getValueAt(j, 2));
				x = x + value*percent;
			}
			subjects[i].setGrade(x/100 + "");
		}
	}
	
	public void calculateGPA() {
		
		float GPA = 0, sum = 0;
		for (int i=0; i<numberOfSubjects; i++) {
			GPA = GPA + subjects[i].getGrade()*subjects[i].getCredits();
			sum = sum + subjects[i].getCredits();
		}
		GPATextField.setText(GPA/sum + "");
	}
}