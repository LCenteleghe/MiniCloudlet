package br.unisinos.edu.request.processor.query;

import java.util.regex.Pattern;

public class ServiceCheckQueryProcessor implements QueryProcessor {
	private static ServiceCheckQueryProcessor instance = new ServiceCheckQueryProcessor();
	
	Pattern pattern = Pattern.compile("CHECK (\\S+)");
	
	private ServiceCheckQueryProcessor() {}

	@Override
	public String processQuery(String query) {
		return getQueryStyle();
	}

	@Override
	public String getQueryStyle() {
		return "";
	}

	@Override
	public String getQuerySummary() {
		return "CHECK $ServiceID 	Check whether a service is available in cloudlet.";
	}
	
	public static ServiceCheckQueryProcessor getInstance(){
		return instance;
	}
}
