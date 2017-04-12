package br.unisinos.edu.exception;

public class ServiceExecutionFailureException extends RuntimeException {
	private static final long serialVersionUID = -8874327275198185253L;
	
	private final String failureCauseMessage;
	
	public ServiceExecutionFailureException(Throwable cause) {
		failureCauseMessage = cause.getMessage();
	}

	public String getFailureCauseMessage() {
		return failureCauseMessage;
	}

	@Override
	public String toString() {
		return "ServiceExecutionFailureException [failureCauseMessage=" + failureCauseMessage + "]";
	}
}
