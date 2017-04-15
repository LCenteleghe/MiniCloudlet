package br.edu.unisinos.request.processor;

public interface RequestProcessor<T,S> {
	public S processRequest(T request);
}
