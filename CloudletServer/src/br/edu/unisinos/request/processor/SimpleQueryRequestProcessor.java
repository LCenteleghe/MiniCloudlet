package br.edu.unisinos.request.processor;

import br.edu.unisinos.lcloudlet.api.SimpleQueryRequest;
import br.edu.unisinos.request.processor.query.GeneralQueryProcessor;

/**
 * A simple query processor.
 */
public final class SimpleQueryRequestProcessor implements RequestProcessor<SimpleQueryRequest, String> {

	private SimpleQueryRequestProcessor() {
	}

	/**
	 * Gets the single instance of SimpleQueryRequestProcessor.
	 *
	 * @return single instance of SimpleQueryRequestProcessor
	 */
	public static SimpleQueryRequestProcessor getInstance() {
		return new SimpleQueryRequestProcessor();
	}

	@Override
	public String processRequest(SimpleQueryRequest request) {
		return GeneralQueryProcessor
				.getInstance()
				.processQuery(request.getQuery());
	}
}
