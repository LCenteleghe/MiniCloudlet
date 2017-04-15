package br.unisinos.edu.service;

import br.edu.unisinos.lcloudlet.api.Service;

public interface ServiceExecutor {
	Object execute(Service service, Object[] parameters);
}
