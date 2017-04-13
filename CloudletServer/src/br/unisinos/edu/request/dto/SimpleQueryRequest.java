package br.unisinos.edu.request.dto;

import java.io.Serializable;

public class SimpleQueryRequest implements Serializable {
	private static final long serialVersionUID = 3575576140491136233L;
	
	private String query;
	
	public SimpleQueryRequest(String serviceID){
		this.query = serviceID;
	}

	public String getServiceID() {
		return query;
	}

	@Override
	public String toString() {
		return "SimpleQueryRequest [serviceID=" + query + "]";
	}
}
