
public class Main {
	
	public static void createAndShowGUI(int numberOfSubjects) {
		
		Window mainW = new Window(numberOfSubjects);	//creates the main window
		mainW.addContentsToPane(mainW.getContentPane());	//adds elements to window
		mainW.setVisible(true);	//makes the window visible
	}
	
	public static void main (String args[]) {
		
		int numberOfSubjects = 7;	//number of subjects
		createAndShowGUI(numberOfSubjects);	//creates the GUI
		/*
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
