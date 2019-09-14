package app;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// public class GameOfLife extends JApplet implements ActionListener {

// 	private Container c;
// 	private JTextArea displayBoard; // display board
// 	private JButton nextGeneration; // button to generate next generation
// 	//private JLabel 

// 	private boolean[][] matrix;
// 	private boolean[][] tempMatrix;
// 	private int rows;
// 	private int columns;

// 	public void init() { // Applet init() method
// 		// set layout manager
// 		c = getContentPane();
// 		c.setLayout(new BorderLayout());

// 		// setup components
// 		displayBoard = new JTextArea();
// 		displayBoard.setEditable(false);
// 		displayBoard.setFont(new Font("monospaced", Font.PLAIN, 12));
// 		nextGeneration = new JButton("Next generation");
// 		nextGeneration.addActionListener(this);

// 		// add components to applet
// 		c.add(displayBoard, BorderLayout.CENTER);
// 		c.add(nextGeneration, BorderLayout.SOUTH);

// 		rows = getANumber();
// 		if (rows == -1) {
// 			showByeBye();
// 			return;
// 		}
// 		columns = getANumber();
// 		if (columns == -1) {
// 			showByeBye();
// 			return;
// 		}
// 		matrix = new boolean[rows][columns];
// 		tempMatrix = new boolean[rows][columns];
// 		/*
// 		 * matrix[13][14] = true; matrix[14][13] = true; matrix[14][14] = true;
// 		 * matrix[14][15] = true; matrix[15][13] = true; matrix[15][15] = true;
// 		 * matrix[16][14] = true;
// 		 */
// 		randomiseMatrix();
// 		displayLife();
// 	}

// 	public void displayLife() {

// 		String str = "";
// 		for (int i = 0; i < rows; i++) {
// 			for (int j = 0; j < columns; j++) {
// 				if (matrix[i][j])
// 					str += "+";
// 				else
// 					str += "-";
// 				if (j < columns - 1)
// 					str += " ";
// 			}
// 			str += "\n";
// 		}
// 		displayBoard.setText(str);

// 		/*
// 		 * displayBoard.setText(""); for (int i = 0; i < rows; i++) { for (int j = 0; j
// 		 * < columns; j++) { if (matrix[i][j]) addColoredText("+", Color.GREEN); else
// 		 * addColoredText("-", Color.RED); if (j < columns - 1) addColoredText(" ",
// 		 * Color.BLACK); } addColoredText("\n", Color.BLACK); }
// 		 */
// 	}

// 	// implementation of ActionListener interface
// 	public void actionPerformed(ActionEvent e) {
// 		if (generateNextGeneration()) {
// 			displayLife();
// 		} else {
// 			if (askStartOver()) {
// 				randomiseMatrix();
// 				displayLife();
// 			} else {
// 				showByeBye();
// 			}
// 		}

// 	}

// 	public boolean generateNextGeneration() {
// 		cloneMatrix();
// 		boolean isChanged = false;
// 		for (int i = 0; i < rows; i++) {
// 			for (int j = 0; j < columns; j++) {
// 				int neighbours = countNeighbours(i, j);
// 				if (matrix[i][j] && (neighbours < 2 || neighbours > 3)) {
// 					tempMatrix[i][j] = false;
// 					isChanged = true;
// 				}
// 				if (!matrix[i][j] && neighbours == 3) {
// 					tempMatrix[i][j] = true;
// 					isChanged = true;
// 				}
// 			}
// 		}
// 		swapMatrices();
// 		return isChanged;
// 	}

// 	private int countNeighbours(int row, int column) {
// 		int counter = matrix[row][column] ? -1 : 0;
// 		for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, rows - 1); i++) {
// 			for (int j = Math.max(column - 1, 0); j <= Math.min(column + 1, columns - 1); j++) {
// 				if (matrix[i][j])
// 					counter++;
// 			}
// 		}
// 		return counter;
// 	}

// 	private void cloneMatrix() {
// 		for (int i = 0; i < rows; i++) {
// 			for (int j = 0; j < columns; j++) {
// 				tempMatrix[i][j] = matrix[i][j];
// 			}
// 		}
// 	}

// 	private void randomiseMatrix() {
// 		Random rnd = new Random();
// 		for (int i = 0; i < rows; i++) {
// 			for (int j = 0; j < columns; j++) {
// 				if (rnd.nextDouble() > 0.5) {
// 					matrix[i][j] = true;
// 				} else {
// 					matrix[i][j] = false;
// 				}
// 			}
// 		}
// 	}

// 	private void swapMatrices() {
// 		boolean[][] temp = matrix;
// 		matrix = tempMatrix;
// 		tempMatrix = temp;
// 	}

// 	private boolean askStartOver() {
// 		int result = JOptionPane.showConfirmDialog(null,
// 				"The bacteria population stabilized.\nDo you want to start over?", "", JOptionPane.YES_NO_OPTION);

// 		if (result == JOptionPane.YES_OPTION) {
// 			return true;
// 		}
// 		return false;
// 	}

// 	private int getANumber() {
// 		boolean isNumberOK = false;
// 		String numberStr = JOptionPane.showInputDialog("Enter a positive whole number");
// 		while (!isNumberOK) {
// 			try {
// 				int number = Integer.parseInt(numberStr);
// 				if (number > 0)
// 					return number;
// 				// throw new NumberFormatException();
// 			} catch (NumberFormatException ex) {
// 				if (numberStr == null) {
// 					return -1;
// 				}
// 			}
// 			numberStr = JOptionPane.showInputDialog("The number is not valid, enter a new one");
// 		}
// 		return -1;

// 	}

