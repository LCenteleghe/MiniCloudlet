package br.unisinos.edu;

public final class Service {
	private final String id;
	private final String code;
	
	public Service(String id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
}
