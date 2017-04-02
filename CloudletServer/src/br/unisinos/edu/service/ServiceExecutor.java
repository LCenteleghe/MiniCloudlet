package br.unisinos.edu.service;

import br.unisinos.edu.Service;

public interface ServiceExecutor {
	Object execute(Service service, Object parametersData);
}
