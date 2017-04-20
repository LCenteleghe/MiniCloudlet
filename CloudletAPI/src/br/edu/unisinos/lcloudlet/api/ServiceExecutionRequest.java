package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Represents a request for service execution.
 */
public class ServiceExecutionRequest implements Serializable{
	private static final long serialVersionUID = -6493525239149932063L;
	
	private String serviceID;
	
	private String method;
	
	private Object[] parameters;

	/**
	 * Instantiates a new service execution request.
	 *
	 * @param serviceID the service ID
	 * @param method the method
	 * @param parameters the parameters
	 */
	public ServiceExecutionRequest(String serviceID, String method, Object[] parameters) {
		super();
		this.serviceID = serviceID;
		this.method = method;
		this.parameters = parameters;
	}

	/**
	 * Gets the service ID.
	 *
	 * @return the service ID
	 */
	public String getServiceID() {
		return serviceID;
	}

	/**
	 * Gets the parameters data.
	 *
	 * @return the parameters data
	 */
	public Object[] getParametersData() {
		return parameters;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return "ServiceExecutionRequest [serviceID=" + serviceID + ", method=" + method + ", parameters="
				+ Arrays.toString(parameters) + "]";
	}
}
