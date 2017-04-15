package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;

public class ServiceRegistrationRequest implements Serializable {
	private static final long serialVersionUID = 3575576140491136233L;
	
	private final Service service;
	
	public ServiceRegistrationRequest(Service service){
		this.service = service;
	}

	public Service getService() {
		return service;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [service=" + service + "]";
	}
}
