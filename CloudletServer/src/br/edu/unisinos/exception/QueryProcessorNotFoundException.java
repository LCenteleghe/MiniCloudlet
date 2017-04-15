package br.edu.unisinos.exception;

import java.util.List;

import br.edu.unisinos.request.processor.query.QueryProcessor;

public class QueryProcessorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3598233401870645621L;

	public QueryProcessorNotFoundException(String query, List<QueryProcessor> queryProcessors) {
		super("No query processor was found for the query: " + query + " \n Available queries: "
				+ buildAvailableQueriesMessage(queryProcessors));
	}

	private static String buildAvailableQueriesMessage(List<QueryProcessor> queryProcessors) {
		StringBuilder sb = new StringBuilder();
		
		for (QueryProcessor queryProcessor : queryProcessors) {
			sb.append(queryProcessor.getQuerySummary());
			sb.append('\n');
		}
		
		return sb.toString();
	}

}
