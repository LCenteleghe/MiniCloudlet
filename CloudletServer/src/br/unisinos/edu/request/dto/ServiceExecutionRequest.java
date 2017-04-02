package br.unisinos.edu.request.dto;

public class ServiceExecutionRequest {
	private String serviceID;
	private Object parameterData;
	
	public String getServiceID() {
		return serviceID;
	}

	public Object getParametersData() {
		return parameterData;
	}
}
