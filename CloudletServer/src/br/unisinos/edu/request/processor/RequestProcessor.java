package br.unisinos.edu.request.processor;

public interface RequestProcessor<T,S> {
	public S processRequest(T request);
}
