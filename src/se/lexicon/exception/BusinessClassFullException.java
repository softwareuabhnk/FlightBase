package se.lexicon.exception;

public class BusinessClassFullException extends FlightFullException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3246709984670540037L;

	public BusinessClassFullException() { super(); }
	public BusinessClassFullException(String message) { super(message); }
	public BusinessClassFullException(String message, Throwable cause) { super(message, cause); }
}
