package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;
import java.util.Arrays;

public class ServiceExecutionRequest implements Serializable{
	private static final long serialVersionUID = -6493525239149932063L;
	
	private String serviceID;
	
	private String method;
	
	private Object[] parameters;

	public ServiceExecutionRequest(String serviceID, String method, Object[] parameters) {
		super();
		this.serviceID = serviceID;
		this.method = method;
		this.parameters = parameters;
	}

	public String getServiceID() {
		return serviceID;
	}

	public Object[] getParametersData() {
		return parameters;
	}

	public String getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return "ServiceExecutionRequest [serviceID=" + serviceID + ", method=" + method + ", parameters="
				+ Arrays.toString(parameters) + "]";
	}
}
