package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfLife extends JApplet implements ActionListener {

	private Container c;
	private JTextArea displayBoard; // display board
	private JButton nextGeneration; // button to generate next generation

	public void init() { // Applet init() method
		// set layout manager
		c = getContentPane();
		c.setLayout(new BorderLayout());

		// setup components
		displayBoard = new JTextArea();
		nextGeneration = new JButton("Next generation");
		nextGeneration.addActionListener(this);
		displayBoard.setEditable(false);
		// add components to applet
		c.add(displayBoard, BorderLayout.CENTER);
		c.add(nextGeneration, BorderLayout.SOUTH);
		JOptionPane.showInputDialog("Enter Data");
	}

	public void displayLife() {
		if (displayBoard.getText().equals("")) {
			displayBoard.setText("Hello");
			displayBoard.append("\n");
			displayBoard.append("YG 4");
		} else {
			displayBoard.setText("");
		}

	}

	// implementation of ActionListener interface
	public void actionPerformed(ActionEvent e) {
		generateNextGeneration();
		displayLife();
	}

	public void generateNextGeneration() {

	}
}
