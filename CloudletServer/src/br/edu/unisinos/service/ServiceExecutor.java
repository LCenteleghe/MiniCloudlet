package br.edu.unisinos.service;

import br.edu.unisinos.lcloudlet.api.Service;

public interface ServiceExecutor {
	Object execute(Service service, String method, Object[] parameters);
}
