package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;

/**
 * Represents a request for service registration.
 */
public class ServiceRegistrationRequest implements Serializable {
	private static final long serialVersionUID = 3575576140491136233L;
	
	private final Service service;
	
	/**
	 * Instantiates a new service registration request.
	 *
	 * @param service the service
	 */
	public ServiceRegistrationRequest(Service service){
		this.service = service;
	}

	/**
	 * Gets the service itself.
	 *
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [service=" + service + "]";
	}
}
