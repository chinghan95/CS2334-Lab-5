import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Lab 5 Driver
 * CS 2334 Spring 2020
 * 
 * This class is complete. There is no need to modify the code.
 */
public class Driver {

	private static final String PROMPT = "Input: ";
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Java Calculator");
		System.out.println("---------------");
		System.out.println();
		System.out.println("Input formats:");
		System.out.println("1. OP x, where OP is log, sin, cos, or tan.");
		System.out.println("2. x OP y, where OP is +, -, *, /, or ^.");
		System.out.println();
		
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader userInput = new BufferedReader(stdin);
		
		// Perform a priming read before entering the user input loop.
		System.out.print(PROMPT);
		String expression = userInput.readLine();
		
		// Get expressions from the user until they quit.
		while (!expression.equalsIgnoreCase("quit")) {
			
			String result = Calculator.calculate(expression);
			System.out.println(result);
			System.out.println();
			
			System.out.print(PROMPT);
			expression = userInput.readLine();
		}
		
		System.out.println("Goodbye!");
	}
}
