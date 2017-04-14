package br.unisinos.edu.exception;

public class InvalidQueryParametersException extends RuntimeException {
	private static final long serialVersionUID = -1147663422935636332L;

	public InvalidQueryParametersException(String[] queryParts, String actual) {
		super("Insuficient query parameters receiveid. "
				+ "Expected parameters: " + queryParts 
				+ " Received parameters: " + actual);
	}

}