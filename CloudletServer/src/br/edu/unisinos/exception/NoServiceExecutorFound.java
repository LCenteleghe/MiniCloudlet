package br.edu.unisinos.exception;

/**
 * Exception thrown when no Service Executor is found for a given MIME type.
 */
public class NoServiceExecutorFound extends RuntimeException {
	
	/**
	 * Instantiates a new no service executor found.
	 *
	 * @param mimeType the mime type
	 */
	public NoServiceExecutorFound(String mimeType) {
		super("No service executor was found for the MIME Type: " + mimeType);
	}

	private static final long serialVersionUID = -842028203164578999L;

}
