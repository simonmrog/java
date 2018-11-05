import java.util.Scanner;

//This class shows how to create a class with its basics: constructors, set and get methods.
//Also, provides an example of how we can work with matrices in Java.

public class Matrix {
	
	private Scanner input;
	
	private float[][] M;
	private int numberOfRows, numberOfColumns;
	private boolean filled;
	
	public static byte ASCENDING_ORDER = 1;
	public static byte DESCENDING_ORDER = 2;
	
	public Matrix() {
	//Empty constructor, in case we don't want to create a Matrix specifying it's dimensions	
	}
	
	//Constructor specifying the matrix dimensions
	public Matrix (int i, int j) {
		
		numberOfRows = i;
		numberOfColumns = j;
		M = new float[i][j]; //creates the matrix with the appropiate dimension
	}
	
	public void setNumberOfRows(int value) {
		numberOfRows = value;
	}
	
	public void setNumberOfColumns(int value) {
		numberOfColumns = value;
	}
	
	public int getNumberOfRows() {
		return numberOfRows;
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public void fill() {
		
		filled = true;
		input = new Scanner(System.in);
		
		for (int i=0; i<numberOfRows; i++) {
			for (int j=0; j<numberOfColumns; j++) {
				System.out.print("Element (" + (int) (i+1) + ", " + (int) (j+1) + "): ");
				M[i][j] = input.nextFloat();
			}
		}
	}
	
	public void print() {
		
		if (filled) {
			
			for (int i=0; i<numberOfRows; i++) {
				for (int j=0; j<numberOfColumns; j++) {
					System.out.print(M[i][j] + " ");
				}
				System.out.println();
			}
		}
		else
			System.out.println("Empty matrix");
	}
	
	//Implementing the BubbleSort method which is very slow, this is just for illustration
	//We create two variables for specifying whether we want to order in ascending or descending order
	public void sortRow(int index, byte order) {
		
		boolean isSorted = false;
		int lastElement;
		float temp;
		
		if (order == Matrix.ASCENDING_ORDER) {
			
			lastElement = numberOfColumns - 1;
			while (!isSorted) {
				isSorted = true;
				for (int i=0; i<lastElement; i++) {
					if (M[index][i] > M[index][i+1]) { //swaping values
						temp = M[index][i];
						M[index][i] = M[index][i+1];
						M[index][i+1] = temp;
						isSorted = false;
					}
				}
				lastElement = lastElement - 1; //the greatest value ends up in the last position
												//after the first iteration of the while loop
			}
		}
		else if (order == Matrix.DESCENDING_ORDER) {
		
			lastElement = 0;
			while (!isSorted) {
				isSorted = true;
				for (int i=numberOfColumns - 1; i>lastElement; i--) {
					if (M[index][i] > M[index][i-1]) { //swaping values
						temp = M[index][i];
						M[index][i] = M[index][i-1];
						M[index][i-1] = temp;
						isSorted = false;
					}
				}
				lastElement = lastElement + 1; //the greatest value ends up in the last position
												//after the first iteration of the while loop
			}
		}
		else System.out.println("Invalid parameter of ordering");
	}
	
	public void sortColumn(int index, byte order) {
		
		boolean isSorted = false;
		int lastElement;
		float temp;
		
		if (order == Matrix.ASCENDING_ORDER) {
			
			lastElement = numberOfRows - 1;
			while (!isSorted) {
				isSorted = true;
				for (int i=0; i<lastElement; i++) {
					if (M[i][index] > M[i+1][index]) { //swaping values
						temp = M[i][index];
						M[i][index] = M[i+1][index];
						M[i+1][index] = temp;
						isSorted = false;
					}
				}
				lastElement = lastElement - 1; //the greatest value ends up in the last position
												//after the first iteration of the while loop
			}
		}
		else if (order == Matrix.DESCENDING_ORDER) {
		
			lastElement = 0;
			while (!isSorted) {
				isSorted = true;
				for (int i=numberOfRows - 1; i>lastElement; i--) {
					if (M[i][index] > M[i-1][index]) { //swaping values
						temp = M[i][index];
						M[i][index] = M[i-1][index];
						M[i-1][index] = temp;
						isSorted = false;
					}
				}
				lastElement = lastElement + 1; //the greatest value ends up in the last position
												//after the first iteration of the while loop
			}
		}
		else System.out.println("Invalid parameter of ordering");
	}
	
	public static void main(String args[]) {
		
		Matrix m = new Matrix(3, 4);
		m.fill();
		m.print();
		System.out.println("Sorting the first row in ascending order: \n");
		m.sortRow(0, Matrix.ASCENDING_ORDER);
		m.print();
		System.out.println("Sorting the second row in descending order: \n");
		m.sortRow(1, Matrix.DESCENDING_ORDER);
		m.print();
	}
}
