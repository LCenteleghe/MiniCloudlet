package br.edu.unisinos.request.processor.query;

import br.edu.unisinos.ServicesDataBase;

/**
 * Query processor used for listing the services available in the cloudlet.
 */
public class ServiceListingQueryProcessor implements QueryProcessor {
	private static ServiceListingQueryProcessor instance = new ServiceListingQueryProcessor();
	
	@Override
	public String processQuery(String query) {
		return String.valueOf(ServicesDataBase.getInstance().getServicesIDs());
	}
	
	@Override
	public String getQueryBaseCommand() {
		return "LIST";
	}

	@Override
	public String getQuerySummary() {
		return "LIST  Lists all the services available in the cloudlet.";
	}

	/**
	 * Gets the single instance of ServiceListingQueryProcessor.
	 *
	 * @return single instance of ServiceListingQueryProcessor
	 */
	public static ServiceListingQueryProcessor getInstance(){
		return instance;
	}
}
