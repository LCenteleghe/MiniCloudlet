package br.unisinos.edu.request.dto;

import java.io.Serializable;

public class ServiceExecutionRequest implements Serializable{
	private static final long serialVersionUID = -6493525239149932063L;
	
	private String serviceID;
	
	private Object parameterData;
	
	public ServiceExecutionRequest(String serviceID, Object parameterData) {
		super();
		this.serviceID = serviceID;
		this.parameterData = parameterData;
	}

	public String getServiceID() {
		return serviceID;
	}

	public Object getParametersData() {
		return parameterData;
	}

	@Override
	public String toString() {
		return "ServiceExecutionRequest [serviceID=" + serviceID + ", parameterData=" + parameterData + "]";
	}
}
