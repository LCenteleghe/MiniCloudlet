package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;

public class SimpleQueryRequest implements Serializable {
	private static final long serialVersionUID = 3575576140491136233L;
	
	private String query;
	
	public SimpleQueryRequest(String query){
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "SimpleQueryRequest [query=" + query + "]";
	}
}
