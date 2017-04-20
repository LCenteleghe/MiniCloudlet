package br.edu.unisinos.service;

import br.edu.unisinos.lcloudlet.api.Service;

/**
 * The Interface for Service Executors .
 */
public interface ServiceExecutor {
	
	/**
	 * Executes a service.
	 *
	 * @param service the service
	 * @param method the method
	 * @param parameters the parameters
	 * @return the response object
	 */
	Object execute(Service service, String method, Object[] parameters);
}
