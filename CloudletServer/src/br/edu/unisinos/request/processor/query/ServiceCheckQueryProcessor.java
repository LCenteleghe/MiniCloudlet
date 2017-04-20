package br.edu.unisinos.request.processor.query;

import br.edu.unisinos.ServicesDataBase;
import br.edu.unisinos.exception.InvalidQueryParametersException;

/**
 * Query processor for checking whether a Service ID is registered in the cloudlet.
 */
public class ServiceCheckQueryProcessor implements QueryProcessor {
	private static ServiceCheckQueryProcessor instance = new ServiceCheckQueryProcessor();

	private ServiceCheckQueryProcessor() {
	}

	@Override
	public String processQuery(String query) {
		String[] queryParts = query.split("\\s+");
		validateQueryParts(queryParts);
		
		String serviceID = queryParts[1];
		return String.valueOf(ServicesDataBase.getInstance().contains(serviceID));
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

	/**
	 * Gets the single instance of ServiceCheckQueryProcessor.
	 *
	 * @return single instance of ServiceCheckQueryProcessor
	 */
	public static ServiceCheckQueryProcessor getInstance() {
		return instance;
	}
}
