package br.unisinos.edu.request.processor.query;

public class ClouletAvailabilityQueryProcessor implements QueryProcessor {
	private static ClouletAvailabilityQueryProcessor instance = new ClouletAvailabilityQueryProcessor();

	private ClouletAvailabilityQueryProcessor() {}

	@Override
	public String processQuery(String query) {
		return String.valueOf(true);
	}

	@Override
	public String getQueryBaseCommand() {
		return "AVAILABLE";
	}

	@Override
	public String getQuerySummary() {
		return "Checks whether the cloudlet is available to receive more services.";
	}

	public static ClouletAvailabilityQueryProcessor getInstance() {
		return instance;
	}

}
