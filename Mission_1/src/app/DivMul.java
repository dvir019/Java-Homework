package app;

import java.util.Random;
import javax.swing.JOptionPane;

public class DivMul {
	// ---------------------------------------------------------------------------------
	// Divide And Multiply
	// -------------------
	//
	// General : Gives the user to solve simple mathematical exercises.
	//
	// Input : The answer of the exercise from the user.
	//
	// Process : Produce two random numbers and a mathematical operation,
	// gives the user to answer the exercise, and check the answer.
	//
	// Output : Whether or not the answer is true.
	//
	// ---------------------------------------------------------------------------------
	// Programmer : Dvir Twito
	// Student No : 324270883
	// Date : 07.09.2019
	// ---------------------------------------------------------------------------------
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
				firstNumber -= firstNumber % secondNumber;
			}
			String expression = createExpression(firstNumber, operator, secondNumber);
			userAnswer = JOptionPane.showInputDialog(expression);
			if (userAnswer != null && !userAnswer.isEmpty()) {
				while (!(userAnswer == null || userAnswer.isEmpty() || isNumber(userAnswer))) {
					JOptionPane.showMessageDialog(null, "You must to enter a number");
					userAnswer = JOptionPane.showInputDialog(expression);
				}
				if (userAnswer != null && !userAnswer.isEmpty()) {
					int intUserAnswer = Integer.parseInt(userAnswer);
					int realAnswer = calculate(firstNumber, operator, secondNumber);
					if (intUserAnswer == realAnswer) {
						winningCounter++;
						System.out.println("Correct");
					} else {
						System.out.println("Wrong");
						JOptionPane.showMessageDialog(null,
								String.format("You are wrong, %s = %d", expression, realAnswer));
					}
					totalCounter++;
				}
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

	private static Boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}