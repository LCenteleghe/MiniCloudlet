package br.unisinos.edu.request.processor.query;

import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.exception.InvalidQueryParametersException;

public class ServiceCheckQueryProcessor implements QueryProcessor {
	private static ServiceCheckQueryProcessor instance = new ServiceCheckQueryProcessor();

	private ServiceCheckQueryProcessor() {
	}

	@Override
	public String processQuery(String query) {
		String[] queryParts = query.split("\\s+");
		validateQueryParts(queryParts);
		
		String serviceID = queryParts[1];
		return String.valueOf(ServicesBase.getInstance().contains(serviceID));
	}

	private void validateQueryParts(String[] queryParts) {
		if (queryParts.length < 2) {
			throw new InvalidQueryParametersException(queryParts, "$ServiceID");
		}
	}

	@Override
	public String getQueryBaseCommand() {
		return "CHECK";
	}

	@Override
	public String getQuerySummary() {
		return "Checks whether a service is available in cloudlet. Parameters: $ServiceID ";
	}

	public static ServiceCheckQueryProcessor getInstance() {
		return instance;
	}
}
