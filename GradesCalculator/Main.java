import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
	
	public static void createAndShowGUI(int numberOfSubjects) {
		
		Window mainW = new Window(numberOfSubjects);
		mainW.addContentsToPane(mainW.getContentPane());
		mainW.setVisible(true);
	}
	
	public static void main (String args[]) {
		
		int numberOfSubjects = 6;
		createAndShowGUI(numberOfSubjects);
		

		/*System.out.print("Número de materias: ");
		int N = in.nextInt();
		list = new Subject[N];
		in.nextLine();
		
		for (int i=0; i<N; i++) {
			System.out.print("Nombre de la materia: ");
			String name = in.nextLine();
			
			System.out.print("Créditos de " + name + ": ");
			int credits = in.nextInt();
			in.nextLine();
			
			System.out.print("¿Cuántas notas tiene " + name + ":");
			int size = in.nextInt();
			in.nextLine();
			
			Subject subject = new Subject(name, size, credits);
			
			for (int j=0; j<size; j++) {
				System.out.println("Ingrese una descripción para la nota # " + j + 1 + ":");
				String desc = in.nextLine();
				subject.setDescription(j, desc);
				
				System.out.println("Ingrese un porcentaje (0-100%) para la nota # " + j + 1 + ":");
				float perc = in.nextFloat();
				subject.setPercent(j, perc);
				
				System.out.println("Ingrese una nota para la nota # " + j + 1 + ":");
				float grade = in.nextFloat();
				in.nextLine();
				subject.setGrade(j, grade);
			}
			
			list[i] = subject;
			subject.showSubjectStatus();
			System.out.println("Nota final: " + subject.getSubjectGrade());
		}
		
		System.out.println("Promedio acumulado: " + getGPA(N, list));*/
	}
	
	static float getGPA(int n, Subject[] list) {
		float GPA = 0;
		int credits = 0;
		for (int i=0; i<n; i++) {
			GPA = GPA + list[i].getCredits()*list[i].getSubjectGrade();
			credits = credits + list[i].getCredits();
		}		
		return (GPA/credits);
	}
}
