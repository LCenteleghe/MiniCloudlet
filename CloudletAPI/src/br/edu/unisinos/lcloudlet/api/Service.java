package br.edu.unisinos.lcloudlet.api;

import java.io.Serializable;

/**
 * Represents a service.
 */
public final class Service implements Serializable {
	private static final long serialVersionUID = 734412204365522334L;
	
	/** The id. */
	private final String id;
	
	/** The source code of the service. */
	private final Object code;
	
	/** The mime type of the service. */
	private final String mimeType;
	
	/**
	 * Instantiates a new service.
	 *
	 * @param id the id of the service.
	 * @param code the source code of the service.
	 * @param mimeType the mime type 
	 */
	public Service(String id, Object code, String mimeType) {
		super();
		this.id = id;
		this.code = code;
		this.mimeType = mimeType;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the source code.
	 *
	 * @return the source code
	 */
	public Object getSourceCode() {
		return code;
	}

	/**
	 * Gets the mime type.
	 *
	 * @return the mime type
	 */
	public String getMimeType() {
		return mimeType;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", code=\n" + code + "\n, mimeType=" + mimeType + "]";
	}
}
