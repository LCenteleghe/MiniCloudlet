package br.unisinos.edu.request.processor;

import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.request.dto.SimpleQueryRequest;

public final class SimpleQueryRequestProcessor implements RequestProcessor<SimpleQueryRequest,  Boolean>{
	
	private SimpleQueryRequestProcessor(){}
	
	public static SimpleQueryRequestProcessor getInstance(){
		return new SimpleQueryRequestProcessor();
	}

	public Boolean processRequest(SimpleQueryRequest request){
		String query = request.getServiceID();
		return ServicesBase.getInstance().contains(query);
	}
}
