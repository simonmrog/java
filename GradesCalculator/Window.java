import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Window extends JFrame {

	private GridLayout mainGrid;
	private GridLayout secondGrid;
	private int numberOfSubjects;
	
	JButton calculateButton;
	JTextField textField;
	
	public Window(int n){
		
		super("Grades Calculator");
		numberOfSubjects = n;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1200, 600);
		setLocationRelativeTo(null);
	}
	
	public void addContentsToPane(final Container pane) {
		
		//creates layouts for the frame
		mainGrid = new GridLayout(2, numberOfSubjects);
		secondGrid = new GridLayout(1, 2);
		
		//Creates arrays to put in the window
		Subject[] subjects = new Subject[numberOfSubjects];
		JScrollPane[] scrollpanes = new JScrollPane[numberOfSubjects];
		JTextField[] credits = new JTextField[numberOfSubjects];
		JTextField[] results = new JTextField[numberOfSubjects];
				
        //Creates a panel for the tables
		JPanel panel = new JPanel();
		//Sets the layout for the panel
		panel.setLayout(mainGrid);
		
		for (int i=0; i<numberOfSubjects; i++) {
			
			//creates objects 
			subjects[i] = new Subject("", 4, 4);
	        //subjects[i].setPreferredScrollableViewportSize(new Dimension(500, 100));
	        subjects[i].setFillsViewportHeight(true);
	        scrollpanes[i] = new JScrollPane(subjects[i]);
	        credits[i] = new JTextField();
	        results[i] = new JTextField();
	        
	        panel.add(scrollpanes[i]);
			//panel.add(credits[i]);
			//panel.add(results[i]);
			
		}
		
		//Creates and fills the button panel
		JPanel calculations = new JPanel();
		calculations.setLayout(secondGrid);
		//Creates and adds the button to the panel
		calculateButton = new JButton("Calcular");
		calculations.add(calculateButton);
		//Creates and adds the textfield to the panel
		textField = new JTextField("Promedio acumulado");
		calculations.add(textField);

		//Adds the panels to the frame container
		pane.add(panel);
		pane.add(calculations, BorderLayout.SOUTH);
	}
}