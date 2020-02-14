/**
 * A custom exception used by Calculator to indicate when an expression has an 
 * invalid operator.
 * @author Ching Han Huang
 * @version 1.0
 */

// Inherit from the Exception class.
public class CalculatorOperatorException extends Exception{
	
	// Any class that inherits from Exception will generate a warning if this 
	// field is not initialized. We may discuss its use later in the semester.
	private static final long serialVersionUID = 2L;
	
	public CalculatorOperatorException(String operator) {
		
		// Pass the operator to the parent class constructor that takes
		// a single String argument. (See the Exception class API.)
		super(operator);
	}
}
