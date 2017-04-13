package br.unisinos.edu.request.processor.query;

import java.util.Arrays;
import java.util.List;

public class GeneralQueryProcessor {
	private static List<QueryProcessor> queryProcessors = 
			Arrays.asList(
					ServiceCheckQueryProcessor.getInstance(),
					ServiceListingQueryProcessor.getInstance(),
					ClouletAvailabilityQueryProcessor.getInstance()
			);
	
	
}
