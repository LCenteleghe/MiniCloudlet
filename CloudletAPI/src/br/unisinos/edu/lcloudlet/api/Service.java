package br.unisinos.edu.lcloudlet.api;

import java.io.Serializable;

public final class Service implements Serializable {
	private static final long serialVersionUID = 734412204365522334L;
	
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

	public Object getSourceCode() {
		return code;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getEntryMethod() {
		return entryMethod;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", entryMethod=" + entryMethod + ", code=" + code + ", mimeType=" + mimeType + "]";
	}
}
