package br.edu.unisinos.exception;

/**
 * Exception thrown when an Invalid Query Parameter is received.
 */
public class InvalidQueryParametersException extends RuntimeException {
	private static final long serialVersionUID = -1147663422935636332L;

	/**
	 * Instantiates a new invalid query parameters exception.
	 *
	 * @param queryParts the query parts
	 * @param actual the actual
	 */
	public InvalidQueryParametersException(String[] queryParts, String actual) {
		super("Insuficient query parameters receiveid. "
				+ "Expected parameters: " + queryParts 
				+ " Received parameters: " + actual);
	}

}