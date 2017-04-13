package br.unisinos.edu.request.processor.query;

public interface QueryProcessor {
	public String processQuery(String query);
	
	public String getQueryStyle();
	
	public String getQuerySummary();
}
