package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameOfLife extends JApplet implements ActionListener {

	private Container c;
	private JTextArea displayBoard; // display board
	private JButton nextGeneration; // button to generate next generation

	private boolean[][] matrix;
	private boolean[][] tempMatrix;
	private int rows;
	private int columns;

	public void init() { // Applet init() method
		// set layout manager
		c = getContentPane();
		c.setLayout(new BorderLayout());

		// setup components
		displayBoard = new JTextArea();
		displayBoard.setEditable(false);
		displayBoard.setFont(new Font("monospaced", Font.PLAIN, 12));
		nextGeneration = new JButton("Next generation");
		nextGeneration.addActionListener(this);

		// add components to applet
		c.add(displayBoard, BorderLayout.CENTER);
		c.add(nextGeneration, BorderLayout.SOUTH);

		rows = 30;
		columns = 30;
		matrix = new boolean[rows][columns];
		tempMatrix = new boolean[rows][columns];
		
		matrix[13][14] = true;
		matrix[14][13]=true;
		matrix[14][14]=true;
		matrix[14][15]=true;
		matrix[15][13]=true;
		matrix[15][15]=true;
		matrix[16][14]=true;
		
		displayLife();
	}

	public void displayLife() {
		String str = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j])
					str += "+";
				else
					str += "-";
				if (j < columns - 1)
					str += " ";
			}
			str += "\n";
		}
		displayBoard.setText(str);
	}

	// implementation of ActionListener interface
	public void actionPerformed(ActionEvent e) {
		generateNextGeneration();
		displayLife();
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
}