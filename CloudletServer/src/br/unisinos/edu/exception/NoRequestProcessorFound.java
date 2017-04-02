package br.unisinos.edu.exception;

public class NoRequestProcessorFound extends RuntimeException {
	private static final long serialVersionUID = -3406661384236662640L;

	public NoRequestProcessorFound(Object request) {
		super("No request processor was found for the request of the type: " + request.getClass());
	}

}
