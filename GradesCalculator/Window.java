import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Window extends JFrame {

	private GridLayout grid;
	private int numberOfSubjects;
	
	public Window(int n){
		
		super("Grades Calculator");
		numberOfSubjects = n;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1200, 600);
		setLocationRelativeTo(null);
	}
	
	public void addContentsToPane(final Container pane) {
		
		//creates a layout for the frame
		grid = new GridLayout(2, numberOfSubjects);
		
		Subject[] subjects = new Subject[numberOfSubjects];
		JScrollPane[] scrollpanes = new JScrollPane[numberOfSubjects];;
		JPanel panel = new JPanel();
		panel.setLayout(grid);
		
		for (int i=0; i<numberOfSubjects; i++) {
			
			subjects[i] = new Subject("", 4, 4);
	        subjects[i].setPreferredScrollableViewportSize(new Dimension(500, 100));
	        //subject.setFillsViewportHeight(true);
	        scrollpanes[i] = new JScrollPane(subjects[i]);
			panel.add(scrollpanes[i]);
		}
		
		//Creates a new subject table
		/*Subject subject = new Subject("", 4, 4);
		JFrame frame = new JFrame("Table");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        subject.setPreferredScrollableViewportSize(new Dimension(500, 100));
        //subject.setFillsViewportHeight(true);
        JScrollPane scrollpane = new JScrollPane(subject);*/
        
        //Creates a panel for the tables
		
		//Manages the tables pane
		
		//Manages the button panel
		JPanel calculations = new JPanel();
		calculations.add(new JButton("Calcular"));
		calculations.add(new JTextField("This is a calculation"));

		//Adds the panels to the frame container
		pane.add(panel);
		pane.add(calculations, BorderLayout.SOUTH);
	}
}