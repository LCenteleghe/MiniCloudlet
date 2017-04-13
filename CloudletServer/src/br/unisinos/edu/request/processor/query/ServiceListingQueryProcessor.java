package br.unisinos.edu.request.processor.query;

public class ServiceListingQueryProcessor implements QueryProcessor {
	private static ServiceListingQueryProcessor instance = new ServiceListingQueryProcessor();
	
	@Override
	public String processQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuerySummary() {
		return "LIST  Lists all the services available in the cloudlet.";
	}

	public static ServiceListingQueryProcessor getInstance(){
		return instance;
	}
}
