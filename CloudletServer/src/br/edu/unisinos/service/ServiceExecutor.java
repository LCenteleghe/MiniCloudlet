package br.edu.unisinos.service;

import br.edu.unisinos.lcloudlet.api.Service;

public interface ServiceExecutor {
	Object execute(Service service, Object[] parameters);
}
