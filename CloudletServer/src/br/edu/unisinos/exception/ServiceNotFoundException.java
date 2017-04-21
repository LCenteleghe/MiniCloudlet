package br.edu.unisinos.exception;

/**
 * Exception thrown when a service with a given ID not found.
 */
public class ServiceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2632853778532457158L;

	/**
	 * Instantiates a new service not found exception.
	 *
	 * @param serviceID the service ID
	 */
	public ServiceNotFoundException(String serviceID) {
		super("No service with id=" + serviceID + " was found.");
	}

}
