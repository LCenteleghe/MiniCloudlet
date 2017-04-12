package br.unisinos.edu.request.dto;

import java.io.Serializable;

public class ServiceCheckRequest implements Serializable {
	private static final long serialVersionUID = 3575576140491136233L;
	
	private String serviceID;
	
	public ServiceCheckRequest(String serviceID){
		this.serviceID = serviceID;
	}

	public String getServiceID() {
		return serviceID;
	}

	@Override
	public String toString() {
		return "ServiceCheckRequest [serviceID=" + serviceID + "]";
	}
}
