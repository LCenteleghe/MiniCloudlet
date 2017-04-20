package br.edu.unisinos.lcloudlet.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import br.edu.unisinos.lcloudlet.util.ClassUtils;

/**
 * Represents an interface to a Cloudlet.
 */
public class Cloudlet {
	
	/** The connectionTimeout. */
	private static final int connectionTimeout = 1000*60;
	
	/** The socket. */
	private Socket socket = new Socket();
	
	/** The socket address. */
	private InetSocketAddress socketAddress;
	
	/** The stream to server. */
	private ObjectOutputStream streamToServer;
	
	/** The stream from server. */
	private ObjectInputStream streamFromServer;
	
	/**
	 * Instantiates a new cloudlet.
	 *
	 * @param cloudletAddress the cloudlet address.
	 * @throws UnknownHostException when the host is unknown.
	 */
	public Cloudlet(String cloudletAddress) throws UnknownHostException {
		socketAddress = new InetSocketAddress(cloudletAddress, 5555);
	}
	
	/**
	 * Executes a simple query against the Cloudlet.
	 *
	 * @param query the query.
	 * @return the result of the query.
	 */
	public String executeQuery(String query){
		SimpleQueryRequest sqr = new SimpleQueryRequest(query);
		return String.valueOf(sendRequestToServer(sqr));
	}
	
	
	/**
	 * Register a service on the Cloudlet.
	 *
	 * @param id the the service ID
	 * @param code the code of the service.
	 * @param mimeType the mime type of the service.
	 * @return the result of the registration.
	 */
	public String registerService(String id, String code, MimeType mimeType){
		Service service = new Service(id, code, mimeType.getCode());
		return registerService(service);
	}
	
	/**
	 * Register a service on the Cloudlet.
	 *
	 * @param id the the service ID
	 * @param clazz the class that represents the service.
	 * @param mimeType the mime type of the service.
	 * @return the result of the registration.
	 */
	public String registerService(String id, Class<?> clazz, MimeType mimeType){
		Service service = new Service(id, ClassUtils.getClassBytes(clazz), mimeType.getCode());
		return registerService(service);
	}
	
	/**
	 * Execute service (and already registered) service.
	 *
	 * @param serviceID the service ID
	 * @param method the method
	 * @param parameters the parameters
	 * @return the string
	 */
	public String executeService(String serviceID, String method, Object ... parameters){
		ServiceExecutionRequest ser = new ServiceExecutionRequest(serviceID, method, parameters);
		return String.valueOf(sendRequestToServer(ser));
	}
	
	/**
	 * Checks whether a service is registered on the Cloudlet.
	 *
	 * @param serviceID the service ID
	 * @return {@code true}, if it exists, {@code false} otherwise.
	 */
	public boolean checkService(String serviceID) {
		SimpleQueryRequest sqr = new SimpleQueryRequest("CHECK " + serviceID);
		return Boolean.valueOf(sendRequestToServer(sqr).toString());
	}

	private String registerService(Service service) {
		ServiceRegistrationRequest srr = new ServiceRegistrationRequest(service);
		return String.valueOf(sendRequestToServer(srr));
	}
	
	private Object sendRequestToServer(Object request){
		if(!socket.isConnected()){
			openSocketAndConnectStreams();
		}
		
		try {
			streamToServer.writeObject(request);
			return streamFromServer.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private void openSocketAndConnectStreams() {
			try {
				socket.connect(socketAddress, connectionTimeout);
				streamToServer = new ObjectOutputStream(socket.getOutputStream());
				streamFromServer = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	}
	
	@Override
	public String toString() {
		return "Cloudlet [" + socketAddress + "]";
	}
}
