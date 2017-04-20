package br.edu.unisinos.service;

import br.edu.unisinos.exception.NoServiceExecutorFound;
import br.edu.unisinos.lcloudlet.api.Service;

/**
 * A factory for creating ServiceExecutor objects.
 */
public final class ServiceExecutorFactory {
	private ServiceExecutorFactory(){}
	
	/**
	 * Gets the executor by its service MIME.
	 *
	 * @param service the service
	 * @return the executor by its service MIME
	 */
	public static ServiceExecutor getExecutorByServiceMIME(Service service){
		String mimeType = service.getMimeType();
		
		if("application/java".equals(mimeType)){
			return new ClassExecutor();
		}
		
		if("application/javascript".equals(mimeType)){
			return new ScriptExecutor(mimeType);
		}
		
		throw new NoServiceExecutorFound(mimeType);
	}
}
