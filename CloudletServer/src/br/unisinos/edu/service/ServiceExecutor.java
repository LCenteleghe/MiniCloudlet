package br.unisinos.edu.service;

import br.unisinos.edu.lcloudlet.api.Service;

public interface ServiceExecutor {
	Object execute(Service service, Object[] parameters);
}
