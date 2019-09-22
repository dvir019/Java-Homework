package app;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class CubesTower extends JApplet implements ActionListener {

	private Container c;
	private int cubeLength;

	public void init() { // Applet init() method
		// set layout manager
		c = getContentPane();
		c.setLayout(new BorderLayout());

		cubeLength = getANumber();

	}

	@Override
	public void paint(Graphics g) {
		clearScreen(g);
		g.setColor(Color.RED);
		g.drawRect(5, 5,  getWidth()/ 3, getHeight() / 3);
		
	}

	private void clearScreen(Graphics g)
	{
		Color color = g.getColor();
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(color);
	}

	private int getANumber() {
		boolean isNumberOK = false;
		String numberStr = JOptionPane.showInputDialog("Enter a positive whole number");
		while (!isNumberOK) {
			try {
				int number = Integer.parseInt(numberStr);
				if (number > 0)
					return number;
			} catch (NumberFormatException ex) {
				if (numberStr == null) {
					return -1;
				}
			}
			numberStr = JOptionPane.showInputDialog("The number is not valid, enter a new one");
		}
		return -1;

	}

	// implementation of ActionListener interface
	public void actionPerformed(ActionEvent e) {

	}
}
