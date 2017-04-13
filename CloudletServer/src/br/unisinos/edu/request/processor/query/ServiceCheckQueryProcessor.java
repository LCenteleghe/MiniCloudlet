package br.unisinos.edu.request.processor.query;

public class ServiceCheckQueryProcessor implements QueryProcessor {
	private static ServiceCheckQueryProcessor instance = new ServiceCheckQueryProcessor();
	
	private ServiceCheckQueryProcessor() {}

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
		return "CHECK $ServiceID 	 Check whether a service is available in cloudlet.";
	}
	
	public static ServiceCheckQueryProcessor getInstance(){
		return instance;
	}
}
