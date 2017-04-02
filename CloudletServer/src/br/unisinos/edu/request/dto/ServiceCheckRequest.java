package br.unisinos.edu.request.dto;

public class ServiceCheckRequest {
	private String serviceID;
	
	public ServiceCheckRequest(String serviceID){
		this.serviceID = serviceID;
	}

	public String getServiceID() {
		return serviceID;
	}
}
