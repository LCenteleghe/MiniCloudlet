package br.edu.unisinos.request.processor;

public class ServiceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2632853778532457158L;

	public ServiceNotFoundException(String serviceID) {
		super("No service with id=" + serviceID + " was found.");
	}

}
