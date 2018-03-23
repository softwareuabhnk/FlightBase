package se.lexicon.exception;

public class EconomyClassFullException extends FlightFullException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6427409275789261937L;

	public EconomyClassFullException() { super(); }
	public EconomyClassFullException(String message) { super(message); }
	public EconomyClassFullException(String message, Throwable cause) { super(message, cause); }
}
