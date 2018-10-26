import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	public static void main (String args[]) {
		
		int numberOfSubjects = getNumberOfSubjects();
		/*
			list[i] = subject;
			subject.showSubjectStatus();
			System.out.println("Nota final: " + subject.getSubjectGrade());
		}
		
		System.out.println("Promedio acumulado: " + getGPA(N, list));*/
	}
	
	public static void createAndShowGUI(int numberOfSubjects) {
		
		Window mainW = new Window(numberOfSubjects);	//creates the main window
		mainW.addContentsToPane(mainW.getContentPane());	//adds elements to window
		mainW.setVisible(true);	//makes the window visible
	}
	
	private static int getNumberOfSubjects() {
		JFrame frame = new JFrame("Hello");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 150);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel text = new JLabel("Ingrese número de materias");
		text.setPreferredSize(new Dimension(150, 10));
		panel.add(text);
		
		JTextField field = new JTextField();
		//field.setPreferredSize(new Dimension(150, 10));
		panel.add(field);
		
		JButton button = new JButton("Ok");
		//button.setAlignmentX(Component.CENTER_ALIGNMENT);
		//button.setPreferredSize(new Dimension(200, 10));
		
		button.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				System.out.print(field.getText());
				int NumberOfSubjects = Integer.parseInt(field.getText());
				createAndShowGUI(NumberOfSubjects);	//creates the GUI
	      }
 	    });

		panel.add(button);
		
		frame.add(panel);
		//frame.pack();
		frame.setVisible(true);
		return 0;
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
