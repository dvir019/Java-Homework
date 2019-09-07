package app;

import java.util.Random;
import javax.swing.*;

public class DivMul {
	public static void main(String[] args) {
		int totalCounter = 0;
		int winningCounter = 0;
		String userAnswer = " ";
		Random rnd = new Random();
		int firstNumber;
		int secondNumber;
		while (userAnswer != null && !userAnswer.isEmpty()) {
			char operator = getOperator();
			if (operator == '*') {
				firstNumber = rnd.nextInt(10);
				secondNumber = rnd.nextInt(10);
			} else {
				firstNumber = rnd.nextInt(100);
				secondNumber = rnd.nextInt(9) + 1;
				firstNumber += howMuchToAdd(firstNumber, secondNumber);
			}
			String expression = createExpression(firstNumber, operator, secondNumber);
			userAnswer = JOptionPane.showInputDialog(expression);
			if (userAnswer != null && !userAnswer.isEmpty()) {
				int intUserAnswer = Integer.parseInt(userAnswer);
				int realAnswer = calculate(firstNumber, operator, secondNumber);
				if (intUserAnswer == realAnswer) {
					winningCounter++;
					JOptionPane.showMessageDialog(null, "You are right!!");
				} else
					JOptionPane.showMessageDialog(null, String.format("You are wrong, the answer is %d", realAnswer));
				totalCounter++;
			}
		}

		JOptionPane.showMessageDialog(null, String.format("You were right in %d%% of the questions",
				(int) ((((double) winningCounter) / totalCounter) * 100)));
	}

	private static char getOperator() {
		Random rnd = new Random();
		double randonValue = rnd.nextDouble();
		if (randonValue < 0.5)
			return '/';
		return '*';
	}

	private static int calculate(int firstNumber, char operator, int secondNumber) {
		if (operator == '/')
			return firstNumber / secondNumber;
		return firstNumber * secondNumber;
	}

	private static String createExpression(int firstNumber, char operator, int secondNumber) {
		return String.format("%d %c %d", firstNumber, operator, secondNumber);
	}

	private static int howMuchToAdd(int firstNumber, int secondNumber) {
		int remainder = firstNumber % secondNumber;
		if (firstNumber % (secondNumber + remainder) == 0)
			return remainder;
		else
			return -remainder;
	}
}