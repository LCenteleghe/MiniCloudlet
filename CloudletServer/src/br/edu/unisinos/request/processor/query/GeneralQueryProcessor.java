package br.edu.unisinos.request.processor.query;

import java.util.Arrays;
import java.util.List;

import br.edu.unisinos.exception.QueryProcessorNotFoundException;

/**
 * General query processor.
 */
public class GeneralQueryProcessor {
	private static final GeneralQueryProcessor instance = new GeneralQueryProcessor();
	
	private static List<QueryProcessor> queryProcessors = 
			Arrays.asList(
					ServiceCheckQueryProcessor.getInstance(),
					ServiceListingQueryProcessor.getInstance(),
					ClouletAvailabilityQueryProcessor.getInstance()
			);
	
	private GeneralQueryProcessor(){}
	
	/**
	 * Gets the single instance of GeneralQueryProcessor.
	 *
	 * @return single instance of GeneralQueryProcessor
	 */
	public static GeneralQueryProcessor getInstance(){
		return instance;
	}
	
	/**
	 * Process a simple query.
	 *
	 * @param query the query
	 * @return the response for the query.
	 */
	public String processQuery(String query) {
		for (QueryProcessor queryProcessor : queryProcessors) {
			if(query.startsWith(queryProcessor.getQueryBaseCommand())){
				return queryProcessor.processQuery(query);
			}
		}
		
		throw new QueryProcessorNotFoundException(query, queryProcessors);
	}
}
