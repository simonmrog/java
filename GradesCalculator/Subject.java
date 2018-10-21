import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Subject extends JPanel {

	//Subject parameters
	String subjectName;
	String[] columnNames = {"Descripción", "Valor (%)", "Nota (0-5)"};
	int numberOfRows, credits;
	
	//Subject components
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollpane; 
	JTextField subjectTitle;
	
	public Subject (int rows, int cred, int width, int height) {
		
		numberOfRows = rows;
		credits = cred;
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		//Creates a textfield for the title
		subjectTitle = new JTextField("Subject name");
		subjectTitle.setMaximumSize(new Dimension(200, 800));

		
		//Creates and configures our subject table
        model = new DefaultTableModel(columnNames, numberOfRows);
		table = new JTable(model);
		table.setRowHeight(25);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setPreferredScrollableViewportSize(new Dimension(width, height));
		
		//Centers data in the table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);	
		scrollpane = new JScrollPane(table);
		
		setLayout(layout);
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(subjectTitle);
		add(scrollpane);

		
		
	}
	
	public String getName() {
		return subjectName;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public float getSubjectGrade() {
		
		float perc, grade, value = 0;
		
		for (int i=0; i<numberOfRows; i++) {
			
			perc = (float) table.getModel().getValueAt(i,1);
			grade = (float) table.getModel().getValueAt(i, 2);
			value = value + perc*grade;
		}
		return value/100;	
	}
	
	public void showSubjectStatus() {
		
		String desc, perc, grades;
		
		for (int i=0; i<numberOfRows; i++) {
			
			desc = (String) table.getModel().getValueAt(i,0);
			perc = (String) table.getModel().getValueAt(i,1);
			grades = (String) table.getModel().getValueAt(i,2);
			System.out.println(desc + " " + perc + " " + grades);
		}
	}
}