// 	private void showByeBye() {
// 		c.remove(nextGeneration);
// 		displayBoard.setFont(new Font("monospaced", Font.BOLD, 26));
// 		displayBoard.setText("Bye Bye");
// 	}

// 	private void addColoredText(String text, Color color) {
// 		/*
// 		 * StyledDocument doc = displayBoard.getStyledDocument(); Style style =
// 		 * displayBoard.addStyle("I'm a Style", null);
// 		 * StyleConstants.setForeground(style, color);
// 		 * 
// 		 * try { doc.insertString(doc.getLength(), text,style); } catch
// 		 * (BadLocationException e){}
// 		 */
// 		int a;
// 	}
// }

public class GameOfLife extends JApplet implements ActionListener {

	private Container c;
	private JTextPane displayBoard; // display board
	private JButton nextGeneration; // button to generate next generation
	private JLabel numberOfBacteriasLabel;

	private boolean[][] matrix;
	private boolean[][] tempMatrix;
	private int rows;
	private int columns;

	public void init() { // Applet init() method
		// set layout manager
		c = getContentPane();
		c.setLayout(new BorderLayout());

		// setup components
		displayBoard = new JTextPane();
		displayBoard.setEditable(false);
		displayBoard.setFont(new Font("monospaced", Font.PLAIN, 12));
		nextGeneration = new JButton("Next generation");
		nextGeneration.addActionListener(this);

		numberOfBacteriasLabel = new JLabel();

		// add components to applet
		c.add(numberOfBacteriasLabel, BorderLayout.NORTH);
		c.add(displayBoard, BorderLayout.CENTER);
		c.add(nextGeneration, BorderLayout.SOUTH);

		rows = getANumber();
		if (rows == -1) {
			showByeBye();
			return;
		}
		columns = getANumber();
		if (columns == -1) {
			showByeBye();
			return;
		}
		matrix = new boolean[rows][columns];
		tempMatrix = new boolean[rows][columns];
		/*
		 * matrix[13][14] = true; matrix[14][13] = true; matrix[14][14] = true;
		 * matrix[14][15] = true; matrix[15][13] = true; matrix[15][15] = true;
		 * matrix[16][14] = true;
		 */
		randomiseMatrix();
		displayLife();
		setLabelText();
	}

	public void displayLife() {
		displayBoard.setText("");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j])
					addColoredText("+", Color.GREEN);
				else
					addColoredText("-", Color.RED);
				if (j < columns - 1)
					addColoredText(" ", Color.BLACK);
			}
			addColoredText("\n", Color.BLACK);
		}

	}

	// implementation of ActionListener interface
	public void actionPerformed(ActionEvent e) {
		if (generateNextGeneration()) {
			displayLife();
			setLabelText();
		} else {
			if (askStartOver()) {
				randomiseMatrix();
				displayLife();
				setLabelText();
			} else {
				showByeBye();
			}
		}

	}

	public boolean generateNextGeneration() {
		cloneMatrix();
		boolean isChanged = false;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int neighbours = countNeighbours(i, j);
				if (matrix[i][j] && (neighbours < 2 || neighbours > 3)) {
					tempMatrix[i][j] = false;
					isChanged = true;
				}
				if (!matrix[i][j] && neighbours == 3) {
					tempMatrix[i][j] = true;
					isChanged = true;
				}
			}
		}
		swapMatrices();
		return isChanged;
	}

	private int countNeighbours(int row, int column) {
		int counter = matrix[row][column] ? -1 : 0;
		for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, rows - 1); i++) {
			for (int j = Math.max(column - 1, 0); j <= Math.min(column + 1, columns - 1); j++) {
				if (matrix[i][j])
					counter++;
			}
		}
		return counter;
	}

	private void cloneMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tempMatrix[i][j] = matrix[i][j];
			}
		}
	}

	private void randomiseMatrix() {
		Random rnd = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (rnd.nextDouble() > 0.5) {
					matrix[i][j] = true;
				} else {
					matrix[i][j] = false;
				}
			}
		}
	}

	private void swapMatrices() {
		boolean[][] temp = matrix;
		matrix = tempMatrix;
		tempMatrix = temp;
	}

	private boolean askStartOver() {
		String message = String.format("The The bacteria population %s.\nDo you want to start over?",
				countBacterias() == 0 ? "is dead" : "stabilized");
		int result = JOptionPane.showConfirmDialog(null,
				message, "", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	private int getANumber() {
		boolean isNumberOK = false;
		String numberStr = JOptionPane.showInputDialog("Enter a positive whole number");
		while (!isNumberOK) {
			try {
				int number = Integer.parseInt(numberStr);
				if (number > 0)
					return number;
				// throw new NumberFormatException();
			} catch (NumberFormatException ex) {
				if (numberStr == null) {
					return -1;
				}
			}
			numberStr = JOptionPane.showInputDialog("The number is not valid, enter a new one");
		}
		return -1;

	}

	private void showByeBye() {
		c.removeAll();
		c.add(displayBoard, BorderLayout.CENTER);
		displayBoard.setText("");
		displayBoard.setFont(new Font("monospaced", Font.BOLD, 26));
		addColoredText("Bye Bye", Color.BLUE);
	}

	private int countBacterias() {
		int counter = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j]) {
					counter++;
				}
			}
		}
		return counter;
	}

	private void setLabelText() {
		int numberOfBacterias = countBacterias();
		numberOfBacteriasLabel.setText(String.format("Number of alive bacterias: %d", numberOfBacterias));
	}

	private void addColoredText(String text, Color color) {

		StyledDocument doc = displayBoard.getStyledDocument();
		Style style = displayBoard.addStyle("I'm a Style", null);
		StyleConstants.setForeground(style, color);

		try {
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
		}

	}
}