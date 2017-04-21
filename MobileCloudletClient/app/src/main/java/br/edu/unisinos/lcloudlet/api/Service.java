package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;

public final class Service implements Serializable {
	private static final long serialVersionUID = 734412204365522334L;
	
	private final String id;
	private final Object code;
	private final String mimeType;
	
	public Service(String id, Object code, String mimeType) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Service [id=" + id + ", code=\n" + code + "\n, mimeType=" + mimeType + "]";
	}
}
