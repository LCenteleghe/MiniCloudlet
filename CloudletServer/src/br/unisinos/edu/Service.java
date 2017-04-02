package br.unisinos.edu;

public final class Service {
	private final String id;
	private final String entryMethod;
	private final Object code;
	private final String mimeType;
	
	public Service(String id, String entryMethod, Object code, String mimeType) {
		super();
		this.id = id;
		this.entryMethod = entryMethod;
		this.code = code;
		this.mimeType = mimeType;
	}

	public String getId() {
		return id;
	}

	public Object getCode() {
		return code;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getEntryMethod() {
		return entryMethod;
	}
}
