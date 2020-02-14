/**
 * This utility class is used by Driver to parse user input and calculate the 
 * results of calculator expressions.
 * @author Ching Han Huang
 * @version 1.0
 */
public class Calculator {

	/**
	 * This is the only method called by the Driver class. If the given 
	 * expression is valid, it returns the result. Otherwise, it returns an 
	 * error message that describes the problem.
	 */
	public static String calculate(String expression) {

		// Pass the given expression to parseAndCalc() and return the 
		// result as a String. If parseAndCalc() throws an exception, catch it 
		// and return an error message. The message should correspond to the 
		// exception type and have the format shown in the sample run in the 
		// README.
		String result;
		double resultOfCalc = 0.0;
		try {
			resultOfCalc = parseAndCalc(expression);
			result = Double.toString(resultOfCalc);
		}
		
		catch(CalculatorNumTokensException e) {
			result = e.getMessage();
		}
		catch (CalculatorOperatorException e) {
			result = e.getMessage();
		}
		// The third type is thrown if an operand in the expression cannot be parsed as a double.
		catch(NumberFormatException e) {
			result = "Cannot parse " + getOperand(e) + " as a double.";
		}

		return result;
	}
	
	/**
	 * Given a NumberFormatException caused by a String that cannot be parsed 
	 * as a double, return the String that caused the exception.
	 * Note: You do not need to change this method. It is intended to help you 
	 * create the corresponding error message in calculate().
	 */
	private static String getOperand(NumberFormatException exception) {
		String message = exception.getMessage();
		String[] tokens = message.split(" ");
		return tokens[tokens.length - 1];
	}
	
	/**
	 * Parse a given calculator expression and return the result.
	 *
	 * @throws CalculatorNumTokensException, CalculatorOperatorException, NumberFormatException
	 */
	public static double parseAndCalc(String expression) throws CalculatorNumTokensException, CalculatorOperatorException, NumberFormatException {
		
		// Splits the string based on whitespace and plus symbol (\s+)
		String[] tokens = expression.split("\\s+");

		double result = 0;
		// The number of tokens
		int numTokens = tokens.length;
		
		// If the expression contains two tokens, pass it to 
		// calcTwoTokens() and return the result. 
		if (numTokens == 2) {
			result = calcTwoTokens(tokens);
		}
		
		// If the expression contains three tokens,
		// pass it to calcThreeTokens() and return the result.
		else if (numTokens == 3) {
			result = calcThreeTokens(tokens);
		}
		
		// Otherwise, throw a CalculatorNumTokensException.
		else {
			throw new CalculatorNumTokensException(numTokens);
		}

		return result;
	}
	
	/**
	 * Given the tokens from a two-token expression, return the result. The 
	 * operator is stored at index 0, and the operand is stored at index 1.
	 * The possible operators are log, sin, cos, and tan.
	 * @throws CalculatorOperatorException, NumberFormatException
	 */
	public static double calcTwoTokens(String[] tokens) throws CalculatorOperatorException, NumberFormatException {
		
		// Parse the operand as a double and return the result of the expression. 
		// For example: tokens = ["sin", "7"]
		// operand = 7
		// operator = "sin"
		// However, if operand can not be parsed as a double, this could throw NumberFormatException.
		// (This is unchecked exception, a.k.a DEFAULT.)
		double operand = Double.parseDouble(tokens[1]);
		double result = 0.0;
		String operator = tokens[0];

		if (operator.equals("log")) {
			result = Math.log(operand);
		}
		else if (operator.equals("sin")) {
			result = Math.sin(operand);
		}
		else if (operator.equals("cos")) {
			result = Math.cos(operand);
		}
		else if (operator.equals("tan")) {
			result = Math.tan(operand);
		}
		//If the operator is not "log", "sin", "cos", or "tan", throw a CalculatorOperatorException.
		else {
			throw new CalculatorOperatorException("Invalid operator: " + operator);
		}

		return result;
	}

	/**
	 * Given the tokens from a three-token expression, return the result. The 
	 * operator is stored at index 1, and the operands are stored at indices 0 
	 * and 2. The possible operators are +, -, *, /, and ^.
	 * @throws CalculatorOperatorException, NumberFormatException
	 */
	public static double calcThreeTokens(String[] tokens) throws CalculatorOperatorException, NumberFormatException {
		
		// Parse the operands as doubles and return the result of the expression. 
		// For example: tokens = ["3", "+", "4"]
		// operand1 = 3
		// operand2 = 4
		// operator = "+"
		// However, if operand can not be parsed as a double, this could throw NumberFormatException.
		// (This is unchecked exception, a.k.a DEFAULT.)
		double operand1 = Double.parseDouble(tokens[0]);
		double operand2 = Double.parseDouble(tokens[2]);
		double result = 0.0;
		String operator = tokens[1];
		
		if (operator.equals("+")) {
			result = operand1 + operand2;
		}
		else if (operator.equals("-")) {
			result = operand1 - operand2;
		}
		else if (operator.equals("*")) {
			result = operand1 * operand2;
		}
		else if (operator.equals("/")) {
			result = operand1 / operand2;
		}
		// The operator "^" stands for exponentiation.
		else if (operator.equals("^")) {
			result = Math.pow(operand1, operand2);
		}
		// If the operator is not "+", "-", "*", "/", or "^", throw a CalculatorOperatorException.
		else {
			throw new CalculatorOperatorException("Invalid operator: " + operator);
		}
		
		return result;
	}
}
