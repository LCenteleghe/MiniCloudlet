package br.unisinos.edu.request.processor.query;

public interface QueryProcessor {
	String processQuery(String query);
	
	String getQuerySummary();

	String getQueryBaseCommand();
	
}
