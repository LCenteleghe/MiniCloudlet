package br.unisinos.edu;

public final class Service {
	private final String id;
	private final String entryMethod;
	private final String code;
	
	public Service(String id, String entryMethod, String code) {
		super();
		this.id = id;
		this.entryMethod = entryMethod;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getEntryMethod() {
		return entryMethod;
	}
}
