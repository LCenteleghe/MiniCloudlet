package br.edu.unisinos.request.processor.query;

public interface QueryProcessor {
	String processQuery(String query);
	
	String getQuerySummary();

	String getQueryBaseCommand();
	
}
