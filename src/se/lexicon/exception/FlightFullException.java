package se.lexicon.exception;

public class FlightFullException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7862329245853862776L;

	public FlightFullException() { super(); }
	public FlightFullException(String message) { super(message); }
	public FlightFullException(String message, Throwable cause) { super(message, cause); }
}

