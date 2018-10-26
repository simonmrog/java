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
	DefaultTableModel model; //model for the table
	JScrollPane scrollpane; 
	JTextField subjectTitleField;
	JTextField subjectGrade;
	
	public Subject (int rows, int cred, int width, int height) {
		
		credits = cred;
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		//Creates a textfield for the title
		subjectTitleField = new JTextField("Nombre");
		subjectTitleField.setMaximumSize(new Dimension(200, 800));
		subjectTitleField.setHorizontalAlignment(JTextField.CENTER);
		
		//Creates a textfield for the grade
		subjectGrade = new JTextField("Nota acumulada");
		subjectGrade.setMaximumSize(new Dimension(200, 800));
		subjectGrade.setHorizontalAlignment(JTextField.CENTER);
		
		//Creates and configures our subject table
        model = new DefaultTableModel(columnNames, rows);
		table = new JTable(model);
		table.setRowHeight(25);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		table.setPreferredScrollableViewportSize(new Dimension(width, height));
		scrollpane = new JScrollPane(table);
		
		setLayout(layout);
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(subjectTitleField);
		add(subjectGrade);
		add(scrollpane);

	}
	
	public String getName() {
		return subjectName;
	}
	
	public float getGrade() {
		String line = subjectGrade.getText();
		return Float.parseFloat(line);
	}
	
	public int getNumberOfRows() {
		return numberOfRows;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setName(String name) {
		subjectTitleField.setText(name);
	}
	
	public void setGrade(String grade) {
		subjectGrade.setText(grade);
	}
	
	public void setNumberOfRows(int rows) {
		numberOfRows = rows;
	}
	
	public void setValueAt(String value, int i, int j) {
		if (i < table.getRowCount() && j < table.getColumnCount())
			table.setValueAt(value, i, j);
	}
	
	/*public float getSubjectGrade() {
		
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
	}*/
}
