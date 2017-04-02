package br.unisinos.edu.request.dto;

import br.unisinos.edu.Service;

public class RegistrationRequest {
	private final Service service;
	
	public RegistrationRequest(Service service){
		this.service = service;
	}

	public Service getService() {
		return service;
	}
}
