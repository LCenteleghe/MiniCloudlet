package br.edu.unisinos.request.processor;

/**
 * The Interface of a RequestProcessor.
 *
 * @param <T> the request type
 * @param <S> the response type
 */
public interface RequestProcessor<T,S> {
	
	/**
	 * Process a request.
	 *
	 * @param request the request
	 * @return the response
	 */
	public S processRequest(T request);
}
