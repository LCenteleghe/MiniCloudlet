package br.unisinos.edu.request.processor.query;

import br.unisinos.edu.ServicesBase;

public class ServiceListingQueryProcessor implements QueryProcessor {
	private static ServiceListingQueryProcessor instance = new ServiceListingQueryProcessor();
	
	@Override
	public String processQuery(String query) {
		return String.valueOf(ServicesBase.getInstance().getServicesIDs());
	}
	
	@Override
	public String getQueryBaseCommand() {
		return "LIST";
	}

	@Override
	public String getQuerySummary() {
		return "LIST  Lists all the services available in the cloudlet.";
	}

	public static ServiceListingQueryProcessor getInstance(){
		return instance;
	}
}
