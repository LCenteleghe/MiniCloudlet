package br.edu.unisinos.request.processor.query;


/**
 * The Interface for a simple Query Processor.
 */
public interface QueryProcessor {
	
	/**
	 * Process the query.
	 *
	 * @param query the query
	 * @return the response to the query
	 */
	String processQuery(String query);
	
	/**
	 * Returns a summary of the query definition.
	 *
	 * @return the query summary
	 */
	String getQuerySummary();

	/**
	 * Gets the query base command. (e.g.: CHECK, LIST, AVAILABLE, etc)
	 *
	 * @return the query base command
	 */
	String getQueryBaseCommand();
	
}
