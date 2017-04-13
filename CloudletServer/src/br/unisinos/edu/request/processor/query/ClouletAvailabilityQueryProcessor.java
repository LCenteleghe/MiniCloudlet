package br.unisinos.edu.request.processor.query;

public class ClouletAvailabilityQueryProcessor implements QueryProcessor {
	private static ClouletAvailabilityQueryProcessor instance = new ClouletAvailabilityQueryProcessor();

	private ClouletAvailabilityQueryProcessor() {}
	
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
		return "AVAILABLE  Checks whether the cloudlet is available to receive more services.";
	}

	public static ClouletAvailabilityQueryProcessor getInstance(){
		return instance;
	}
}
