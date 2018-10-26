import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	public static void main (String args[]) throws IOException {

		startReadingData();
		/*
			list[i] = subject;
			subject.showSubjectStatus();
			System.out.println("Nota final: " + subject.getSubjectGrade());
		}
		
		System.out.println("Promedio acumulado: " + getGPA(N, list));*/
	}
	
	public static void createAndShowGUI(int subjects) {
		
		Window mainW = new Window(subjects);	//creates the main window
		mainW.addContentsToPane(mainW.getContentPane());	//adds elements to window
		mainW.setVisible(true);	//makes the window visible
	}
	
	private static void startReadingData() throws IOException {
		
		String fileName = "data.dat";
		String line = null;
		int subjects = 0;
		
		try {
			FileReader fileReader = new FileReader("resources\\" + fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			line = bufferedReader.readLine();
			if (line != null) {
				subjects = Integer.parseInt(line); //reads the number of subjects
				createAndShowGUI(subjects); //creates the GUI
			}
			else {
				System.out.println("El archivo '" + fileName + "'" + " no tiene datos");
	        	createNumberOfSubjectsFrame(); //asks for the number of subjects if the
	        									//file is empty
			}
		}
        catch(FileNotFoundException ex) {
        	System.out.println("Error leyendo el archivo");
        	File file = new File("resources\\data.dat");
        	file.createNewFile(); //creates the file if it doesn't exists
        	createNumberOfSubjectsFrame(); //asks for the number of subjects
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
	}

	private static void createNumberOfSubjectsFrame() {
		
		int subjects;
		JFrame frame = new JFrame("Hello");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 150);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel text = new JLabel("Ingrese número de materias (max. 10)");
		panel.add(text);
		
		JTextField field = new JTextField();
		panel.add(field);
		//Event when the ENTER key is pressed
		field.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
		    }

		    public void keyReleased(KeyEvent e) {
		    	//only if the key is the ENTER key
		    	if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    	createAndShowGUI(Integer.parseInt(field.getText()));
		    }

		    public void keyPressed(KeyEvent e) {
		    }
		});
		
		JButton button = new JButton("Ok");
		panel.add(button);
		//Event when the button is pressed
		button.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				createAndShowGUI(Integer.parseInt(field.getText()));
	      }
 	    });
		
		frame.add(panel); //adds the panel to the frame
		frame.setVisible(true);
	}

	/*static float getGPA(int n, Subject[] list) {
		float GPA = 0;
		int credits = 0;
		for (int i=0; i<n; i++) {
			GPA = GPA + list[i].getCredits()*list[i].getSubjectGrade();
			credits = credits + list[i].getCredits();
		}
		
		return (GPA/credits);
	}*/
}
