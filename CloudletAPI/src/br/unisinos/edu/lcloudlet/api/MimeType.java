package br.unisinos.edu.lcloudlet.api;

public enum MimeType {
	APPLICATION_JAVASCRIPT("application/javascript"),
	APPLICATION_JAVA("application/java");
	
	private String code;
	
	private MimeType(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
