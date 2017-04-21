package br.edu.unisinos.exception;

import java.util.List;

import br.edu.unisinos.request.processor.query.QueryProcessor;

/**
 * Exception thrown when  a query processor is not found for a given base command.
 */
public class QueryProcessorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3598233401870645621L;

	/**
	 * Instantiates a new query processor not found exception.
	 *
	 * @param query the query
	 * @param queryProcessors the available query processors
	 */
	public QueryProcessorNotFoundException(String query, List<QueryProcessor> queryProcessors) {
		super("No query processor was found for the query: " + query + " \n Available queries: "
				+ buildAvailableQueriesMessage(queryProcessors));
	}

	/**
	 * Builds the available-queries message.
	 *
	 * @param queryProcessors the query processors
	 * @return the string
	 */
	private static String buildAvailableQueriesMessage(List<QueryProcessor> queryProcessors) {
		StringBuilder sb = new StringBuilder();
		
		for (QueryProcessor queryProcessor : queryProcessors) {
			sb.append(queryProcessor.getQuerySummary());
			sb.append('\n');
		}
		
		return sb.toString();
	}

}
