package br.unisinos.edu.request.processor.query;

import java.util.Arrays;
import java.util.List;

import br.unisinos.edu.exception.QueryProcessorNotFoundException;

public class GeneralQueryProcessor {
	private static final GeneralQueryProcessor instance = new GeneralQueryProcessor();
	
	private static List<QueryProcessor> queryProcessors = 
			Arrays.asList(
					ServiceCheckQueryProcessor.getInstance(),
					ServiceListingQueryProcessor.getInstance(),
					ClouletAvailabilityQueryProcessor.getInstance()
			);
	
	private GeneralQueryProcessor(){}
	
	public static GeneralQueryProcessor getInstance(){
		return instance;
	}
	
	public String processQuery(String query) {
		for (QueryProcessor queryProcessor : queryProcessors) {
			if(query.startsWith(queryProcessor.getQueryBaseCommand())){
				return queryProcessor.processQuery(query);
			}
		}
		
		throw new QueryProcessorNotFoundException(query, queryProcessors);
	}
}
