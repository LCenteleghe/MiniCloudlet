package br.edu.unisinos;

public class IncorrectResponseTypeException extends RuntimeException {
	private static final long serialVersionUID = -6673402854437997059L;

	public IncorrectResponseTypeException(Class<?> expected, Class<?> received) {
		super("The server hasn't returned the expected result type. "
				+ "Expected: " + expected + " | "
				+ "Received: " + received);
	}

}
