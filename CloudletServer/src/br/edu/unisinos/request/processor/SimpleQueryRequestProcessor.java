package br.edu.unisinos.request.processor;

import br.edu.unisinos.lcloudlet.api.SimpleQueryRequest;
import br.edu.unisinos.request.processor.query.GeneralQueryProcessor;

public final class SimpleQueryRequestProcessor implements RequestProcessor<SimpleQueryRequest, String> {

	private SimpleQueryRequestProcessor() {
	}

	public static SimpleQueryRequestProcessor getInstance() {
		return new SimpleQueryRequestProcessor();
	}

	public String processRequest(SimpleQueryRequest request) {
		return GeneralQueryProcessor
				.getInstance()
				.processQuery(request.getQuery());
	}
}