package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;

/**
 * Represents a simple query request.
 */
public class SimpleQueryRequest implements Serializable {
	private static final long serialVersionUID = 3575576140491136233L;
	
	private String query;
	
	/**
	 * Instantiates a new simple query request.
	 *
	 * @param query the query
	 */
	public SimpleQueryRequest(String query){
		this.query = query;
	}

	/**
	 * Gets the query.
	 *
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "SimpleQueryRequest [query=" + query + "]";
	}
}
