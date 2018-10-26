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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	
	public static void main (String args[]) throws IOException {

		String fileName = "data.dat";
		startReadingData(fileName);
	}
	
	private static void startReadingData(String fileName) throws IOException {
		
		String line = null;
		
		try {
			//creates the file and buffered readers 
			FileReader fr = new FileReader("resources\\" + fileName);
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine(); //this will check if the file is empty
			if (line != null) {
				int subjects = Integer.parseInt(line); //reads the number of subjects
				createAndShowGUI(subjects, fileName); //creates the GUI based on the subjects
			}
			else {
				System.out.println("El archivo '" + fileName + "'" + " no tiene datos");
	        	createNumberOfSubjectsFrame(fileName); //asks for the number of subjects if the
	        									//file is empty
			}
		}
        catch(FileNotFoundException ex) {
        	System.out.println("Error leyendo el archivo");
        	File file = new File("resources\\data.dat");
        	file.createNewFile(); //creates the file if it doesn't exists
        	createNumberOfSubjectsFrame(fileName); //asks for the number of subjects
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
	}

	private static void createNumberOfSubjectsFrame(String fileName) {
		
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
		    	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    		try {
						validateData(frame, field, fileName);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			    }
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
				try {
					validateData(frame, field, fileName);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
 	    });
		
		frame.add(panel); //adds the panel to the frame
		frame.setVisible(true);
	}
	
	public static void validateData(JFrame frame, JTextField field, String fileName) throws IOException {
		
		int numberOfSubjects = Integer.parseInt(field.getText());
    	if (numberOfSubjects <= 10) {
    		createAndShowGUI(numberOfSubjects, fileName);
    		frame.dispose(); //destroys the frame if the input is right
    	}
    	else {
    		JOptionPane.showMessageDialog(frame, "El número de materias "
    				+ "no debe ser mayor a 10");
    		field.setText(""); //restarts the text in JTextField
    	}
	}
	
	public static void createAndShowGUI(int subjects, String fileName) throws IOException {
		
		Window mainW = new Window(subjects);	//creates the main window
		mainW.addContentsToPane(mainW.getContentPane());	//adds elements to window
		mainW.addDataToSubjects(fileName, subjects); //collects and shows the data from the file
		mainW.setVisible(true);	//makes the window visible
	}
}
