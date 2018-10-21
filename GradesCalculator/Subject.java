import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Subject extends JTable {

	String subjectName;
	String[] columnNames = {"Descripción", "Porcentaje (%)", "Nota (0-5)"};
	
	int numberOfRows, credits;
	
	public Subject (String name, int rows, int cred) {
		
		//Creates the model for our table
		numberOfRows = rows;
        DefaultTableModel model = new DefaultTableModel(columnNames, numberOfRows);
        //Sets the new model
		setModel(model);
		setRowHeight(25);
		
		//Centers data in the table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		setDefaultRenderer(String.class, centerRenderer);
		
		subjectName = new String(name);
		credits = cred;
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
			
			perc = (float) getModel().getValueAt(i,1);
			grade = (float) getModel().getValueAt(i, 2);
			value = value + perc*grade;
		}
		return value/100;	
	}
	
	public void showSubjectStatus() {
		
		String desc, perc, grades;
		
		for (int i=0; i<numberOfRows; i++) {
			
			desc = (String) getModel().getValueAt(i,0);
			perc = (String) getModel().getValueAt(i,1);
			grades = (String) getModel().getValueAt(i,2);
			System.out.println(desc + " " + perc + " " + grades);
		}
	}
}
