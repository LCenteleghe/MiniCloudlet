package br.unisinos.edu.request.processor;

import br.unisinos.edu.lcloudlet.api.SimpleQueryRequest;
import br.unisinos.edu.request.processor.query.GeneralQueryProcessor;

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
