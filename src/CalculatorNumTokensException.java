/**
 * A custom exception used by Calculator to indicate when an expression has an 
 * invalid number of tokens.
 * @author Ching Han Huang
 * @version 1.0
 */

// Inherit from the Exception class.
public class CalculatorNumTokensException extends Exception{
	
	// Any class that inherits from Exception will generate a warning if this 
	// field is not initialized. We may discuss its use later in the semester.
	private static final long serialVersionUID = 1L;
	
	public CalculatorNumTokensException(int numTokens) {
		
		// Pass the number of tokens to the parent class constructor that 
		// takes a single String argument. (See the Exception class API.)
		super(Integer.toString(numTokens));
	}
	
	public CalculatorNumTokensException(String message, int numTokens) {
		
		super(message + Integer.toString(numTokens));
	}
}
