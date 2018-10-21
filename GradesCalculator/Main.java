
public class Main {
	
	public static void createAndShowGUI(int numberOfSubjects) {
		
		Window mainW = new Window(numberOfSubjects);
		mainW.addContentsToPane(mainW.getContentPane());
		mainW.setVisible(true);
	}
	
	public static void main (String args[]) {
		
		int numberOfSubjects = 8;
		createAndShowGUI(numberOfSubjects);
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
