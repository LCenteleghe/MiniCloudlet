package br.unisinos.edu.lcloudlet.api;

import java.io.Serializable;

public class ServiceExecutionRequest implements Serializable{
	private static final long serialVersionUID = -6493525239149932063L;
	
	private String serviceID;
	
	private Object[] parameters;
	
	public ServiceExecutionRequest(String serviceID, Object[] parameterData) {
		super();
		this.serviceID = serviceID;
		this.parameters = parameterData;
	}

	public String getServiceID() {
		return serviceID;
	}

	public Object[] getParametersData() {
		return parameters;
	}

	@Override
	public String toString() {
		return "ServiceExecutionRequest [serviceID=" + serviceID + ", parameters=" + parameters + "]";
	}
}
