package br.edu.unisinos.exception;

/**
 * Exception thrown when an error occurs to execute a service.
 */
public class ServiceExecutionFailureException extends RuntimeException {
	private static final long serialVersionUID = -8874327275198185253L;
	
	private final String failureCauseMessage;
	
	/**
	 * Instantiates a new service execution failure exception.
	 *
	 * @param cause the cause
	 */
	public ServiceExecutionFailureException(Throwable cause) {
		failureCauseMessage = cause.getMessage();
	}

	/**
	 * Gets the failure cause message.
	 *
	 * @return the failure cause message
	 */
	public String getFailureCauseMessage() {
		return failureCauseMessage;
	}

	@Override
	public String toString() {
		return "ServiceExecutionFailureException [failureCauseMessage=" + failureCauseMessage + "]";
	}
}
