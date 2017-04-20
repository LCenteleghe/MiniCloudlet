package br.edu.unisinos.lcloudlet.api;

/**
 * Represents a MIME type.
 */
public enum MimeType {
	
	/** The application/javascript type. */
	APPLICATION_JAVASCRIPT("application/javascript"),
	
	/** The application/java type. */
	APPLICATION_JAVA("application/java");
	
	private String code;
	
	private MimeType(String code){
		this.code = code;
	}

	/**
	 * Gets the code of the type.
	 *
	 * @return the code of the type.
	 */
	public String getCode() {
		return code;
	}
}
