package br.edu.unisinos.exception;

public class NoServiceExecutorFound extends RuntimeException {
	public NoServiceExecutorFound(String mimeType) {
		super("No service executor was found for the MIME Type: " + mimeType);
	}

	private static final long serialVersionUID = -842028203164578999L;

}
