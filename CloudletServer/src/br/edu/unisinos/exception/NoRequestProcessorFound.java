package br.edu.unisinos.exception;

/**
 * Exception thrown when an no Request Processors are found for a request.
 */
public class NoRequestProcessorFound extends RuntimeException {
	private static final long serialVersionUID = -3406661384236662640L;

	/**
	 * Instantiates a new no request processor found.
	 *
	 * @param request the request
	 */
	public NoRequestProcessorFound(Object request) {
		super("No request processor was found for the request of the type: " + request.getClass());
	}
}
